package com.star.quickezeclient.otp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.star.quickezeclient.R;
import com.star.quickezeclient.databinding.ActivityOtpBinding;
import com.star.quickezeclient.otp.viewmodal.OtpActivityVm;

public class OtpActivity extends AppCompatActivity {

    OtpActivityVm otpActivityVm;

    ActivityOtpBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=DataBindingUtil.setContentView(this,R.layout.activity_otp);
        otpActivityVm=new OtpActivityVm(this,binding);
        binding.setOtpVm(otpActivityVm);

    }
}
