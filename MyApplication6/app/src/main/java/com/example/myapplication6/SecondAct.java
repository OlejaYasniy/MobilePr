package com.example.myapplication6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Главная"); // Установить заголовок
            BottomNavigationView bottomNavigationView =
                    findViewById(R.id.bottom_navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
                if (item.getItemId() == R.id.nav_home) {
                    actionBar.setTitle("Главная");
                    MoveToS1Fr();
                } else if (item.getItemId() == R.id.nav_setting) {
                    actionBar.setTitle("Уведомления");
                } else if (item.getItemId() == R.id.nav_notifications) {
                    actionBar.setTitle("Настройки");
                    MoveToS2Fr();
                }
                return false;
            });
        }

    }

    public void MoveToS1Fr(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        S1Fragment fragment1 = new S1Fragment();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container2, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void MoveToS2Fr(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        S2Fragment fragment2 = new S2Fragment();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container2, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}