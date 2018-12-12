package com.star.quickezeclient.allservice.modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllserviceModal {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ServiceData> getData() {
        return data;
    }

    public void setData(List<ServiceData> data) {
        this.data = data;
    }

    @SerializedName("message")
    String message;

    @SerializedName("data")
    List<ServiceData> data;

}
