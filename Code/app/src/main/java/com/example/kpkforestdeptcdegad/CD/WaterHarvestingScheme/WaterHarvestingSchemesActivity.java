package com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter.WaterHarvestingScheme_Adapter;
import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.WaterHarvestingSchemeResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WaterHarvestingSchemesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameOfDivisionET;
    EditText employeeNoET;
    EditText employeeNameET;
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
        setContentView(R.layout.activity_water_harvesting_schemes);

        nameOfDivisionET = findViewById(R.id.et_waterHarvestingScheme_NameOfDivision);
        employeeNoET = findViewById(R.id.et_waterHarvestingScheme_empNo);
        employeeNameET = findViewById(R.id.et_waterHarvestingScheme_empName);
        nameOfForestDivisionET = findViewById(R.id.et_waterHarvestingScheme_NameOfForestDivision);
        targetAsPC1ET = findViewById(R.id.et_waterHarvestingScheme_TargetAsPC1);
        achievedSoFarNoET = findViewById(R.id.et_waterHarvestingScheme_AchievedSoFarNo);
        vdcEstablishedET = findViewById(R.id.et_waterHarvestingScheme_vdcEstablish);
        progressTillDateET = findViewById(R.id.et_waterHarvestingScheme_progressTillDate);
        submitBT = findViewById(R.id.bt_waterHarvestingScheme_submit);

        submitBT.setOnClickListener(this);

        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);

        progressDialog = new ProgressDialog(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_waterHarvestingScheme_submit:
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


        if (nameOfDivisionET.length() == 0){
            nameOfDivisionET.setError("Enter the name of division");
        }else if (nameOfForestDivisionET.length()== 0){
            nameOfForestDivisionET.setError("Enter the name of Forest Division");
        }else if (targetAsPC1ET.length()== 0 ){
            targetAsPC1ET.setError("Enter the target as PC1");
        }else if (achievedSoFarNoET.length()== 0 ){
            achievedSoFarNoET.setError("Enter the achieved so far No");
        }else if (vdcEstablishedET.length()== 0){
            vdcEstablishedET.setError("Enter the vdc established");
        }else if (progressTillDateET.length()== 0 ){
            progressTillDateET.setError("Enter the progress till date");
        }else {


            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<WaterHarvestingSchemeResponse> call = RetrofitClient.getInstance().getApi().waterHarvestingResponse(employeeNo,
                    employeeName,nameOfDivision,nameOfForestDivision,targetAsPC1,achievedSoFarNo,vdcEstablished,progressTillDate);
            call.enqueue(new Callback<WaterHarvestingSchemeResponse>() {
                @Override
                public void onResponse(Call<WaterHarvestingSchemeResponse> call, Response<WaterHarvestingSchemeResponse> response) {
                    WaterHarvestingSchemeResponse waterHarvestingSchemeResponse = response.body();
                    if (response.isSuccessful()){
                        progressDialog.dismiss();
                        if (waterHarvestingSchemeResponse.equals("200")){
                            Toast.makeText(WaterHarvestingSchemesActivity.this,waterHarvestingSchemeResponse.getMessage() , Toast.LENGTH_SHORT).show();
                        }else if (waterHarvestingSchemeResponse.equals("400")){
                            Toast.makeText(WaterHarvestingSchemesActivity.this, waterHarvestingSchemeResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<WaterHarvestingSchemeResponse> call, Throwable t) {
                    try {
                        Toast.makeText(WaterHarvestingSchemesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });

        }
    }
}