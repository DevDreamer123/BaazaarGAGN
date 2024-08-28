package com.example.neerajinnostore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neerajinnostore.Utils.CartListModel;
import com.example.neerajinnostore.Utils.ProductModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDetailAdaper extends RecyclerView.Adapter<RecyclerDetailAdaper.viewHolder> {
    private final Context context;
    private final List<ProductModel> courseModelArrayList;
    private AppCompatActivity mActivity;
    // Constructor
    public RecyclerDetailAdaper(Context context, List<ProductModel> courseModelArrayList,AppCompatActivity activity ) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
        this.mActivity = activity;

    }

    @NonNull
    @Override
    public RecyclerDetailAdaper.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_detail_layout, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerDetailAdaper.viewHolder holder, int position) {
        ProductModel model = courseModelArrayList.get(position);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
        layoutParams.topMargin = 5;
        holder.itemView.setLayoutParams(layoutParams);
        holder.images.setImageResource(R.drawable.kurkure2);
        holder.txtdeatil.setText(model.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //showPopup(model);
                showBottomSheetDialog();
                //showPopup(holder.add);
            }
        });
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item add", Toast.LENGTH_SHORT).show();

                showBottomSheetDialog();
                //showPopup(holder.add);
            }
        });

    }

    @Override
    public int getItemCount() {
        return courseModelArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView txtdeatil;
        Button add;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            images = (ImageView) itemView.findViewById(R.id.imgdetail);
            txtdeatil = (TextView) itemView.findViewById(R.id.txtdetail);
            add = (Button) itemView.findViewById(R.id.add_item);

        }
    }

   private void showBottomSheetDialog(){
        MyBottomSheetDialogFragment bottomSheetDialogFragment = new MyBottomSheetDialogFragment();
        bottomSheetDialogFragment.show(mActivity.getSupportFragmentManager(),bottomSheetDialogFragment.getTag());
    }

}

