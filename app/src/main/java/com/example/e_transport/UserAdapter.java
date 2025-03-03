package com.example.e_transport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    Context context;
    ArrayList<User> list;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView MobileNumber,SelectedDate,Weight,SelectedVehicle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MobileNumber=itemView.findViewById(R.id.mobilenumberinadminpanel);
            SelectedDate=itemView.findViewById(R.id.dateinadminpanel);
            Weight=itemView.findViewById(R.id.weightinadminpanel);
            SelectedVehicle=itemView.findViewById(R.id.selectedvehicleinadminpanel);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.userslayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.SelectedVehicle.setText(user.getSelectedVehicle());
        holder.Weight.setText(user.getWeight());
        holder.MobileNumber.setText(user.getMobileno());
        holder.SelectedDate.setText(user.getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
