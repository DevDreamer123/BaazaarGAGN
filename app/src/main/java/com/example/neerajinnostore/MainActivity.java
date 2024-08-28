package com.example.neerajinnostore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.neerajinnostore.account.StoreFragment;
import com.example.neerajinnostore.category.CategoryFragment;
import com.example.neerajinnostore.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FloatingActionButton fab,fab_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showHomeFragment();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //  bottomNavigationView = findViewById(R.id.bottonnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                int id = item.getItemId();

                if(id == R.id.home)
                {
                    transaction.replace(R.id.container, new HomeFragment());

                }
                  if(id == R.id.category)
                   {
                       transaction.replace(R.id.container, new CategoryFragment());

                  }
                if(id == R.id.store)
                {
                    transaction.replace(R.id.container, new StoreFragment());

                }
                transaction.commit();
                return true;
            }
        });
        int icon1color = ContextCompat.getColor(this,R.color.white);
        fab= findViewById(R.id.fab);
        fab.setColorFilter(icon1color, PorterDuff.Mode.SRC_IN);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new StoreFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
            }
        });
        fab_msg = findViewById(R.id.fab_msg);
        fab_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });


    }

    private void showHomeFragment() {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new HomeFragment());
        transaction.commit();










    }
}