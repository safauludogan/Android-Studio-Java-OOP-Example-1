package com.example.myapplication.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityAcademicianDetailBinding;

import java.util.List;

public class AcademicianDetailActivity extends AppCompatActivity {

    ActivityAcademicianDetailBinding activityAcademicianDetailBinding;
    Academician academician;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAcademicianDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_academician_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        academician = (Academician) bundle.getSerializable("academicianModel");

        System.out.println(academician.getName());
        System.out.println(academician.getMission());

        activityAcademicianDetailBinding.setAcademician(academician);
    }
}