package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.database.Academician;
import com.example.myapplication.database.AcademicianDetailActivity;
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Academician academicianModel = academicianArrayList.get(position);
                Intent intent = new Intent(HomeActivity.this, AcademicianDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("academicianModel", academicianModel);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        getAcademicians();
    }

    private void getAcademicians() {

        new DatabaseManager(new FirebaseManager()).getAcademicians().observe(this, academicians -> {
            academicianArrayList = (ArrayList<Academician>) academicians;
            for (int i = 0; i < academicians.size(); i++) {
                academicianList.add(academicians.get(i).getName());
            }
            listView.setAdapter(arrayAdapter);
        });
    }

    public void addData(View view) {

        new DatabaseManager(
                new FirebaseManager(getBaseContext(),
                        new Academician("Merve ekşi",
                                "05565737404",
                                "merveksi@hotmail.com",
                                "Fizik",
                                "Kuantum Fiziği",
                                "4")
                                .getWorker()))
                .addData();

       /* new DatabaseManager(
                new FirebaseManager(getBaseContext(),
                        new Officer("Ferhat Dinç", "05392954693", "1030510124@erciyes.edu.tr", "Siber Güvenlik", "24").getWorker())).addData();*/
    }
}