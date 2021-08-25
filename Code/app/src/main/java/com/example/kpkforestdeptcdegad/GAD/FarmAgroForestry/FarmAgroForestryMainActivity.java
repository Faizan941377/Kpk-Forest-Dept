package com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry;

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
import com.example.kpkforestdeptcdegad.Response.FarmAgroForestryResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FarmAgroForestryMainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeNoET;
    EditText employeeNameET;
    EditText gadAddET;
    EditText otherActivitiesET;
    EditText nameOfWomenOrganizationET;
    EditText nameOfMajorActivitiesET;
    EditText nameOfVillageET;
    LinearLayout submitBT;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_agro_forestry_main);

        employeeNoET = findViewById(R.id.et_farmAgroForestry_employeeNo);
        employeeNameET = findViewById(R.id.et_farmAgroForestry_employeeName);
        gadAddET = findViewById(R.id.et_farmAgroForestry_gadAdd);
        otherActivitiesET = findViewById(R.id.et_farmAgroForestry_otherActivities);
        nameOfWomenOrganizationET = findViewById(R.id.et_farmAgroForestry_nameOfWomenOrganization);
        nameOfMajorActivitiesET = findViewById(R.id.et_farmAgroForestry_nameOfMajorActivities);
        nameOfVillageET = findViewById(R.id.et_farmAgroForestry_nameOfVillage);
        submitBT = findViewById(R.id.bt_farmAgroForestry_submit);

        submitBT.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_farmAgroForestry_submit:
                submitFarmAgroForestry();
                break;
        }
    }

    private void submitFarmAgroForestry() {

        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String gadAdd = gadAddET.getText().toString();
        String otherActivity = otherActivitiesET.getText().toString();
        String nameOfWomenOrganization = nameOfWomenOrganizationET.getText().toString();
        String nameOfMajorActivities = nameOfMajorActivitiesET.getText().toString();
        String nameOfVillage = nameOfVillageET.getText().toString();

        if (gadAddET.length() == 0) {
            gadAddET.setError("Enter the Gad Add");
        } else if (otherActivitiesET.length() == 0) {
            otherActivitiesET.setError("Enter the other activities");
        } else if (nameOfWomenOrganizationET.length() == 0) {
            nameOfWomenOrganizationET.setError("Enter the name of women organization");
        } else if (nameOfMajorActivitiesET.length() == 0) {
            nameOfMajorActivitiesET.setError("Enter the name of major activities");
        } else if (nameOfVillageET.length() == 0) {
            nameOfVillageET.setError("Enter the name of village");
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(true);
            progressDialog.setIndeterminate(true);

            Call<FarmAgroForestryResponse> call = RetrofitClient.getInstance().getApi().farmAgroForestryResponse(employeeNo, employeeName,
                    gadAdd, otherActivity, nameOfWomenOrganization, nameOfMajorActivities, nameOfVillage);
            call.enqueue(new Callback<FarmAgroForestryResponse>() {
                @Override
                public void onResponse(Call<FarmAgroForestryResponse> call, Response<FarmAgroForestryResponse> response) {
                    FarmAgroForestryResponse farmAgroForestryResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        if (farmAgroForestryResponse.getError().equals("200")) {
                            Toast.makeText(FarmAgroForestryMainActivity.this, farmAgroForestryResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (farmAgroForestryResponse.getError().equals("400")) {
                            Toast.makeText(FarmAgroForestryMainActivity.this, farmAgroForestryResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<FarmAgroForestryResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    try {
                        Toast.makeText(FarmAgroForestryMainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}