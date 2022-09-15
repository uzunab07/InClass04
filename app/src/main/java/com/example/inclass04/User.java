package com.example.inclass04;

import java.io.Serializable;

public class User implements Serializable {


    private String name,email,id,department;

    public User(String name, String email, String id, String department) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
