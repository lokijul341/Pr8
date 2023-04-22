package com.example.myapplication110.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication110.data.database.Entity.Drinks2Entity;
import com.example.myapplication110.data.models.Drinks2;
import com.example.myapplication110.data.repository.Drinks2Repository;


import java.util.List;

public class Drinks2ListViewModel extends AndroidViewModel {
    private Drinks2Repository mRepository;

    private final LiveData<List<Drinks2>> mAllDrinks2;

    public Drinks2ListViewModel(Application application) {
        super(application);
        mRepository = new Drinks2Repository(application);
        mAllDrinks2 = mRepository.getAllDrinks2();
    }

    public LiveData<List<Drinks2>> getAllDrinks() { return mAllDrinks2; }

    public void insert(Drinks2 book) { mRepository.insert(new Drinks2Entity(book.getName(), book.getName(), book.getImage()));
    }
}

