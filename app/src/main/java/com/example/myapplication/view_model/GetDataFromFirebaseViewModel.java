package com.example.myapplication.view_model;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.database.Academician;
import com.example.myapplication.database.Officer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GetDataFromFirebaseViewModel extends ViewModel {

    private static final String TAG = "GetDataFromFirebaseViewModel";

    FirebaseDatabase rootNode = FirebaseDatabase.getInstance();

    public GetDataFromFirebaseViewModel() {
    }

    private MutableLiveData<List<Academician>> academicianLiveData;
    private MutableLiveData<List<Officer>> officerLiveData;

    public LiveData<List<Academician>> getAcademicians() {
        if (academicianLiveData == null) {
            academicianLiveData = new MutableLiveData<>();
        }
        loadAcademicians();
        return academicianLiveData;
    }

    private void loadAcademicians() {
        DatabaseReference databaseReference = rootNode.getReference("workers").child("academician");

        List<Academician> academiciansArrayList = new ArrayList<>();
        ValueEventListener academiciansListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    Academician academician = childSnapshot.getValue(Academician.class);
                    academiciansArrayList.add(academician);
                    academicianLiveData.setValue(academiciansArrayList);
                }
            }

            @SuppressLint("LongLogTag")
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "loadPost:onCancelled", error.toException());
            }
        };
        databaseReference.addValueEventListener(academiciansListener);
    }
}
