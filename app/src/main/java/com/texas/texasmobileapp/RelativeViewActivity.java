package com.texas.texasmobileapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RelativeViewActivity extends AppCompatActivity {

    EditText fullName, mobileNumber, email;
    RadioGroup rgGender;
    Spinner spCountry;
    CheckBox cbReading, cbTravelling, cbPlaying;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relative_view);

        fullName = findViewById(R.id.etFullName);
        mobileNumber = findViewById(R.id.etMobileNumber);
        email = findViewById(R.id.etEmail);
        rgGender = findViewById(R.id.rgGender);
        spCountry = findViewById(R.id.spCountry);
        cbReading = findViewById(R.id.cbReading);
        cbPlaying = findViewById(R.id.cbPlaying);
        cbTravelling = findViewById(R.id.cbTravelling);
        submitButton = findViewById(R.id.btnSubmit);

        //Populating Country Spinner
        String[] countries = {"Select A Country", "Nepal", "Bhutan", "Australia", "USA", "Canada", "China"};
        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countries);
        spCountry.setAdapter(countriesAdapter);

    }
}