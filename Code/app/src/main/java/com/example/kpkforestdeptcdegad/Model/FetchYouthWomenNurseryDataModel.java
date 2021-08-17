package com.example.kpkforestdeptcdegad.Model;

public class FetchYouthWomenNurseryDataModel {

    String employee_no;
    String employee_name;
    String name_of_division;
    String name_of_sub_division_range;
    String vdc_wo;
    String name_of_nursery_owner;
    String location_village_name;
    String limits;
    String time_date;

    public FetchYouthWomenNurseryDataModel(String employee_no, String employee_name, String name_of_division, String name_of_sub_division_range, String vdc_wo, String name_of_nursery_owner, String location_village_name, String limits, String time_date) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.name_of_division = name_of_division;
        this.name_of_sub_division_range = name_of_sub_division_range;
        this.vdc_wo = vdc_wo;
        this.name_of_nursery_owner = name_of_nursery_owner;
        this.location_village_name = location_village_name;
        this.limits = limits;
        this.time_date = time_date;
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

    public String getName_of_division() {
        return name_of_division;
    }

    public void setName_of_division(String name_of_division) {
        this.name_of_division = name_of_division;
    }

    public String getName_of_sub_division_range() {
        return name_of_sub_division_range;
    }

    public void setName_of_sub_division_range(String name_of_sub_division_range) {
        this.name_of_sub_division_range = name_of_sub_division_range;
    }

    public String getVdc_wo() {
        return vdc_wo;
    }

    public void setVdc_wo(String vdc_wo) {
        this.vdc_wo = vdc_wo;
    }

    public String getName_of_nursery_owner() {
        return name_of_nursery_owner;
    }

    public void setName_of_nursery_owner(String name_of_nursery_owner) {
        this.name_of_nursery_owner = name_of_nursery_owner;
    }

    public String getLocation_village_name() {
        return location_village_name;
    }

    public void setLocation_village_name(String location_village_name) {
        this.location_village_name = location_village_name;
    }

    public String getLimits() {
        return limits;
    }

    public void setLimits(String limits) {
        this.limits = limits;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }
}
