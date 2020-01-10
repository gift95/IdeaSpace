package cn.yunhe.map;

public class User implements Comparable {
    private int age;
    private String name;

    public User() {
    }

    public User(int age, String name) {
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

    public String getNaem() {
        return name;
    }

    public void setNaem(String naem) {
        this.name = naem;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {//������������ֵ�hashֵ
        return this.age + this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {//�ж�
        User user = (User) obj;
        if (this.age == user.age) {
            return user.name.equals(this.name);
        }
        return false;
    }


    @Override
    public int compareTo(Object o) {
        User user = (User) o;
        int result = this.age - user.age;
        if (result != 0) {
            return result;
        }
        return this.name.length() - user.name.length();
    }


}
