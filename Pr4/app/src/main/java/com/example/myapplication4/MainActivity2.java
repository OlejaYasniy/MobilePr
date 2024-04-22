package com.example.myapplication4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView NameView;

    private TextView SecondNameView;

    private EditText textSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        NameView = findViewById(R.id.textView6);
        SecondNameView = findViewById(R.id.textView3);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("name");
        String SecondName = intent.getStringExtra("secondName");

        NameView.setText(Name);
        SecondNameView.setText(SecondName);

        textSubject = findViewById(R.id.editTextText3);

        Button button = findViewById(R.id.button2);

        button.setOnClickListener(v -> {
            ThirdAct();
        });

    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                String time = data.getStringExtra("time");
                Toast.makeText(MainActivity2.this, "Время записи: " + time, Toast.LENGTH_SHORT).show();
            }
        }
    });

    public void ThirdAct(){
        String inputSubjectText = textSubject.getText().toString();
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("Subject", inputSubjectText);
        mStartForResult.launch(intent);
        Toast.makeText(getApplicationContext(), "Third Act", Toast.LENGTH_LONG).show();
    }
}
