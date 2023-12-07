package org.mishka.injector;
/**
 * Класс InjectorException является пользовательским классом исключений, который расширяет RuntimeException.
 * Это означает, что он используется для представления ошибок, которые могут возникнуть во время процесса
 * внедрения зависимостей.
 *
 * @author Mishka2374
 */

public class InjectorException extends RuntimeException {
    /**
     * Этот конструктор принимает одну строку в качестве аргумента, которая представляет собой сообщение об ошибке.
     * Это сообщение может быть использовано для описания причины исключения.
     *
     * @param message сообщение об ошибке
     */
    public InjectorException(String message) {
        super(message);
    }

    /**
     * Этот конструктор принимает одну строку в качестве аргумента, которая представляет собой сообщение об ошибке.
     * Это сообщение может быть использовано для описания причины исключения.
     *
     * @param message  сообщение об ошибке
     * @param cause представляет собой объект Throwable, который является причиной исключения.
     */
    public InjectorException(String message, Throwable cause) {
        super(message, cause);
    }
}

