package com.mobilelesson.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList idList, jobList, createTimeList, createrList;

    CustomAdapter(Context context,
                  ArrayList idList,
                  ArrayList jobList,
                  ArrayList createTimeList,
                  ArrayList createrList){
        this.context = context;
        this.idList = idList;
        this.jobList = jobList;
        this.createTimeList = createTimeList;
        this.createrList = createrList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.idListObject.setText(String.valueOf(idList.get(position)));
        holder.jobListObject.setText(String.valueOf(jobList.get(position)));
        holder.createTimeListObject.setText(String.valueOf(createTimeList.get(position)));
        holder.createrListObject.setText(String.valueOf(createrList.get(position)));

    }

    @Override
    public int getItemCount() {
        return idList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idListObject, jobListObject, createTimeListObject, createrListObject;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idListObject = itemView.findViewById(R.id.idTxtView);
            jobListObject = itemView.findViewById(R.id.jobTxtView);
            createTimeListObject = itemView.findViewById(R.id.createTimeTxtView);
            createrListObject = itemView.findViewById(R.id.createrTxtView);
        }
    }
}
