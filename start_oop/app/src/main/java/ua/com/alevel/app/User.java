package ua.com.alevel.app;

import ua.com.alevel.lib.BaseEntity;

public class User extends BaseEntity {

    private int age;
    private String name;

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
        return "User{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
