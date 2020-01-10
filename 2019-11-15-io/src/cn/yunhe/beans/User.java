package cn.yunhe.beans;

import java.io.Serializable;

public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static String name;
    private int age;
    //transient �����η����εı�����Ϊ˲̬����
    private transient int num;

    public User() {
    }

    public User(int age) {
        super();
        this.age = age;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
