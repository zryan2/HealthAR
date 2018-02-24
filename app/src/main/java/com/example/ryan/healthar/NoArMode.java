package com.example.ryan.healthar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class NoArMode extends AppCompatActivity {

    private TextView mTextMessage;
    Fragment selectedFragment = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_symptoms:
                    SymptomsNoAr symptomsNoAr = new SymptomsNoAr();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = symptomsNoAr;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_2d:
                    //go to 2D body fragment
                    Body2D body2D = new Body2D();
                    transaction = getSupportFragmentManager().beginTransaction();
                    selectedFragment = body2D;
                    transaction.replace(R.id.contentLayout, selectedFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_3d:
                    mTextMessage.setText(R.string.title_3d);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_ar__mode);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //stop shifting englarging on navigation view bar
        BottomNavigationViewHelper.disableShiftMode(navigation);
    }

}
