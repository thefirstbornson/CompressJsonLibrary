package com.thefirstbornson.compressjson;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CompressJson {
    String expansions() default "";
    String delimiter() default ".";
    String identifier() default "id";
}
