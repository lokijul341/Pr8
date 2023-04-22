package com.example.myapplication110.data.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.myapplication110.data.database.RoomDatabase.Drinks2RoomDatabase;
import com.example.myapplication110.data.database.dao.Drinks2Dao;
import com.example.myapplication110.data.models.Drinks2;
import com.example.myapplication110.data.database.Entity.Drinks2Entity;

import java.util.List;
import java.util.stream.Collectors;

public class Drinks2Repository {
    private final Drinks2Dao mDrinks2Dao;
    private final LiveData<List<Drinks2>> mAllDrinks2;

    private final Context context;

    Drinks2RoomDatabase roomDatabase;
    public Drinks2Repository(Context applicationContext) {
        context = applicationContext;
        roomDatabase = Drinks2RoomDatabase.getDatabase(context);
        mDrinks2Dao = Drinks2RoomDatabase.getDatabase(context).drinks2Dao();
        mAllDrinks2 = Transformations.map(mDrinks2Dao.getAllDrinks2(), entities -> entities.stream()
                .map(Drinks2Entity::toDr).collect(Collectors.toList()));
    }
    public LiveData<List<Drinks2>> getAllDrinks2() {
        return mAllDrinks2;
    }

    public void insert(Drinks2Entity drinks2) {
        Drinks2RoomDatabase.databaseWriteExecutor.execute(() -> {
            mDrinks2Dao.insert(drinks2);
        });
    }
}

