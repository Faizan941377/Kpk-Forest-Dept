package com.example.kpkforestdeptcdegad.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Dashboard.DashboardActivity;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.RegistrationResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner genderSP;
    TextInputEditText firstNameET;
    TextInputEditText employeeNoET;
    TextInputEditText cnicET;
    TextInputEditText mobileET;
    TextInputEditText divisionET;
    TextInputEditText emailET;
    TextInputEditText passwordET;
    LinearLayout registerBT;

    private static final int GALLERY_REQUEST = 100;
    ImageView showImage;
    FloatingActionButton openGalleryBT;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        genderSP = findViewById(R.id.sp_gender);
        firstNameET = findViewById(R.id.et_register_firstName);
        employeeNoET = findViewById(R.id.et_register_employeeNo);
        cnicET = findViewById(R.id.et_register_cnic);
        mobileET = findViewById(R.id.et_register_mobile);
        divisionET = findViewById(R.id.et_register_division);
        emailET = findViewById(R.id.et_register_email);
        passwordET = findViewById(R.id.et_register_password);
        registerBT = findViewById(R.id.bt_registeration_register);

        showImage = findViewById(R.id.iv_showImage);
        openGalleryBT = findViewById(R.id.bt_openGallery);

        registerBT.setOnClickListener(this);
        openGalleryBT.setOnClickListener(this);

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
                submitRegistration();
                break;

            case R.id.bt_openGallery:
                getImageFromGallery();
                break;
        }
    }

    //send image to database
    private String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imageByte, Base64.DEFAULT);
    }

    private void getImageFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GALLERY_REQUEST && resultCode == RESULT_OK) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                showImage.setImageBitmap(bitmap);
                showImage.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void submitRegistration() {
        String firstName = firstNameET.getText().toString();
        String gender = genderSP.getSelectedItem().toString();
        String cnic = cnicET.getText().toString();
        String emp = employeeNoET.getText().toString();
        String mobile = mobileET.getText().toString();
        String division = divisionET.getText().toString();
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        String image = imageToString();

        Call<RegistrationResponse> call = RetrofitClient.getInstance().getApi().register(firstName, gender, cnic, emp, mobile, division, email, password,image);
        call.enqueue(new Callback<RegistrationResponse>() {
            @Override
            public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                RegistrationResponse registrationResponse = response.body();
                if (response.isSuccessful()) {
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
    }
}