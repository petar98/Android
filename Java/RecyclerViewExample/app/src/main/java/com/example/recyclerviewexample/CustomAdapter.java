package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private String[] mDataset;

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CustomViewHolder(TextView tv) {
            super(tv);
            textView = tv;
        }
    }

    public CustomAdapter(String[] dataset) {
        mDataset = dataset;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.custom_list_item, parent, false);

        return new CustomViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
