package com.example.kpkforestdeptcdegad.CD.VDC;

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
import com.example.kpkforestdeptcdegad.Response.VDCResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VDC_Activity extends AppCompatActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST = 100;
    ImageView showImage;
    FloatingActionButton openGalleryBT;
    Bitmap bitmap;
    EditText employeeNoET;
    EditText employeeNameET;
    EditText forestDivisionET;
    EditText subDivisionET;
    EditText nameOfVillageET;
    EditText vdcJfmcET;
    EditText dateOfEstablishmentET;
    EditText nameOfPresidentET;
    EditText contactEt;
    EditText JFMCWOET;
    EditText totalMemberET;
    LinearLayout submitBT;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_d_c);

        showImage = findViewById(R.id.iv_showImage);
        employeeNoET = findViewById(R.id.et_vdc_employeeNo);
        employeeNameET = findViewById(R.id.et_vdc_employeeName);
        openGalleryBT = findViewById(R.id.bt_openGallery);
        forestDivisionET = findViewById(R.id.et_vdc_forestDivision);
        subDivisionET = findViewById(R.id.et_vdc_subDivision);
        nameOfVillageET = findViewById(R.id.et_vdc_village);
        vdcJfmcET = findViewById(R.id.et_vdc_vdcJfmc);
        dateOfEstablishmentET = findViewById(R.id.et_vdc_date_establishment);
        nameOfPresidentET = findViewById(R.id.et_vdc_president);
        contactEt = findViewById(R.id.et_vdc_contact);
        submitBT = findViewById(R.id.bt_vdc_submit);
        JFMCWOET = findViewById(R.id.et_vdc_JFMCWO);
        totalMemberET = findViewById(R.id.et_vdc_totalMember);

        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());

        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);

        progressDialog = new ProgressDialog(this);

        submitBT.setOnClickListener(this);
        openGalleryBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_vdc_submit:
                submitVDC();
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

    private void submitVDC() {

        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String forestDivision = forestDivisionET.getText().toString();
        String subDivision = subDivisionET.getText().toString();
        String nameOfVillage = nameOfVillageET.getText().toString();
        String vdcJfmc = vdcJfmcET.getText().toString();
        String dateOfEstablishment = dateOfEstablishmentET.getText().toString();
        String nameOfPresident = nameOfPresidentET.getText().toString();
        String contact = contactEt.getText().toString();
        String jfmcWO = JFMCWOET.getText().toString();
        String totalMember = totalMemberET.getText().toString();
        String image = imageToString();

        if (forestDivisionET.length()==0){
            forestDivisionET.setError("Enter Forest Division Name");
        }else if (subDivisionET.length()==0){
            subDivisionET.setError("Enter Sub Division Name");
        }else if (nameOfVillageET.length()==0){
            nameOfVillageET.setError("Enter Village Name");
        }else if (vdcJfmcET.length()==0){
            vdcJfmcET.setError("Enter Name of VDC | JFMC");
        }else if (dateOfEstablishmentET.length()==0){
            dateOfEstablishmentET.setError("Enter Date of Establishment");
        }else if (nameOfPresidentET.length()==0){
            nameOfPresidentET.setError("Enter Name of President");
        }else if (contactEt.length()==0){
            contactEt.setError("Enter Contact Number");
        }else if (JFMCWOET.length()==0){
            JFMCWOET.setError("Enter JFMCWO");
        }else if (totalMemberET.length()==0) {
            totalMemberET.setError("Enter Total Number of Members");
        }else{

           // Toast.makeText(this, "method Call", Toast.LENGTH_SHORT).show();

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<VDCResponse> call = RetrofitClient.getInstance().getApi().vdcInsert(employeeNo, employeeName, forestDivision, subDivision, nameOfVillage, vdcJfmc
                    , dateOfEstablishment, nameOfPresident, contact, jfmcWO, totalMember,image);
            call.enqueue(new Callback<VDCResponse>() {
                @Override
                public void onResponse(Call<VDCResponse> call, Response<VDCResponse> response) {
                    VDCResponse vdcResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        if (vdcResponse.getError().equals("200")) {
                            Toast.makeText(VDC_Activity.this, vdcResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        } else if (vdcResponse.getError().equals("400")) {

                            Toast.makeText(VDC_Activity.this, vdcResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<VDCResponse> call, Throwable t) {
                    try {
                        Toast.makeText(VDC_Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}