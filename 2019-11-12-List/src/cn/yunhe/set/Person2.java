package cn.yunhe.set;

public class Person2 {

    private int age;

    private String name;

    public Person2(int age) {
        this.age = age;
    }

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person2 [age=" + age + ", name=" + name + "]";
    }

}
