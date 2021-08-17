package com.example.kpkforestdeptcdegad.Response;

import com.example.kpkforestdeptcdegad.Model.FetchYouthWomenNurseryDataModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchYouthWomenNurseryResponse {

    @SerializedName("users")
    @Expose
    private List<FetchYouthWomenNurseryDataModel> fetchYouthWomenNurseryDataModelList = null;

    public List<FetchYouthWomenNurseryDataModel> getFetchYouthWomenNurseryDataModelList() {
        return fetchYouthWomenNurseryDataModelList;
    }

    public void setUsers(List<FetchYouthWomenNurseryDataModel> fetchYouthWomenNurseryDataModelList) {
        this.fetchYouthWomenNurseryDataModelList = fetchYouthWomenNurseryDataModelList;
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
    @SerializedName("name_of_division")
    @Expose
    private String nameOfDivision;
    @SerializedName("name_of_sub_division_range")
    @Expose
    private String nameOfSubDivisionRange;
    @SerializedName("vdc_wo")
    @Expose
    private String vdcWo;
    @SerializedName("name_of_nursery_owner")
    @Expose
    private String nameOfNurseryOwner;
    @SerializedName("location_village_name")
    @Expose
    private String locationVillageName;
    @SerializedName("limits")
    @Expose
    private String limits;
    @SerializedName("time_date")
    @Expose
    private String timeDate;

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

    public String getNameOfDivision() {
        return nameOfDivision;
    }

    public void setNameOfDivision(String nameOfDivision) {
        this.nameOfDivision = nameOfDivision;
    }

    public String getNameOfSubDivisionRange() {
        return nameOfSubDivisionRange;
    }

    public void setNameOfSubDivisionRange(String nameOfSubDivisionRange) {
        this.nameOfSubDivisionRange = nameOfSubDivisionRange;
    }

    public String getVdcWo() {
        return vdcWo;
    }

    public void setVdcWo(String vdcWo) {
        this.vdcWo = vdcWo;
    }

    public String getNameOfNurseryOwner() {
        return nameOfNurseryOwner;
    }

    public void setNameOfNurseryOwner(String nameOfNurseryOwner) {
        this.nameOfNurseryOwner = nameOfNurseryOwner;
    }

    public String getLocationVillageName() {
        return locationVillageName;
    }

    public void setLocationVillageName(String locationVillageName) {
        this.locationVillageName = locationVillageName;
    }

    public String getLimits() {
        return limits;
    }

    public void setLimits(String limits) {
        this.limits = limits;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
}
