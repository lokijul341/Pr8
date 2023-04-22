package com.example.myapplication110.ui.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication110.R;
import com.example.myapplication110.data.models.Drinks2;

import java.util.ArrayList;
import java.util.List;

public class MyCustomListAdapter extends RecyclerView.Adapter<MyCustomListAdapter.MyViewHolder> {

    private List<Drinks2> drinks2;
    public MyCustomListAdapter() {
        this.drinks2 =  new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Drinks2 drink = drinks2.get(position);
        holder.name.setText(drink.getName());
        holder.volume.setText(drink.getVolume());
        holder.imageView.setImageResource(drink.getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Name", drink.getName());
                bundle.putString("Drinks1", drink.getVolume());
                bundle.putInt("Image", drink.getImage());
                Navigation.findNavController(view).navigate(R.id.action_drinks2_list_fragment_to_single_drinks2_fragment, bundle);
            }
        });

    }

    @Override
    public int getItemCount() {
        return drinks2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView volume;
        public TextView name;
        public ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_drink1);
            imageView = itemView.findViewById(R.id.item_image);
            volume = itemView.findViewById(R.id.item_ml);
        }
    }

    public void updateDrinks(List<Drinks2> drinks2) {
        this.drinks2.clear();
        this.drinks2 = drinks2;
        notifyDataSetChanged();
    }
}

