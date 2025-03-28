package com.java_concepts.java8features;

public class LambdaExpression {

    public static void main(String[] args) {

        //Syntax - (args1, args2, args3, ……) -> { body }
        
        LambdaExpression main = new LambdaExpression();

        //with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        //with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        //without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + main.operate(10, 5, addition));
        System.out.println("10 - 5 = " + main.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + main.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + main.operate(10, 5, division));

        //with parenthesis
        GreetingService greetService1 = message
                -> System.out.println("Hello " + message);

        //without parenthesis
        GreetingService greetService2 = (message)
                -> System.out.println("Hello " + message);

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
        
        SayMyName sn = name -> System.out.print("My Name " + name);
        sn.sayName("Anil");
        
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
    
    
    interface SayMyName{
        void sayName(String name);
    }

}
