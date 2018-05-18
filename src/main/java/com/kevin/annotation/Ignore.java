package com.kevin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标识实体中，不映射到数据库中的属性
 * 
 * @author Kevin Zhang @Date 2018年3月19日 上午11:35:12
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.FIELD })
public @interface Ignore {
}
