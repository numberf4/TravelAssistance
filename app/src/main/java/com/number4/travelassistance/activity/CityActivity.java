package com.number4.travelassistance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.number4.travelassistance.R;
import com.number4.travelassistance.adapter.CityAdapter;
import com.number4.travelassistance.adapter.CityDetailsAdapter;
import com.number4.travelassistance.model.citydetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import  com.number4.travelassistance.model.city;
import com.number4.travelassistance.uiti.Checkconnect;
import com.number4.travelassistance.uiti.Server;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class CityActivity extends AppCompatActivity {
    ListView listViewLocationofCity;
    ArrayList<citydetails> citydetailsArrayList;
    CityDetailsAdapter cityDetailsAdapter;
    TextView txtNameofCity;
    ImageView imgofCiTy;
    int id = 0;
    String NameofCity = "";
    String ImgofCity = "";
    String Location = "";

    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        anhxa();
        city city = (city) getIntent().getSerializableExtra(CityAdapter.key);
        id = city.getId();
        NameofCity = city.getNameCity();
        ImgofCity = city.getImageCity();
        //Location = city.getLocation();
        txtNameofCity.setText(NameofCity);
        Picasso.with(getApplicationContext()).load(ImgofCity)
                .placeholder(R.drawable.unnamed)
                .error(R.drawable.error_2)
                .into(imgofCiTy);
        GetInformation(page);
        ClicklocationOfCity();

    }

    private void ClicklocationOfCity() {
        listViewLocationofCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),locationsActivity.class);
                intent.putExtra("locationOfCity",citydetailsArrayList.get(i));
                startActivity(intent);
            }
        });
    }

    private void GetInformation(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.duongdanlocations + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int Id = 0;
                String NameLocation = "";
                String ImgLocation = "";
                String DetailLocation = "";
                String MakerLocation = "";
                int IdCity = 0;

                if (response != null){
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Id = jsonObject.getInt("id");
                            NameLocation = jsonObject.getString("namelocation");
                            ImgLocation = jsonObject.getString("imagelocation");
                            DetailLocation = jsonObject.getString("detail");
                            MakerLocation = jsonObject.getString("marker");
                            IdCity = jsonObject.getInt("idcity");
                            citydetailsArrayList.add(new citydetails(Id,NameLocation,ImgLocation,DetailLocation,MakerLocation,IdCity));
                            cityDetailsAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Checkconnect.ShowToast_Short(getApplicationContext(),error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("idcity", String.valueOf(id));
                return param;
            }
        };
        requestQueue.add(stringRequest);

    }

    private void anhxa() {
        txtNameofCity = findViewById(R.id.txtNameOfCity);
        imgofCiTy = findViewById(R.id.imgCityDetail);

        listViewLocationofCity = findViewById(R.id.lisviewlocationofcity);
        citydetailsArrayList = new ArrayList<>();
        cityDetailsAdapter = new CityDetailsAdapter(citydetailsArrayList, getApplicationContext());
        listViewLocationofCity.setAdapter(cityDetailsAdapter);
    }


}