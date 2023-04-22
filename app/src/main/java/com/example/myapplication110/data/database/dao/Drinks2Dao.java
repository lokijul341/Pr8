package com.example.myapplication110.data.database.dao;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication110.data.database.Entity.Drinks2Entity;

@Dao
public interface Drinks2Dao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Drinks2Entity book);
    @Query("DELETE FROM drinks2_table")
    void deleteAll();
    @Query("SELECT * FROM drinks2_table ORDER BY id")
    LiveData<List<Drinks2Entity>> getAllDrinks2();
}
