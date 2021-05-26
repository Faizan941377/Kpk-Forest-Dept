package com.example.kpkforestdeptcdegad.CD.VDC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.kpkforestdeptcdegad.CD.VDC.Adapter.VDC_Adapter;
import com.example.kpkforestdeptcdegad.R;

public class View_VDC_DataActivity extends AppCompatActivity {

    RecyclerView vdcViewRV;
    VDC_Adapter vdc_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__v_d_c__data);

        vdcViewRV = findViewById(R.id.rv_view_vdc);


        setAdapter();

    }

    private void setAdapter() {
        vdc_adapter = new VDC_Adapter(this);
        vdcViewRV.setLayoutManager(new LinearLayoutManager(this));
        vdcViewRV.setAdapter(vdc_adapter);

    }
}