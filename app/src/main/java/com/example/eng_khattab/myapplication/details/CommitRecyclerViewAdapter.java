package com.example.eng_khattab.myapplication.details;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.eng_khattab.myapplication.R;
import java.util.ArrayList;

public class CommitRecyclerViewAdapter extends RecyclerView.Adapter<CommitRecyclerViewAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<Commit> itemList;

    CommitRecyclerViewAdapter(int listItemLayout) {
        this.listItemLayout = listItemLayout;
    }

    public void addList( ArrayList<Commit> itemList){
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItemLayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        TextView item = viewHolder.message;
        item.setText(itemList.get(i).getUrl());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView message;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.itemName);
        }
    }

}