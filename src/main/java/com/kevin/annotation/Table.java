package com.kevin.annotation;

/**
 * 为实体指定表名
 * @author Kevin Zhang @Date 2018年3月16日 下午2:46:51
 */
public @interface Table {
	//表名
	public abstract String name();
}
