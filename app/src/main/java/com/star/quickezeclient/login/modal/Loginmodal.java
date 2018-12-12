package com.star.quickezeclient.login.modal;

import com.google.gson.annotations.SerializedName;

public class Loginmodal {

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @SerializedName("mobile")
    String mobile;

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    @SerializedName("otp")
    String otp;


}
