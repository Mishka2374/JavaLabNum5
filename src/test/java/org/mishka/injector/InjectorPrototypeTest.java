package org.mishka.injector;

import org.junit.Test;
import org.junit.Assert;
import org.mishka.example.SomeBean;

import java.lang.reflect.Field;

public class InjectorPrototypeTest {
    @Test
    public void testInject() throws Exception {
        SomeBean sb = new SomeBean();
        InjectorPrototype.inject(sb);

        // Проверяем, что поля были правильно внедрены

        Field field1 = SomeBean.class.getDeclaredField("field1");
        field1.setAccessible(true);
        Assert.assertNotNull(field1.get(sb));

        Field field2 = SomeBean.class.getDeclaredField("field2");
        field2.setAccessible(true);
        Assert.assertNotNull(field2.get(sb));
        // ! С таким тестом надо быть аккуратным, тк мы обращаемя к приватным полям, но
        // конечно во избежание проблем их можно сделать публичными!
    }

    //Дальше можно проверять в InjectorPrototype правильность содержимого файла,
    // но путь к файлу по условию задачи находится внутри класса, следовательно,
    // придется менять параметры config.properties и пробовать вручную.
}