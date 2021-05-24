package com.example.kpkforestdeptcdegad.HR;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kpkforestdeptcdegad.HR.Spinner.SpinnerBPS;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;

public class HRActivity extends AppCompatActivity {

    Spinner bpsSP;
    Spinner bpsServiceHistorySP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_r);

        bpsSP=findViewById(R.id.sp_HR_BPS);
        bpsServiceHistorySP =findViewById(R.id.sp_HR_Service_BPS);

        Select_BPS_Type();
        Service_History_BPS();
    }

    private void Service_History_BPS() {

        ArrayList<SpinnerBPS> dataList = new ArrayList<>();
        SpinnerBPS user = new SpinnerBPS("1", "Select BPS");
        SpinnerBPS user1 = new SpinnerBPS("1", "1");
        SpinnerBPS user2 = new SpinnerBPS("1", "2");
        SpinnerBPS user3 = new SpinnerBPS("1", "3");
        SpinnerBPS user4 = new SpinnerBPS("1", "4");
        SpinnerBPS user5 = new SpinnerBPS("1", "5");
        SpinnerBPS user6 = new SpinnerBPS("1", "6");
        SpinnerBPS user7 = new SpinnerBPS("1", "7");
        SpinnerBPS user8 = new SpinnerBPS("1", "8");
        SpinnerBPS user9 = new SpinnerBPS("1", "9");
        SpinnerBPS user10 = new SpinnerBPS("1", "10");
        SpinnerBPS user11 = new SpinnerBPS("1", "11");
        SpinnerBPS user12 = new SpinnerBPS("1", "12");
        SpinnerBPS user13 = new SpinnerBPS("1", "13");
        SpinnerBPS user14 = new SpinnerBPS("1", "14");
        SpinnerBPS user15 = new SpinnerBPS("1", "15");
        SpinnerBPS user16 = new SpinnerBPS("1", "16");
        SpinnerBPS user17 = new SpinnerBPS("1", "17");
        SpinnerBPS user18 = new SpinnerBPS("1", "18");
        SpinnerBPS user19 = new SpinnerBPS("1", "19");
        SpinnerBPS user20 = new SpinnerBPS("1", "20");
        SpinnerBPS user21 = new SpinnerBPS("1", "21");
        SpinnerBPS user22 = new SpinnerBPS("1", "22");
        dataList.add(user);
        dataList.add(user1);
        dataList.add(user2);
        dataList.add(user3);
        dataList.add(user4);
        dataList.add(user5);
        dataList.add(user6);
        dataList.add(user7);
        dataList.add(user8);
        dataList.add(user9);
        dataList.add(user10);
        dataList.add(user11);
        dataList.add(user12);
        dataList.add(user13);
        dataList.add(user14);
        dataList.add(user15);
        dataList.add(user16);
        dataList.add(user17);
        dataList.add(user18);
        dataList.add(user19);
        dataList.add(user20);
        dataList.add(user21);
        dataList.add(user22);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, dataList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        bpsServiceHistorySP.setAdapter(arrayAdapter);

        bpsServiceHistorySP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                bpsServiceHistorySP.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(HRActivity.this, "Please Select your gender!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Select_BPS_Type() {

        ArrayList<SpinnerBPS> dataList = new ArrayList<>();
        SpinnerBPS user = new SpinnerBPS("1", "Select BPS");
        SpinnerBPS user1 = new SpinnerBPS("1", "1");
        SpinnerBPS user2 = new SpinnerBPS("1", "2");
        SpinnerBPS user3 = new SpinnerBPS("1", "3");
        SpinnerBPS user4 = new SpinnerBPS("1", "4");
        SpinnerBPS user5 = new SpinnerBPS("1", "5");
        SpinnerBPS user6 = new SpinnerBPS("1", "6");
        SpinnerBPS user7 = new SpinnerBPS("1", "7");
        SpinnerBPS user8 = new SpinnerBPS("1", "8");
        SpinnerBPS user9 = new SpinnerBPS("1", "9");
        SpinnerBPS user10 = new SpinnerBPS("1", "10");
        SpinnerBPS user11 = new SpinnerBPS("1", "11");
        SpinnerBPS user12 = new SpinnerBPS("1", "12");
        SpinnerBPS user13 = new SpinnerBPS("1", "13");
        SpinnerBPS user14 = new SpinnerBPS("1", "14");
        SpinnerBPS user15 = new SpinnerBPS("1", "15");
        SpinnerBPS user16 = new SpinnerBPS("1", "16");
        SpinnerBPS user17 = new SpinnerBPS("1", "17");
        SpinnerBPS user18 = new SpinnerBPS("1", "18");
        SpinnerBPS user19 = new SpinnerBPS("1", "19");
        SpinnerBPS user20 = new SpinnerBPS("1", "20");
        SpinnerBPS user21 = new SpinnerBPS("1", "21");
        SpinnerBPS user22 = new SpinnerBPS("1", "22");
        dataList.add(user);
        dataList.add(user1);
        dataList.add(user2);
        dataList.add(user3);
        dataList.add(user4);
        dataList.add(user5);
        dataList.add(user6);
        dataList.add(user7);
        dataList.add(user8);
        dataList.add(user9);
        dataList.add(user10);
        dataList.add(user11);
        dataList.add(user12);
        dataList.add(user13);
        dataList.add(user14);
        dataList.add(user15);
        dataList.add(user16);
        dataList.add(user17);
        dataList.add(user18);
        dataList.add(user19);
        dataList.add(user20);
        dataList.add(user21);
        dataList.add(user22);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, dataList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        bpsSP.setAdapter(arrayAdapter);

        bpsSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                bpsSP.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(HRActivity.this, "Please Select your gender!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}