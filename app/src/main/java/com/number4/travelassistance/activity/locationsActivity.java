package com.number4.travelassistance.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.number4.travelassistance.R;
import com.number4.travelassistance.model.citydetails;
import com.squareup.picasso.Picasso;

public class locationsActivity extends AppCompatActivity {

    TextView txtNameLocationOfCity, txtDetailLocation;
    ImageView imgLocationOfcCity;
    int id = 0;
    String NameLocationOfCity = "";
    String ImgLocationOfCity = "";
    String DetailLocationOfCity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        Anhxa();
        citydetails citydetails = (citydetails) getIntent().getSerializableExtra("locationOfCity");
        id = citydetails.getId();
        NameLocationOfCity = citydetails.getNamelocation();
        ImgLocationOfCity = citydetails.getImagelocation();
        DetailLocationOfCity = citydetails.getDetail();

        txtNameLocationOfCity.setText(NameLocationOfCity);
        txtDetailLocation.setText(DetailLocationOfCity);
        Picasso.with(getApplicationContext()).load(ImgLocationOfCity)
                .placeholder(R.drawable.unnamed)
                .error(R.drawable.error_2)
                .into(imgLocationOfcCity);

    }

    private void Anhxa() {
        txtNameLocationOfCity = findViewById(R.id.txtNameOfLocationDetails);
        txtDetailLocation = findViewById(R.id.txtDetailLocationOfCity);
        imgLocationOfcCity = findViewById(R.id.imgLocationDetails);
    }
}