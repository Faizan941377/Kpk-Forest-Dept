package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchFarmForestryDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchFarmForestryResponse {


    @SerializedName("users")
    @Expose
    private List<FetchFarmForestryDataModel> fetchFarmForestryDataModelList = null;

    public List<FetchFarmForestryDataModel> getFetchFarmForestryDataModelList() {
        return fetchFarmForestryDataModelList;
    }

    public void setUsers(List<FetchFarmForestryDataModel> fetchFarmForestryDataModelList) {
        this.fetchFarmForestryDataModelList = fetchFarmForestryDataModelList;
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
    @SerializedName("name_of_forest_division")
    @Expose
    private String nameOfForestDivision;
    @SerializedName("name_of_sub_division")
    @Expose
    private String nameOfSubDivision;
    @SerializedName("plants_distributed_today")
    @Expose
    private String plantsDistributedToday;
    @SerializedName("total_no_of_plants_distributed_today")
    @Expose
    private String totalNoOfPlantsDistributedToday;
    @SerializedName("total_no_of_plants_distribute_till_date")
    @Expose
    private String totalNoOfPlantsDistributeTillDate;
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

    public String getNameOfForestDivision() {
        return nameOfForestDivision;
    }

    public void setNameOfForestDivision(String nameOfForestDivision) {
        this.nameOfForestDivision = nameOfForestDivision;
    }

    public String getNameOfSubDivision() {
        return nameOfSubDivision;
    }

    public void setNameOfSubDivision(String nameOfSubDivision) {
        this.nameOfSubDivision = nameOfSubDivision;
    }

    public String getPlantsDistributedToday() {
        return plantsDistributedToday;
    }

    public void setPlantsDistributedToday(String plantsDistributedToday) {
        this.plantsDistributedToday = plantsDistributedToday;
    }

    public String getTotalNoOfPlantsDistributedToday() {
        return totalNoOfPlantsDistributedToday;
    }

    public void setTotalNoOfPlantsDistributedToday(String totalNoOfPlantsDistributedToday) {
        this.totalNoOfPlantsDistributedToday = totalNoOfPlantsDistributedToday;
    }

    public String getTotalNoOfPlantsDistributeTillDate() {
        return totalNoOfPlantsDistributeTillDate;
    }

    public void setTotalNoOfPlantsDistributeTillDate(String totalNoOfPlantsDistributeTillDate) {
        this.totalNoOfPlantsDistributeTillDate = totalNoOfPlantsDistributeTillDate;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
