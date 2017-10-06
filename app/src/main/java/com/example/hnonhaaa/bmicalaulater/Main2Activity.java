package com.example.hnonhaaa.bmicalaulater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView t ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = (TextView) findViewById(R.id.textvieww);
        Intent intent = getIntent() ;
        Double bmi    = intent.getDoubleExtra("bmi_values",0);
        String bmiText = intent.getStringExtra("bmi_text") ;
        String boxx = String.format("ค่า BMI ที่ได้คือ %.3f\n\n อยู่ในเกณท์ : %s",bmi , bmiText);
        t.setText(boxx);

        //t.setText("HNONHAAA");
    }
}
