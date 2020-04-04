package com.shravan.learn.spring.core.model;

import lombok.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component("shape")
public class Circle implements ApplicationContextAware, BeanNameAware, Shape {

    @Setter(onMethod = @__({@Autowired, @Qualifier("center")}))
    private Point center;
    @Setter(onMethod = @__({@Required, @Value("1")}))
    private int radius;
    @Autowired
    private MessageSource messageSource;
    private ApplicationContext context;

    @Override
    public String toString() {
        return "Circle{" +
                this.messageSource.getMessage("circle.detail", new Object[]{center.toString(), radius}, Locale.ENGLISH) +
                ", label=" + this.messageSource.getMessage("circle.name", null, "", Locale.ENGLISH) +
                '}';
    }

    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
        System.out.println("Application context aware : " + applicationContext.getDisplayName());
    }

    public void setBeanName(String s) {
        System.out.println("Bean name aware : bean name : " + s);
    }

    public void draw() {
        System.out.println("Drawing circle : " + toString());
    }
}
