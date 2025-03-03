package com.example.e_transport.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_transport.Adapter.MyAdapter;
import com.example.e_transport.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    Integer[] Img={R.drawable.vehicleone,R.drawable.vehicletwo,R.drawable.vehiclethree, R.drawable.vehiclefour,R.drawable.vehiclefive,R.drawable.vehiclesix,
            R.drawable.newthirteen,R.drawable.newforteen,R.drawable.neweleven,R.drawable.newten};
    GoogleSignInClient mGoogleSignInClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        RecyclerView rv=(RecyclerView) view.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),2);
        rv.setLayoutManager(gridLayoutManager);
        MyAdapter adapter=new MyAdapter(addVehicle(),addPrice(),addDescription(),Img);
        rv.setAdapter(adapter);

        TextView Uname=view.findViewById(R.id.UsernameofGoogle);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);
        GoogleSignInAccount acct=GoogleSignIn.getLastSignedInAccount(getContext());
        if(acct!=null)
        {
            String personName=acct.getDisplayName();
            Uname.setText(personName);
        }
        return view;
    }

    public ArrayList<String> addVehicle(){
        ArrayList<String> vehicles=new ArrayList<>();
        vehicles.add("Cyber Truck");
        vehicles.add("Heavy Truck");
        vehicles.add("16 Wheeler");
        vehicles.add("Ultra Truck");
        vehicles.add("Mega Truck");
        vehicles.add("Tractor");
        vehicles.add("Tata LPT 3723");
        vehicles.add("Eicher Pro  Checkeout now");
        vehicles.add("Tata LPT 3723");
        vehicles.add("Eicher Pro 6000");
        return vehicles;
    }

    public ArrayList<String> addPrice(){
        ArrayList<String> price=new ArrayList<>();
        price.add("20");
        price.add("50");
        price.add("30");
        price.add("60");
        price.add("50");
        price.add("10");
        price.add("15");
        price.add("16");
        price.add("15");
        price.add("16");
        return price;

    }

    public ArrayList<String> addDescription(){
        ArrayList<String> description=new ArrayList<>();
        description.add("Weight Capacity : 100 Kg \n\nVehicle Fuel Type : Petrol \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : Yes");
        description.add("Weight Capacity : 200 Kg \n\nVehicle Fuel Type : Diesel \n\n \nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : No");
        description.add("Weight Capacity : 300 Kg \n\nVehicle Fuel Type : Diesel \n\n \nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : Yes");
        description.add("Weight Capacity : 400 Kg \n\nVehicle Fuel Type : EV \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : No");
        description.add("Weight Capacity : 450 Kg \n\nVehicle Fuel Type : Diesel \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : Yes");
        description.add("Weight Capacity : 500 Kg \n\nVehicle Fuel Type : Petrol \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : No");
        description.add("Weight Capacity : 550 Kg \n\nVehicle Fuel Type : Petrol \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : Yes");
        description.add("Weight Capacity : 600 Kg \n\nVehicle Fuel Type : Ev \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : No");
        description.add("Weight Capacity : 650 Kg \n\nVehicle Fuel Type : Ev \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : Yes");
        description.add("Weight Capacity : 700 Kg \n\nVehicle Fuel Type : Diesel \n\nHeight : 10ft \n\nWidth : 15ft \n\nVehicle with Roof : No");

        return description;
    }
}