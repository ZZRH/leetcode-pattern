package test;

public class ValueTransmitTest {
    static class Dog {
        int age = 0;
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.age);
        change2(dog);
        System.out.println(dog.age);
    }

    public static void change(Dog dog) {
        dog = new Dog();
        dog.age=10;
    }

    public static void change2(Dog dog) {
        dog.age=10;
    }
}
