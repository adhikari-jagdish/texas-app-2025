package com.texas.texasmobileapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GridViewActivity extends AppCompatActivity {

    GridView gvCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gvCountries = findViewById(R.id.gv_countries);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String [] countries = {"Nepal", "Bhutan", "China", "India", "Singapore", "Switzerland", "Australia", "USA", "UK", "Burma", "Kenya",
                "Portugal", "Argentina", "Russia", "Chile", "Hongkong", "Dubai", "Qatar", "Sweden", "Norway", "SriLanka", "Bangladesh"};

        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(GridViewActivity.this, android.R.layout.simple_list_item_1, countries );

        gvCountries.setAdapter(countriesAdapter);
    }
}