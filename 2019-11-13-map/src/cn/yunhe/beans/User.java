package cn.yunhe.beans;

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
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

    @Override
    public int compareTo(Object o) {
        User user = (User) o;

        return this.age - user.age;
    }

}
