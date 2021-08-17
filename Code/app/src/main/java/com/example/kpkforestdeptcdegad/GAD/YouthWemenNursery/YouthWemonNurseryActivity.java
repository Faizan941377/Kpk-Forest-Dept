package com.example.kpkforestdeptcdegad.GAD.YouthWemenNursery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.YouthWomenNurseryResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YouthWemonNurseryActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeNoET;
    EditText employeeNameET;
    EditText nameOfDivisionET;
    EditText nameOfSubDivisionET;
    EditText vdcWOET;
    EditText nameOfNurseryOwnerET;
    EditText locationVillageNameET;
    EditText limitET;
    LinearLayout submitBT;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youth_wemon_nursery);

        employeeNoET = findViewById(R.id.et_youthWomenNursery_employeeNo);
        employeeNameET = findViewById(R.id.et_youthWomenNursery_employeeName);
        nameOfDivisionET = findViewById(R.id.et_youthWomenNursery_NameOfDivision);
        nameOfSubDivisionET = findViewById(R.id.et_youthWomenNursery_nameOfSubDivisionRange);
        vdcWOET = findViewById(R.id.et_youthWomenNursery_vdcWO);
        nameOfNurseryOwnerET = findViewById(R.id.et_youthWomenNursery_nameOfNurseryOwner);
        locationVillageNameET = findViewById(R.id.et_youthWomenNursery_locationVillagename);
        limitET = findViewById(R.id.et_youthWomenNursery_limit);
        submitBT = findViewById(R.id.bt_youthWemenNursery_submit);


        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNameET.setEnabled(false);
        employeeNoET.setEnabled(false);

        submitBT.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_youthWemenNursery_submit:
                submitYouthWomenNursery();
                break;
        }
    }

    private void submitYouthWomenNursery() {

        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String nameOfDivision = nameOfDivisionET.getText().toString();
        String nameOfSubDivision = nameOfSubDivisionET.getText().toString();
        String vdcWo = vdcWOET.getText().toString();
        String nameOfNurseryOwner = nameOfNurseryOwnerET.getText().toString();
        String locationVillageName = locationVillageNameET.getText().toString();
        String limit = limitET.getText().toString();

        if (nameOfDivisionET.length() == 0) {
            nameOfDivisionET.setError("Enter the name of division");
        } else if (nameOfSubDivisionET.length() == 0) {
            nameOfSubDivisionET.setError("Enter the name of sub division");
        } else if (vdcWOET.length() == 0) {
            vdcWOET.setError("Enter the VDC WO");
        } else if (nameOfNurseryOwnerET.length() == 0) {
            nameOfNurseryOwnerET.setError("Enter the name of nursery owner");
        } else if (locationVillageNameET.length() == 0) {
            locationVillageNameET.setError("Enter the name of location Village name");
        } else if (limitET.length() == 0) {
            limitET.setError("Enter the limit");
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(true);
            progressDialog.setIndeterminate(true);

            Call<YouthWomenNurseryResponse> call = RetrofitClient.getInstance().getApi().youthWomenNurseryResponse(
                    employeeNo, employeeName, nameOfDivision, nameOfSubDivision, vdcWo, nameOfNurseryOwner, locationVillageName, limit);
            call.enqueue(new Callback<YouthWomenNurseryResponse>() {
                @Override
                public void onResponse(Call<YouthWomenNurseryResponse> call, Response<YouthWomenNurseryResponse> response) {
                    YouthWomenNurseryResponse youthWomenNurseryResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        clearEditText();
                        if (youthWomenNurseryResponse.getError().equals("200")) {
                            Toast.makeText(YouthWemonNurseryActivity.this, youthWomenNurseryResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (youthWomenNurseryResponse.getError().equals("400")) {
                            Toast.makeText(YouthWemonNurseryActivity.this, youthWomenNurseryResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<YouthWomenNurseryResponse> call, Throwable t) {
                    try {
                        Toast.makeText(YouthWemonNurseryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void clearEditText() {
        nameOfDivisionET.setText("");
        nameOfSubDivisionET.setText("");
        vdcWOET.setText("");
        nameOfNurseryOwnerET.setText("");
        locationVillageNameET.setText("");
        limitET.setText("");
    }
}