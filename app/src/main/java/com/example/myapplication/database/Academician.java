package com.example.myapplication.database;

import java.io.Serializable;
import java.util.HashMap;

public class Academician extends Worker implements Serializable {
    private String section;
    private String mission;
    private String lesson;

    public Academician(String name, String phoneNumber, String e_mail,
                       String section, String mission, String lessons) {
        super(name, phoneNumber, e_mail);
        unit = "academician";
        this.section = section;
        this.mission = mission;
        this.lesson = lessons;
    }

    public Academician(){

    }

    public String getSection() {
        return section;
    }

    public String getMission() {
        return mission;
    }

    public String getLesson() {
        return lesson;
    }

    private final HashMap<Object, Object> workers = new HashMap<>();

    public HashMap<Object, Object> getWorker() {
        workers.put("name", getName());
        workers.put("mailAdress", getMailAdress());
        workers.put("phoneNumber", getPhoneNumber());
        workers.put("section", getSection());
        workers.put("mission", getMission());
        workers.put("lesson", getLesson());
        workers.put("uid", getUID());
        return workers;
    }

}
