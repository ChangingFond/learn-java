package com.changingfond.serializable;

import java.io.*;

/**
 * @auther: fangchengjin_sx
 * @date: 2019/8/22 15:50
 * @description:
 */
public class SerializeAndDeserializeTest {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setAge(23);
//        person.setName("ChangingFond");
//        serialize(person);

        Person person2 = deSerialize();
        System.out.println(person2.getAge());
        System.out.println(person2.getName());
    }

    private static void serialize(Person person) {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("./person.txt"));
            outputStream.writeObject(person);
            System.out.println("serialize success.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Person deSerialize() {
        Person person = null;
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("./person.txt"));
            try {
                person = (Person) inputStream.readObject();
                System.out.println("deserialize success.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return person;
    }
}
