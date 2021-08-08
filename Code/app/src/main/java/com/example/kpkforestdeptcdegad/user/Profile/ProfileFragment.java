package com.example.kpkforestdeptcdegad.user.Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kpkforestdeptcdegad.Dashboard.DashboardActivity;
import com.example.kpkforestdeptcdegad.Dashboard.Fragment.DashboardFragment;
import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.SharePrefManager;
import com.example.kpkforestdeptcdegad.user.LoginActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    TextView nameTV;
    TextView emailTV;
    TextView cnicTV;
    TextView employeeNoTV;
    TextView genderTV;
    TextView divisionTV;
    TextView mobileTV;
    TextView joiningDateTV;
    CardView dashboardBT;
    CardView logoutBT;
    LinearLayout updateProfileBT;
    CircleImageView profileImageIV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nameTV = view.findViewById(R.id.tv_profile_name);
        profileImageIV = view.findViewById(R.id.iv_profile_profileImage);
        emailTV = view.findViewById(R.id.tv_profile_email);
        cnicTV = view.findViewById(R.id.tv_profile_cnic);
        employeeNoTV = view.findViewById(R.id.tv_profile_employeeNo);
        genderTV = view.findViewById(R.id.tv_profile_gender);
        divisionTV = view.findViewById(R.id.tv_profile_division);
        mobileTV = view.findViewById(R.id.tv_profile_mobile);
        joiningDateTV = view.findViewById(R.id.tv_profile_joiningDate);
        dashboardBT = view.findViewById(R.id.bt_profile_dashboard);
        logoutBT = view.findViewById(R.id.bt_profile_logout);
        updateProfileBT = view.findViewById(R.id.bt_profile_update);


        updateProfileBT.setOnClickListener(this);
        dashboardBT.setOnClickListener(this);
        logoutBT.setOnClickListener(this);

        LoginModel loginModel = SharePrefManager.getInstance(getActivity()).getUsers();
        nameTV.setText("" + loginModel.getFull_name());
        emailTV.setText("" + loginModel.getEmail());
        cnicTV.setText("" + loginModel.getCnic());
        employeeNoTV.setText("" + loginModel.getEmployee_no());
        genderTV.setText("" + loginModel.getGender());
        divisionTV.setText("" + loginModel.getDivision());
        mobileTV.setText("" + loginModel.getMobile());
        joiningDateTV.setText("" + loginModel.getData_time());

        String path = RetrofitClient.IMAGE_BASE_URL + loginModel.getImage() + "";
        Glide.with(this).load(path).into(profileImageIV);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_profile_update:
                Intent intent = new Intent(getActivity(),UpdateProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_profile_dashboard:
                Intent intent1 = new Intent(getActivity(), DashboardActivity.class);
                startActivity(intent1);
                break;

            case R.id.bt_profile_logout:
                logout();
                Toast.makeText(getActivity(), "Logging Out...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void logout() {
        SharePrefManager.getInstance(getActivity()).clear();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}