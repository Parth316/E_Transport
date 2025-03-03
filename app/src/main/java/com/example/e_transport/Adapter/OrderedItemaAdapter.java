package com.example.e_transport.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_transport.R;

import java.util.ArrayList;

public class OrderedItemaAdapter extends RecyclerView.Adapter<OrderedItemaAdapter.ViewHolder> {
    View view1;
    ArrayList<String> theName;
//    String theName;
//    ArrayList<String> theName=null;
    public OrderedItemaAdapter(ArrayList<String> theName) {
        this.theName = theName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view1= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartlayout,parent,false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTxt1().setText(theName.get(position));
    }

    @Override
    public int getItemCount() {
        return theName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt1;

        public TextView getTxt1() {
            return txt1;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1=itemView.findViewById(R.id.hamaraname);
        }
    }
}