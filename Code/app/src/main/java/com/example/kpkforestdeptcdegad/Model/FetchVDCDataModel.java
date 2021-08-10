package com.example.kpkforestdeptcdegad.Model;

public class FetchVDCDataModel {

    String id;
    String employee_no;
    String employee_name;
    String name_of_forest_divsion;
    String name_of_sub_division_range;
    String name_of_village;
    String name_of_vdc_jfmc;
    String date_of_establishment_registration;
    String name_of_president;
    String contact;
    String jfmc_wo;
    String total_member;
    String image;
    String date_time;

    public FetchVDCDataModel(String id, String employee_no, String employee_name, String name_of_forest_divsion,
                             String name_of_sub_division_range, String name_of_village, String name_of_vdc_jfmc,
                             String date_of_establishment_registration, String name_of_president, String contact,
                             String jfmc_wo, String total_member, String image, String date_time) {
        this.id = id;
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.name_of_forest_divsion = name_of_forest_divsion;
        this.name_of_sub_division_range = name_of_sub_division_range;
        this.name_of_village = name_of_village;
        this.name_of_vdc_jfmc = name_of_vdc_jfmc;
        this.date_of_establishment_registration = date_of_establishment_registration;
        this.name_of_president = name_of_president;
        this.contact = contact;
        this.jfmc_wo = jfmc_wo;
        this.total_member = total_member;
        this.image = image;
        this.date_time = date_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName_of_forest_divsion() {
        return name_of_forest_divsion;
    }

    public void setName_of_forest_divsion(String name_of_forest_divsion) {
        this.name_of_forest_divsion = name_of_forest_divsion;
    }

    public String getName_of_sub_division_range() {
        return name_of_sub_division_range;
    }

    public void setName_of_sub_division_range(String name_of_sub_division_range) {
        this.name_of_sub_division_range = name_of_sub_division_range;
    }

    public String getName_of_village() {
        return name_of_village;
    }

    public void setName_of_village(String name_of_village) {
        this.name_of_village = name_of_village;
    }

    public String getName_of_vdc_jfmc() {
        return name_of_vdc_jfmc;
    }

    public void setName_of_vdc_jfmc(String name_of_vdc_jfmc) {
        this.name_of_vdc_jfmc = name_of_vdc_jfmc;
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

    public String getJfmc_wo() {
        return jfmc_wo;
    }

    public void setJfmc_wo(String jfmc_wo) {
        this.jfmc_wo = jfmc_wo;
    }

    public String getTotal_member() {
        return total_member;
    }

    public void setTotal_member(String total_member) {
        this.total_member = total_member;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}