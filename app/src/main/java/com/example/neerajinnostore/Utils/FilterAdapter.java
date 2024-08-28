package com.example.neerajinnostore.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neerajinnostore.R;
import com.example.neerajinnostore.RecyclerAdapter;

import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {
    private final Context context;
    private final List<FilterModel> filterModels;

    public FilterAdapter(Context context, List<FilterModel> filterModels) {
        this.context = context;
        this.filterModels = filterModels;
    }

    @NonNull
    @Override
    public FilterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAdapter.ViewHolder holder, int position) {
        FilterModel filterModel = filterModels.get(position);
        holder.filter_text.setText(filterModel.FilterName);

    }

    @Override
    public int getItemCount() {
        return filterModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        Button filter_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            filter_text = itemView.findViewById(R.id.filter_text);
        }
    }
}
