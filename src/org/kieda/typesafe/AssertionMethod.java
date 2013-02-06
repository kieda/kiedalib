package org.kieda.typesafe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * used to mark methods that are used in an assertion. Later, we can use an
 * Annotation Processor to comment out all of the assertion methods after 
 * compile
 * 
 * @author kieda
 */
@TypeSafe
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface AssertionMethod {
    String value() default "";
}
