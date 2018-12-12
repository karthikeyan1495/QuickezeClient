package com.star.quickezeclient.recommendedservice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import com.star.quickezeclient.R;
import com.star.quickezeclient.databinding.ActivityServiceRecommendBinding;
import com.star.quickezeclient.recommendedservice.viewmodal.RecommendedVm;

public class RecommendedActivity extends AppCompatActivity {

    ActivityServiceRecommendBinding binding;
    RecommendedVm recommendedVm;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      bindview();

    }

    private void bindview() {

        binding=DataBindingUtil.setContentView(this, R.layout.activity_service_recommend);
        recommendedVm=new RecommendedVm(this,binding);
        binding.setRecommendedVm(recommendedVm);

    }
}
