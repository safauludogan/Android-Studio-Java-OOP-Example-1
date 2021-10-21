package com.example.myapplication;

import java.util.HashMap;

public class Academician extends Worker {
    private final String section;
    private final String mission;
    private final String lessons;

    public Academician(String name, String phoneNumber, String e_mail,
                       String section, String mission, String lessons) {
        super(name, phoneNumber, e_mail);
        unit="academician";
        this.section = section;
        this.mission = mission;
        this.lessons = lessons;
    }

    public String getSection() {
        return section;
    }

    public String getMission() {
        return mission;
    }

    public String getLessons() {
        return lessons;
    }

    private final HashMap<Object, Object> workers = new HashMap<>();

    public HashMap<Object, Object> getWorker() {
        workers.put("name", getName());
        workers.put("e_mail", getEmail());
        workers.put("phoneNumber", getPhoneNumber());
        workers.put("section", getSection());
        workers.put("mission", getMission());
        workers.put("lesson", getLessons());
        return workers;
    }

}
