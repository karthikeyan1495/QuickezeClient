package com.star.quickezeclient.allservice.viewmodal;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import com.star.quickezeclient.R;
import com.star.quickezeclient.allservice.adaptor.AllServiceAdaptor;
import com.star.quickezeclient.allservice.modal.AllserviceModal;
import com.star.quickezeclient.allservice.modal.ServiceData;
import com.star.quickezeclient.api.APIConfiguration;
import com.star.quickezeclient.api.APIErrorHandler;
import com.star.quickezeclient.api.ApiCall;
import com.star.quickezeclient.databinding.ActivityAllserviceBinding;
import com.star.quickezeclient.utils.InternetChecker;
import com.star.quickezeclient.utils.MyProgressDialog;
import com.star.quickezeclient.utils.MySnackBar;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class AllServiceVm {
    Activity activity;
    ActivityAllserviceBinding binding;
    MyProgressDialog myProgressDialog;


    public AllServiceVm(Activity activity, ActivityAllserviceBinding binding) {

        this.activity=activity;
        this.binding=binding;
        myProgressDialog=new MyProgressDialog();
        callApi();
    }

    private void callApi() {

        if (InternetChecker.getInstance().isReachable()) {
            myProgressDialog.showDialog(activity);

            ApiCall api = APIConfiguration.getInstance().createService(ApiCall.class);
            Observable<Response<AllserviceModal>> observable = api.allservice();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responses -> {
                        myProgressDialog.dismissDialog();

                        if (responses.code() == 200) {

                            AllserviceModal allserviceModal=responses.body();

                            setupRecycleView(allserviceModal.getData());

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

    private void setupRecycleView(List<ServiceData> data) {


        binding.recycleView.setLayoutManager(new LinearLayoutManager(activity));

        AllServiceAdaptor  adaptor=new AllServiceAdaptor(activity,data);
        binding.recycleView.setAdapter(adaptor);


    }
}
