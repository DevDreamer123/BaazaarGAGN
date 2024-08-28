package com.example.neerajinnostore.Utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neerajinnostore.IncreaseDecreaseModel;
import com.example.neerajinnostore.R;
import com.example.neerajinnostore.RecyclerDetailAdaper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private final Context context;
    private final List<ProductItemListModel> productItemListModels;
    private AppCompatActivity mActivity;
    private int value = 0;

    public ItemListAdapter(Context context, List<ProductItemListModel> productItemListModels,AppCompatActivity activity) {
        this.context = context;
        this.productItemListModels = productItemListModels;
        this.mActivity = activity;

    }

    @NonNull
    @Override
    public ItemListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.ViewHolder holder, int position) {
        ProductItemListModel model = productItemListModels.get(position);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
        layoutParams.topMargin = 5;
        holder.itemView.setLayoutParams(layoutParams);
      //  holder.images_item.setImageResource(R.drawable.kurkure2);
        holder.item_title_item.setText(model.getTitle());
        holder.item_price_item.setText(model.getPrice());
        holder.item_offer_price_item.setText(model.getOfferPrice());

        holder.img_plus_vote.setOnClickListener(new View.OnClickListener() {
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
                            Toast.makeText(context,modls.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<IncreaseDecreaseModel> call, Throwable t) {
                            Toast.makeText(context,t.toString(), Toast.LENGTH_SHORT).show();
                            Log.d("error",t.getMessage());

                            t.toString();
                        }
                    });


                } catch (Exception e) {
                    Toast.makeText(context,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("error1",e.getMessage());
                    e.getMessage();
                }


                //  Toast.makeText(getContext(), "Increase", Toast.LENGTH_SHORT).show();
                value++;
                //  quantityTextView.setText(value);
                //updateValue();
                holder.txt_num_vote.setText(String.valueOf(value));

            }
        });
        holder.img_minus_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitInstance.BASEURL = "http://baazaarapi.gagn.in/";
                ItemQtyRequestModel brandModel =  new ItemQtyRequestModel("123","001","003");
                try {
                    Call<IncreaseDecreaseModel> calld = RetrofitInstance.getInstance().getMyApi().getDecreaseItemList(brandModel);
                    calld.enqueue(new Callback<IncreaseDecreaseModel>() {
                        @Override
                        public void onResponse(Call<IncreaseDecreaseModel> call, Response<IncreaseDecreaseModel> response) {
                            IncreaseDecreaseModel modls = response.body();
                            Toast.makeText(context,modls.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<IncreaseDecreaseModel> call, Throwable t) {
                            Toast.makeText(context,t.toString(), Toast.LENGTH_SHORT).show();
                            Log.d("error",t.getMessage());

                            t.toString();
                        }
                    });


                } catch (Exception e) {
                    Toast.makeText(context,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("error1",e.getMessage());
                    e.getMessage();
                }


                // Toast.makeText(getContext(), "Increase", Toast.LENGTH_SHORT).show();

                // updateValue();
               value--;
                holder.txt_num_vote.setText(String.valueOf(value));


            }

        });



    }

    @Override
    public int getItemCount() {
        return productItemListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView images_item;
        TextView item_title_item,item_price_item,item_offer_price_item,txt_num_vote;
        Button add_item_item;
        Button img_minus_vote,img_plus_vote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images_item = (ImageView) itemView.findViewById(R.id.img_item);
            img_minus_vote = (Button) itemView.findViewById(R.id.img_minus_vote);
            img_plus_vote = (Button) itemView.findViewById(R.id.img_plus_vote);
            item_title_item = (TextView) itemView.findViewById(R.id.item_title_item);
            item_price_item = (TextView) itemView.findViewById(R.id.item_price_item);
            item_offer_price_item = (TextView) itemView.findViewById(R.id.item_offer_price_item);
            txt_num_vote = (TextView) itemView.findViewById(R.id.txt_num_vote);
        }
    }

    }

