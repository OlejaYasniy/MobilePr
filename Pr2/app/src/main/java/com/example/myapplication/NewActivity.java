package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        TextView NameView = findViewById(R.id.textView2);
        TextView SecondNameView = findViewById(R.id.textView6);
        TextView AgeView = findViewById(R.id.textView7);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("name");
        String SecondName = intent.getStringExtra("secondName");
        String Age = intent.getStringExtra("age");
        NameView.setText("Имя " + Name);
        SecondNameView.setText("Фамилия " + SecondName);
        AgeView.setText("Возраст " + Age);
    }
}