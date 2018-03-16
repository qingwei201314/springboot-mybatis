package com.kevin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库中表的字段名称
 * @author Kevin Zhang @Date 2018年3月16日 下午2:51:18
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface Column {
	//列名
	public abstract String name();
}
