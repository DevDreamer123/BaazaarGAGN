package com.example.neerajinnostore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private final Context context;
    private final List<ItemModel> categoryModelList;


    public GridAdapter(Context context, List<ItemModel> categoryModelList) {
        this.context = context;
        this.categoryModelList = categoryModelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridimage, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ItemModel model = categoryModelList.get(position);
        holder.title.setText(model.getTitle());
        Glide.with(context).load(model.getImage()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*AppCompatActivity activity = (AppCompatActivity) view.getContext();

                Fragment fragment = new StoreFragment();
                FragmentTransaction mFragmentTransaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();

                mFragmentTransaction.replace(R.id.container, new StoreFragment()).addToBackStack("").commit();*/

            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        LinearLayout category_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            img = (ImageView)itemView.findViewById(R.id.img);
            category_layout = itemView.findViewById(R.id.category_layout);
        }
    }






























   /* private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public GridAdapter(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        return web.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.gridimage, null);
            TextView textView = (TextView) grid.findViewById(R.id.title);
            ImageView imageView = (ImageView)grid.findViewById(R.id.img);
            textView.setText(web[i]);
            imageView.setImageResource(Imageid[i]);
        } else {
            grid = (View) view;
        }

        return grid;
    }*/
}
