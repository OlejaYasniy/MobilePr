package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MCE extends AppCompatActivity {
    ArrayList<String> products = new ArrayList<String>();
    ArrayList<String> selectedPR = new ArrayList<String>();
    ArrayAdapter<String> prAdapter;
    ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mce);
        String[] prNames = getResources().getStringArray(R.array.MCE);
        Collections.addAll(products, prNames);
        listView = (ListView) findViewById(R.id.list);
        prAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, products);
        listView.setAdapter(prAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String prod = prAdapter.getItem(position);
                if (listView.isItemChecked(position))
                    selectedPR.add(prod);
                else
                    selectedPR.remove(prod);
            }
        });
    }
    public void add(View view){
        EditText PrName = findViewById(R.id.editTextText);
        String pr = PrName.getText().toString();
        if(!pr.isEmpty()){
            prAdapter.add(pr);
            PrName.setText("");
            prAdapter.notifyDataSetChanged();
        }
    }
    public void remove(View view){
        for(int i=0; i< selectedPR.size();i++){
            prAdapter.remove(selectedPR.get(i));
        }
        listView.clearChoices();
        selectedPR.clear();
        prAdapter.notifyDataSetChanged();
    }
}