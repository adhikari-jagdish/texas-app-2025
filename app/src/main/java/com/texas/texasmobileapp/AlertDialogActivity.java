package com.texas.texasmobileapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlertDialogActivity extends AppCompatActivity {

    Button btnShowAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert_dialog);

        btnShowAlertDialog = findViewById(R.id.btn_show_alert_dialog);

    }

    @Override
    protected void onStart() {
        super.onStart();

        btnShowAlertDialog.setOnClickListener(v -> {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(AlertDialogActivity.this);
            alertDialog.setTitle("Logout!!");
            alertDialog.setMessage("Are you sure you want to logout?");
            alertDialog.setIcon(R.mipmap.ic_launcher);

            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(AlertDialogActivity.this, "Yes Clicked", Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });


            AlertDialog alert = alertDialog.create();
            alert.show();
        });
    }
}