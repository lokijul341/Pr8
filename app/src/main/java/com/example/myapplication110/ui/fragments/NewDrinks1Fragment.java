package com.example.myapplication110.ui.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication110.R;
import com.example.myapplication110.databinding.NewDrinks1FragmentBinding;

public class NewDrinks1Fragment extends Fragment {
    private NewDrinks1FragmentBinding binding;
    private EditText mEditWordView;

    public NewDrinks1Fragment() {
        super(R.layout.new_drinks1_fragment);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = NewDrinks1FragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonUpload.setOnClickListener(v -> {
            String drinks1Name = binding.editTextDrinks1.getText().toString();
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(drinks1Name)) {
                binding.editTextDrinks1.setError(null);
                bundle.putString("RESULT_OK_NAME", drinks1Name);
                bundle.putInt("RESULT_OK_IMG", R.drawable.placeholder);
                Navigation.findNavController(view).navigate(R.id.action_new_drinks1_fragment_to_drinks1_list_fragment, bundle);
            } else {
                binding.editTextDrinks1.setError("Пустая строка!");
            }
        });
    }
}
