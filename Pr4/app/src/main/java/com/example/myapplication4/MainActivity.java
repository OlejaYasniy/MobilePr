package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textName;
    private EditText textSecondName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("RRR","onCreate()");


        textName = findViewById(R.id.editTextText);
        textSecondName = findViewById(R.id.editTextText2);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            SecondAct();
        });
    }

    public void SecondAct(){
        String inputFirstNameText = textName.getText().toString();
        String inputSecondNameText = textSecondName.getText().toString();
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("name", inputFirstNameText);
        intent.putExtra("secondName", inputSecondNameText);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Second Act", Toast.LENGTH_LONG).show();
    }
}