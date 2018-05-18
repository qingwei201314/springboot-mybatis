package com.kevin.mapper.common;

import org.apache.ibatis.jdbc.SQL;

/**
 * 公用crud
 * 
 * @author Kevin Zhang @Date 2018年3月15日 下午4:43:52
 */
public class CommonProvider {

	public static <T> String find(final String name) throws IllegalAccessException {
		return new SQL() {
			{
				// Class<?> entityClass = t.getClass();
				// // 取出表名
				// Table a = entityClass.getAnnotation(Table.class);
				// String tableName = null;
				// if (a != null) { //有加注解，写明表名
				// tableName = a.name();
				// } else { //没加注解，则用类名
				// String className = entityClass.getName();
				// tableName = className.substring(className.lastIndexOf("."));
				// }
				// SELECT("*");
				// FROM(tableName);
				//
				// //各字段，如果不为null, 且不为"", 则作为查询条件，并用and连接后，生成SQL
				// Field[] fields = entityClass.getDeclaredFields();
				// if(fields != null && fields.length > 0){
				// for(Field field: fields){
				// String fieldName = field.getName();
				// if(!"serialVersionUID".equals(fieldName)){
				// Object o = field.get(t);
				// WHERE(fieldName + "=" + o);
				// }
				// }
				// }

				SELECT("*");
				FROM("city");
				WHERE("name = '" + name + "'");
			}
		}.toString();
	}
}
