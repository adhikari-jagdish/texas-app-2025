package com.texas.texasmobileapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserRegistration extends AppCompatActivity {

    EditText etFullName, etMobileNumber;
    RadioGroup rgGender;
    Spinner spCountry;
    CheckBox cbPlaying, cbReading, cbTravelling;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_registration);

        etFullName = findViewById(R.id.etFullName);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        rgGender = findViewById(R.id.rgGender);
        spCountry = findViewById(R.id.spCountry);
        cbPlaying = findViewById(R.id.cbPlaying);
        cbTravelling = findViewById(R.id.cbTravelling);
        cbReading = findViewById(R.id.cbReading);
        btnSubmit = findViewById(R.id.btnSubmit);

        String [] countriesList = {"Nepal", "USA", "Bhutan", "Australia", "Canada", "UK"};
        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, countriesList );
        spCountry.setAdapter(countriesAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullNameValue = etFullName.getText().toString();
                double mobileNumberValue = Double.parseDouble(etMobileNumber.getText().toString());

                Toast.makeText(UserRegistration.this, fullNameValue + " / " + mobileNumberValue, Toast.LENGTH_LONG).show();

            }
        });


    }
}