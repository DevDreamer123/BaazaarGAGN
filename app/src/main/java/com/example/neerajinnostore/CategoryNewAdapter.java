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
import com.example.neerajinnostore.account.StoreFragment;

import java.util.List;

public class CategoryNewAdapter extends RecyclerView.Adapter<CategoryNewAdapter.ViewHolder> {
    private final Context context;
    private final List<CategoryModel> categoryModelList;

    // private static final int LIST_AD_DELTA = 11;
    private final int limit = 11;

    public CategoryNewAdapter(Context context, List<CategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
        }
    @NonNull
    @Override
    public CategoryNewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryNewAdapter.ViewHolder holder, int position) {
        final CategoryModel model = categoryModelList.get(position);
        holder.textView.setText(model.getName());
        Glide.with(context).load(model.getImage()).into(holder.imageView);
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
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        LinearLayout category_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.category_title);
            imageView = (ImageView)itemView.findViewById(R.id.category_image);
            category_layout = itemView.findViewById(R.id.category_layout);
        }
    }
}
