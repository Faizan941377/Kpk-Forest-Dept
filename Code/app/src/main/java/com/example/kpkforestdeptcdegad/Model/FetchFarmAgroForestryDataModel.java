package com.example.kpkforestdeptcdegad.Model;

public class FetchFarmAgroForestryDataModel {

    String employee_no;
    String employee_name;
    String gad_add;
    String other_activities;
    String name_of_women_organization;
    String name_of_major_activities;
    String name_of_village;
    String date_time;

    public FetchFarmAgroForestryDataModel(String employee_no, String employee_name, String gad_add, String other_activities,
                                          String name_of_women_organization, String name_of_major_activities,
                                          String name_of_village, String date_time) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.gad_add = gad_add;
        this.other_activities = other_activities;
        this.name_of_women_organization = name_of_women_organization;
        this.name_of_major_activities = name_of_major_activities;
        this.name_of_village = name_of_village;
        this.date_time = date_time;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getGad_add() {
        return gad_add;
    }

    public void setGad_add(String gad_add) {
        this.gad_add = gad_add;
    }

    public String getOther_activities() {
        return other_activities;
    }

    public void setOther_activities(String other_activities) {
        this.other_activities = other_activities;
    }

    public String getName_of_women_organization() {
        return name_of_women_organization;
    }

    public void setName_of_women_organization(String name_of_women_organization) {
        this.name_of_women_organization = name_of_women_organization;
    }

    public String getName_of_major_activities() {
        return name_of_major_activities;
    }

    public void setName_of_major_activities(String name_of_major_activities) {
        this.name_of_major_activities = name_of_major_activities;
    }

    public String getName_of_village() {
        return name_of_village;
    }

    public void setName_of_village(String name_of_village) {
        this.name_of_village = name_of_village;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
