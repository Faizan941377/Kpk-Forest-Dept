package com.example.kpkforestdeptcdegad.CD.Enclosure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kpkforestdeptcdegad.CD.Enclosure.Adapter.EnclosureAdapter;
import com.example.kpkforestdeptcdegad.CD.FormForestry.Adapter.FormForestryAdapter;
import com.example.kpkforestdeptcdegad.R;

public class View_Enclosure_DataActivity extends AppCompatActivity {

    RecyclerView enclosureRV;
    EnclosureAdapter enclosureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__enclosure__data);

        enclosureRV = findViewById(R.id.rv_view_enclosure);

        setAdapter();
    }

    private void setAdapter() {
        enclosureAdapter = new EnclosureAdapter(this);
        enclosureRV.setLayoutManager(new LinearLayoutManager(this));
        enclosureRV.setAdapter(enclosureAdapter);

    }
}