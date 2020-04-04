package com.shravan.learn.lambda.java8.streams.agiledeveloper.designpatterns;

import java.util.function.Consumer;

public class CascadeMethodPattern {

    public static void main(String[] args) {
        System.out.print("Normal object builder : ");
        Mailer mailer = new Mailer();
        mailer.from("abc@def.com");
        mailer.to("def@abc.com");
        mailer.subject("subject");
        mailer.body("body");
        mailer.send();
        System.out.println();

        System.out.print("Cascade method builder : ");
        MailerCascade.send(mailerCascade -> mailerCascade
                .from("abc@def.com")
                .to("def@abc.com")
                .subject("subject")
                .body("body")
        );
        System.out.println();
    }

    static class MailerCascade {
        public static void print(String msg) {
            System.out.println(msg);
        }

        public MailerCascade from(String from) {
            print(from);
            return this;
        }

        public MailerCascade to(String to) {
            print(to);
            return this;
        }

        public MailerCascade subject(String subject) {
            print(subject);
            return this;
        }

        public MailerCascade body(String body) {
            print(body);
            return this;
        }

        public static void send(Consumer<MailerCascade> consumer) {
            MailerCascade mailerCascade = new MailerCascade();
            consumer.accept(mailerCascade);
            print("sending...");
        }
    }

    static class Mailer {
        public static void print(String msg) {
            System.out.println(msg);
        }

        public void from(String from) {
            print(from);
        }

        public void to(String to) {
            print(to);
        }

        public void subject(String subject) {
            print(subject);
        }

        public void body(String body) {
            print(body);
        }

        public void send() {
            print("sending...");
        }
    }
}
