package com.example.myapplication110.data.database.RoomDatabase;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.example.myapplication110.R;

import com.example.myapplication110.data.database.Entity.Drinks1Entity;
import com.example.myapplication110.data.database.dao.Drinks1Dao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Drinks1Entity.class}, version = 1, exportSchema = false)
public abstract class Drinks1RoomDatabase extends RoomDatabase {
    public abstract Drinks1Dao drinks1Dao();
    private static volatile Drinks1RoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static Drinks1RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Drinks1RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    Drinks1RoomDatabase.class, "drinks1_database")
                            .addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }


    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                Drinks1Dao dao = INSTANCE.drinks1Dao();
                dao.deleteAll();
                Drinks1Entity drinks1 = new Drinks1Entity("Кофе",R.drawable.coffee);
                dao.insert(drinks1);
                drinks1 = new Drinks1Entity("Сок",R.drawable.juice);
                dao.insert(drinks1);
            });
        }
    };
}

