package com.example.kpkforestdeptcdegad.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CelebrationOfEnvironmentalPlantingEventResponse {


    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("message")
    @Expose
    private String message;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
