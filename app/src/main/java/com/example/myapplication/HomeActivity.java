package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void addData(View view) {
       /* new DatabaseManager(
                new FirebaseManager(
                        new Academician("Nazım Uludoğan",
                                "05565737404",
                                "nuludogan@yandex.com",
                                "Elektrik",
                                "Kontrol kumanda",
                                "3")
                                .getWorker()))
                                .addData();*/

        new DatabaseManager(
                new FirebaseManager(getBaseContext(),
                        new Officer("Ferhat Dinç", "05392954693", "1030510124@erciyes.edu.tr", "Siber Güvenlik", "24").getWorker())).addData();

    }
}