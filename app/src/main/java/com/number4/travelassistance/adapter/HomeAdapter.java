package com.number4.travelassistance.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.number4.travelassistance.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_city, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public HomeAdapter(){

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View view;

        ViewHolder(@NonNull View view) {
            super(view);
            this.view = view;
        }

        View getView() {
            return view;
        }
    }
    public interface Callback {
        void onClickItem(int position);
    }
}
