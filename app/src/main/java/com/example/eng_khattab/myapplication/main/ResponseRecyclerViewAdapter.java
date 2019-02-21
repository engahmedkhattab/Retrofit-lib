package com.example.eng_khattab.myapplication.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.eng_khattab.myapplication.details.DetailsActivity;
import com.example.eng_khattab.myapplication.R;
import com.example.eng_khattab.myapplication.main.pojo.Response;
import java.util.ArrayList;

public class ResponseRecyclerViewAdapter extends RecyclerView.Adapter<ResponseRecyclerViewAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<Response> itemList;

    ResponseRecyclerViewAdapter(int listItemLayout) {
        this.listItemLayout = listItemLayout;
    }

    public void addList(ArrayList<Response> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(listItemLayout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        TextView item = viewHolder.itemName;
        item.setText(itemList.get(i).getName());


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                intent.putExtra("response", itemList.get(i));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (itemList == null)
            return 0;
        else
            return itemList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
        }
    }

}