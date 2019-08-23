package com.changingfond.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/22 15:34
 * @description:
 */
@Data
public class Person implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private String name;

    private int age;

}
