package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class BP extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bp);

        String[] textArray = getResources().getStringArray(R.array.BP);
        int[] imageResources = {
                R.drawable.xleb,
                R.drawable.borodinskiy,
                R.drawable.rjanoy,
                R.drawable.bylochka,
                R.drawable.kruasan,
                R.drawable.ponchik
        };

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SimpleAdapter(textArray, imageResources));
    }
}