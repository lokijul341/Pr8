package com.example.myapplication110.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication110.R;
import com.example.myapplication110.databinding.NewDrinks2FragmentBinding;

public class NewDrinks2Fragment extends Fragment {
    private NewDrinks2FragmentBinding binding;

    public NewDrinks2Fragment() {
        super(R.layout.new_drinks2_fragment);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = NewDrinks2FragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonUpload.setOnClickListener(v -> {
            String drinks2Name = binding.editTextName.getText().toString();
            String drinks2Value = binding.editTextDrinks1.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(drinks2Name) && !TextUtils.isEmpty(drinks2Value)) {
                binding.editTextName.setError(null);
                bundle.putString("RESULT_OK_NAME", drinks2Name);
                bundle.putString("RESULT_OK_AUTHOR", drinks2Value);
                bundle.putInt("RESULT_OK_IMG", R.drawable.placeholder);
                Navigation.findNavController(view).navigate(R.id.action_new_drinks2_fragment_to_drinks2_list_fragment, bundle);
            }
            else if (TextUtils.isEmpty(drinks2Name)) {
                binding.editTextName.setError("Пустая строка!");
            }
            else if (TextUtils.isEmpty(drinks2Value))
            {
                binding.editTextDrinks1.setError("Пустая строка!");
            }
            else
            {
                binding.editTextName.setError("Пустая строка!");
                binding.editTextDrinks1.setError("Пустая строка!");
            }
        });
    }
}

