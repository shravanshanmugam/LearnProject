package com.shravan.learn.lambda.java8.streams.agiledeveloper.designpatterns;

import java.util.function.Consumer;

/**
 * Can be used in transactions or policies
 */
public class ExecuteAroundPattern {

    static class Resource {
        private Resource() {

        }
        public Resource op1() {
            System.out.println("Resource.op1");
            return this;
        }
        public Resource op2() {
            System.out.println("Resource.op2");
            return this;
        }

        private void close() {
            System.out.println("Resource.close");
        }

        public static void use(Consumer<Resource> consumer) {
            Resource resource = new Resource();
            try {
                consumer.accept(resource);
            } finally {
                resource.close();
            }
        }
    }
    public static void main(String[] args) {
        Resource.use(resource -> resource.op1().op2());
    }
}
