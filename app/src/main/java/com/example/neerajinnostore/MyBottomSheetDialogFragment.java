package com.example.neerajinnostore;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neerajinnostore.Utils.CartListModel;
import com.example.neerajinnostore.Utils.ItemListAdapter;
import com.example.neerajinnostore.Utils.ItemQtyRequestModel;
import com.example.neerajinnostore.Utils.ProductIDModel;
import com.example.neerajinnostore.Utils.ProductItemListModel;
import com.example.neerajinnostore.Utils.RetrofitInstance;
import com.example.neerajinnostore.Utils.UserIDModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyBottomSheetDialogFragment extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
Button increaseButton,decreaseButton;
TextView quantityTextView ,product_title_set;
RecyclerView item_show_popup_recyclerview;
    private int value = 0;
    private AppCompatActivity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_my_bottom_sheet_dialog, container, false);
        item_show_popup_recyclerview= view.findViewById(R.id.item_show_popup_recyclerview);
        product_title_set = view.findViewById(R.id.product_title_set);
       quantityTextView= view.findViewById(R.id.quantityTextView);
       /* increaseButton = view.findViewById(R.id.increaseButton);
        decreaseButton = view.findViewById(R.id.decreaseButton);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
                ItemQtyRequestModel brandModel =  new ItemQtyRequestModel("123","001","003");
                try {
                    Call<IncreaseDecreaseModel> call = RetrofitInstance.getInstance().getMyApi().getIncreaseItemList(brandModel);
                    call.enqueue(new Callback<IncreaseDecreaseModel>() {
                        @Override
                        public void onResponse(Call<IncreaseDecreaseModel> call, Response<IncreaseDecreaseModel> response) {
                            IncreaseDecreaseModel modls = response.body();
                            Toast.makeText(getContext(),modls.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<IncreaseDecreaseModel> call, Throwable t) {
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


              //  Toast.makeText(getContext(), "Increase", Toast.LENGTH_SHORT).show();
                value++;
              //  quantityTextView.setText(value);
                updateValue();
            }
        });
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Decrease", Toast.LENGTH_SHORT).show();
                RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
                ItemQtyRequestModel brandModel =  new ItemQtyRequestModel("123","001","003");
                try {
                    Call<IncreaseDecreaseModel> calld = RetrofitInstance.getInstance().getMyApi().getDecreaseItemList(brandModel);
                    calld.enqueue(new Callback<IncreaseDecreaseModel>() {
                        @Override
                        public void onResponse(Call<IncreaseDecreaseModel> call, Response<IncreaseDecreaseModel> response) {
                            IncreaseDecreaseModel modls = response.body();
                            Toast.makeText(getContext(),modls.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<IncreaseDecreaseModel> call, Throwable t) {
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


               // Toast.makeText(getContext(), "Increase", Toast.LENGTH_SHORT).show();

                // updateValue();
               value--;
                //quantityTextView.setText(value);
                updateValue();
            }
        });*/

        RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
        ProductIDModel productIDModel =  new ProductIDModel("001");
        try {
            Call<List<ProductItemListModel>> call = RetrofitInstance.getInstance().getMyApi().getProductItemList(productIDModel);
            call.enqueue(new Callback<List<ProductItemListModel>>() {
                @Override
                public void onResponse(Call<List<ProductItemListModel>> call, Response<List<ProductItemListModel>> response) {
                   List<ProductItemListModel> modls = response.body();
                  ItemListAdapter courseAdapter = new ItemListAdapter(getContext(), modls,activity);

                    // below line is for setting a layout manager for our recycler view.
                    // here we are creating vertical list so we will provide orientation as vertical
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

                    // in below two lines we are setting layoutmanager and adapter to our recycler view.
                    item_show_popup_recyclerview.setLayoutManager(linearLayoutManager);
                    item_show_popup_recyclerview.setAdapter(courseAdapter);
                    Toast.makeText(getContext(),modls.toString(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<List<ProductItemListModel>> call, Throwable t) {
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


     /*   ArrayList<ItemModel> courseModelArrayList = new ArrayList<ItemModel>();
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure2));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure));
        courseModelArrayList.add(new ItemModel("Kurkure", R.drawable.kurkure));*/








        return view;
    }
    private void updateValue() {
        quantityTextView.setText(String.valueOf(value));
    }
}