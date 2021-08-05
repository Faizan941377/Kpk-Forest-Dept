package com.example.kpkforestdeptcdegad.user;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Dashboard.DashboardActivity;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.LoginResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText emailET;
    TextInputEditText passwordET;
    LinearLayout loginBT;
    TextView signUpBT;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.et_email);
        passwordET = findViewById(R.id.et_password);
        loginBT = findViewById(R.id.bt_login);
        signUpBT = findViewById(R.id.bt_signUp);

        progressDialog = new ProgressDialog(this);


        signUpBT.setOnClickListener(this);
        loginBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                Login();
                break;

            case R.id.bt_signUp:
                Intent intent1 = new Intent(this, RegistrationActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (SharePrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void Login() {
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();

        if (emailET.length() == 0) {
            emailET.setError("Please Enter Your Email Address");
            emailET.requestFocus();
            return;
        } else if (passwordET.length() == 0) {
            passwordET.setError("Please Enter Your Password");
            passwordET.requestFocus();
            return;
        } else if (passwordET.length() < 6) {
            passwordET.setError("Password should be at least 6 characters long");
            passwordET.requestFocus();
            return;
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);
            Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(email, password);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    LoginResponse loginResponse = response.body();
                    if (!loginResponse.equals("200")) {

                        SharePrefManager.getInstance(LoginActivity.this)
                                .saveUser(loginResponse.getLoginModel());
                        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);

                        progressDialog.dismiss();

                    } else {
                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    try {
                        Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}