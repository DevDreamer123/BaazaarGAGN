package com.example.neerajinnostore;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neerajinnostore.Utils.StoreModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final Context context;
    private final List<StoreModel> courseModelArrayList;

    // Constructor
    public RecyclerAdapter(Context context, List<StoreModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.storerecycler, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        StoreModel model = courseModelArrayList.get(position);
        holder.text.setText(model.getTitle());
        holder.type_shop.setText(model.getDescription());
        holder.images.setImageResource(R.drawable.store8);
        holder.layoutstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,StoreDetailActivity.class);
                context.startActivity(i);


            }
        });


    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        ImageView images;
        TextView text,type_shop;
      CardView layoutstore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            images = (ImageView) itemView.findViewById(R.id.img2);
            text = (TextView) itemView.findViewById(R.id.txt);
            type_shop = (TextView) itemView.findViewById(R.id.type_shop);
            layoutstore = (CardView) itemView.findViewById(R.id.storedetail);
        }
    }
}
