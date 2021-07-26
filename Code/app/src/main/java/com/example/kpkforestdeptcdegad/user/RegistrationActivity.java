package com.example.kpkforestdeptcdegad.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Dashboard.DashboardActivity;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.RegistrationResponse;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner genderSP;
    TextInputEditText firstNameET;
    TextInputEditText lastNameET;
    TextInputEditText cnicET;
    TextInputEditText mobileET;
    TextInputEditText divisionET;
    TextInputEditText emailET;
    TextInputEditText passwordET;
    LinearLayout registerBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        genderSP = findViewById(R.id.sp_gender);
        firstNameET = findViewById(R.id.et_register_firstName);
        lastNameET = findViewById(R.id.et_register_lastName);
        cnicET = findViewById(R.id.et_register_cnic);
        mobileET = findViewById(R.id.et_register_mobile);
        divisionET = findViewById(R.id.et_register_division);
        emailET = findViewById(R.id.et_register_email);
        passwordET = findViewById(R.id.et_register_password);
        registerBT = findViewById(R.id.bt_registeration_register);

        registerBT.setOnClickListener(this);

        Select_Gender();

    }

    private void Select_Gender() {
        ArrayList<String> item1 = getGenderType("Gender.json");
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, R.layout.spinner_layout, R.id.spinner_textView, item1);
        genderSP.setAdapter(adapter5);

    }

    public ArrayList<String> getGenderType(String fileBodyType) {
        JSONArray jsonArray = null;
        ArrayList<String> bodyList = new ArrayList<>();
        try {
            InputStream is = getResources().getAssets().open(fileBodyType);
            int size = is.available();
            byte[] data = new byte[size];
            is.read(data);
            is.close();
            String json = new String(data, "UTF-8");
            jsonArray = new JSONArray(json);
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    bodyList.add(jsonArray.getJSONObject(i).getString("gender"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException je) {
            je.printStackTrace();
        }
        return bodyList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_registeration_register:
              /*  submitRegistration();*/
                break;
        }
    }

   /* private void submitRegistration() {
        String firstName = firstNameET.getText().toString();
        String lastName = lastNameET.getText().toString();
        String gender = genderSP.getSelectedItem().toString();
        String cnic = cnicET.getText().toString();
        String mobile = mobileET.getText().toString();
        String division = divisionET.getText().toString();
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        Call<RegistrationResponse> call = RetrofitClient.getInstance().getApi().registration(firstName,lastName,gender,cnic,mobile,division,email,password);
        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                RegistrationResponse registrationResponse = response.body();
                if (response.isSuccessful()){
                    if (registrationResponse.getError().equals("")) {

                        Toast.makeText(RegistrationActivity.this, registrationResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<RegistrationResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}