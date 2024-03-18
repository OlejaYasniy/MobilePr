package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication3.R.id;

public class NewActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        TextView messageText = findViewById(id.objView);

        MyObject myObject = (MyObject) getIntent().getSerializableExtra("myObject");
        if (myObject!= null){
            messageText.setText("Name: " + myObject.getName() + "\nAge: " + myObject.getAge());
        }

        Button backButton = findViewById(R.id.button5);
        backButton.setOnClickListener(v -> {
            First();
        });
    }

    public void First(){
        Intent intent = new Intent(NewActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}