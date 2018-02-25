package com.example.ryan.healthar;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.view.View.VISIBLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArCamera extends Fragment {

    ImageButton mCamOn;
    ImageButton mMale;
    ImageButton mFemale;
    TextView touchText;
    TextView selectText;
//    Boolean genderChosen = false;
    Boolean femaleChosen = false;
    Boolean maleChosen = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ar, container, false);
        mCamOn = view.findViewById(R.id.mCamOn);
        mMale = view.findViewById(R.id.mMale);
        mFemale = view.findViewById(R.id.mFemale);
        touchText = view.findViewById(R.id.touchText);
        selectText = view.findViewById(R.id.selectText);

        mCamOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (maleChosen) {
                    Intent intent = new Intent(getActivity(), ArCameraOn.class).putExtra("Gender",maleChosen);
                    startActivity(intent);

                }else if(femaleChosen){
                    touchText.setText("Female anatomy currently unavailable");
                    touchText.setVisibility(VISIBLE);
                }else{
                    selectText.setText("Please select the gender");
                    touchText.setVisibility(View.INVISIBLE);
                }
            }
        });

        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!maleChosen) {
                    maleChosen = true;
                    femaleChosen = false;
                    selectText.setText("You have chosen the Male anatomy");
                    ViewCompat.setBackgroundTintList(
                            mMale, BackgroundTints.forColoredButton(mMale.getContext(), Color.argb(255, 72, 77,228)));
                    ViewCompat.setBackgroundTintList(
                            mFemale, BackgroundTints.forColoredButton(mFemale.getContext(), Color.argb(255, 255, 255,255)));
                    touchText.setText("Touch the Camera");
                    touchText.setVisibility(VISIBLE);
                }else{
                    maleChosen = false;
                    ViewCompat.setBackgroundTintList(
                            mMale, BackgroundTints.forColoredButton(mMale.getContext(), Color.argb(255, 255, 255,255)));
                    selectText.setText("Please select the gender");
                    touchText.setVisibility(View.INVISIBLE);
                }
            }
        });
        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!femaleChosen) {
                    femaleChosen = true;
                    maleChosen = false;
                    selectText.setText("You have chosen the female anatomy");
                    ViewCompat.setBackgroundTintList(
                            mFemale, BackgroundTints.forColoredButton(mMale.getContext(), Color.argb(255, 72, 77,228)));
                    ViewCompat.setBackgroundTintList(
                            mMale, BackgroundTints.forColoredButton(mFemale.getContext(), Color.argb(255, 255, 255,255)));
                    touchText.setText("Touch the Camera");
                    touchText.setVisibility(VISIBLE);

                }else{
                    femaleChosen = false;
                    ViewCompat.setBackgroundTintList(
                            mFemale, BackgroundTints.forColoredButton(mMale.getContext(), Color.argb(255, 255, 255,255)));
                    selectText.setText("Please select the gender");
                    touchText.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }



}
