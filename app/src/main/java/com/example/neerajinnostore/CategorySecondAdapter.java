package com.example.neerajinnostore;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neerajinnostore.Utils.ProductCategoryModel;
import com.example.neerajinnostore.account.StoreFragment;
import com.example.neerajinnostore.category.CategoryFragment;

import java.util.List;

public class CategorySecondAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int VIEW_TYPE_ITEM = 1;
    private static final int VIEW_TYPE_SHOW_MORE = 2;

    private List<ProductCategoryModel> dataList;
    private Context context;

    public CategorySecondAdapter(List<ProductCategoryModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_ITEM) {
            View itemView = inflater.inflate(R.layout.category_img_sec_layout, parent, false);
            return new ItemViewHolder(itemView);
        } else {
            View showMoreView = inflater.inflate(R.layout.more_layout, parent, false);
            return new ShowMoreViewHolder(showMoreView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ProductCategoryModel item = dataList.get(position);
            ((ItemViewHolder) holder).bind(item);
        } else if (holder instanceof ShowMoreViewHolder) {
            ((ShowMoreViewHolder) holder).showMoreLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "More", Toast.LENGTH_SHORT).show();
                    // Start new activity to show all items
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();

                    Fragment fragment = new CategoryFragment();
                    FragmentTransaction mFragmentTransaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();

                    mFragmentTransaction.replace(R.id.container, new CategoryFragment()).addToBackStack("").commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return Math.min(dataList.size(), 4) + 1; // Show 8 items initially, plus "Show More" card
    }

    @Override
    public int getItemViewType(int position) {
        return (position == getItemCount() - 1) ? VIEW_TYPE_SHOW_MORE : VIEW_TYPE_ITEM;
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.category_sec_image);
            textView = itemView.findViewById(R.id.category_sec_title);
        }

        void bind(ProductCategoryModel item) {
            Glide.with(itemView.getContext()).load("https://cdn-icons-png.flaticon.com/512/3733/3733209.png").into(imageView);
            textView.setText(item.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(itemView.getContext(), "category", Toast.LENGTH_SHORT).show();
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();

                    Fragment fragment = new StoreFragment();
                    FragmentTransaction mFragmentTransaction = ((MainActivity) itemView.getContext()).getSupportFragmentManager().beginTransaction();
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.replace(R.id.container, new StoreFragment()).addToBackStack("").commit();
                }
            });
        }
    }

    private static class ShowMoreViewHolder extends RecyclerView.ViewHolder {
        CardView showMoreLayout;

        ShowMoreViewHolder(@NonNull View itemView) {
            super(itemView);
            showMoreLayout = itemView.findViewById(R.id.showMore);
        }
    }
























   /* private final Context context;
    private final List<ProductCategoryModel> categoryModelList;

    // private static final int LIST_AD_DELTA = 11;
    private final int limit = 11;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_SHOW_MORE = 2;
    public CategorySecondAdapter(Context context, List<ProductCategoryModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;

    }

    @NonNull
    @Override
    public CategorySecondAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_ITEM) {
            View itemView = inflater.inflate(R.layout.category_img_sec_layout, parent, false);
            return new ViewHolder(itemView);
        } else {
            View showMoreView = inflater.inflate(R.layout.more_layout, parent, false);
            return new ShowMoreViewHolder(showMoreView);
        }




      //  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_img_sec_layout, parent, false);

       // return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategorySecondAdapter.ViewHolder holder, int position) {
     if (holder instanceof ItemViewHolder) {
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
     } else if (holder instanceof ShowMoreViewHolder) {
         Toast.makeText(context, "More", Toast.LENGTH_SHORT).show();

     }
    }

    @Override
    public int getItemCount() {
        return Math.min(categoryModelList.size(),8)+1;
     //   if (categoryModelList.size() >limit) {
     //       return limit;
            // }else {
            //     return categoryModelList.size();
     //   }
      //  return categoryModelList.size();
    }
    public int getItemViewType(int position){
        return (position == getItemCount() - 1) ? VIEW_TYPE_SHOW_MORE : VIEW_TYPE_ITEM;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
       CardView category_layout;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.category_sec_title);
            imageView = (ImageView)itemView.findViewById(R.id.category_sec_image);
            category_layout = itemView.findViewById(R.id.category_sec_layout);

        }
        void bind(ProductCategoryModel item){
            imageView.setImageResource(R.drawable.kurkure2);
            textView.setText(item.getTitle());
        }
    }
    private static class ShowMoreViewHolder extends RecyclerView.ViewHolder{
        CardView showMore;
        public ShowMoreViewHolder(@NonNull View itemView) {
            super(itemView);
            showMore = itemView.findViewById(R.id.showMore);
        }
    }*/
}
