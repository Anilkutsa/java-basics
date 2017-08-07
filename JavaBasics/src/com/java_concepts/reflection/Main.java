package com.java_concepts.reflection;

public class Main {

    public static void main(String[] args) throws Exception {
        Product product = new Product();
        product.setId(300);
        product.setName("My Java Product Name");
        product.setDescription("My Java Product description...");
        product.setPrice(10.10);
        ReflectionUtil.describeInstance(product);
    }
}
