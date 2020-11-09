package test;

import java.util.List;

public class GenericTest {
    public void testExtends(List<? extends Fruit> list) {
        // list.add(new Fruit());

    }

    public void testSuper(List<? super Fruit> list) {
        list.add(new Fruit());
    }
}

class Food {}
class Fruit extends Food {}
class Apple extends Fruit {}
class Banana extends Fruit {}