package com.example.kpkforestdeptcdegad.Model;

public class FetchOtherActivityDataModel {
    String employee_no;
    String employee_name;
    String activity_title;
    String name_of_forest_division;
    String name_of_wo;
    String name_of_village;
    String description;
    String date_time;

    public FetchOtherActivityDataModel(String employee_no, String employee_name, String activity_title,
                                       String name_of_forest_division, String name_of_wo, String name_of_village,
                                       String description, String date_time) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.activity_title = activity_title;
        this.name_of_forest_division = name_of_forest_division;
        this.name_of_wo = name_of_wo;
        this.name_of_village = name_of_village;
        this.description = description;
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

    public String getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(String activity_title) {
        this.activity_title = activity_title;
    }

    public String getName_of_forest_division() {
        return name_of_forest_division;
    }

    public void setName_of_forest_division(String name_of_forest_division) {
        this.name_of_forest_division = name_of_forest_division;
    }

    public String getName_of_wo() {
        return name_of_wo;
    }

    public void setName_of_wo(String name_of_wo) {
        this.name_of_wo = name_of_wo;
    }

    public String getName_of_village() {
        return name_of_village;
    }

    public void setName_of_village(String name_of_village) {
        this.name_of_village = name_of_village;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
