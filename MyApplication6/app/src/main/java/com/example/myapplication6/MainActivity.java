package com.example.myapplication6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.drawer_open,
                R.string.drawer_close);
        if (drawer != null) {
            drawer.addDrawerListener(toggle);
        }
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // Обработка нажатия на иконку меню в ActionBar для открытия и закрытия Drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.krasivie) {
            MoveToFirstFr();
        } else if (id == R.id.komnatnie) {
            MoveToSecondFr();
        } else if (id == R.id.polevie) {
            MoveToThirdFr();
        } else if (id == R.id.NextAct) {
            MoveToNextAct();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void MoveToFirstFr(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FirstFragment fragment1 = new FirstFragment();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void MoveToSecondFr(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        SecondFragment fragment2 = new SecondFragment();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void MoveToThirdFr(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        ThirdFragment fragment3 = new ThirdFragment();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void MoveToNextAct(){
        Intent intent = new Intent(this, SecondAct.class);
        startActivity(intent);
    }

}
