package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.database.Academician;
import com.example.myapplication.databinding.ActivityAcademicianDetailBinding;

import java.util.List;

public class AcademicianDetailActivity extends AppCompatActivity {

    ActivityAcademicianDetailBinding activityAcademicianDetailBinding;
    Academician academician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAcademicianDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_academician_detail);

        //GetSerializable Model
        Intent intent = getIntent();
        academician = (Academician) intent.getSerializableExtra("academician");
        Toast.makeText(getApplicationContext(), academician.getUID(), Toast.LENGTH_SHORT).show();
        activityAcademicianDetailBinding.setAcademician(academician);
    }
}