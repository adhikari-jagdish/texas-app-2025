package com.texas.texasmobileapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PopupMenuActivity extends AppCompatActivity {
    Button btnOpenPopupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_popup_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnOpenPopupMenu = findViewById(R.id.btn_open_popup_menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnOpenPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(PopupMenuActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int selectedMenuId = item.getItemId();

                        if(selectedMenuId == R.id.popup_menu_view){
                            Toast.makeText(PopupMenuActivity.this, "View Option Clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        }else if (selectedMenuId == R.id.popup_menu_edit){
                            Toast.makeText(PopupMenuActivity.this, "Edit Option Clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (selectedMenuId == R.id.popup_menu_delete){
                            Toast.makeText(PopupMenuActivity.this, "Delete Option Clicked", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });

                popupMenu.show();

            }
        });
    }
}