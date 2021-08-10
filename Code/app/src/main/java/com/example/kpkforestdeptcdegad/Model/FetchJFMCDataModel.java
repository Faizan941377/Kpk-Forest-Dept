package com.example.kpkforestdeptcdegad.Model;

public class FetchJFMCDataModel {

    String employee_no;
    String employee_name;
    String name_of_forest_division;
    String name_of_sub_division_range;
    String name_of_village_vdc;
    String name_of_jfmc;
    String date_of_establishment_registration;
    String name_of_president;
    String contact;
    String time_date;

    public FetchJFMCDataModel(String employee_no, String employee_name, String name_of_forest_division, String name_of_sub_division_range,
                              String name_of_village_vdc, String name_of_jfmc, String date_of_establishment_registration,
                              String name_of_president, String contact, String time_date) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.name_of_forest_division = name_of_forest_division;
        this.name_of_sub_division_range = name_of_sub_division_range;
        this.name_of_village_vdc = name_of_village_vdc;
        this.name_of_jfmc = name_of_jfmc;
        this.date_of_establishment_registration = date_of_establishment_registration;
        this.name_of_president = name_of_president;
        this.contact = contact;
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

    public String getName_of_forest_division() {
        return name_of_forest_division;
    }

    public void setName_of_forest_division(String name_of_forest_division) {
        this.name_of_forest_division = name_of_forest_division;
    }

    public String getName_of_sub_division_range() {
        return name_of_sub_division_range;
    }

    public void setName_of_sub_division_range(String name_of_sub_division_range) {
        this.name_of_sub_division_range = name_of_sub_division_range;
    }

    public String getName_of_village_vdc() {
        return name_of_village_vdc;
    }

    public void setName_of_village_vdc(String name_of_village_vdc) {
        this.name_of_village_vdc = name_of_village_vdc;
    }

    public String getName_of_jfmc() {
        return name_of_jfmc;
    }

    public void setName_of_jfmc(String name_of_jfmc) {
        this.name_of_jfmc = name_of_jfmc;
    }

    public String getDate_of_establishment_registration() {
        return date_of_establishment_registration;
    }

    public void setDate_of_establishment_registration(String date_of_establishment_registration) {
        this.date_of_establishment_registration = date_of_establishment_registration;
    }

    public String getName_of_president() {
        return name_of_president;
    }

    public void setName_of_president(String name_of_president) {
        this.name_of_president = name_of_president;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }
}
