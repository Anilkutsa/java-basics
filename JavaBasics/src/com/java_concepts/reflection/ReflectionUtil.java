package com.java_concepts.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtil {
    
    public static void describeInstance(Object object) {
        Class<?> clazz = object.getClass();
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Description for class: " + clazz.getName());
        System.out.println();
        System.out.println("Summary");
        System.out.println("-----------------------------------------");
        System.out.println("Constructors: " + (constructors.length));
        System.out.println("Fields: " + (fields.length));
        System.out.println("Methods: " + (methods.length));
        System.out.println();
        System.out.println();
        System.out.println("Details");
        System.out.println("-----------------------------------------");
        if (constructors.length > 0) {
            System.out.println();
            System.out.println("Constructors:");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
        }
        if (fields.length > 0) {
            System.out.println();
            System.out.println("Fields:");
            for (Field field : fields) {
                System.out.println(field);
            }
        }
        if (methods.length > 0) {
            System.out.println();
            System.out.println("Methods:");
            for (Method method : methods) {
                System.out.println(method);
            }
        }
    }
}
