package com.ladyishenlong.ioc_annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * activity 绑定layout 加入到baseActivity之中
 * */
@Retention(RetentionPolicy.CLASS)//运行时生成注解
@Target(ElementType.TYPE)
public @interface BaseActivityLayout {
      int value() default -1;
}
