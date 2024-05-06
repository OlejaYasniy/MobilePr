package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] products = getResources().getStringArray(R.array.products);
        ListView prListView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> prAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, products);
        prListView.setAdapter(prAdapter);

        prListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, VFN.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(MainActivity.this, MCE.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, BP.class);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, MP.class);
                    startActivity(intent);
                } else if (position == 4){
                    Intent intent = new Intent(MainActivity.this, FS.class);
                    startActivity(intent);
                }
            }
        });
    }
}
