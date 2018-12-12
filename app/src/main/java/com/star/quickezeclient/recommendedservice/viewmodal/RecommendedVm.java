package com.star.quickezeclient.recommendedservice.viewmodal;

import android.app.Activity;

import com.star.quickezeclient.databinding.ActivityServiceRecommendBinding;
import com.star.quickezeclient.recommendedservice.RecommendedActivity;

public class RecommendedVm {

    Activity activity;
    ActivityServiceRecommendBinding binding;
    public RecommendedVm(Activity activity, ActivityServiceRecommendBinding binding) {

        this.activity=activity;
        this.binding=binding;
    }
}
