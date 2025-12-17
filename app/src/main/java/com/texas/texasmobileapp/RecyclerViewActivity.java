package com.texas.texasmobileapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.texas.texasmobileapp.Adapter.CountryAdapter;
import com.texas.texasmobileapp.Model.CountryModel;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView countriesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        countriesRecyclerView = findViewById(R.id.recyclerview_countries);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayList<CountryModel> countries = new ArrayList<>();
        countries.add(new CountryModel("Nepal", R.mipmap.nepal_flag));
        countries.add(new CountryModel("USA", R.mipmap.ic_launcher));
        countries.add(new CountryModel("Japan", R.mipmap.ic_launcher_round));

        CountryAdapter countryAdapter = new CountryAdapter(RecyclerViewActivity.this, countries);
        countriesRecyclerView.setAdapter(countryAdapter);

    }
}