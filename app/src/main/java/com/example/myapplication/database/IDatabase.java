package com.example.myapplication.database;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface IDatabase {
    void addData();

    void updateData();

    void deleteData();

    LiveData<List<Academician>> getAcademicians();

    LiveData<List<Officer>> getOfficers();
}
