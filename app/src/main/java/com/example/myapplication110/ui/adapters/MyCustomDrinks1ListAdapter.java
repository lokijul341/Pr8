package com.example.myapplication110.ui.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication110.R;
import com.example.myapplication110.data.models.Drinks1;

import java.util.ArrayList;
import java.util.List;

public class MyCustomDrinks1ListAdapter extends RecyclerView.Adapter<MyCustomDrinks1ListAdapter.MyDrinks1ViewHolder> {
    private List<Drinks1> drinks1;
    public MyCustomDrinks1ListAdapter() {
        this.drinks1 =  new ArrayList<>();
    }


    public MyCustomDrinks1ListAdapter.MyDrinks1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.drinks1_list_item, parent, false);
        return new MyCustomDrinks1ListAdapter.MyDrinks1ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyDrinks1ViewHolder holder, int position) {
        Drinks1 drink = drinks1.get(position);
        holder.name.setText(drink.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Name",drink.getName());
                bundle.putInt("Photo", drink.getPhoto());
                Navigation.findNavController(view).navigate(R.id.action_drinks1_list_fragment_to_single_drinks1_fragment, bundle);
            }
        });

    }
    @Override
    public int getItemCount() {
        return drinks1.size();
    }

    public static class MyDrinks1ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyDrinks1ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView16);
        }
    }
    public void updateDrinks(List<Drinks1> drinks1) {
        this.drinks1.clear();
        this.drinks1 = drinks1;
        notifyDataSetChanged();
    }
}
