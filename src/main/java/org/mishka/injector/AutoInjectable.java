package org.mishka.injector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Класс AutoInjectable является пользовательской аннотацией в Java.
 * То есть он используется для обозначения полей, которые должны быть автоматически внедрены зависимостями.
 *
 * @author Mishka2374
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AutoInjectable { }
