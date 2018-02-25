package com.example.ryan.healthar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ArMode extends AppCompatActivity {

    Fragment selectedFragment = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment_Ar homeFragmentAr = new HomeFragment_Ar();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = homeFragmentAr;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_symptoms:
                    SymptomsNoAr symptomsNoAr = new SymptomsNoAr();
                    transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = symptomsNoAr;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_2d:
                    //go to ar fragment
                    ArCamera arCamera = new ArCamera();
                    transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = arCamera;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_mode);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        HomeFragment_Ar homeFragmentAr = new HomeFragment_Ar();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        selectedFragment = homeFragmentAr;
        transaction.replace(R.id.contentLayout, selectedFragment);
        transaction.commit();
    }

}
