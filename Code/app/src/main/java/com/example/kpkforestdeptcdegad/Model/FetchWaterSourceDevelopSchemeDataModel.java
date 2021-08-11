package com.example.kpkforestdeptcdegad.Model;

public class FetchWaterSourceDevelopSchemeDataModel {

    String employee_no;
    String employee_name;
    String name_of_division;
    String name_of_forest_division;
    String target_as_pc_1;
    String achieved_so_far_no;
    String vdc_established;
    String progress_till_date;
    String date_time;

    public FetchWaterSourceDevelopSchemeDataModel(String employee_no, String employee_name, String name_of_division,
                                                  String name_of_forest_division, String target_as_pc_1, String achieved_so_far_no,
                                                  String vdc_established, String progress_till_date, String date_time) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.name_of_division = name_of_division;
        this.name_of_forest_division = name_of_forest_division;
        this.target_as_pc_1 = target_as_pc_1;
        this.achieved_so_far_no = achieved_so_far_no;
        this.vdc_established = vdc_established;
        this.progress_till_date = progress_till_date;
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

    public String getName_of_division() {
        return name_of_division;
    }

    public void setName_of_division(String name_of_division) {
        this.name_of_division = name_of_division;
    }

    public String getName_of_forest_division() {
        return name_of_forest_division;
    }

    public void setName_of_forest_division(String name_of_forest_division) {
        this.name_of_forest_division = name_of_forest_division;
    }

    public String getTarget_as_pc_1() {
        return target_as_pc_1;
    }

    public void setTarget_as_pc_1(String target_as_pc_1) {
        this.target_as_pc_1 = target_as_pc_1;
    }

    public String getAchieved_so_far_no() {
        return achieved_so_far_no;
    }

    public void setAchieved_so_far_no(String achieved_so_far_no) {
        this.achieved_so_far_no = achieved_so_far_no;
    }

    public String getVdc_established() {
        return vdc_established;
    }

    public void setVdc_established(String vdc_established) {
        this.vdc_established = vdc_established;
    }

    public String getProgress_till_date() {
        return progress_till_date;
    }

    public void setProgress_till_date(String progress_till_date) {
        this.progress_till_date = progress_till_date;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}