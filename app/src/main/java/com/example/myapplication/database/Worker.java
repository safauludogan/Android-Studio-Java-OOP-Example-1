package com.example.myapplication.database;

public class Worker {
    private String name;
    private String phoneNumber;
    private String e_mail;
    public static String unit = "null";

    public Worker(String name, String phoneNumber, String e_mail) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
    }

    public Worker(){

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
