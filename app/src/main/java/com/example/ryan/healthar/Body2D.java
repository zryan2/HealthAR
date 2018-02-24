package com.example.ryan.healthar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Body2D extends Fragment {
//    private OpenGLView body2D;

    public Body2D() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_2d_body, container, false);
//        body2D = (OpenGLView) v.findViewById(R.id.body2D);


        // Inflate the layout for this fragment
        return v;
    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        body2D.onResume();
//    }
//
//    @Override
//    public void onPause(){
//        super.onPause();
//        body2D.onPause();
//    }

}
