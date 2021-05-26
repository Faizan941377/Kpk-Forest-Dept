package com.example.kpkforestdeptcdegad.CD.JFMC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kpkforestdeptcdegad.CD.JFMC.Adapter.JFMC_Adapter;
import com.example.kpkforestdeptcdegad.CD.VDC.Adapter.VDC_Adapter;
import com.example.kpkforestdeptcdegad.R;

public class JFMC_View_DataActivity extends AppCompatActivity {

    RecyclerView jfmcViewRV;
    JFMC_Adapter jfmc_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_f_m_c_view_data);


        jfmcViewRV = findViewById(R.id.rv_view_jfmc);
        setAdapter();
    }

    private void setAdapter() {
        jfmc_adapter = new JFMC_Adapter(this);
        jfmcViewRV.setLayoutManager(new LinearLayoutManager(this));
        jfmcViewRV.setAdapter(jfmc_adapter);

    }
}