package cn.yunhe.set;

public class User {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }

    @Override
    public int hashCode() {
        System.out.println("-------");
        return this.age;
    }

    @Override
    public boolean equals(Object obj) {

        User user = (User) obj;
        System.out.println(user);
        //�ȱȽ�����
        int ageResult = this.age - user.age;
        if (ageResult != 0) {
            return false;
        }

        return this.name.equals(user.name);
    }


}
