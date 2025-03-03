//package com.example.e_transport;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.ColorInt;
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.core.content.ContextCompat;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
//    public static final String MSG11="myadapter.orderedvehcle";
//    String[] Vdetails;
//    ArrayList<String> Vname;
//    Integer[] Vimg;
//    Context context;
//    ArrayList<String> Checked=new ArrayList<>();
//    QuntityListener quntityListener=null;
//    int Selecteditem=0;
//    public MyAdapter(ArrayList<String> vname, String[] vdetails, Integer[] vimg)
//    {
//        this.Vname=vname;
//        this.Vdetails=vdetails;
//        this.Vimg=vimg;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        TextView Vehiclename;
//        TextView Vehicledetails;
//        ImageView Vehicleimg;
//        CardView cardView;
//        Button continuebutton;
//        CheckBox checkBox;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//             Vehiclename=itemView.findViewById(R.id.vname);
//             Vehicledetails=itemView.findViewById(R.id.vdetail);
//             Vehicleimg=itemView.findViewById(R.id.vimg);
//             cardView=itemView.findViewById(R.id.layoutcardview);
//             continuebutton=itemView.findViewById(R.id.continuebtninhomepage2);
//             checkBox=itemView.findViewById(R.id.vehicleselection);
//        }
//        public TextView getName()
//        {
//            return Vehiclename;
//        }
//        public TextView getDetails()
//        {
//            return Vehicledetails;
//        }
//        public ImageView getImage()
//        {
//            return Vehicleimg;
//        }
//        public CheckBox getCheckBox()
//        {
//            return checkBox;
//        }
//    }
//
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vehiclescrollview,parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.getCheckBox().setText(Vname.get(position));
//        holder.getName().setText(Vname.get(position));
//        holder.getDetails().setText(Vdetails[position]);
//        holder.getImage().setImageResource(Vimg[position]);
//
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//
//            String str=Vname.get(position);
//            @Override
//            public void onClick(View v) {
//                Selecteditem+=1;
//                if(Selecteditem==1) {
//                    holder.cardView.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.gray));
//
//                    Intent intent = new Intent(v.getContext(), ordereditem.class);
//                    intent.putExtra(MSG11, str);
////                v.getContext().startActivity(intent);
//                    Toast.makeText(v.getContext(), "" + str + " Selected", Toast.LENGTH_SHORT).show();
//                    notifyDataSetChanged();
//                }
//                else {
//                    if (Selecteditem>=2)
//                    {
//                        Selecteditem-=1;
//                        notify();
//                    }
//                }
//                notifyDataSetChanged();
//
//
//            }
//            });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return Vname.size();
//    }
//
//}
package com.example.e_transport.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_transport.Activity.Main.ActivityDetail;
import com.example.e_transport.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    ArrayList<String> vehicleName;
    ArrayList<String> vehiclePrice;
    ArrayList<String> vehicleDescription;
    Integer[] vehicleImages;
    View v;
    Context context;
    public MyAdapter(ArrayList<String> vehicleName, ArrayList<String> vehiclePrice,ArrayList<String> vehicleDescription,Integer[] vehicleImages) {
        this.vehicleName = vehicleName;
        this.vehiclePrice=vehiclePrice;
        this.vehicleDescription=vehicleDescription;
        this.vehicleImages = vehicleImages;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView vName,vPrice,vDesc;
        ImageView vImg;
        Button order;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vName=itemView.findViewById(R.id.vehicleName);
            vImg=itemView.findViewById(R.id.vehicleImage);
            order=itemView.findViewById(R.id.order);
            vDesc=itemView.findViewById(R.id.vehicledescription);
            vPrice=itemView.findViewById(R.id.vehiclePrice);
        }

        public TextView getvName() {
            return vName;
        }
        public ImageView getvImg() {
            return vImg;
        }
        public Button getOrder(){ return order; }
        public TextView getvPrice() {
            return vPrice;
        }
        public TextView getvDescription() { return vDesc; }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutmain,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.getvName().setText(vehicleName.get(position));
        holder.getvPrice().setText(vehiclePrice.get(position));
        holder.getvImg().setImageResource(vehicleImages[position]);
        holder.getvDescription().setText(vehicleDescription.get(position));
        holder.getOrder().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ActivityDetail.class);
                Integer image=vehicleImages[position];
                intent.putExtra("VehicleDescription",vehicleDescription.get(position));
                intent.putExtra("VehiclePrice",vehiclePrice.get(position));
                intent.putExtra("VehicleName",vehicleName.get(position));
                intent.putExtra("VehicleImage",image);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicleName.size();
    }

}
