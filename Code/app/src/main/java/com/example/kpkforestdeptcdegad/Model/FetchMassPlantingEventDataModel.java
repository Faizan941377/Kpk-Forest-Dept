package com.example.kpkforestdeptcdegad.Model;

public class FetchMassPlantingEventDataModel {

    String employee_no;
    String employee_name;
    String location_venu;
    String chief_guest;
    String date_of_event;
    String no_of_plants_planted;
    String no_of_plants_distributed;
    String spring_moon_soon;
    String total_no_of_plants;
    String date_time;

    public FetchMassPlantingEventDataModel(String employee_no, String employee_name, String location_venu,
                                           String chief_guest, String date_of_event, String no_of_plants_planted,
                                           String no_of_plants_distributed, String spring_moon_soon, String total_no_of_plants,
                                           String date_time) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.location_venu = location_venu;
        this.chief_guest = chief_guest;
        this.date_of_event = date_of_event;
        this.no_of_plants_planted = no_of_plants_planted;
        this.no_of_plants_distributed = no_of_plants_distributed;
        this.spring_moon_soon = spring_moon_soon;
        this.total_no_of_plants = total_no_of_plants;
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

    public String getLocation_venu() {
        return location_venu;
    }

    public void setLocation_venu(String location_venu) {
        this.location_venu = location_venu;
    }

    public String getChief_guest() {
        return chief_guest;
    }

    public void setChief_guest(String chief_guest) {
        this.chief_guest = chief_guest;
    }

    public String getDate_of_event() {
        return date_of_event;
    }

    public void setDate_of_event(String date_of_event) {
        this.date_of_event = date_of_event;
    }

    public String getNo_of_plants_planted() {
        return no_of_plants_planted;
    }

    public void setNo_of_plants_planted(String no_of_plants_planted) {
        this.no_of_plants_planted = no_of_plants_planted;
    }

    public String getNo_of_plants_distributed() {
        return no_of_plants_distributed;
    }

    public void setNo_of_plants_distributed(String no_of_plants_distributed) {
        this.no_of_plants_distributed = no_of_plants_distributed;
    }

    public String getSpring_moon_soon() {
        return spring_moon_soon;
    }

    public void setSpring_moon_soon(String spring_moon_soon) {
        this.spring_moon_soon = spring_moon_soon;
    }

    public String getTotal_no_of_plants() {
        return total_no_of_plants;
    }

    public void setTotal_no_of_plants(String total_no_of_plants) {
        this.total_no_of_plants = total_no_of_plants;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}
