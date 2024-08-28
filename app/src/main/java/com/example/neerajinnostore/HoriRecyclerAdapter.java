package com.example.neerajinnostore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HoriRecyclerAdapter extends RecyclerView.Adapter<HoriRecyclerAdapter.Viewholder> {
    private final Context context;
    private final ArrayList<ItemModel> courseModelArrayList;

    // Constructor
    public HoriRecyclerAdapter(Context context, ArrayList<ItemModel> courseModelArrayList) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public HoriRecyclerAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontalrecycler, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoriRecyclerAdapter.Viewholder holder, int position) {
        ItemModel model = courseModelArrayList.get(position);
        holder.images.setImageResource(model.getImage());


    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }


    public class Viewholder  extends RecyclerView.ViewHolder{
        ImageView images;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            images = (ImageView) itemView.findViewById(R.id.brandimg);
        }
    }
}
