package com.example.e_transport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public static final String MSG11="myadapter.orderedvehcle";
    String[] Vdetails;
    ArrayList<String> Vname;
    Integer[] Vimg;
    Context context;
    ArrayList<String> Checked=new ArrayList<>();
    QuntityListener quntityListener;

    public MyAdapter(ArrayList<String> vname,String[] vdetails,Integer[] vimg,QuntityListener quntityListener)
    {
        this.quntityListener=quntityListener;
        this.Vname=vname;
        this.Vdetails=vdetails;
        this.Vimg=vimg;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Vehiclename;
        TextView Vehicledetails;
        ImageView Vehicleimg;
        CardView cardView;
        Button continuebutton;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             Vehiclename=itemView.findViewById(R.id.vname);
             Vehicledetails=itemView.findViewById(R.id.vdetail);
             Vehicleimg=itemView.findViewById(R.id.vimg);
             cardView=itemView.findViewById(R.id.layoutcardview);
             continuebutton=itemView.findViewById(R.id.continuebtninhomepage2);
             checkBox=itemView.findViewById(R.id.vehicleselection);
        }
        public TextView getName()
        {
            return Vehiclename;
        }
        public TextView getDetails()
        {
            return Vehicledetails;
        }
        public ImageView getImage()
        {
            return Vehicleimg;
        }
        public CheckBox getCheckBox()
        {
            return checkBox;
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vehiclescrollview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getCheckBox().setText(Vname.get(position));
        holder.getName().setText(Vname.get(position));
        holder.getDetails().setText(Vdetails[position]);
        holder.getImage().setImageResource(Vimg[position]);

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(Vname!=null&&Vname.size()>0)
                {
                    Checked.add(Vname.get(position));
                  //  notifyDataSetChanged();

                }
                else {
                    if(Vname.size()>1) {
                        Checked.remove(Vname.get(position));
                        notifyItemRemoved(position);
                    }
                    }
                quntityListener.onQuantityChangeListener(Checked,Vname.get(position));

            }

        });

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//
//            String str=Vname.get(position);
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(v.getContext(),ordereditem.class);
//                intent.putExtra(str,MSG11);
//                v.getContext().startActivity(intent);
//                Toast.makeText(v.getContext(), ""+str+" Selected", Toast.LENGTH_SHORT).show();
//            }
//            });

    }

    @Override
    public int getItemCount() {
        return Vname.size();
    }

}
