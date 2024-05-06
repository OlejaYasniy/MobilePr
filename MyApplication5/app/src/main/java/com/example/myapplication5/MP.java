package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp);

        String[] mps = getResources().getStringArray(R.array.MP);
        // находим представление списка
        ListView listView = (ListView) findViewById(R.id.list);
        // создаем адаптер
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mps);
        // устанавливаем адаптер для списка
        listView.setAdapter(Adapter);
    }
}