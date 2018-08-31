package com.ladyishenlong.ioc_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * fragment使用 子类的layout添加到basefragment
 * */
@Retention(RetentionPolicy.CLASS)//运行时生成注解
@Target(ElementType.TYPE)
public @interface BaseFragmentLayout {
    int value();
}
