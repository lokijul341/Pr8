package com.example.myapplication110.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication110.data.models.Drinks1;
import com.example.myapplication110.ui.adapters.MyCustomDrinks1ListAdapter;
import com.example.myapplication110.R;

import com.example.myapplication110.databinding.Drinks1ListBinding;
import com.example.myapplication110.ui.viewmodels.Drinks1ListViewModel;

public class Drinks1ListFragment extends Fragment{

        RecyclerView recyclerView;
        MyCustomDrinks1ListAdapter myCustomListAdapter;
        Drinks1ListBinding binding;
        Drinks1ListViewModel drinks1ListViewModel;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            drinks1ListViewModel = new ViewModelProvider(this).get(Drinks1ListViewModel.class);
        }

        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            binding = Drinks1ListBinding.inflate(inflater, container, false);
            myCustomListAdapter = new MyCustomDrinks1ListAdapter();// создание адаптера
            Bundle args = getArguments();
            if (args != null && args.containsKey("RESULT_OK_NAME") && args.containsKey("RESULT_OK_IMG")) {
                Drinks1 drink = new Drinks1(args.getString("RESULT_OK_NAME"), args.getInt("RESULT_OK_IMG"));
                drinks1ListViewModel.insert(drink);
            }
            if (args != null && args.containsKey("Favorite"))
            {
                Toast.makeText(getContext(), "Вы добавили " +args.getString("Favorite")+" в избранное", Toast.LENGTH_SHORT).show();
            }
            //args.clear();
            return binding.getRoot();
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            binding.button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.action_drinks1_list_fragment_to_profile_fragment);
                }
            });
            binding.button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.action_drinks1_list_fragment_to_new_drinks1_fragment);
                }
            });

            recyclerView = view.findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(myCustomListAdapter);// установка адаптера
            drinks1ListViewModel.getAllDrinks().observe(getViewLifecycleOwner(), drinkList ->
                    myCustomListAdapter.updateDrinks(drinkList));
        }
}


