package com.example.myapplication.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DatabaseManager {
    private final IDatabase database;

    public DatabaseManager(IDatabase database) {
        this.database = database;
    }

    public void addData() {
        database.addData();
    }

    public void updateData() {
        database.updateData();
    }

    public void deleteData() {
        database.deleteData();
    }

    public LiveData<List<Academician>> getAcademicians() {
        return database.getAcademicians();
    }

    public LiveData<List<Officer>> getOfficers() {
        return database.getOfficers();
    }
}
