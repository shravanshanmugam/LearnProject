package com.shravan.learn.lambda.java8.examples;

public class ThisReferenceExample {

    public void doProcess(int a, Process process) {
        process.process(a);
    }

    public void execute() {
        doProcess(20, i -> {
            System.out.println("Value of i in lambda is : " + i);
            System.out.println(this);
        });
    }

    @Override
    public String toString() {
        return "ThisReferenceExample{}";
    }

    public static void main(String[] args) {
        ThisReferenceExample example = new ThisReferenceExample();
        example.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i is : " + i);
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "Anonymous inner class";
            }
        });

        example.doProcess(20, i -> {
            System.out.println("Value of i in lambda is : " + i);
            /**
             * Reference of this does not exist in lambda
             * It is not same as anonymous inner class
             * Compilation error
             */
//            System.out.println(this);
        });

        example.execute();
    }
}
