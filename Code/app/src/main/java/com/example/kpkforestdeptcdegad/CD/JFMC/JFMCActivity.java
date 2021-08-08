package com.example.kpkforestdeptcdegad.CD.JFMC;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.CD_JFMCResponse;

import java.security.ProtectionDomain;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JFMCActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameOfDivisionET;
    EditText nameOfSubDivisionET;
    EditText nameOfVillageVDCET;
    EditText nameOfJfmcET;
    EditText dateOfEstablishmentET;
    EditText nameOfPresidentET;
    EditText contactET;
    LinearLayout submitBT;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_f_m_c);

        nameOfDivisionET = findViewById(R.id.tv_jfmc_nameOfForestDivision);
        nameOfSubDivisionET = findViewById(R.id.tv_jfmc_nameOfSubDivisionRange);
        nameOfVillageVDCET = findViewById(R.id.tv_jfmc_nameOfVillageVDC);
        nameOfJfmcET = findViewById(R.id.tv_jfmc_nameOfJfmc);
        dateOfEstablishmentET = findViewById(R.id.tv_jfmc_dateOfEstablishmentRegistration);
        nameOfPresidentET = findViewById(R.id.tv_jfmc_nameOfPresident);
        contactET = findViewById(R.id.tv_jfmc_contact);
        submitBT = findViewById(R.id.bt_jfmc_submit);


        progressDialog = new ProgressDialog(this);
        submitBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_jfmc_submit:
                SubmitJFMC();
        }
    }

    private void SubmitJFMC() {
        String forestDivision = nameOfDivisionET.getText().toString();
        String subDivision = nameOfSubDivisionET.getText().toString();
        String nameOfVillage = nameOfVillageVDCET.getText().toString();
        String Jfmc = nameOfJfmcET.getText().toString();
        String dateOfEstablishment = dateOfEstablishmentET.getText().toString();
        String nameOfPresident = nameOfPresidentET.getText().toString();
        String contact = contactET.getText().toString();


        if (nameOfDivisionET.length() == 0) {
            nameOfDivisionET.setError("Enter Forest Division Name");
        } else if (nameOfSubDivisionET.length() == 0) {
            nameOfSubDivisionET.setError("Enter Sub Division Name");
        } else if (nameOfVillageVDCET.length() == 0) {
            nameOfVillageVDCET.setError("Enter Village | VDC");
        } else if (nameOfJfmcET.length() == 0) {
            nameOfJfmcET.setError("Enter JFMC");
        } else if (dateOfEstablishmentET.length() == 0) {
            dateOfEstablishmentET.setError("Enter Date of Establishment | Registration");
        } else if (nameOfPresidentET.length() == 0) {
            nameOfPresidentET.setError("Enter President Name");
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            Call<CD_JFMCResponse> call = RetrofitClient.getInstance().getApi().jfmcInsert(forestDivision,subDivision,nameOfVillage,
                    Jfmc,dateOfEstablishment,nameOfPresident,contact);
            call.enqueue(new Callback<CD_JFMCResponse>() {
                @Override
                public void onResponse(Call<CD_JFMCResponse> call, Response<CD_JFMCResponse> response) {
                    CD_JFMCResponse cdJfmcResponse = response.body();
                    if (response.isSuccessful()){
                        progressDialog.dismiss();
                        if (cdJfmcResponse.getError().equals("200")){
                            Toast.makeText(JFMCActivity.this, cdJfmcResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }else if (cdJfmcResponse.getError().equals("400")){
                            Toast.makeText(JFMCActivity.this, cdJfmcResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<CD_JFMCResponse> call, Throwable t) {
                    Toast.makeText(JFMCActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}