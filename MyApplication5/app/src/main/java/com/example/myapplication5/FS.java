package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class FS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fs);

        Spinner spinnerName = findViewById(R.id.spinner);

        String[] fss = getResources().getStringArray(R.array.FS);

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, fss);
        // устанавливаем адаптер для списка
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerName.setAdapter(Adapter);
    }
}