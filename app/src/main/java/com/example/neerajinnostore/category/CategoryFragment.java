package com.example.neerajinnostore.category;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.neerajinnostore.AccountActivity;
import com.example.neerajinnostore.CategoryAdapter;
import com.example.neerajinnostore.CategoryCardAdapter;
import com.example.neerajinnostore.CategoryModel;
import com.example.neerajinnostore.CategoryNewAdapter;
import com.example.neerajinnostore.CategorySecondAdapter;
import com.example.neerajinnostore.GridAdapter;
import com.example.neerajinnostore.HoriRecyclerAdapter;
import com.example.neerajinnostore.ItemModel;
import com.example.neerajinnostore.R;
import com.example.neerajinnostore.SearchLocation;
import com.example.neerajinnostore.SearchProductActivity;
import com.example.neerajinnostore.Utils.CategorySecondAllShowAdapter;
import com.example.neerajinnostore.Utils.ProductCategoryModel;
import com.example.neerajinnostore.Utils.RetrofitInstance;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    RecyclerView recylerbrand;
    GridView grid;
    RecyclerView product,category_category;
    LinearLayoutManager horizontal;
    ImageView search;
    ImageView profile;
    Button location;
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

    int[] image = {
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
    ImageSlider slider;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_category, container, false);
       recylerbrand = view.findViewById(R.id.recylerbrand);
        ArrayList<ItemModel> courseModelArrayList = new ArrayList<ItemModel>();
        courseModelArrayList.add(new ItemModel("DSA in Java", R.drawable.cupcake));
        courseModelArrayList.add(new ItemModel("Java Course", R.drawable.kurkure));
        courseModelArrayList.add(new ItemModel("C++ Course", R.drawable.chips));
        courseModelArrayList.add(new ItemModel("DSA in C++", R.drawable.kurkure2));
        courseModelArrayList.add(new ItemModel("Kotlin for Android", R.drawable.cupcake));
        courseModelArrayList.add(new ItemModel("Java for Android", R.drawable.cheena));
        courseModelArrayList.add(new ItemModel("HTML and CSS", R.drawable.chips));


        // Setting the layout as linear
        // layout for vertical orientation
        CategoryCardAdapter courseAdapter = new CategoryCardAdapter(getContext(), courseModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        horizontal =new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        recylerbrand.setLayoutManager(horizontal);
        recylerbrand.setAdapter(courseAdapter);


        //Product Recycler

        product = view.findViewById(R.id.product);


        // Setting the layout as linear
        // layout for vertical orientation

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        horizontal =new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        product.setLayoutManager(horizontal);
        product.setAdapter(courseAdapter);





        //slider = view.findViewById(R.id.image_slider);
      //  ArrayList<SlideModel> imageList = new ArrayList<>();// Create image list

      //  imageList.add(new SlideModel(R.drawable.cupcake, ScaleTypes.FIT));
      //  imageList.add(new SlideModel(R.drawable.kurkure, ScaleTypes.FIT));
      //  imageList.add(new SlideModel(R.drawable.cheena, ScaleTypes.FIT));
      //  imageList.add(new SlideModel(R.drawable.gulabjamun, ScaleTypes.FIT));
      //  slider.setImageList(imageList);




      /* recylerbrand = view.findViewById(R.id.recylerbrand);
        GridAdapter adapter = new GridAdapter(getContext(), web, imageId);
        grid=(GridView)view.findViewById(R.id.gridimg);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getContext(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });*/
        //Search
      //  search = view.findViewById(R.id.searchv);
       // search.setOnClickListener(new View.OnClickListener() {
       //     @Override
      //      public void onClick(View view) {
      //        Intent i = new Intent(getContext(), SearchProductActivity.class);
       //         startActivity(i);
      //     }
     ///   });
        profile = view.findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AccountActivity.class);
                startActivity(i);
            }
        });
     //   location = view.findViewById(R.id.local);
      //  location.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {
      //          Intent i = new Intent(getContext(), SearchLocation.class);
      //          startActivity(i);
      //      }
     //   });



     //   List<CategoryModel> models = getModelList();
        RecyclerView recyclerView = view.findViewById(R.id.category_category);
        RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
        try {
            Call<List<ProductCategoryModel>> call = RetrofitInstance.getInstance().getMyApi().getCategory();
            call.enqueue(new Callback<List<ProductCategoryModel>>() {
                @Override
                public void onResponse(Call<List<ProductCategoryModel>> call, Response<List<ProductCategoryModel>> response) {
                    //  Toast.makeText(CategoryActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    List<ProductCategoryModel> brandModels = response.body();
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
                    CategorySecondAllShowAdapter categoryadapter = new CategorySecondAllShowAdapter(getContext(),brandModels);
                    recyclerView.setAdapter(categoryadapter);



                }

                @Override
                public void onFailure(Call<List<ProductCategoryModel>> call, Throwable t) {
                    Toast.makeText(getContext(),t.toString(), Toast.LENGTH_SHORT).show();
                    Log.d("error",t.getMessage());

                    t.toString();
                }
            });

        } catch (Exception e) {
            Toast.makeText(getContext(),e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            Log.d("error1",e.getMessage());
            e.getMessage();
        }






      //  recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
     //  CategoryNewAdapter categoryAdapteradapter = new CategoryNewAdapter(getContext(),models,this);
    //    recyclerView.setAdapter(categoryAdapteradapter);





        return view;
    }
    private List<CategoryModel> getModelList(){
        InputStream is = getResources().openRawResource(R.raw.category);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            int n;
            while (( n = reader.read(buffer))!= -1){
                writer.write(buffer,0,n);
            }

        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();

        }
        String jsonstr = writer.toString();
        Gson gson = new Gson();
        CategoryModel[] itemModels= gson.fromJson(jsonstr,CategoryModel[].class);
        List<CategoryModel> list = Arrays.asList(itemModels);
        return list;

    }

}