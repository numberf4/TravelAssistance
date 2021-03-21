package com.number4.travelassistance.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.number4.travelassistance.R;
import com.number4.travelassistance.activity.CityActivity;
import com.number4.travelassistance.model.city;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ItemHolder> {
    public final static String key="Thông tin city";
    ArrayList<city> ArraylistCity;
    Context context;

    public CityAdapter(ArrayList<city> arraylistCity, Context context) {
        this.ArraylistCity = arraylistCity;
        this.context = context;
    }



    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_city,null);
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        city city = ArraylistCity.get(position);
        holder.txtNameCity.setText(city.getNameCity());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {
                    Intent intent = new Intent(view.getContext(), CityActivity.class);
                    intent.putExtra(key, ArraylistCity.get(position));
                    view.getContext().startActivity(intent);
                }
            }
        });

        Picasso.with(context).load(city.getImageCity())
                .placeholder(R.drawable.unnamed)
                .error(R.drawable.error_2)
                .into(holder.imgCity);


    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return ArraylistCity.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imgCity;
        public TextView txtNameCity;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        private ItemClickListener itemClickListener;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imgCity = (ImageView) itemView.findViewById(R.id.imgCity);
            txtNameCity = (TextView) itemView.findViewById(R.id.txtNameOfCity);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition(), false);
        }
    }
    public interface ItemClickListener {
        void onClick(View view, int position,boolean isLongClick);
    }

}
