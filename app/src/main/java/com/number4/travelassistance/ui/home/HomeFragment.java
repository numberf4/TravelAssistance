package com.number4.travelassistance.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.number4.travelassistance.R;
import com.number4.travelassistance.adapter.CityAdapter;
import com.number4.travelassistance.adapter.HomeAdapter;
import com.number4.travelassistance.model.city;
import com.number4.travelassistance.uiti.Checkconnect;
import com.number4.travelassistance.uiti.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class HomeFragment extends Fragment implements HomeAdapter.Callback {
    HomeAdapter homeAdapter;
    RecyclerView recyclerViewofcity;
    ArrayList<city> ArraylistCity;
    CityAdapter cityAdapter;
    int id = 0;
    String nameCity = "";
    String imgCity = "";
    String location = "";
    public HomeFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ArraylistCity = new ArrayList<>();
        cityAdapter =  new CityAdapter(ArraylistCity, getContext().getApplicationContext());
        recyclerViewofcity =root.findViewById(R.id.recyclerViewListCity);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerViewofcity.setLayoutManager(layoutManager);
        recyclerViewofcity.setAdapter(cityAdapter);
        getCity();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    @Override
    public void onClickItem(int position) {

    }


    private void getCity() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext().getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongdancity, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null){
                    for (int i = 0; i < response.length(); i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            nameCity = jsonObject.getString("namecity");
                            imgCity = jsonObject.getString("imagecity");
                            location = jsonObject.getString("location");
                            ArraylistCity.add(new city(id,nameCity,imgCity,location));
                            cityAdapter.notifyDataSetChanged();
                            Log.e(TAG, "onResponse: ",ArraylistCity.get(i) );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Checkconnect.ShowToast_Short(getContext().getApplicationContext(),error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }




//    private void anhXa() throws IOException {

//
//    }



}