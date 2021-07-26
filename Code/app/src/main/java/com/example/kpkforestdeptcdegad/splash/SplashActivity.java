package com.example.kpkforestdeptcdegad.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.kpkforestdeptcdegad.CD.VDC.VDC_Activity;
import com.example.kpkforestdeptcdegad.Dashboard.DashboardActivity;
import com.example.kpkforestdeptcdegad.Dashboard.Fragment.DashboardFragment;
import com.example.kpkforestdeptcdegad.MainActivity;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.user.LoginActivity;
import com.example.kpkforestdeptcdegad.user.RegistrationActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}