package com.texas.texasmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class RelativeViewActivity extends AppCompatActivity {

    EditText fullName, mobileNumber, email;
    RadioGroup rgGender;
    Spinner spCountry;
    CheckBox cbReading, cbTravelling, cbPlaying;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String fullNameValue = fullName.getText().toString();
                double mobileNumberValue = Double.parseDouble(mobileNumber.getText().toString());
                String emailValue = email.getText().toString();
                String gender = "";

                int selectedId = rgGender.getCheckedRadioButtonId();
                if(selectedId!=-1){
                    RadioButton selectedGender = findViewById(selectedId);
                    gender = selectedGender.getText().toString();
                }

                String country = spCountry.getSelectedItem().toString();

                ArrayList<String> hobbies = new ArrayList<>();

                if(cbPlaying.isChecked()){
                    hobbies.add("Playing");
                }
                if(cbTravelling.isChecked()){
                    hobbies.add("Travelling");
                }
                if(cbReading.isChecked()){
                    hobbies.add("Reading");
                }

                Intent intent = new Intent(getApplicationContext(), UserDetailsActivity.class);
                intent.putExtra("full_name",fullNameValue );
                intent.putExtra("mobile_number", mobileNumberValue);
                intent.putExtra("email", emailValue);
                intent.putExtra("gender", gender);
                intent.putExtra("country", country);
                intent.putExtra("hobbies", hobbies);
                startActivity(intent);


                Toast.makeText(RelativeViewActivity.this, fullNameValue + "-" + mobileNumberValue + "-" +emailValue, Toast.LENGTH_SHORT).show();

            }
        });

    }
}