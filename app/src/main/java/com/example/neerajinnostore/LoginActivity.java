package com.example.neerajinnostore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.neerajinnostore.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {
    Button loginl;
    TextView sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       loginl = findViewById(R.id.login);
        loginl.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               Intent i = new Intent(LoginActivity.this, MainActivity.class);
               startActivity(i);
               finish();
           }
        });
       sign = findViewById(R.id.signupbtn);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
               Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

    }
}