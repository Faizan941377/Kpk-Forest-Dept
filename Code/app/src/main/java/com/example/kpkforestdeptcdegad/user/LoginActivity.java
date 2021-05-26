package com.example.kpkforestdeptcdegad.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kpkforestdeptcdegad.Dashboard.DashboardActivity;
import com.example.kpkforestdeptcdegad.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText emailET;
    TextInputEditText passwordET;
    LinearLayout loginBT;
    TextView signUpBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.et_email);
        passwordET = findViewById(R.id.et_password);
        loginBT = findViewById(R.id.bt_login);
        signUpBT = findViewById(R.id.bt_signUp);
        signUpBT.setOnClickListener(this);
        loginBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_signUp:
                Intent intent1 = new Intent(this,RegistrationActivity.class);
                startActivity(intent1);
                break;
        }
    }
}