package org.mishka.injector;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Properties;
/**
 * Класс InjectorPrototype представляет собой реализацию класса Injector, то есть реализацию паттерна внедрения зависимостей.
 * Здесь используется параметризованный метод inject, который принимает в качестве параметра объект
 * любого класса и, используя механизмы рефлексии, осуществляет поиск полей, помеченных этой аннотацией
 * и осуществляет инициализацию этих полей экземплярами классов, которые указаны в качестве реализации
 * соответствующего интерфейса в некотором файле config.properties
 *
 * @author Mishka2374
 */
public class InjectorPrototype {
    /**
     * Метод для внедрения зависимостей в объект.
     *
     * @param obj - объект, который хотим внедрить в зависимость
     * @return возвращает изменённый объект
     * @throws InjectorException исключение, которое может быть выброшено, если что-то пошло
     * не так во время процесса внедрения зависимостей.
     */
    public static Object inject(Object obj) throws InjectorException {
        Field[] fields = obj.getClass().getDeclaredFields();
        Properties quality = new Properties();

        try (InputStream in = InjectorPrototype.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new InjectorException("Properties file not found");
            }

            quality.load(new InputStreamReader(in));
        } catch (IOException e) {
            throw new InjectorException("Failed to read properties file", e);
        }

        for (Field field : fields) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                String qualityKey = field.getType().getName();
                String implementationClassName = quality.getProperty(qualityKey);

                if (implementationClassName == null) {
                    throw new InjectorException("There is no implementation for " + qualityKey);
                }

                try {
                    Class<?> implementationClass = Class.forName(implementationClassName);
                    Object implementationClassInstance = implementationClass.getDeclaredConstructor().newInstance();
                    field.setAccessible(true);
                    field.set(obj, implementationClassInstance);
                    field.setAccessible(false);
                } catch (Exception e) {
                    throw new InjectorException("Injection failed for " + field.getName(), e);
                }
            }
        }

        return obj;
    }
}
