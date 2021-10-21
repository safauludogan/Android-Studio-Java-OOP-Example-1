package com.example.myapplication.database;

import java.util.HashMap;

public class Officer extends Worker {
    private final String department;
    private final String shift;

    public Officer(String name, String phoneNumber, String e_mail,
                   String department, String shift) {
        super(name, phoneNumber, e_mail);
        unit="officer";
        this.department = department;
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public String getShift() {
        return shift;
    }

    private final HashMap<Object, Object> workers = new HashMap<>();

    public HashMap<Object, Object> getWorker() {
        workers.put("name", getName());
        workers.put("e_mail", getEmail());
        workers.put("phoneNumber", getPhoneNumber());
        workers.put("department", getDepartment());
        workers.put("shift", getShift());
        return workers;
    }
}
