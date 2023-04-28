package com.example.myapplication110.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.myapplication110.data.database.Entity.Drinks1Entity;
import com.example.myapplication110.data.database.RoomDatabase.Drinks1RoomDatabase;
import com.example.myapplication110.data.database.dao.Drinks1Dao;
import com.example.myapplication110.data.models.Drinks1;

import java.util.List;
import java.util.stream.Collectors;

public class Drinks1Repository {
    private final Drinks1Dao mDrinks1Dao;
    private final LiveData<List<Drinks1>> mAllDrinks1;

    private final Context context;

    Drinks1RoomDatabase roomDatabase;
    public Drinks1Repository(Context applicationContext) {

        context = applicationContext;
        roomDatabase = Drinks1RoomDatabase.getDatabase(context);
        mDrinks1Dao = Drinks1RoomDatabase.getDatabase(context).drinks1Dao();
        mAllDrinks1 = Transformations.map(mDrinks1Dao.getAllDrinks1(), entities -> entities.stream()
                .map(Drinks1Entity::toDr).collect(Collectors.toList()));
    }
    public LiveData<List<Drinks1>> getAllDrinks1() {
        return mAllDrinks1;
    }

    public void insert(Drinks1Entity drinks1) {
        Drinks1RoomDatabase.databaseWriteExecutor.execute(() -> {
            mDrinks1Dao.insert(drinks1);
        });
    }
}
