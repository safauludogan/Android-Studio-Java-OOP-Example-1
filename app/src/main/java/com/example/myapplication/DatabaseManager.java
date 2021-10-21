package com.example.myapplication;

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

    public void getData() {
        database.getData();
    }
}
