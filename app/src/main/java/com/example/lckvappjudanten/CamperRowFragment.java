package com.example.lckvappjudanten;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class CamperRowFragment extends Fragment implements View.OnClickListener {

    private String name;
    private Double balance;
    private ViewGroup mContainer;
//    private FragmentActivity myContext;


    public CamperRowFragment(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.camper_row_view, container, false);
        mContainer = container;
        mContainer.setOnClickListener(this);

        return v;
    }
    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        TextView store_name = (TextView) getView().findViewById(R.id.store_name);
        TextView store_balance = (TextView) getView().findViewById(R.id.store_balance);
        store_name.setText(this.name);
        NumberFormat df = DecimalFormat.getInstance();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(4);
        df.setRoundingMode(RoundingMode.DOWN);
        String new_balance = "€" + df.format(this.balance);
        store_balance.setText(new_balance);
    }

//    @Override
//    public void onAttach(Context context) {
//        myContext=(FragmentActivity) context;
//        super.onAttach(context);
//    }

    @Override
    public void onClick(View v) {
        Log.d("tag", "onClick: " + mContainer.getId());
    }
}