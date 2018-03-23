package com.kevin.mapper.common;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.jdbc.SQL;

import com.kevin.annotation.Column;
import com.kevin.annotation.Ignore;
import com.kevin.annotation.Table;

/**
 * 公用crud
 * 
 * @author Kevin Zhang @Date 2018年3月15日 下午4:43:52
 */
public class CommonProvider {
	/**
	 * 保存对象至数据库
	 */
	public static <T> String save(T t) throws IllegalAccessException {
		String sql = new SQL() {
			{
				Class<?> entityClass = t.getClass();
				String tableName = tableName(entityClass);

				// 各字段，如果不为null, 且不为"", 则作为查询条件，并用and连接后，生成SQL
				Field[] fields = entityClass.getDeclaredFields();
				if (fields != null && fields.length > 0) {
					// 生成insert
					INSERT_INTO(tableName);
					for (Field field : fields) {
						String fieldName = field.getName();
						Ignore ignore = field.getAnnotation(Ignore.class);
						if (!"serialVersionUID".equals(fieldName) && ignore == null) {
							field.setAccessible(true);
							Column column = field.getAnnotation(Column.class);
							if (column != null) { 															// 如果有加列注解，用列的注解名
								fieldName = column.name();
							}

							Object o = field.get(t);
							if(!"id".equals(fieldName) || ("id".equals(fieldName) && o != null)){
								if (o instanceof String) { 													// 如果string类型, SQL里要加引号
									VALUES(fieldName, "'" + o.toString() + "'");
								} else if(o instanceof Date) {												// 如果是日期格式,转换成string: yyyy-MM-dd HH:mm:ss
									DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String dateString = format.format((Date)o);
									VALUES(fieldName, "'" + dateString + "'");
								} else { 																	// 如果不是string类型，直接填值
									String value = o == null ? "null" : o.toString();
									VALUES(fieldName, value);
								}
							}
						}
					}
				}
			}
		}.toString();
		return sql;
	}
	
	/**
	 * 删除指定表，指id行的记录
	 */
	public static <T> String delete(final Integer id, final Class<T> t) {
		String sql = new SQL() {
			{
				String tableName = tableName(t);
				DELETE_FROM(tableName);
				WHERE("id = " + id);
			}
		}.toString();
		return sql;
	}

	/**
	 * 更新数据库记录
	 */
	public static <T> String update(Integer id, Map<String,Object> map, Class<T> t) {
		String sql = new SQL() {
			{
				String tableName = tableName(t);

				Set<String> columns = map.keySet();
				if (id != null && columns != null && columns.size() > 0) {
					// 生成update
					UPDATE(tableName);
					for (String column : columns) {
						Object o = map.get(column);
						if (o instanceof String) { 													// 如果string类型, SQL里要加引号
							SET(column + "='" + o.toString() + "'");
						} else { 																	// 如果不是string类型，直接填值
							String value = o == null ? "null" : o.toString();
							SET(column + "=" + value);
						}
					}
					//where 条件
					WHERE("id = " + id);
				}
			}
		}.toString();
		return sql;
	}
	
	/**
	 * 根据查询条件查出记录:查询条件用and连接， null或"" 不能作为查询条件
	 */
	public static <T> String find(T t) throws IllegalAccessException {
		return new SQL() {
			{
				Class<?> entityClass = t.getClass();
				String tableName = tableName(entityClass);

				// 各字段，如果不为null, 且不为"", 则作为查询条件，并用and连接后，生成SQL
				Field[] fields = entityClass.getDeclaredFields();
				if (fields != null && fields.length > 0) {
					SELECT("*");
					FROM(tableName);
					for (Field field : fields) {
						String fieldName = field.getName();
						Ignore ignore = field.getAnnotation(Ignore.class);
						if (!"serialVersionUID".equals(fieldName) && ignore == null) {
							field.setAccessible(true);
							Column column = field.getAnnotation(Column.class);
							if (column != null) { // 如果有加列注解，用列的注解名
								fieldName = column.name();
							}

							Object o = field.get(t);
							// 字段值不为null, 且不为"", 才作为条件进行查询
							if (o != null && !"".equals(o.toString())) {
								if (o instanceof String) { 									// 如果string类型, SQL里要加引号
									WHERE(fieldName + "='" + o + "'");
								} else if(o instanceof Date){								// 如果Date作为查询条件
									DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String value = format.format((Date)o);
									WHERE(fieldName + "='" + value + "'");
								} else { // 如果不是string类型，直接填值
									WHERE(fieldName + "=" + o);
								}
							}
						}
					}
				}
			}
		}.toString();
	}

	/**
	 * 根据对象取出表名
	 */
	private static <T> String tableName(Class<?> entityClass) {
		// 取出表名
		Table a = entityClass.getAnnotation(Table.class);
		String tableName = null;
		if (a != null) { // 有加注解，写明表名
			tableName = a.name();
		} else { // 没加注解，则用类名
			String className = entityClass.getName();
			tableName = className.substring(className.lastIndexOf("."));
		}
		return tableName;
	}
}
