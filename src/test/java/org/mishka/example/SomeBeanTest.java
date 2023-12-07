package org.mishka.example;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBeanTest {
    @Test
    public void testFoo() {
        // Создаем реальные экземпляры классов
        SomeInterface someInterface = new SomeImpl();
        SomeOtherInterface someOtherInterface = new SODoer();

        // Внедряем реальные экземпляры в SomeBean
        SomeBean someBean = new SomeBean();
        someBean.setField1(someInterface);
        someBean.setField2(someOtherInterface);

        // Перенаправляем стандартный вывод в ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Вызываем метод, который мы хотим протестировать
        someBean.foo();

        // Проверяем, что методы doSomething и doSomeOther были вызваны
        assertEquals("A\nC\n", outContent.toString());
    }
}