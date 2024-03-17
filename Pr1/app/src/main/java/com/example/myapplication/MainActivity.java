package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            SecondAct();
        });
    }

    public void SecondAct(){
        String inputText = editText.getText().toString();
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("input_text", inputText);
        startActivity(intent);
    }
}