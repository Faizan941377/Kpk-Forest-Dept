package com.example.kpkforestdeptcdegad.CD.VDC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.VDC;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VDC_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText forestDivisionET;
    EditText subDivisionET;
    EditText nameOfVillageET;
    EditText vdcJfmcET;
    EditText dateOfEstablishmentET;
    EditText nameOfPresidentET;
    EditText contactEt;
    RadioButton functionalRB;
    RadioButton nonFunctionalRB;
    LinearLayout submitBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_d_c);

        forestDivisionET = findViewById(R.id.et_vdc_forestDivision);
        subDivisionET = findViewById(R.id.et_vdc_subDivision);
        nameOfVillageET = findViewById(R.id.et_vdc_village);
        vdcJfmcET = findViewById(R.id.et_vdc_vdcJfmc);
        dateOfEstablishmentET = findViewById(R.id.et_vdc_date_establishment);
        nameOfPresidentET = findViewById(R.id.et_vdc_president);
        contactEt = findViewById(R.id.et_vdc_contact);
        functionalRB = findViewById(R.id.rb_vdc_functional);
        nonFunctionalRB = findViewById(R.id.rb_vdc_nonFunctional);
        submitBT = findViewById(R.id.bt_vdc_submit);


        submitBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_vdc_submit:
                submitVDC();
        }
    }

    private void submitVDC() {

        String forestDivision = forestDivisionET.getText().toString();
        String subDivision = subDivisionET.getText().toString();
        String nameOfVillage = nameOfVillageET.getText().toString();
        String vdcJfmc = vdcJfmcET.getText().toString();
        String dateOfEstablishment = dateOfEstablishmentET.getText().toString();
        String nameOfPresident = nameOfPresidentET.getText().toString();
        String contact = contactEt.getText().toString();
        String functional = functionalRB.getText().toString();
        String nonFunctional = nonFunctionalRB.getText().toString();

        Call<VDC> call = RetrofitClient.getInstance().getApi().vdcInsert(forestDivision,subDivision,nameOfVillage,vdcJfmc
                ,dateOfEstablishment,nameOfPresident,contact,functional);
        call.enqueue(new Callback<VDC>() {
            @Override
            public void onResponse(Call<VDC> call, Response<VDC> response) {
                VDC vdc = response.body();
                if (response.isSuccessful()){
                    if (vdc.getError().equals("200")){

                        Toast.makeText(VDC_Activity.this, vdc.getMessage(), Toast.LENGTH_SHORT).show();

                    }else if (vdc.getError().equals("400")){

                        Toast.makeText(VDC_Activity.this, vdc.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<VDC> call, Throwable t) {
                Toast.makeText(VDC_Activity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}