package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchMassPlantingEventDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchMassPlantingEventResponse {


    @SerializedName("users")
    @Expose
    private List<FetchMassPlantingEventDataModel> fetchMassPlantingEventDataModelList = null;

    public List<FetchMassPlantingEventDataModel> getFetchMassPlantingEventDataModelList() {
        return fetchMassPlantingEventDataModelList;
    }

    public void setFetchMassPlantingEventDataModelList(List<FetchMassPlantingEventDataModel> fetchMassPlantingEventDataModelList) {
        this.fetchMassPlantingEventDataModelList = fetchMassPlantingEventDataModelList;
    }


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("employee_no")
    @Expose
    private String employeeNo;
    @SerializedName("employee_name")
    @Expose
    private String employeeName;
    @SerializedName("location_venu")
    @Expose
    private String locationVenu;
    @SerializedName("chief_guest")
    @Expose
    private String chiefGuest;
    @SerializedName("date_of_event")
    @Expose
    private String dateOfEvent;
    @SerializedName("no_of_plants_planted")
    @Expose
    private String noOfPlantsPlanted;
    @SerializedName("no_of_plants_distributed")
    @Expose
    private String noOfPlantsDistributed;
    @SerializedName("spring_moon_soon")
    @Expose
    private String springMoonSoon;
    @SerializedName("total_no_of_plants")
    @Expose
    private String totalNoOfPlants;
    @SerializedName("date_time")
    @Expose
    private String dateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLocationVenu() {
        return locationVenu;
    }

    public void setLocationVenu(String locationVenu) {
        this.locationVenu = locationVenu;
    }

    public String getChiefGuest() {
        return chiefGuest;
    }

    public void setChiefGuest(String chiefGuest) {
        this.chiefGuest = chiefGuest;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getNoOfPlantsPlanted() {
        return noOfPlantsPlanted;
    }

    public void setNoOfPlantsPlanted(String noOfPlantsPlanted) {
        this.noOfPlantsPlanted = noOfPlantsPlanted;
    }

    public String getNoOfPlantsDistributed() {
        return noOfPlantsDistributed;
    }

    public void setNoOfPlantsDistributed(String noOfPlantsDistributed) {
        this.noOfPlantsDistributed = noOfPlantsDistributed;
    }

    public String getSpringMoonSoon() {
        return springMoonSoon;
    }

    public void setSpringMoonSoon(String springMoonSoon) {
        this.springMoonSoon = springMoonSoon;
    }

    public String getTotalNoOfPlants() {
        return totalNoOfPlants;
    }

    public void setTotalNoOfPlants(String totalNoOfPlants) {
        this.totalNoOfPlants = totalNoOfPlants;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
