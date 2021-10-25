package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.database.Academician;
import com.example.myapplication.database.DatabaseManager;
import com.example.myapplication.database.FirebaseManager;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ListView listView;
    List<String> academicianList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    ArrayList<Academician> academicianArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, academicianList);


        listView.setOnItemClickListener((parent, view, position, id) -> {//When clicking on listView, we will send that clicked.
            Intent intent = new Intent(HomeActivity.this, AcademicianDetailActivity.class);
            intent.putExtra("academician", academicianArrayList.get(position));
            startActivity(intent);
        });

        getAcademicians();
    }

    private void getAcademicians() {//Get just academicians name to listView
        new DatabaseManager(new FirebaseManager()).getAcademicians().observe(this, academicians -> {

            //Clearing the lists to avoid duplication of data.
            academicianArrayList.clear();
            academicianList.clear();

            for (int i = 0; i < academicians.size(); i++) {
                academicianArrayList.add(academicians.get(i));//Add all academicians to list for intent(We will use this list when click on listView)
                academicianList.add(academicians.get(i).getName());
            }
            listView.setAdapter(arrayAdapter);
        });
    }

    public void addData(View view) {

        new DatabaseManager(
                new FirebaseManager(getBaseContext(),
                        new Academician("Safa Uludoğan",
                                "05520018569",
                                "suludogan1@gmail.com",
                                "Bilişim",
                                "Mobile Developer",
                                "4")
                                .getWorker()))
                .addData();

       /* new DatabaseManager(
                new FirebaseManager(getBaseContext(),
                        new Officer("Ferhat Dinç", "05392954693", "1030510124@erciyes.edu.tr", "Siber Güvenlik", "24").getWorker())).addData();*/
    }
}