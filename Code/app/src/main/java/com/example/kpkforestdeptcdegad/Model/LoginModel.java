package com.example.kpkforestdeptcdegad.Model;

public class LoginModel {
    private String id;
    private String full_name;
    private String gender;
    private String cnic;
    private String employee_no;
    private String division;
    private String date_time;
    private String email;
    private String mobile;
    private String image;

    public LoginModel(String id, String full_name, String gender, String cnic, String employee_no,
                      String division, String data_time, String email, String mobile, String image) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.cnic = cnic;
        this.employee_no = employee_no;
        this.division = division;
        this.email = email;
        this.mobile = mobile;
        this.image = image;
        this.date_time = data_time;
    }

    public LoginModel(String full_name, String gender, String cnic, String employee_no,
                      String division, String email, String mobile, String image,  String date_time) {
        this.full_name = full_name;
        this.gender = gender;
        this.cnic = cnic;
        this.employee_no = employee_no;
        this.division = division;
        this.date_time = date_time;
        this.email = email;
        this.mobile = mobile;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getData_time() {
        return date_time;
    }

    public void setData_time(String data_time) {
        this.date_time = data_time;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
