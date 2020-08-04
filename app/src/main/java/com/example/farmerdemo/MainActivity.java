package com.example.farmerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        //setSupportActionBar(toolbar);
        getSupportActionBar();

        ActionBarDrawerToggle drawerToggle =
                new ActionBarDrawerToggle(this,
                        drawerLayout,toolbar,
                        0,0);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        drawerToggle.getDrawerArrowDrawable()
                .setColor(getResources().getColor(android.R.color.white));

        navigationView.setNavigationItemSelectedListener(this);

        manager =getSupportFragmentManager();
        transaction= manager.beginTransaction();
        HomeFragment home = new HomeFragment();
        transaction.replace(R.id.main_body,home);
        transaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        manager = getSupportFragmentManager();
        transaction =manager.beginTransaction();

        switch (item.getItemId()){
            case R.id.home:
                HomeFragment home =new HomeFragment();
                transaction.replace(R.id.main_body,home);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.news:
                NewsFragment news =new NewsFragment();
                transaction.replace(R.id.main_body,news);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.weather:
                WeatherFragment weather =new WeatherFragment();
                transaction.replace(R.id.main_body,weather);
                transaction.commit();
                drawerLayout.closeDrawers();
                break;
        }
        return false;
    }
}