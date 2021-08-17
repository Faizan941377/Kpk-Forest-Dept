package com.example.kpkforestdeptcdegad.Model;

public class FetchGadMassPlantingEventDataModel {

    String employee_no;
    String employee_name;
    String name_of_division;
    String chief_guest;
    String name_of_event;
    String date_of_event;
    String location;
    String name_of_institute;
    String no_of_plants_planted;
    String no_of_plants_distributed;
    String no_of_plants_utilized;
    String time_date;

    public FetchGadMassPlantingEventDataModel(String employee_no, String employee_name, String name_of_division, String chief_guest, String name_of_event, String date_of_event, String location, String name_of_institute, String no_of_plants_planted, String no_of_plants_distributed, String no_of_plants_utilized, String time_date) {
        this.employee_no = employee_no;
        this.employee_name = employee_name;
        this.name_of_division = name_of_division;
        this.chief_guest = chief_guest;
        this.name_of_event = name_of_event;
        this.date_of_event = date_of_event;
        this.location = location;
        this.name_of_institute = name_of_institute;
        this.no_of_plants_planted = no_of_plants_planted;
        this.no_of_plants_distributed = no_of_plants_distributed;
        this.no_of_plants_utilized = no_of_plants_utilized;
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

    public String getChief_guest() {
        return chief_guest;
    }

    public void setChief_guest(String chief_guest) {
        this.chief_guest = chief_guest;
    }

    public String getName_of_event() {
        return name_of_event;
    }

    public void setName_of_event(String name_of_event) {
        this.name_of_event = name_of_event;
    }

    public String getDate_of_event() {
        return date_of_event;
    }

    public void setDate_of_event(String date_of_event) {
        this.date_of_event = date_of_event;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName_of_institute() {
        return name_of_institute;
    }

    public void setName_of_institute(String name_of_institute) {
        this.name_of_institute = name_of_institute;
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

    public String getNo_of_plants_utilized() {
        return no_of_plants_utilized;
    }

    public void setNo_of_plants_utilized(String no_of_plants_utilized) {
        this.no_of_plants_utilized = no_of_plants_utilized;
    }

    public String getTime_date() {
        return time_date;
    }

    public void setTime_date(String time_date) {
        this.time_date = time_date;
    }
}
