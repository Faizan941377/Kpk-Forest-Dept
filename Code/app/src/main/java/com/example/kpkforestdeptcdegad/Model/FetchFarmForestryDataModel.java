package com.example.kpkforestdeptcdegad.Model;

public class FetchFarmForestryDataModel {
    String employee_no;
    String employee_name;
    String name_of_forest_division;
    String name_of_sub_division;
    String plants_distributed_today;
    String total_no_of_plants_distributed_today;
    String total_no_of_plants_distribute_till_date;
    String date_time;

    public FetchFarmForestryDataModel(String employee_no, String employee_name, String name_of_forest_division,
                                      String name_of_sub_division, String plants_distributed_today,
                                      String total_no_of_plants_distributed_today,
                                      String total_no_of_plants_distribute_till_date, String date_time) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.name_of_forest_division = name_of_forest_division;
        this.name_of_sub_division = name_of_sub_division;
        this.plants_distributed_today = plants_distributed_today;
        this.total_no_of_plants_distributed_today = total_no_of_plants_distributed_today;
        this.total_no_of_plants_distribute_till_date = total_no_of_plants_distribute_till_date;
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

    public String getName_of_forest_division() {
        return name_of_forest_division;
    }

    public void setName_of_forest_division(String name_of_forest_division) {
        this.name_of_forest_division = name_of_forest_division;
    }

    public String getName_of_sub_division() {
        return name_of_sub_division;
    }

    public void setName_of_sub_division(String name_of_sub_division) {
        this.name_of_sub_division = name_of_sub_division;
    }

    public String getPlants_distributed_today() {
        return plants_distributed_today;
    }

    public void setPlants_distributed_today(String plants_distributed_today) {
        this.plants_distributed_today = plants_distributed_today;
    }

    public String getTotal_no_of_plants_distributed_today() {
        return total_no_of_plants_distributed_today;
    }

    public void setTotal_no_of_plants_distributed_today(String total_no_of_plants_distributed_today) {
        this.total_no_of_plants_distributed_today = total_no_of_plants_distributed_today;
    }

    public String getTotal_no_of_plants_distribute_till_date() {
        return total_no_of_plants_distribute_till_date;
    }

    public void setTotal_no_of_plants_distribute_till_date(String total_no_of_plants_distribute_till_date) {
        this.total_no_of_plants_distribute_till_date = total_no_of_plants_distribute_till_date;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
