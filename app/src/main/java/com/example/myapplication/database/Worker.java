package com.example.myapplication.database;

import com.google.firebase.database.annotations.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class Worker implements Serializable {
    private String name;
    private String phoneNumber;
    private String mailAdress;
    private String uid;
    public static String unit = "null";

    public Worker(String name, String phoneNumber, String mailAdress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.mailAdress = mailAdress;

    }

    public Worker(String uid) {
        this.uid = uid;
    }

    public Worker() {

    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public String getUID() {//If uid is null,create a new uid. If uid already created, return creating uid
        try {
            if (uid.isEmpty())
                return UUID.randomUUID().toString();
            else
                return uid;
        } catch (NullPointerException nullPointerException) {
            nullPointerException.printStackTrace();
            return UUID.randomUUID().toString();
        }
    }
}
