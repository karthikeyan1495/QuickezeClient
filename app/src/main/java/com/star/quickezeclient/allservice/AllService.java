package com.star.quickezeclient.allservice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.star.quickezeclient.allservice.viewmodal.AllServiceVm;
import com.star.quickezeclient.R;
import com.star.quickezeclient.databinding.ActivityAllserviceBinding;

public class AllService  extends AppCompatActivity {

    ActivityAllserviceBinding binding;
    AllServiceVm allServiceVm;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();

    }

    private void bindview() {

        binding=DataBindingUtil.setContentView(this,R.layout.activity_allservice);
        allServiceVm=new AllServiceVm(this,binding);
        binding.setAllserviceVm(allServiceVm);

    }
}
