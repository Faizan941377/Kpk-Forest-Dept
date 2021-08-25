package com.example.kpkforestdeptcdegad.GAD.OtherActivity;

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
import com.example.kpkforestdeptcdegad.Response.OtherActivityResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherActivityMainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeNoET;
    EditText employeeNameET;
    EditText activityTitleET;
    EditText nameOfForestDivisionET;
    EditText nameOfWoET;
    EditText nameOfVillageET;
    EditText descriptionET;
    LinearLayout submitBT;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_main);

        employeeNoET = findViewById(R.id.et_otherActivity_employeeNo);
        employeeNameET = findViewById(R.id.et_otherActivity_employeeName);
        activityTitleET = findViewById(R.id.et_otherActivity_activityTitle);
        nameOfForestDivisionET = findViewById(R.id.et_otherActivity_nameOfForestDivision);
        nameOfWoET = findViewById(R.id.et_otherActivity_nameOfWo);
        nameOfVillageET = findViewById(R.id.et_otherActivity_nameOfVillage);
        descriptionET = findViewById(R.id.et_otherActivity_description);
        submitBT = findViewById(R.id.bt_otherActivity_submit);

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
            case R.id.bt_otherActivity_submit:
                submitOtherActivity();
        }
    }

    private void submitOtherActivity() {

        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String activityTitle = activityTitleET.getText().toString();
        String nameOfForestDivision = nameOfForestDivisionET.getText().toString();
        String nameOfWo = nameOfWoET.getText().toString();
        String nameOfVillage = nameOfVillageET.getText().toString();
        String description = descriptionET.getText().toString();

        if (activityTitleET.length() == 0) {
            activityTitleET.setError("Enter the activity title");
        } else if (nameOfForestDivisionET.length() == 0) {
            nameOfForestDivisionET.setError("Enter the name of forest division");
        } else if (nameOfWoET.length() == 0) {
            nameOfWoET.setError("Enter the name of WO");
        } else if (nameOfVillageET.length() == 0) {
            nameOfVillageET.setError("Enter the name of village");
        } else if (descriptionET.length() == 0) {
            descriptionET.setError("Enter the description");
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<OtherActivityResponse> call = RetrofitClient.getInstance().getApi().otherActivityResponse(employeeNo, employeeName,
                    activityTitle, nameOfForestDivision, nameOfWo, nameOfVillage, description);
            call.enqueue(new Callback<OtherActivityResponse>() {
                @Override
                public void onResponse(Call<OtherActivityResponse> call, Response<OtherActivityResponse> response) {
                    OtherActivityResponse otherActivityResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        if (otherActivityResponse.getError().equals("200")) {
                            Toast.makeText(OtherActivityMainActivity.this, otherActivityResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (otherActivityResponse.getError().equals("400")) {
                            Toast.makeText(OtherActivityMainActivity.this, otherActivityResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<OtherActivityResponse> call, Throwable t) {
                    progressDialog.dismiss();
                    try {
                        Toast.makeText(OtherActivityMainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}