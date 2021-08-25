package com.example.kpkforestdeptcdegad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry.Adapter.FarmAgroForestryAdapter;
import com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry.ViewFarmAgroForestryActivity;
import com.example.kpkforestdeptcdegad.Model.FetchFarmAgroForestryDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchFarmForestryDataModel;
import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.Response.FarmAgroForestryResponse;
import com.example.kpkforestdeptcdegad.Response.FetchFarmAgroForestryResponse;
import com.example.kpkforestdeptcdegad.Response.LoginResponse;
import com.example.kpkforestdeptcdegad.Response.RegistrationResponse;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    AdapterClass adapter;
    RecyclerView recyclerView;
    List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModelList;
    List<FetchFarmAgroForestryDataModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        setAdatper();
    }

    private void setAdatper() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Call<FetchFarmAgroForestryResponse> call = RetrofitClient.getInstance().getApi().fetchFarmAgroForestryResponse();
        call.enqueue(new Callback<FetchFarmAgroForestryResponse>() {
            @Override
            public void onResponse(Call<FetchFarmAgroForestryResponse> call, Response<FetchFarmAgroForestryResponse> response) {
                if (response.isSuccessful()) {
                    fetchFarmAgroForestryDataModelList = response.body().getFetchFarmAgroForestryDataModelList();
                    recyclerView.setAdapter(new AdapterClass(fetchFarmAgroForestryDataModelList, getApplicationContext()));
                    adapter = new AdapterClass(fetchFarmAgroForestryDataModelList,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchFarmAgroForestryResponse> call, Throwable t) {
                try {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}