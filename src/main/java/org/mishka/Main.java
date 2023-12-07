package org.mishka;

import org.mishka.example.SomeBean;
import org.mishka.injector.InjectorPrototype;

public class Main {
    public static void main(String[] args) {
        SomeBean sb = (SomeBean) InjectorPrototype.inject(new SomeBean());
        sb.foo();
    }
}