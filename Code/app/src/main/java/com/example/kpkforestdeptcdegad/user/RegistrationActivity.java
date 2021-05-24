package com.example.kpkforestdeptcdegad.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.user.spinner.SpinnerMaleFemale;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner genderSP;
    SpinnerMaleFemale spinnerMaleFemale;
    TextInputEditText firstNameET;
    TextInputEditText lastNameET;
    TextInputEditText cnicET;
    TextInputEditText mobileET;
    TextInputEditText divisionET;
    TextInputEditText emailET;
    TextInputEditText passwordET;
    LinearLayout registerBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        genderSP = findViewById(R.id.sp_gender);
        firstNameET = findViewById(R.id.et_register_firstName);
        lastNameET = findViewById(R.id.et_register_lastName);
        cnicET = findViewById(R.id.et_register_cnic);
        mobileET = findViewById(R.id.et_register_mobile);
        divisionET = findViewById(R.id.et_register_division);
        emailET = findViewById(R.id.et_register_email);
        passwordET = findViewById(R.id.et_register_password);
        registerBT = findViewById(R.id.bt_registeration_register);

        registerBT.setOnClickListener(this);

        Select_Gender();

    }

    private void Select_Gender() {

        ArrayList<SpinnerMaleFemale> dataList = new ArrayList<>();
        SpinnerMaleFemale user = new SpinnerMaleFemale("1", "Gender");
        SpinnerMaleFemale user1 = new SpinnerMaleFemale("1", "Male");
        SpinnerMaleFemale user2 = new SpinnerMaleFemale("1", "Female");
        dataList.add(user);
        dataList.add(user1);
        dataList.add(user2);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, dataList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        genderSP.setAdapter(arrayAdapter);

        genderSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                genderSP.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(RegistrationActivity.this, "Please Select your gender!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_registeration_register:
                Intent intent = new Intent(this,EmailVerificationActivity.class);
                startActivity(intent);
                break;
        }
    }
}