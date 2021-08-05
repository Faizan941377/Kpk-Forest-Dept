package com.example.kpkforestdeptcdegad.Model;

public class LoginModel {
    private String id;
    private String full_name;
    private String email;
    private String mobile;
    private String image;


    public LoginModel(String id, String full_name, String email, String mobile, String image) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.mobile = mobile;
        this.image = image;

    }

    public LoginModel(String full_name, String email, String mobile, String image) {
        this.full_name = full_name;
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
