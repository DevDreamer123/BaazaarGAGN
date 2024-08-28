package com.example.neerajinnostore.account;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.neerajinnostore.AccountActivity;
import com.example.neerajinnostore.R;
import com.example.neerajinnostore.RecyclerAdapter;
import com.example.neerajinnostore.RecyclerModel;
import com.example.neerajinnostore.SearchLocation;
import com.example.neerajinnostore.SearchProductActivity;
import com.example.neerajinnostore.Utils.RetrofitInstance;
import com.example.neerajinnostore.Utils.StoreModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreFragment extends Fragment {
RecyclerView storerecycler;
Button locat;
ImageView searchview;
ImageView pro;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_store, container, false);
      //  searchview = view.findViewById(R.id.searhview);
       //   searchview.setOnClickListener(new View.OnClickListener() {
        //     @Override
          //    public void onClick(View view) {
         //       Intent i = new Intent(getContext(), SearchProductActivity.class);
         //       startActivity(i);
          //    }
       //   });
     //   pro = view.findViewById(R.id.pro);
      //  pro.setOnClickListener(new View.OnClickListener() {
     //       @Override
     //       public void onClick(View view) {
      //          Intent i = new Intent(getContext(), AccountActivity.class);
      //          startActivity(i);
      //      }
     //   });
       // locat = view.findViewById(R.id.locat);
    //    locat.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
       //         Intent i = new Intent(getContext(), SearchLocation.class);
      //          startActivity(i);
       //     }
     //  });






        /*ArrayList<RecyclerModel> courseModelArrayList = new ArrayList<RecyclerModel>();
        courseModelArrayList.add(new RecyclerModel("Whole Foods Store",R.drawable.store3,"(Grocery Store)"));
        courseModelArrayList.add(new RecyclerModel("Gift Giver", R.drawable.store7,"(Gift Shop)"));
        courseModelArrayList.add(new RecyclerModel("The Sugar Rush", R.drawable.store8,"(Sweet Shop)"));
        courseModelArrayList.add(new RecyclerModel("SR Restaurant", R.drawable.store3,"(Restaurant)"));
        courseModelArrayList.add(new RecyclerModel("Absolute Power Electric", R.drawable.store7,"(electronic and Electrical  Store) "));
        courseModelArrayList.add(new RecyclerModel("The Classic Cut", R.drawable.store8,"(Barber shop) "));
        courseModelArrayList.add(new RecyclerModel("Hearty Mart", R.drawable.store3,"(Medical Shop)"));*/

        storerecycler = (RecyclerView) view.findViewById(R.id.storerecycler);

        RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
        try {
            Call<List<StoreModel>> call = RetrofitInstance.getInstance().getMyApi().getStore();
            call.enqueue(new Callback<List<StoreModel>>() {
                @Override
                public void onResponse(Call<List<StoreModel>> call, Response<List<StoreModel>> response) {
                    //  Toast.makeText(CategoryActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    List<StoreModel> brandModels = response.body();
                    storerecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
                    RecyclerAdapter cate = new RecyclerAdapter(getContext(),brandModels);
                    storerecycler.setAdapter(cate);

                }

                @Override
                public void onFailure(Call<List<StoreModel>> call, Throwable t) {
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






        return view;
    }
}