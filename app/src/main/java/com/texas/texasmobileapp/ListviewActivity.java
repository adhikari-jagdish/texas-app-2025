package com.texas.texasmobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListviewActivity extends AppCompatActivity {
    ListView lvCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvCountries = findViewById(R.id.lv_countries);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String [] countries = {"Nepal", "Bhutan", "China", "India", "Singapore", "Switzerland", "Australia", "USA", "UK", "Burma", "Kenya",
        "Portugal", "Argentina", "Russia", "Chile", "Hongkong", "Dubai", "Qatar", "Sweden", "Norway", "SriLanka", "Bangladesh"};

        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(ListviewActivity.this, android.R.layout.simple_list_item_1,countries);
        lvCountries.setAdapter(countriesAdapter);

        lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = countries[position];
                Toast.makeText(ListviewActivity.this, "Selected Country: "+selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}