package com.example.kpkforestdeptcdegad.Model;

public class FetchWomenOrganizationDataModel {
    String employee_no;
    String employee_name;
    String name_of_village_vdc;
    String name_of_wo;
    String date_year_of_establishment;
    String name_of_president;
    String mojor_activities;
    String total_member;
    String contact;
    String remarks;
    String image;
    String time_date;

    public FetchWomenOrganizationDataModel(String employee_no, String employee_name, String name_of_village_vdc, String name_of_wo, String date_year_of_establishment, String name_of_president, String mojor_activities, String total_member, String contact, String remarks, String image, String time_date) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.name_of_village_vdc = name_of_village_vdc;
        this.name_of_wo = name_of_wo;
        this.date_year_of_establishment = date_year_of_establishment;
        this.name_of_president = name_of_president;
        this.mojor_activities = mojor_activities;
        this.total_member = total_member;
        this.contact = contact;
        this.remarks = remarks;
        this.image = image;
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

    public String getName_of_village_vdc() {
        return name_of_village_vdc;
    }

    public void setName_of_village_vdc(String name_of_village_vdc) {
        this.name_of_village_vdc = name_of_village_vdc;
    }

    public String getName_of_wo() {
        return name_of_wo;
    }

    public void setName_of_wo(String name_of_wo) {
        this.name_of_wo = name_of_wo;
    }

    public String getDate_year_of_establishment() {
        return date_year_of_establishment;
    }

    public void setDate_year_of_establishment(String date_year_of_establishment) {
        this.date_year_of_establishment = date_year_of_establishment;
    }

    public String getName_of_president() {
        return name_of_president;
    }

    public void setName_of_president(String name_of_president) {
        this.name_of_president = name_of_president;
    }

    public String getMojor_activities() {
        return mojor_activities;
    }

    public void setMojor_activities(String mojor_activities) {
        this.mojor_activities = mojor_activities;
    }

    public String getTotal_member() {
        return total_member;
    }

    public void setTotal_member(String total_member) {
        this.total_member = total_member;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }
}
