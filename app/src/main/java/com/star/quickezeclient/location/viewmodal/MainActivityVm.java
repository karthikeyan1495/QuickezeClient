package com.star.quickezeclient.location.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.star.quickezeclient.databinding.ActivityMainBinding;
import com.star.quickezeclient.recommendedservice.RecommendedActivity;

public class MainActivityVm {
    Activity activity;
    ActivityMainBinding binding;

    public MainActivityVm(Activity activity, ActivityMainBinding binding) {

        this.activity=activity;
        this.binding=binding;

    }

    public void onClickcurrentLation(View view){

        activity.startActivity(new Intent(activity,RecommendedActivity.class));

      //  activity.startActivity(new Intent(activity,AllService.class));
    }
}
