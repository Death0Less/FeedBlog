package com.feedblog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private long id;

    private String name;

    private String email;

    private String password;

    private int age;

    private Role role;

    public User(String name, String email, String password, int age, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.role = role;
    }

    public User(String name, String email, String password, int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}
