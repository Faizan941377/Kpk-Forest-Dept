package com.example.kpkforestdeptcdegad.GAD.WemonOrganization;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.WomenOrganizationResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WomenOrganizationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST = 100;
    Bitmap bitmap;
    ImageView showImageIV;
    EditText employeeNoET;
    EditText employeeNameET;
    EditText nameOfVillageVdcET;
    EditText nameOfWOET;
    EditText dateYearOfEstablishmentET;
    EditText nameOfPresidentET;
    EditText majorActivitiesET;
    EditText totalNoOfMemberET;
    EditText contactET;
    EditText remarksET;
    LinearLayout submitBT;
    FloatingActionButton openGalleryBT;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wemon_organization);

        showImageIV = findViewById(R.id.iv_showImage);
        employeeNoET = findViewById(R.id.et_womenOrganization_employeeNo);
        employeeNameET = findViewById(R.id.et_womenOrganization_employeeName);
        nameOfVillageVdcET = findViewById(R.id.et_womenOrganization_nameOfVillageVdc);
        nameOfWOET = findViewById(R.id.et_womenOrganization_nameOfWO);
        dateYearOfEstablishmentET = findViewById(R.id.et_womenOrganization_DateYearOfEstablishment);
        nameOfPresidentET = findViewById(R.id.et_womenOrganization_nameOfPresident);
        majorActivitiesET = findViewById(R.id.et_womenOrganization_majorActivities);
        totalNoOfMemberET = findViewById(R.id.et_womenOrganization_totalNoOfMembers);
        contactET = findViewById(R.id.et_womenOrganization_contact);
        remarksET = findViewById(R.id.et_womenOrganization_remarks);
        submitBT = findViewById(R.id.bt_womenOrganization_submit);
        openGalleryBT = findViewById(R.id.bt_openGallery);


        progressDialog = new ProgressDialog(this);
        submitBT.setOnClickListener(this);
        openGalleryBT.setOnClickListener(this);

        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_womenOrganization_submit:
                submitWomenOrganization();
                break;

            case R.id.bt_openGallery:
                openGallery();
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

    private void openGallery() {
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
                showImageIV.setImageBitmap(bitmap);
                showImageIV.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void submitWomenOrganization() {

        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String nameOfVillageVdc = nameOfVillageVdcET.getText().toString();
        String nameOfWO = nameOfWOET.getText().toString();
        String dateYearOfEstablishment = dateYearOfEstablishmentET.getText().toString();
        String nameOfPresident = nameOfPresidentET.getText().toString();
        String majorActivities = majorActivitiesET.getText().toString();
        String totalNoOfMember = totalNoOfMemberET.getText().toString();
        String contact = contactET.getText().toString();
        String remarks = remarksET.getText().toString();
        String image = imageToString();


        if (nameOfVillageVdcET.length() == 0) {
            nameOfVillageVdcET.setError("Enter the name of village vdc");
        } else if (nameOfWOET.length() == 0) {
            nameOfWOET.setError("Enter the name of WO");
        } else if (dateYearOfEstablishmentET.length() == 0) {
            dateYearOfEstablishmentET.setError("Enter the date and year of establishment");
        } else if (nameOfPresidentET.length() == 0) {
            nameOfPresidentET.setError("Enter the name of president");
        } else if (majorActivitiesET.length() == 0) {
            majorActivitiesET.setError("Enter the name of mojor activities");
        } else if (remarksET.length() == 0) {
            remarksET.setError("Enter the remarks");
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<WomenOrganizationResponse> call = RetrofitClient.getInstance().getApi().womenOrganizationResponse(
                    employeeNo, employeeName, nameOfVillageVdc, nameOfWO, dateYearOfEstablishment, nameOfPresident, majorActivities,
                    totalNoOfMember, contact, remarks, image);
            call.enqueue(new Callback<WomenOrganizationResponse>() {
                @Override
                public void onResponse(Call<WomenOrganizationResponse> call, Response<WomenOrganizationResponse> response) {
                    WomenOrganizationResponse womenOrganizationResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        clearEditText();
                        if (womenOrganizationResponse.getError().equals("200")) {
                            Toast.makeText(WomenOrganizationActivity.this, womenOrganizationResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (womenOrganizationResponse.getError().equals("400")) {
                            Toast.makeText(WomenOrganizationActivity.this, womenOrganizationResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<WomenOrganizationResponse> call, Throwable t) {
                    try {
                        Toast.makeText(WomenOrganizationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void clearEditText() {
        showImageIV.setImageDrawable(null);
        nameOfVillageVdcET.setText("");
        nameOfWOET.setText("");
        dateYearOfEstablishmentET.setText("");
        nameOfPresidentET.setText("");
        majorActivitiesET.setText("");
        totalNoOfMemberET.setText("");
        contactET.setText("");
        remarksET.setText("");
    }
}