package com.shravan.learn.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String user;
    private String lastName;
    private String email;

    public static void main(String[] args) {
        User user = new User();

    }
}
