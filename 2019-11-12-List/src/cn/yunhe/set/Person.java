package cn.yunhe.set;

public class Person implements Comparable {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + "]";
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return this.age - person.age;
    }

}
