package com.star.quickezeclient.allservice.modal;

import com.google.gson.annotations.SerializedName;

public class ServiceData {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    @SerializedName("id")
    String id;

    @SerializedName("service_name")
    String service_name;


}
