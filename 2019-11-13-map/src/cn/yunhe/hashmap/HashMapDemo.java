package cn.yunhe.hashmap;

import cn.yunhe.beans.User;

import java.util.HashMap;


/**
 * hashMapͨ��hashcode��equals����ʵ��Ԫ�صĲ��ظ�����
 */
public class HashMapDemo {

    public static void main(String[] args) {
        //���裺������ͬ������Ҳ��ͬ������ͬһ������
        HashMap map = new HashMap();
        map.put(new Person(13, "С��"), "123");
        map.put(new Person(13, "С��"), "123");
        map.put(new Person(14, "С��2"), "123");
        map.put(new Person(15, "С��3"), "123");

        System.out.println(map);

        System.out.println(new User().toString());
        System.out.println(new User());
    }
}

class Person {

    private int age;

    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        return this.age + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;
        //�ȱȽ���������������Ƿ���ͬ
        boolean flag = this.age == person.age;
        if (!flag) {
            return false;
        }
        return this.name.equals(person.name);
    }

}
