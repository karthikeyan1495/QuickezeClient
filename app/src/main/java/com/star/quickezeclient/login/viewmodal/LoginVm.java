package com.star.quickezeclient.login.viewmodal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.star.quickezeclient.R;
import com.star.quickezeclient.api.APIConfiguration;
import com.star.quickezeclient.api.APIErrorHandler;
import com.star.quickezeclient.api.ApiCall;
import com.star.quickezeclient.api.GeneralResponse;
import com.star.quickezeclient.databinding.ActivityLoginBinding;
import com.star.quickezeclient.location.MainActivity;
import com.star.quickezeclient.login.modal.Loginmodal;
import com.star.quickezeclient.otp.OtpActivity;
import com.star.quickezeclient.sharedprefeence.MySession;
import com.star.quickezeclient.utils.InternetChecker;
import com.star.quickezeclient.utils.MyProgressDialog;
import com.star.quickezeclient.utils.MySnackBar;
import com.star.quickezeclient.utils.Util;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class LoginVm {
    Activity activity;
    ActivityLoginBinding binding;
    MyProgressDialog myProgressDialog;
    Loginmodal loginmodal;
    public LoginVm(Activity activity, ActivityLoginBinding binding) {

        this.activity=activity;
        this.binding=binding;
        loginmodal=new Loginmodal();
        myProgressDialog=new MyProgressDialog();

    }

    public void onClicklogin(View view){

        if(binding.mobile.getText().toString().trim().length()==0){

            MySnackBar.getInstance().showNagativeSnackBar(activity,"Please enter the mobile number");
        }
        else if(!Util.getInstance().Mobile_No_Validator(binding.mobile.getText().toString())){

            MySnackBar.getInstance().showNagativeSnackBar(activity,"Please enter the correct number");

        }else {

            callApi();
        }
    }

    private void callApi() {


        loginmodal.setMobile(binding.mobile.getText().toString());

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);

            ApiCall api = APIConfiguration.getInstance().createService(ApiCall.class);

            Observable<Response<GeneralResponse>> observable = api.login(loginmodal);
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();

                        if (responses.code() == 200) {

                            GeneralResponse generalResponse=responses.body();

                            if(generalResponse.isResult()){

                                Toast.makeText(activity,generalResponse.getMessage(),Toast.LENGTH_LONG).show();
                                MySession.getInstance(activity).saveMobile(binding.mobile.getText().toString());

                                activity.startActivity(new Intent(activity,OtpActivity.class));


                            }else {

                                MySnackBar.getInstance().showNagativeSnackBar(activity,generalResponse.getMessage());
                            }

                        } else {
                            if (responses.body() != null) {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.body().getMessage());
                            } else {
                                APIErrorHandler.getInstance().errorHandler(activity, responses.code(), responses.errorBody().string());
                            }
                        }
                    }, throwable -> {
                        myProgressDialog.dismissDialog();
                        MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.something_went_wrong_while_retrieving_information));

                    });

        } else {
            MySnackBar.getInstance().showNagativeSnackBar(activity, activity.getString(R.string.no_internet));
        }

    }


    public void onClickskip(View view){


        activity.startActivity(new Intent(activity,MainActivity.class));
    }
}
