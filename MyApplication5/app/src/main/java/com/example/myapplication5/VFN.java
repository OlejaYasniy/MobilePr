package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VFN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vfn);

        String[] vfns = getResources().getStringArray(R.array.VFN);
        // находим представление списка
        ListView listView = (ListView) findViewById(R.id.list);
        // создаем адаптер
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, vfns);
        // устанавливаем адаптер для списка
        listView.setAdapter(Adapter);
    }
}