package com.number4.travelassistance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.number4.travelassistance.R;
import com.number4.travelassistance.model.city;
import com.number4.travelassistance.model.citydetails;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CityDetailsAdapter extends BaseAdapter {

    ArrayList<citydetails> ArraylistCityDetails;
    Context context;

    public CityDetailsAdapter(ArrayList<citydetails> arraylistCityDetails, Context context) {
        ArraylistCityDetails = arraylistCityDetails;
        this.context = context;
    }


    @Override
    public int getCount() {
        return ArraylistCityDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return ArraylistCityDetails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class viewHoder{
        TextView txtNameCityDetails;
        ImageView imgCityDetails;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CityDetailsAdapter.viewHoder viewHoder = null;
        if (view == null){
            viewHoder = new viewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_location,null);
            viewHoder.txtNameCityDetails = (TextView) view.findViewById(R.id.txtNameOfLocation);
            viewHoder.imgCityDetails = (ImageView) view.findViewById(R.id.imgLocation);

            view.setTag(viewHoder);
        } else {
            viewHoder = (CityDetailsAdapter.viewHoder) view.getTag();

        }
        citydetails citydetails = (citydetails) getItem(i);
        viewHoder.txtNameCityDetails.setText(citydetails.getNamelocation());
        Picasso.with(context).load(citydetails. getImagelocation())
                .placeholder(R.drawable.unnamed)
                .error(R.drawable.error_2)
                .into(viewHoder.imgCityDetails);


        return view;
    }
}
