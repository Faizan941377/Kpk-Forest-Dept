package com.example.kpkforestdeptcdegad.Dashboard.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kpkforestdeptcdegad.CD.CD_Activity;
import com.example.kpkforestdeptcdegad.Extension.ExtensionActivity;
import com.example.kpkforestdeptcdegad.GAD.GADActivity;
import com.example.kpkforestdeptcdegad.HR.HRActivity;
import com.example.kpkforestdeptcdegad.R;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    CardView cdBT;
    CardView hrBT;
    CardView extensionBT;
    CardView gadBT;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        cdBT = view.findViewById(R.id.cv_dashboard_cd);
        hrBT = view.findViewById(R.id.cv_dashboard_hr);
        extensionBT = view.findViewById(R.id.cd_dashboard_Extension);
        gadBT = view.findViewById(R.id.cd_dashboard_GAD);

        cdBT.setOnClickListener(this);
        hrBT.setOnClickListener(this);
        extensionBT.setOnClickListener(this);
        gadBT.setOnClickListener(this);
        extensionBT.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_dashboard_cd:
                Intent intent = new Intent(getActivity(), CD_Activity.class);
                startActivity(intent);
                break;

            case R.id.cv_dashboard_hr:
                Intent intent1 = new Intent(getActivity(), HRActivity.class);
                startActivity(intent1);
                break;

            case R.id.cd_dashboard_GAD:
                Intent intent3 = new Intent(getActivity(), GADActivity.class);
                startActivity(intent3);
                break;

            case R.id.cd_dashboard_Extension:
                Intent intent4 = new Intent(getActivity(), ExtensionActivity.class);
                startActivity(intent4);
                break;
        }
    }
}