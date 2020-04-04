package com.shravan.learn.springboot.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Topic {

    @Id
    private String topicId;
    private String name;
    private String description;
}
