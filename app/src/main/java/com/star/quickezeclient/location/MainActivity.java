package com.star.quickezeclient.location;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.star.quickezeclient.R;
import com.star.quickezeclient.databinding.ActivityMainBinding;
import com.star.quickezeclient.location.viewmodal.MainActivityVm;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    MainActivityVm mainActivityVm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindview();

    }

    private void bindview() {

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityVm=new MainActivityVm(this,binding);
        binding.setMainActivityVm(mainActivityVm);

    }
}
