package com.example.kpkforestdeptcdegad.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Dashboard.DashboardActivity;
import com.example.kpkforestdeptcdegad.R;
import com.google.android.material.textfield.TextInputEditText;

public class EmailVerificationActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText verityCodeET;
    LinearLayout submitBT;
    TextView resendCodeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        verityCodeET = findViewById(R.id.et_verify_email);
        submitBT = findViewById(R.id.bt_verify_submit);
        resendCodeTV = findViewById(R.id.tv_verify_resend_Code);

        submitBT.setOnClickListener(this);
        resendCodeTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_verify_submit:
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
                break;

            case R.id.tv_verify_resend_Code:
                Toast.makeText(this, "Code resend Successfully!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}