package com.example.kpkforestdeptcdegad.user.spinner;

public class SpinnerMaleFemale {

    public String Id;
    public String gender;

    public SpinnerMaleFemale(String id, String gender) {
        Id = id;
        this.gender = gender;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String gender() {
        return gender;
    }

    public void gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
