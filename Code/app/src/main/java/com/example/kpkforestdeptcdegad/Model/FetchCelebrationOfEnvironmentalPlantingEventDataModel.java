package com.example.kpkforestdeptcdegad.Model;

public class FetchCelebrationOfEnvironmentalPlantingEventDataModel {

    String employee_no;
    String employee_name;
    String location_of_event_name_of_institute;
    String chief_guest;
    String environmental_planting_type;
    String environmental_day_planting_event;
    String date_of_event;
    String no_of_planted;
    String time_date;

    public FetchCelebrationOfEnvironmentalPlantingEventDataModel(String employee_no, String employee_name, String location_of_event_name_of_institute, String chief_guest, String environmental_planting_type, String environmental_day_planting_event, String date_of_event, String no_of_planted, String time_date) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.location_of_event_name_of_institute = location_of_event_name_of_institute;
        this.chief_guest = chief_guest;
        this.environmental_planting_type = environmental_planting_type;
        this.environmental_day_planting_event = environmental_day_planting_event;
        this.date_of_event = date_of_event;
        this.no_of_planted = no_of_planted;
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

    public String getLocation_of_event_name_of_institute() {
        return location_of_event_name_of_institute;
    }

    public void setLocation_of_event_name_of_institute(String location_of_event_name_of_institute) {
        this.location_of_event_name_of_institute = location_of_event_name_of_institute;
    }

    public String getChief_guest() {
        return chief_guest;
    }

    public void setChief_guest(String chief_guest) {
        this.chief_guest = chief_guest;
    }

    public String getEnvironmental_planting_type() {
        return environmental_planting_type;
    }

    public void setEnvironmental_planting_type(String environmental_planting_type) {
        this.environmental_planting_type = environmental_planting_type;
    }

    public String getEnvironmental_day_planting_event() {
        return environmental_day_planting_event;
    }

    public void setEnvironmental_day_planting_event(String environmental_day_planting_event) {
        this.environmental_day_planting_event = environmental_day_planting_event;
    }

    public String getDate_of_event() {
        return date_of_event;
    }

    public void setDate_of_event(String date_of_event) {
        this.date_of_event = date_of_event;
    }

    public String getNo_of_planted() {
        return no_of_planted;
    }

    public void setNo_of_planted(String no_of_planted) {
        this.no_of_planted = no_of_planted;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }
}
