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

import com.example.myapplication110.data.models.Drinks2;
import com.example.myapplication110.ui.adapters.MyCustomListAdapter;
import com.example.myapplication110.R;
import com.example.myapplication110.databinding.Drinks2ListBinding;
import com.example.myapplication110.ui.viewmodels.Drinks2ListViewModel;

public class Drinks2ListFragment extends Fragment {
    RecyclerView recyclerView;
    MyCustomListAdapter myCustomListAdapter;
    Drinks2ListBinding binding;
    Drinks2ListViewModel drinks2ListViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drinks2ListViewModel = new ViewModelProvider(this).get(Drinks2ListViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = Drinks2ListBinding.inflate(inflater, container, false);
        myCustomListAdapter = new MyCustomListAdapter();// создание адаптера
        Bundle args = getArguments();
        if (args != null && args.containsKey("RESULT_OK_NAME") && args.containsKey("RESULT_OK_IMG")&& args.containsKey("RESULT_OK_AUTHOR")) {
            Drinks2 drink = new Drinks2(args.getString("RESULT_OK_NAME"), args.getString("RESULT_OK_AUTHOR"),args.getInt("RESULT_OK_IMG"));
            drinks2ListViewModel.insert(drink);
        }
        if (args != null && args.containsKey("Rating"))
        {
            Toast.makeText(getContext(), "Вы оценили напиток на "+getArguments().getFloat("Rating"), Toast.LENGTH_SHORT).show();
        }

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_drinks2_list_fragment_to_profile_fragment);
            }
        });
        binding.button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_drinks2_list_fragment_to_new_drinks2_fragment);
            }
        });
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myCustomListAdapter);// установка адаптера
        drinks2ListViewModel.getAllDrinks().observe(getViewLifecycleOwner(), drinks2List ->
                myCustomListAdapter.updateDrinks(drinks2List));
    }
}
