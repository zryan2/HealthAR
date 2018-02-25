package com.example.ryan.healthar;

/**
 * Created by Ryan on 2/24/2018.
 */
public class SymptomData {
    String symptom;
    String location;
    String description;
    String webMd;

    public SymptomData(){

    }

    public SymptomData(String symptom, String location, String description, String webMd){
        this.symptom = symptom;
        this.location = location;
        this.description = description;
        this.webMd = webMd;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getWebMd() {
        return webMd;
    }
}


