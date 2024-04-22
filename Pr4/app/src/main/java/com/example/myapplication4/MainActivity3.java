package com.example.myapplication4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    private EditText TextDay;
    private EditText TextTime;
    private EditText TextCom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextDay = findViewById(R.id.editTextText4);
        TextTime = findViewById(R.id.editTextText5);
        TextCom = findViewById(R.id.editTextText6);

        Button button = findViewById(R.id.button3);

        button.setOnClickListener(v -> {
            LastAct();
        });
    }
    public void LastAct(){
        String day = TextDay.getText().toString();
        String time = TextTime.getText().toString();
        String subject = getIntent().getStringExtra("subject");
        String timeAndComment = day + " " + time;
        Intent intent = new Intent();
        intent.putExtra("time", timeAndComment);
        setResult(MainActivity.RESULT_OK, intent);
        finish();
}}
