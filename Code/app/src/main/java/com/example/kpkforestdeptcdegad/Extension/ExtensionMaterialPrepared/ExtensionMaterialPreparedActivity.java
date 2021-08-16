package com.example.kpkforestdeptcdegad.Extension.ExtensionMaterialPrepared;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.ExtensionMaterialPreparedResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtensionMaterialPreparedActivity extends AppCompatActivity implements View.OnClickListener {

    EditText souvenirsShieldNoET;
    EditText noOfPanaflexET;
    EditText squareFeetET;
    EditText monthOfPreparationET;
    EditText noOfDiariesET;
    EditText noOfCalenderET;
    EditText noOfBannersET;
    EditText actionPlanET;
    EditText keyChainET;
    EditText noOfMiscellaneousExtensionMaterialsET;
    LinearLayout submitBT;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension_material_prepared);

        souvenirsShieldNoET = findViewById(R.id.et_ExtensionMaterialPrepared_souvenirsShieldNo);
        noOfPanaflexET = findViewById(R.id.et_ExtensionMaterialPrepared_noOfPanaflex);
        squareFeetET = findViewById(R.id.et_ExtensionMaterialPrepared_squareFeet);
        monthOfPreparationET = findViewById(R.id.et_ExtensionMaterialPrepared_monthOfPrepared);
        noOfDiariesET = findViewById(R.id.et_ExtensionMaterialPrepared_diariesNo);
        noOfCalenderET = findViewById(R.id.et_ExtensionMaterialPrepared_calenderNo);
        noOfBannersET = findViewById(R.id.et_ExtensionMaterialPrepared_banners);
        actionPlanET = findViewById(R.id.et_ExtensionMaterialPrepared_actionPlan);
        keyChainET = findViewById(R.id.et_ExtensionMaterialPrepared_keyChain);
        noOfMiscellaneousExtensionMaterialsET = findViewById(R.id.et_ExtensionMaterialPrepared_noOfMiscellaneousExtensionMaterials);
        submitBT = findViewById(R.id.bt_ExtensionMaterialPrepared_submit);

        progressDialog = new ProgressDialog(this);
        submitBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_ExtensionMaterialPrepared_submit:
                submitData();
                break;
        }
    }

    private void submitData() {
        String souvenirsShieldNo = souvenirsShieldNoET.getText().toString();
        String noOfPanaflex = noOfPanaflexET.getText().toString();
        String squareFeet = squareFeetET.getText().toString();
        String monthOfPreparation = monthOfPreparationET.getText().toString();
        String noOfDiaries = noOfDiariesET.getText().toString();
        String noOfCalender = noOfCalenderET.getText().toString();
        String noOfBanners = noOfBannersET.getText().toString();
        String actionPlan = actionPlanET.getText().toString();
        String keyChain = keyChainET.getText().toString();
        String noOfMiscellaneousExtensionMaterial = noOfMiscellaneousExtensionMaterialsET.getText().toString();

        if (souvenirsShieldNoET.length() == 0) {
            souvenirsShieldNoET.setText("Enter the Souvenirs Shield No");
        } else if (noOfPanaflexET.length() == 0) {
            noOfPanaflexET.setText("Enter the no of Panaflex");
        } else if (squareFeetET.length() == 0) {
            squareFeetET.setText("Enter the square feet");
        } else if (monthOfPreparationET.length() == 0) {
            monthOfPreparationET.setText("Enter the month of Preparation");
        } else if (noOfDiariesET.length() == 0) {
            noOfDiariesET.setText("Enter the no of Diaries");
        } else if (noOfCalenderET.length() == 0) {
            noOfCalenderET.setText("Enter the no of Calender");
        } else if (noOfBannersET.length() == 0) {
            noOfBannersET.setText("Enter the no of banners");
        } else if (actionPlanET.length() == 0) {
            actionPlanET.setText("Enter the action plan");
        } else if (keyChainET.length() == 0) {
            keyChainET.setText("Enter the no of key chain");
        } else if (noOfMiscellaneousExtensionMaterialsET.length() == 0) {
            noOfMiscellaneousExtensionMaterialsET.setText("Enter the no of miscellaneous extension material");
        } else {

            Call<ExtensionMaterialPreparedResponse> call = RetrofitClient.getInstance().getApi().extensionMaterialPreparedResponse(
              souvenirsShieldNo,noOfPanaflex,squareFeet,monthOfPreparation,noOfDiaries,noOfCalender,noOfBanners,actionPlan,
              keyChain,noOfMiscellaneousExtensionMaterial);
            call.enqueue(new Callback<ExtensionMaterialPreparedResponse>() {
                @Override
                public void onResponse(Call<ExtensionMaterialPreparedResponse> call, Response<ExtensionMaterialPreparedResponse> response) {
                    ExtensionMaterialPreparedResponse extensionMaterialPreparedResponse = response.body();
                    if (response.isSuccessful()){
                        clearEditText();
                        if (extensionMaterialPreparedResponse.getError().equals("200")){
                            Toast.makeText(ExtensionMaterialPreparedActivity.this, extensionMaterialPreparedResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }else if (extensionMaterialPreparedResponse.getError().equals("400")){
                            Toast.makeText(ExtensionMaterialPreparedActivity.this, extensionMaterialPreparedResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ExtensionMaterialPreparedResponse> call, Throwable t) {
                    try {
                        Toast.makeText(ExtensionMaterialPreparedActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    private void clearEditText() {
        souvenirsShieldNoET.setText("");
        noOfPanaflexET.setText("");
        squareFeetET.setText("");
        monthOfPreparationET.setText("");
        noOfDiariesET.setText("");
        noOfCalenderET.setText("");
        noOfBannersET.setText("");
        actionPlanET.setText("");
        keyChainET.setText("");
        noOfMiscellaneousExtensionMaterialsET.setText("");
    }
}