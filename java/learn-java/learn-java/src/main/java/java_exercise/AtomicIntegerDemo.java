package java_exercise;

import java.lang.reflect.Field;

/**
 * @date 2022.09.19
 * @author  kraken
 *@docs https://www.liaoxuefeng.com/wiki/1252599548343744/1255945147512512
 */
public class AtomicIntegerDemo {
    static class ObjectA{
        int age = 1;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ObjectA objectA = new ObjectA();
        Class c = objectA.getClass();
        Field field = c.getDeclaredField("age");
        field.set(objectA, 10);
        System.out.println(objectA.age);
    }
}
