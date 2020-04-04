package com.shravan.learn.hibernate.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserDetails {

    @Id
    int userId;
    String username;
}
