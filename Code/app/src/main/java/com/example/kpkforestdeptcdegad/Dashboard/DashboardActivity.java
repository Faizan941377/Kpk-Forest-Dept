package com.example.kpkforestdeptcdegad.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kpkforestdeptcdegad.Dashboard.Fragment.DashboardFragment;
import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.SharePrefManager;
import com.example.kpkforestdeptcdegad.user.LoginActivity;
import com.example.kpkforestdeptcdegad.user.Profile.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashboardActivity extends AppCompatActivity{


    public static String IMAGE_BASE_URL = "http://192.168.43.174:82/forestApi/images/";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    TextView profileNameTV;
    TextView profileContactTV;
    TextView profileEmailTV;
    CircleImageView profileImageIV;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        if (savedInstanceState == null) {
            DashboardFragment f1 = new DashboardFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_Layout, f1);
            fragmentTransaction.commit();

        }


        drawerLayout = findViewById(R.id.dl_dashboard_drawer);
        navigationView = findViewById(R.id.navigationDrawer);

        // for accessing the headerNav
        View headerView = navigationView.getHeaderView(0);
        profileNameTV = headerView.findViewById(R.id.tv_profile_name);
        profileContactTV = headerView.findViewById(R.id.tv_profile_contact);
        profileEmailTV = headerView.findViewById(R.id.tv_profile_email);
        profileImageIV = headerView.findViewById(R.id.iv_dashboard_profile);


        //Here I will fetch save data from sharedPreferences and pass to the required textViews

        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        profileNameTV.setText("" + loginModel.getFull_name());
        profileContactTV.setText("" + loginModel.getMobile());
        profileEmailTV.setText("" + loginModel.getEmail());
        String path = RetrofitClient.IMAGE_BASE_URL + loginModel.getImage() + "";
        Glide.with(this).load(path).into(profileImageIV);


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Here i will change the action bar color pragmatically

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2b9f4c")));
        setDrawerContent(navigationView);

        // progress Dialog
        progressDialog  = new ProgressDialog(this);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer(MenuItem menuItem) {
        Fragment fragment = null;

        Class fragmentClass;

        switch (menuItem.getItemId()) {
            case R.id.menu_dashboard:
                fragmentClass = DashboardFragment.class;
                break;

            case R.id.menu_profile:
                fragmentClass = ProfileFragment.class;
                break;

            case R.id.menu_logout:
                fragmentClass = LoginActivity.class;
                logout();

                finish();
                break;
            default:
                fragmentClass = DashboardFragment.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_Layout, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();

    }


    private void logout() {
        SharePrefManager.getInstance(this).clear();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    private void setDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return false;
            }
        });
    }
}