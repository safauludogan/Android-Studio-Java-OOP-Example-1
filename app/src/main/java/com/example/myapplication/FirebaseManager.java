package com.example.myapplication;

import static com.example.myapplication.Worker.unit;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.UUID;

class FirebaseManager implements IDatabase {

    private final HashMap<Object, Object> workers;
    private Context context;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    public FirebaseManager(Context context, HashMap<Object, Object> workers) {
        this.workers = workers;
        this.context = context;
        myRef = database.getReference("workers").child(unit).child(UUID.randomUUID().toString());
    }

    @Override
    public void addData() {
        myRef.setValue(workers)
                .addOnCompleteListener(task -> Toast.makeText(context, "Data adding successfully.", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(e -> Toast.makeText(context, "Data adding fails.", Toast.LENGTH_SHORT).show());

        /*System.out.println(workers.get("name"));
        System.out.println(workers.get("e_mail"));
        System.out.println(workers.get("phoneNumber"));
        System.out.println(workers.get("section"));
        System.out.println(workers.get("mission"));
        System.out.println(workers.get("lesson"));*/
    }

    @Override
    public void updateData() {

    }

    @Override
    public void deleteData() {

    }

    @Override
    public void getData() {

    }
}
