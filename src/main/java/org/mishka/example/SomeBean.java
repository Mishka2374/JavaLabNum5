package org.mishka.example;

import org.mishka.injector.AutoInjectable;
/**
 * Класс SomeBean служит для работы с пользовательскими аннотациями AutoInjectable
 *
 * @author Mishka2374
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;
    /**
     * Метод установки поля field1
     */
    public void setField1(SomeInterface field1) {
        this.field1 = field1;
    }
    /**
     * Метод установки поля field2
     */
    public void setField2(SomeOtherInterface field2) {
        this.field2 = field2;
    }
    /**
     * Метод для использования имеющихся полей
     */
    public void foo() {
        field1.doSomething();
        field2.doSomeOther();
    }
}
