package com.example.ryan.healthar;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BodySelectionInfo extends Activity{

    TextView questionText;
    Spinner painTypeSpinner;
    ArrayAdapter<CharSequence> adapter;
    public BodySelectionInfo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_body_selection_info);

        String intentPart = getIntent().getStringExtra("Body");
        questionText = findViewById(R.id.questionText);
        String part = "";
        switch (intentPart){
            case ("chest"):
                part = "chest";
                adapter = ArrayAdapter.createFromResource(this, R.array.chestPain, android.R.layout.simple_spinner_item);
                break;
            case("head"):
                part = "head";
                adapter = ArrayAdapter.createFromResource(this, R.array.headPain, android.R.layout.simple_spinner_item);
                break;
            case("neck"):
                part = "neck";
                adapter = ArrayAdapter.createFromResource(this, R.array.neckPain, android.R.layout.simple_spinner_item);
                break;
            case("abs"):
                part = "abdomen";
                adapter = ArrayAdapter.createFromResource(this, R.array.abPain, android.R.layout.simple_spinner_item);
                break;
            case("sides"):
                part = "sides";
                adapter = ArrayAdapter.createFromResource(this, R.array.sidePain, android.R.layout.simple_spinner_item);
                break;
            case("crotch"):
                part = "crotch";
                adapter = ArrayAdapter.createFromResource(this, R.array.crotchPain, android.R.layout.simple_spinner_item);
                break;
            case("right_arm"):
                part = "right arm";
                adapter = ArrayAdapter.createFromResource(this, R.array.armPain, android.R.layout.simple_spinner_item);
                break;
            case("left_arm"):
                part = "left arm";
                adapter = ArrayAdapter.createFromResource(this, R.array.armPain, android.R.layout.simple_spinner_item);
                break;
            case("left_leg_top"):
                part = "area above the left knee";
                adapter = ArrayAdapter.createFromResource(this, R.array.upperLegPain, android.R.layout.simple_spinner_item);
                break;
            case("left_leg_bottom"):
                part = "area below the left knee";
                adapter = ArrayAdapter.createFromResource(this, R.array.lowerLegPain, android.R.layout.simple_spinner_item);
                break;
            case("left_ankle"):
                part = "left ankle";
                adapter = ArrayAdapter.createFromResource(this, R.array.anklePain, android.R.layout.simple_spinner_item);
                break;
            case("left_foot"):
                part = "left foot";
                adapter = ArrayAdapter.createFromResource(this, R.array.footPain, android.R.layout.simple_spinner_item);
                break;
            case("right_leg_top"):
                part = "area above the right knee";
                adapter = ArrayAdapter.createFromResource(this, R.array.upperLegPain, android.R.layout.simple_spinner_item);
                break;
            case("right_leg_bottom"):
                part = "area below the right knee";
                adapter = ArrayAdapter.createFromResource(this, R.array.lowerLegPain, android.R.layout.simple_spinner_item);
                break;
            case("right_ankle"):
                part = "right ankle";
                adapter = ArrayAdapter.createFromResource(this, R.array.anklePain, android.R.layout.simple_spinner_item);
                break;
            case("right_foot"):
                part = "right foot";
                adapter = ArrayAdapter.createFromResource(this, R.array.footPain, android.R.layout.simple_spinner_item);
                break;
            default:
                break;
        }
        // Creates the spinner
        painTypeSpinner = (Spinner) findViewById(R.id.painTypeSpinner);
        List<String> painList = new ArrayList<>();



        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        painTypeSpinner.setAdapter(adapter);

        questionText.setText("What kind pain are you feeling in your " + part +"?");

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        getWindow().setLayout((int)(width*0.8), (int)(height*0.2));
    }
}
