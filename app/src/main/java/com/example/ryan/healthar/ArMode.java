package com.example.ryan.healthar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
                    return true;
                case R.id.navigation_symptoms:
                    SymptomsAr symptomsAr = new SymptomsAr();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = symptomsAr;
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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
