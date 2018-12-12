package com.star.quickezeclient.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.star.quickezeclient.R;
import com.star.quickezeclient.databinding.ActivityLoginBinding;
import com.star.quickezeclient.login.viewmodal.LoginVm;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginVm loginVm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindview();

    }

    private void bindview() {


        binding=DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginVm=new LoginVm(this,binding);
        binding.setLoginVm(loginVm);

    }
}
