package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.database.Academician;
import com.example.myapplication.database.DatabaseManager;
import com.example.myapplication.database.FirebaseManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getAcademicians();
    }

    private void getAcademicians() {
        new DatabaseManager(new FirebaseManager()).getAcademicians().observe(this, academicians -> {
            for (int i = 0; i < academicians.size(); i++) {
                System.out.println(academicians.get(i).getName());
            }
        });
    }

    public void addData(View view) {
        new DatabaseManager(
                new FirebaseManager(getBaseContext(),
                        new Academician("Nazım Uludoğan",
                                "05565737404",
                                "nuludogan@yandex.com",
                                "Elektrik",
                                "Kontrol kumanda",
                                "3")
                                .getWorker()))
                .addData();

       /* new DatabaseManager(
                new FirebaseManager(getBaseContext(),
                        new Officer("Ferhat Dinç", "05392954693", "1030510124@erciyes.edu.tr", "Siber Güvenlik", "24").getWorker())).addData();*/
    }
}