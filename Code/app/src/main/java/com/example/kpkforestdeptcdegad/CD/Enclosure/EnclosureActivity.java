package com.example.kpkforestdeptcdegad.CD.Enclosure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.VDC.VDC_Activity;
import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.EnclosureResponse;
import com.example.kpkforestdeptcdegad.Response.VDCResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnclosureActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeET;
    EditText employeeNameET;
    EditText forestDivisionET;
    EditText dateET;
    EditText targetAsPc1EnclosureET;
    EditText siteForEnclosureAchievedET;
    EditText vdcEstablishmentET;
    EditText NigehbansHiredET;
    EditText paymentUpToET;
    EditText balanceTargetET;
    EditText remarksET;
    LinearLayout submitBT;

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enclousure);

        employeeET = findViewById(R.id.et_enclosure_empNo);
        employeeNameET = findViewById(R.id.et_enclosure_empName);
        forestDivisionET = findViewById(R.id.et_enclosure_forestDivision);
        dateET = findViewById(R.id.et_enclosure_date);
        targetAsPc1EnclosureET = findViewById(R.id.et_enclosure_targetAsPc1Enclosure);
        siteForEnclosureAchievedET = findViewById(R.id.et_enclosure_siteForEnclosureAchieved);
        vdcEstablishmentET = findViewById(R.id.et_enclosure_vdcEstablishment);
        NigehbansHiredET = findViewById(R.id.et_enclosure_NigehbansHired);
        paymentUpToET = findViewById(R.id.et_enclosure_paymentUpTo);
        balanceTargetET = findViewById(R.id.et_enclosure_balanceTarget);
        remarksET = findViewById(R.id.et_enclosure_remarks);
        submitBT = findViewById(R.id.bt_enclosure_submit);


        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNameET.setEnabled(false);
        employeeET.setEnabled(false);

        progressDialog = new ProgressDialog(this);
        submitBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_enclosure_submit:
                submitEnclosure();
                Toast.makeText(this, "Enclosure Submitted", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void submitEnclosure() {

        String employeeNo = employeeET.getText().toString();
        String forestDivision = forestDivisionET.getText().toString();
        String entryDate = dateET.getText().toString();
        String targetAsPc1Enclosure = targetAsPc1EnclosureET.getText().toString();
        String siteForEnclosureAchieved = siteForEnclosureAchievedET.getText().toString();
        String vdcEstablishment = vdcEstablishmentET.getText().toString();
        String NigehbansHired = NigehbansHiredET.getText().toString();
        String paymentUpTo = paymentUpToET.getText().toString();
        String balanceTarget = balanceTargetET.getText().toString();
        String remarks = remarksET.getText().toString();


        if (forestDivisionET.length() == 0) {
            forestDivisionET.setError("Enter Forest Division Name");
        } else if (dateET.length() == 0) {
            dateET.setError("Please enter the date");
        } else if (targetAsPc1EnclosureET.length() == 0) {
            targetAsPc1EnclosureET.setError("Enter Target As PC-1 Enclosure");
        } else if (siteForEnclosureAchievedET.length() == 0) {
            siteForEnclosureAchievedET.setError("Enter Site For Enclosure Achieved");
        } else if (vdcEstablishmentET.length() == 0) {
            vdcEstablishmentET.setError("Enter VDC Establishment");
        } else if (NigehbansHiredET.length() == 0) {
            NigehbansHiredET.setError("Enter Nigehnans Hired");
        } else if (paymentUpToET.length() == 0) {
            paymentUpToET.setError("Enter the payment Upto");
        } else if (balanceTargetET.length() == 0) {
            balanceTargetET.setError("Enter the Balance Target");
        } else if (remarksET.length() == 0) {
            remarksET.setError("Enter remarks");
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<EnclosureResponse> call = RetrofitClient.getInstance().getApi().enclosure(employeeNo,forestDivision, entryDate, targetAsPc1Enclosure, siteForEnclosureAchieved
                    , vdcEstablishment, NigehbansHired, paymentUpTo, balanceTarget, remarks);
            call.enqueue(new Callback<EnclosureResponse>() {
                @Override
                public void onResponse(Call<EnclosureResponse> call, Response<EnclosureResponse> response) {
                    EnclosureResponse enclosureResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        if (enclosureResponse.getError().equals("200")) {
                            Toast.makeText(EnclosureActivity.this, enclosureResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        } else if (enclosureResponse.getError().equals("400")) {

                            Toast.makeText(EnclosureActivity.this, enclosureResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<EnclosureResponse> call, Throwable t) {
                    Toast.makeText(EnclosureActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}