package com.snlabs.aarogyatelangana.account.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SessionParam {
    public static final String DEFAULT_DEFAULT_VALUE = "<null_null>";

    public static final String DEFAULT_VALUE = "<null>";

    String value() default DEFAULT_VALUE;

    boolean required() default true;

    String defaultValue() default DEFAULT_DEFAULT_VALUE;
}