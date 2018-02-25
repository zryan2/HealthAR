package com.example.ryan.healthar;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ryan on 2/24/2018.
 */

public class SymptomList extends ArrayAdapter<SymptomData> {

    private Activity context;
    private List<SymptomData> symptomList;

    public SymptomList(Activity context,List<SymptomData> symptomList){
        super(context, R.layout.fragment_symptoms_layout, symptomList);
        this.context = context;
        this.symptomList = symptomList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.fragment_symptoms_layout, null, true);
        TextView symptoms = listViewItem.findViewById(R.id.symptoms);
        TextView generalLocation = listViewItem.findViewById(R.id.generalLocation);
        TextView description = listViewItem.findViewById(R.id.description);
        TextView link = listViewItem.findViewById(R.id.link);

        SymptomData symptomData = symptomList.get(position);

        symptoms.setText(symptomData.getSymptom());
        generalLocation.setText(symptomData.getLocation());
        description.setText(symptomData.getDescription());
        link.setText(symptomData.getWebMd());

        return listViewItem;
    }
}
