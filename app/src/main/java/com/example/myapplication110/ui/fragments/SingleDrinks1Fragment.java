package com.example.myapplication110.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication110.R;
import com.example.myapplication110.databinding.Drinks1InfoBinding;


public class SingleDrinks1Fragment extends Fragment {
    Drinks1InfoBinding binding;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String name = getArguments().getString("Name");
            int image = getArguments().getInt("Photo");
            binding.textView15.setText(name);
            binding.imageView3.setImageResource(image);
        }
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("Favorite", String.valueOf(binding.textView15.getText()));
                Navigation.findNavController(view)
                        .navigate(R.id.action_single_drinks1_fragment_to_drinks1_list_fragment, bundle);
            }
        });


    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = Drinks1InfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
