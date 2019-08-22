package com.changingfond.annotation;

import java.lang.annotation.*;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/22 22:00
 * @description:
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonAnnotation {

    int age() default 23;

    String name() default "ming";
}

@PersonAnnotation(age = 22, name = "ChangingFond")
class Person {

}

class PersonAnnotationTest {
    public static void main(String[] args) {
        boolean hasAnnotation = Person.class.isAnnotationPresent(PersonAnnotation.class);

        if (hasAnnotation) {
            PersonAnnotation personAnnotation = Person.class.getAnnotation(PersonAnnotation.class);
            System.out.println("age = " + personAnnotation.age());
            System.out.println("name = " + personAnnotation.name());
        }

    }
}
