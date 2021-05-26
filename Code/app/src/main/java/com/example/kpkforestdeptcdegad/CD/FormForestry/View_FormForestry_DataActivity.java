package com.example.kpkforestdeptcdegad.CD.FormForestry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kpkforestdeptcdegad.CD.FormForestry.Adapter.FormForestryAdapter;
import com.example.kpkforestdeptcdegad.CD.VDC.Adapter.VDC_Adapter;
import com.example.kpkforestdeptcdegad.R;

public class View_FormForestry_DataActivity extends AppCompatActivity {

    RecyclerView viewFormForestryRV;
    FormForestryAdapter formForestryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__form_forestry_data);

        viewFormForestryRV = findViewById(R.id.rv_view_formForestry);

        setAdapter();
    }

    private void setAdapter() {
        formForestryAdapter = new FormForestryAdapter(this);
        viewFormForestryRV.setLayoutManager(new LinearLayoutManager(this));
        viewFormForestryRV.setAdapter(formForestryAdapter);

    }
}