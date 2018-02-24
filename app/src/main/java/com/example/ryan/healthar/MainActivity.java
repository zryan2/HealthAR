package com.example.ryan.healthar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.ar.core.ArCoreApk;
import com.google.ar.core.ArCoreApk.*;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;


// Test test
public class MainActivity extends AppCompatActivity {
    Button mArBtn;
    Button mNoArBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArBtn = findViewById(R.id.mArBtn);
        mNoArBtn = findViewById(R.id.mNoArBtn);

        maybeEnableArButton();

        mNoArBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoArMode.class);
                startActivity(intent);
            }
        });

        mArBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ArMode.class);
                startActivity(intent);
            }
        });

    }

    void maybeEnableArButton() {
        // Likely called from Activity.onCreate() of an activity with AR buttons.
        Availability availability = ArCoreApk.getInstance().checkAvailability(this);
        if (availability.isTransient()) {
            // re-query at 5Hz while we check compatibility.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    maybeEnableArButton();
                }
            }, 200);
        }
        if (ArCoreApk.getInstance().checkAvailability(this).isSupported()) {
            mArBtn.setVisibility(VISIBLE);
            mArBtn.setEnabled(true);
            // indicator on the button.
        } else { // unsupported or unknown
            mArBtn.setVisibility(INVISIBLE);
            mArBtn.setEnabled(false);

        }
    }
}
