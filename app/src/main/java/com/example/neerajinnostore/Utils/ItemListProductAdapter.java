package com.example.neerajinnostore.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neerajinnostore.MainActivity;
import com.example.neerajinnostore.R;
import com.example.neerajinnostore.account.StoreFragment;

import java.util.List;

public class ItemListProductAdapter extends RecyclerView.Adapter<ItemListProductAdapter.ViewHolder> {
    private final Context context;
    private final List<ItemProductModel> itemProductModels;
    public ItemListProductAdapter(Context context, List<ItemProductModel> itemProductModels) {
        this.context = context;
        this.itemProductModels = itemProductModels;
    }
    @NonNull
    @Override
    public ItemListProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListProductAdapter.ViewHolder holder, int position) {
        final ItemProductModel model = itemProductModels.get(position);
        holder.title_item_product.setText(model.getTitle());
        holder.description_item_product.setText(model.getDescription());
        holder.gram_item_product.setText(model.getGram());
        holder.rupee_item_product.setText(model.getRupee());
        Glide.with(context).load(R.drawable.kurkure).into(holder.img_item_product);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();

                Fragment fragment = new StoreFragment();
                FragmentTransaction mFragmentTransaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.replace(R.id.container, new StoreFragment()).addToBackStack("").commit();


            }
        });
    }

    @Override
    public int getItemCount() {
        return itemProductModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_item_product;
        TextView title_item_product,description_item_product,gram_item_product,rupee_item_product;
        Button add_item_product;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item_product = itemView.findViewById(R.id.img_item_product);
            title_item_product = itemView.findViewById(R.id.title_item_product);
            description_item_product = itemView.findViewById(R.id.description_item_product);
            gram_item_product = itemView.findViewById(R.id.gram_item_product);
            rupee_item_product = itemView.findViewById(R.id.rupee_item_product);
            add_item_product = itemView.findViewById(R.id.add_item_product);
        }
    }
}
