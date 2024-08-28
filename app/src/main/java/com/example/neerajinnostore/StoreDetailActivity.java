package com.example.neerajinnostore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neerajinnostore.Utils.CartListModel;
import com.example.neerajinnostore.Utils.FilterAdapter;
import com.example.neerajinnostore.Utils.FilterModel;
import com.example.neerajinnostore.Utils.ProductModel;
import com.example.neerajinnostore.Utils.RetrofitInstance;
import com.example.neerajinnostore.Utils.UserIDModel;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselOnScrollListener;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.model.CarouselType;
import org.imaginativeworld.whynotimagecarousel.utils.Utils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.relex.circleindicator.CircleIndicator2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreDetailActivity extends AppCompatActivity {

    RecyclerView detailstr,food,filter_recyclerview;
    LinearLayoutManager horizontal;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);
        filter_recyclerview = findViewById(R.id.filter_recyclerview);
        ArrayList<FilterModel> filterModels = new ArrayList<FilterModel>();
        filterModels.add(new FilterModel("","Recommended"));
        filterModels.add(new FilterModel("","Product1"));
        filterModels.add(new FilterModel("","Ponds Soap"));
        filterModels.add(new FilterModel("","Product2"));
        filterModels.add(new FilterModel("","Product3"));
        filterModels.add(new FilterModel("","Product4"));
        filterModels.add(new FilterModel("","Product5"));

        // Setting the layout as linear
        // layout for vertical orientation
        FilterAdapter Adapter = new FilterAdapter(StoreDetailActivity.this, filterModels);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        horizontal =new LinearLayoutManager(StoreDetailActivity.this,LinearLayoutManager.HORIZONTAL,false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        filter_recyclerview.setLayoutManager(horizontal);
        filter_recyclerview.setAdapter(Adapter);




        info = findViewById(R.id.infoshop);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StoreDetailActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
        detailstr = findViewById(R.id.detailstr);

       RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
        UserIDModel Idmodel =  new UserIDModel("123");
        try {

         Call<List<ProductModel>> callP = RetrofitInstance.getInstance().getMyApi().getProduct();
            callP.enqueue(new Callback<List<ProductModel>>() {
                @Override
                public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                    //  Toast.makeText(CategoryActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    List<ProductModel> brandModels = response.body();
                    RecyclerDetailAdaper courseAdapter = new RecyclerDetailAdaper(StoreDetailActivity.this, brandModels, StoreDetailActivity.this);

                    // below line is for setting a layout manager for our recycler view.
                    // here we are creating vertical list so we will provide orientation as vertical
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StoreDetailActivity.this, LinearLayoutManager.VERTICAL, false);

                    // in below two lines we are setting layoutmanager and adapter to our recycler view.
                    detailstr.setLayoutManager(linearLayoutManager);
                    detailstr.setAdapter(courseAdapter);
                    //  quantityTextView.setText(modls.get);
                    //Toast.makeText(getContext(),modls.getMessage(), Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                    Toast.makeText(StoreDetailActivity.this,t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());

                    t.toString();
                }
            });


           /*  Call<List<CartListModel>> call = RetrofitInstance.getInstance().getMyApi().getCartsList(Idmodel);
            call.enqueue(new Callback<List<CartListModel>>() {
                @Override
                public void onResponse(Call<List<CartListModel>> call, Response<List<CartListModel>> response) {
                    List<CartListModel> modls = response.body();
                    RecyclerDetailAdaper courseAdapter = new RecyclerDetailAdaper(StoreDetailActivity.this, modls, StoreDetailActivity.this);

                    // below line is for setting a layout manager for our recycler view.
                    // here we are creating vertical list so we will provide orientation as vertical
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StoreDetailActivity.this, LinearLayoutManager.VERTICAL, false);

                    // in below two lines we are setting layoutmanager and adapter to our recycler view.
                    detailstr.setLayoutManager(linearLayoutManager);
                    detailstr.setAdapter(courseAdapter);
                    //  quantityTextView.setText(modls.get);
                    //Toast.makeText(getContext(),modls.getMessage(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<CartListModel>> call, Throwable t) {
               //     Toast.makeText(getContext(),t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());

                    t.toString();
                }
            });*/



        } catch (Exception e) {
          //  Toast.makeText(getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            Log.d("error1",e.getMessage());
            e.getMessage();
        }





        ArrayList<ItemModel> courseModelArrayList = new ArrayList<ItemModel>();
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure2));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure2));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure));


        // Setting the layout as linear
        // layout for vertical orientation








        //food RecyclerView
        food = findViewById(R.id.food);

        // Setting the layout as linear
        // layout for vertical orientation
        HoriRecyclerAdapter Adapter1 = new HoriRecyclerAdapter(StoreDetailActivity.this, courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        horizontal =new LinearLayoutManager(StoreDetailActivity.this,LinearLayoutManager.HORIZONTAL,false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        food.setLayoutManager(horizontal);
        food.setAdapter(Adapter1);



    }
}