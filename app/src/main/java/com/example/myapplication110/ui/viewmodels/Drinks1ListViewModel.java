package com.example.myapplication110.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication110.data.models.Drinks1;
import com.example.myapplication110.data.database.Entity.Drinks1Entity;
import com.example.myapplication110.data.repository.Drinks1Repository;


import java.util.List;

public class Drinks1ListViewModel extends AndroidViewModel {
    private Drinks1Repository mRepository;

    private final LiveData<List<Drinks1>> mAllDrinks1;

    public Drinks1ListViewModel(Application application) {
        super(application);
        mRepository = new Drinks1Repository(application);
        mAllDrinks1 = mRepository.getAllDrinks1();
    }

    public LiveData<List<Drinks1>> getAllDrinks() { return mAllDrinks1; }

    public void insert(Drinks1 drink) { mRepository.insert(new Drinks1Entity(drink.getName(), drink.getPhoto())); }
}

