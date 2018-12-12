package com.star.quickezeclient.allservice.adaptor;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.star.quickezeclient.R;
import com.star.quickezeclient.allservice.modal.ServiceData;
import com.star.quickezeclient.databinding.AllserviceAdaptorBinding;
import com.star.quickezeclient.recommendedservice.RecommendedActivity;

import java.util.List;

public class AllServiceAdaptor extends RecyclerView.Adapter<AllServiceAdaptor.ViewHolder> {

    Activity activity;
    List<ServiceData> data;


    public AllServiceAdaptor(Activity activity, List<ServiceData> data) {

        this.activity=activity;
        this.data=data;

    }

    @Override
    public AllServiceAdaptor.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        AllserviceAdaptorBinding binding = DataBindingUtil.inflate(inflater, R.layout.allservice_adaptor, parent, false);
        return new AllServiceAdaptor.ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(AllServiceAdaptor.ViewHolder viewHolder, int position) {

        ServiceData datas=data.get(position);

        viewHolder.binding.text.setText(datas.getService_name());

        viewHolder.binding.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.startActivity(new Intent(activity,RecommendedActivity.class));


            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AllserviceAdaptorBinding binding;
        public ViewHolder(AllserviceAdaptorBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
