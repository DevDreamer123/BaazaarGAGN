package com.example.neerajinnostore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neerajinnostore.Utils.ProductModel;
import com.example.neerajinnostore.account.StoreFragment;

import java.util.List;

public class ProductGridReAdapter extends RecyclerView.Adapter<ProductGridReAdapter.ViewHolder> {
    private final Context context;
    private final List<ProductModel> categoryModelList;


    public ProductGridReAdapter(Context context, List<ProductModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public ProductGridReAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductGridReAdapter.ViewHolder holder, int position) {
        final ProductModel model = categoryModelList.get(position);
        holder.title_pro_card.setText(model.getTitle());
        holder.price_pro_card.setText(model.getCategory());
        Glide.with(context).load(R.drawable.watch).into(holder.img_pro);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // AppCompatActivity activity = (AppCompatActivity) view.getContext();

               // Fragment fragment = new StoreFragment();
              //  FragmentTransaction mFragmentTransaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();

               // mFragmentTransaction.replace(R.id.container, new StoreFragment()).addToBackStack("").commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title_pro_card,price_pro_card;
        ImageView img_pro;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_pro_card = (TextView) itemView.findViewById(R.id.title_pro_card);
            price_pro_card = (TextView) itemView.findViewById(R.id.prize_pro_card);
            img_pro = (ImageView)itemView.findViewById(R.id.img_pro);
        }
    }
}
