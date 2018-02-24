package com.example.ryan.healthar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ryan on 2/24/2018.
 */

public class SymptomsNoAr extends Fragment {

//    public final static String

    View v;
    ListView listViewSymptom;
    List<SymptomData> symptomDataList;

    DatabaseReference databaseSymptom;
    View symptomsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_symptoms, container, false);
        symptomsList = inflater.inflate(R.layout.fragment_symptoms_layout, container, false);
        databaseSymptom = FirebaseDatabase.getInstance().getReference("symptoms");

        listViewSymptom = (ListView) v.findViewById(R.id.listViewSymptoms);
        symptomDataList = new ArrayList<>();

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseSymptom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                symptomDataList.clear();
                for(DataSnapshot symptomSnapshot: dataSnapshot.getChildren()){
                    SymptomData symptomData = symptomSnapshot.getValue(SymptomData.class);
                    symptomDataList.add(symptomData);
                }
                SymptomList adapter = new SymptomList(getActivity(), symptomDataList);
                listViewSymptom.setAdapter(adapter);
                //addSymptoms();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addSymptoms(){
        String id = databaseSymptom.push().getKey();
        SymptomData  symptomDataData = new SymptomData("Cough", "Throat", "Coughing stuff out", "https://www.google.com");
        databaseSymptom.child(id).setValue(symptomDataData);
    }
}
