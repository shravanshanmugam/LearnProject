package com.shravan.learn.lambda.java8.examples;


public class TypeInterfaceExample {

    public static void main(String[] args) {
        StringLengthLambda lambda = s -> s.length();
        System.out.println("lambda.getLength(\"shravan\") = " + lambda.getLength("shravan"));
    }

    interface StringLengthLambda {
        int getLength(String s);
    }

}
