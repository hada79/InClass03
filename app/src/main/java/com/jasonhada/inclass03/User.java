package com.jasonhada.inclass03;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    String email;
    String phone;
    String address;
    String mood;

    public User(String name, String email, String phone, String address, String mood) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.mood = mood;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", mood='" + mood + '\'' +
                '}';
    }
}