package com.texas.texasmobileapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChildActivity extends AppCompatActivity {

    Button btnGoToParentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);

        btnGoToParentActivity = findViewById(R.id.btn_go_to_parent_activity);

    }

    @Override
    protected void onStart() {
        super.onStart();

        btnGoToParentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParentActivity.class);
                intent.putExtra("child_result", "Hello from Child activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}