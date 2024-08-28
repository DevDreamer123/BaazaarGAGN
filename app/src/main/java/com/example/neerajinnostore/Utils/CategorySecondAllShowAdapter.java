package com.example.neerajinnostore.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neerajinnostore.CategoryCardAdapter;
import com.example.neerajinnostore.MainActivity;
import com.example.neerajinnostore.R;
import com.example.neerajinnostore.account.StoreFragment;

import java.util.List;

public class CategorySecondAllShowAdapter extends RecyclerView.Adapter<CategorySecondAllShowAdapter.ViewHolder> {
    private final Context context;
    private final List<ProductCategoryModel> categoryModelList;
    public CategorySecondAllShowAdapter(Context context, List<ProductCategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_img_sec_layout, parent, false);

        return new ViewHolder(view);




        //  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_img_sec_layout, parent, false);

        // return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final ProductCategoryModel model = categoryModelList.get(position);
            holder.textView.setText(model.getTitle());
            Glide.with(context).load("https://cdn-icons-png.flaticon.com/512/3733/3733209.png").into(holder.imageView);
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


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        CardView category_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.category_sec_title);
            imageView = (ImageView)itemView.findViewById(R.id.category_sec_image);
            category_layout = itemView.findViewById(R.id.category_sec_layout);

        }
    }
}
