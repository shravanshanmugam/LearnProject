package com.shravan.learn;

import com.google.protobuf.InvalidProtocolBufferException;
import com.shravan.learn.model.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class Main {

    public static void test_proto() throws InvalidProtocolBufferException {
        Data.Student shravan = Data.Student.newBuilder()
                .setId(1)
                .setName("Shravan")
                .setMarks("100")
                .build();
        System.out.println("shravan = " + shravan);

        System.out.println("shravan.toString() = " + shravan.toString());

        boolean initialized = shravan.isInitialized();
        System.out.println("initialized = " + initialized);

        byte[] bytes = shravan.toByteArray();
        System.out.println("bytes = " + Arrays.toString(bytes));

        Data.Student shravan_parsed = Data.Student.parseFrom(bytes);
        System.out.println("shravan_parsed = " + shravan_parsed);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    @Primary
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @GetMapping("/student")
    public Data.Student singleStudent() {
        return Data.Student.newBuilder()
                .setId(1)
                .setName("Shravan")
                .setMarks("100")
                .build();
    }
}
