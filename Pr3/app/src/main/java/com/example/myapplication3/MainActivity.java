package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button3);

        button.setOnClickListener(v -> {
            Second();
        });
    }

    public void Second(){
        MyObject myObject = new MyObject("Oleg", 19);
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("myObject", myObject);
        startActivity(intent);
    }

}