package org.kieda.typesafe;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * just a marker that tells us what methods are being used with Frank Pfenning's
 * master hacker skills if type safety. After the project is complete, methods
 * constructors, etc, with the @TypeSafe annotation will be commented out.
 * 
 * @author kieda
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.ANNOTATION_TYPE)
public @interface TypeSafe {}
