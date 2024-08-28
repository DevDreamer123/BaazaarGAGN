package com.example.neerajinnostore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {
TextView login;
TextView edit_link,address_book;
CardView id_card_account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        id_card_account = findViewById(R.id.id_card_account);
        id_card_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccountActivity.this, IDcardActivity.class);
                startActivity(i);
            }
        });
        address_book = findViewById(R.id.address_book);
        address_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccountActivity.this, AddressBookActivity.class);
                startActivity(i);
            }
        });
        edit_link= findViewById(R.id.edit_link);
        edit_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccountActivity.this, EditProfileActivity.class);
                startActivity(i);
            }
        });
        login = findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AccountActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}