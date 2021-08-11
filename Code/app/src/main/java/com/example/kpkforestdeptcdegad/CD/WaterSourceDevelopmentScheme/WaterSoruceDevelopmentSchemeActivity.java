package com.example.kpkforestdeptcdegad.CD.WaterSourceDevelopmentScheme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.WaterSourceDevelopmentSchemeResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WaterSoruceDevelopmentSchemeActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeNoET;
    EditText employeeNameET;
    EditText nameOfDivisionET;
    EditText nameOfForestDivisionET;
    EditText targetAsPC1ET;
    EditText achievedSoFarNoET;
    EditText vdcEstablishedET;
    EditText progressTillDateET;
    ProgressDialog progressDialog;
    LinearLayout submitBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_soruce_development_scheme);

        employeeNoET = findViewById(R.id.et_WaterSourceDevelop_empNo);
        employeeNameET = findViewById(R.id.et_WaterSourceDevelop_empName);
        nameOfDivisionET = findViewById(R.id.et_WaterSourceDevelop_nameOfDivision);
        nameOfForestDivisionET = findViewById(R.id.et_WaterSourceDevelop_nameOfForestDivision);
        targetAsPC1ET = findViewById(R.id.et_WaterSourceDevelop_TargetAsPC1);
        achievedSoFarNoET = findViewById(R.id.et_WaterSourceDevelop_AchievedSoFarNo);
        vdcEstablishedET = findViewById(R.id.et_WaterSourceDevelop_vdcEstablish);
        progressTillDateET = findViewById(R.id.et_WaterSourceDevelop_progressTillDate);
        submitBT = findViewById(R.id.bt_waterSourceDevelopmentSchemes_submit);


        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);

        progressDialog = new ProgressDialog(this);

        submitBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_waterSourceDevelopmentSchemes_submit:
                submit();
                break;
        }
    }

    private void submit() {
        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String nameOfDivision = nameOfDivisionET.getText().toString();
        String nameOfForestDivision = nameOfForestDivisionET.getText().toString();
        String targetAsPC1 = targetAsPC1ET.getText().toString();
        String achievedSoFarNo = achievedSoFarNoET.getText().toString();
        String vdcEstablished = vdcEstablishedET.getText().toString();
        String progressTillDate = progressTillDateET.getText().toString();

        if (employeeNoET.length() == 0) {
            employeeNoET.setError("Enter the employee No");
        } else if (employeeNameET.length() == 0) {
            employeeNameET.setError("Enter the your name");
        } else if (nameOfDivisionET.length() == 0) {
            nameOfDivisionET.setError("Enter the division name");
        } else if (nameOfForestDivisionET.length() == 0) {
            nameOfForestDivisionET.setError("Enter the forest division name");
        } else if (targetAsPC1ET.length() == 0) {
            targetAsPC1ET.setError("Enter the target as PC1");
        } else if (achievedSoFarNoET.length() == 0) {
            achievedSoFarNoET.setError("Enter the achieved so far No");
        } else if (vdcEstablishedET.length() == 0) {
            vdcEstablishedET.setError("Enter the vdc established");
        } else if (progressTillDateET.length() == 0) {
            progressTillDateET.setError("Enter the progress till date");
        } else {


            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<WaterSourceDevelopmentSchemeResponse> call = RetrofitClient.getInstance().getApi().waterSourceDevelopmentSchemeResponse(
                    employeeNo, employeeName, nameOfDivision, nameOfForestDivision,
                    targetAsPC1, achievedSoFarNo, vdcEstablished, progressTillDate);
            call.enqueue(new Callback<WaterSourceDevelopmentSchemeResponse>() {
                @Override
                public void onResponse(Call<WaterSourceDevelopmentSchemeResponse> call, Response<WaterSourceDevelopmentSchemeResponse> response) {
                    WaterSourceDevelopmentSchemeResponse waterSourceDevelopmentSchemeResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        if (waterSourceDevelopmentSchemeResponse.equals("200")) {
                            Toast.makeText(WaterSoruceDevelopmentSchemeActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        } else if (waterSourceDevelopmentSchemeResponse.equals("400")) {
                            Toast.makeText(WaterSoruceDevelopmentSchemeActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<WaterSourceDevelopmentSchemeResponse> call, Throwable t) {
                    try {
                        Toast.makeText(WaterSoruceDevelopmentSchemeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}