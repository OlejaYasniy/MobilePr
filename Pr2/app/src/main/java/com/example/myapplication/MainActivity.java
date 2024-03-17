package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText TextFirstName;
    private EditText TextSecondName;
    private EditText TextAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("RRR","onCreate()");


        TextFirstName = findViewById(R.id.editTextText);
        TextSecondName = findViewById(R.id.editTextText4);
        TextAge = findViewById(R.id.editTextText3);
        Button button = findViewById(R.id.programmatically);

        button.setOnClickListener(v -> {
            Second();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("RRR","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("RRR","onResume()");
            //Toast.makeText(getApplicationContext(), "IKBO-11-22", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("RRR","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("RRR","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("RRR","onDestroy()");
    }

    public void SecondAct(View view){
        String inputFirstNameText = TextFirstName.getText().toString();
        String inputSecondNameText = TextSecondName.getText().toString();
        String inputAgeText = TextAge.getText().toString();
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("name", inputFirstNameText);
        intent.putExtra("secondName", inputSecondNameText);
        intent.putExtra("age", inputAgeText);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Декларативно", Toast.LENGTH_LONG).show();
    }

    public void Second() {
        String inputFirstNameText = TextFirstName.getText().toString();
        String inputSecondNameText = TextSecondName.getText().toString();
        String inputAgeText = TextAge.getText().toString();
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("name", inputFirstNameText);
        intent.putExtra("secondName", inputSecondNameText);
        intent.putExtra("age", inputAgeText);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Программно", Toast.LENGTH_LONG).show();
    }
}