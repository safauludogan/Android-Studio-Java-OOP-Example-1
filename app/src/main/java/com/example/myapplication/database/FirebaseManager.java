package com.example.myapplication.database;

import static com.example.myapplication.database.Worker.unit;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;

import com.example.myapplication.view_model.GetDataFromFirebaseViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class FirebaseManager implements IDatabase {

    private HashMap<Object, Object> workers;
    private Context context;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    public FirebaseManager(Context context, HashMap<Object, Object> workers) {
        this();
        this.workers = workers;
        this.context = context;
    }

    public FirebaseManager() {
        myRef = database.getReference("workers").child(unit).child(UUID.randomUUID().toString());
    }

    @Override
    public void addData() {
        myRef.setValue(workers)
                .addOnCompleteListener(task -> Toast.makeText(context, "Data adding successfully.", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(context, "Data adding fails.", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void updateData() {

    }

    @Override
    public void deleteData() {

    }

    @Override
    public LiveData<List<Academician>> getAcademicians() {
        return new GetDataFromFirebaseViewModel().getAcademicians();
    }

    @Override
    public LiveData<List<Officer>> getOfficers() {
        return null;
    }
}
