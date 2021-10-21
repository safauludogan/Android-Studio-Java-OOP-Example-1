package com.example.myapplication;

public class Worker {
    private final String name;
    private final String phoneNumber;
    private final String e_mail;
    public static String unit = "null";
    public Worker(String name, String phoneNumber, String e_mail) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return e_mail;
    }
}
