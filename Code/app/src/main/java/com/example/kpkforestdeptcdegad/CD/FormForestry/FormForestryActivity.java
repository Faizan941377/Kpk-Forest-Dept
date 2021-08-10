package com.example.kpkforestdeptcdegad.CD.FormForestry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Model.FetchFarmForestryDataModel;
import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FarmForestryResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import java.time.ZoneId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormForestryActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeNoET;
    EditText employeeNameET;
    EditText nameOfForestDivisionET;
    EditText nameOfSubDivisionET;
    EditText plantsDistributedTodayET;
    EditText totalNoOfPlantsDistributedTodayET;
    EditText totalNoOfPlantsDistributedTillDateET;
    LinearLayout submitBT;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_forestry);

        employeeNoET = findViewById(R.id.et_farm_forestry_empNo);
        employeeNameET = findViewById(R.id.et_farm_forestry_empName);
        nameOfForestDivisionET =findViewById(R.id.et_farm_forestry_NameOfForestDivision);
        nameOfSubDivisionET =findViewById(R.id.et_farm_forestry_NameOfSubDivision);
        plantsDistributedTodayET = findViewById(R.id.et_farm_forestry_PlantsDistributedToday);
        totalNoOfPlantsDistributedTodayET = findViewById(R.id.et_farm_forestry_TotalNoOfPlantsDistributedToday);
        totalNoOfPlantsDistributedTillDateET = findViewById(R.id.et_farm_forestry_TotalNoOfPlantsDistributedTillDate);
        submitBT = findViewById(R.id.bt_Farm_Forestry_submit);

        progressDialog = new ProgressDialog(this);

        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);

        submitBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_Farm_Forestry_submit:
                submit();
        }
    }

    private void submit() {
        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String nameOfForestDivision = nameOfForestDivisionET.getText().toString();
        String nameOfSubDivisionRange = nameOfSubDivisionET.getText().toString();
        String plantsDistributedToday = plantsDistributedTodayET.getText().toString();
        String totalNoOfPlantsDistributedToday = totalNoOfPlantsDistributedTodayET.getText().toString();
        String totalNoOfPlantsDistributedTillDate = totalNoOfPlantsDistributedTillDateET.getText().toString();


        if (nameOfForestDivisionET.length()== 0){
            nameOfForestDivisionET.setError("Enter the Forest Division Name");
        }else if (totalNoOfPlantsDistributedTodayET.length()== 0){
            totalNoOfPlantsDistributedTodayET.setError("Enter the total no of plants distributed so far");
        }else if (nameOfSubDivisionET.length()== 0){
            nameOfSubDivisionET.setError("Enter the name of sub division Range");
        }else if (totalNoOfPlantsDistributedTillDateET.length()== 0){
            totalNoOfPlantsDistributedTillDateET.setError("Enter the total no of plants distributed till date");
        }else if (plantsDistributedTodayET.length()== 0){
            plantsDistributedTodayET.setError("Enter the plants distributed today");
        }else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<FarmForestryResponse> call = RetrofitClient.getInstance().getApi().farmForestry(employeeNo,employeeName,nameOfForestDivision,
                    nameOfSubDivisionRange,plantsDistributedToday,totalNoOfPlantsDistributedToday,
                    totalNoOfPlantsDistributedTillDate);
            call.enqueue(new Callback<FarmForestryResponse>() {
                @Override
                public void onResponse(Call<FarmForestryResponse> call, Response<FarmForestryResponse> response) {
                    FarmForestryResponse farmForestryResponse = response.body();
                   if (response.isSuccessful()){
                       progressDialog.dismiss();
                       if (farmForestryResponse.equals("200")){
                           Toast.makeText(FormForestryActivity.this, farmForestryResponse.getMessage(), Toast.LENGTH_SHORT).show();
                       }else if (farmForestryResponse.equals("400")){
                           Toast.makeText(FormForestryActivity.this, farmForestryResponse.getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }
                }

                @Override
                public void onFailure(Call<FarmForestryResponse> call, Throwable t) {
                    try {
                        Toast.makeText(FormForestryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });


        }
    }
}