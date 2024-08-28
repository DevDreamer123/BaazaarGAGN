package com.example.neerajinnostore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class SearchProductActivity extends AppCompatActivity {
GridView gridview_product;
    String[] web = {
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure",
            "kurkure"

    } ;
    int[] imageId = {
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure,
            R.drawable.kurkure


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
       /* GridAdapter adapter = new GridAdapter(SearchProductActivity.this, web, imageId);
        gridview_product=(GridView)findViewById(R.id.grid_product);
        gridview_product.setAdapter(adapter);
        gridview_product.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(SearchProductActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });*/

    }
}