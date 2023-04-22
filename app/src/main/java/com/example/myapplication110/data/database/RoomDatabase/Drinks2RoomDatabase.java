package com.example.myapplication110.data.database.RoomDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication110.R;
import com.example.myapplication110.data.database.Entity.Drinks2Entity;
import com.example.myapplication110.data.database.dao.Drinks2Dao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Drinks2Entity.class}, version = 1, exportSchema = false)
public abstract class Drinks2RoomDatabase extends RoomDatabase {
    public abstract Drinks2Dao drinks2Dao();
    private static volatile Drinks2RoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static Drinks2RoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Drinks2RoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Drinks2RoomDatabase.class, "drinks2_database")
                            .addCallback(sRoomDatabaseCallback).build();}}
        }
        return INSTANCE;
    }

    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                Drinks2Dao dao = INSTANCE.drinks2Dao();
                dao.deleteAll();
                Drinks2Entity drink = new Drinks2Entity("Вода","500 мл",R.drawable.water);
                dao.insert(drink);
                drink = new Drinks2Entity("Молоко","250 мл",R.drawable.milk);
                dao.insert(drink);
                drink = new Drinks2Entity("Зеленый чай","300 мл",R.drawable.greentea);
                dao.insert(drink);
                drink = new Drinks2Entity("Кокосовая вода","500 мл",R.drawable.cocowater);
                dao.insert(drink);
                drink = new Drinks2Entity("Газированная вода","300 мл",R.drawable.gaswater);
                dao.insert(drink);
                drink = new Drinks2Entity("Йогурт","250 мл",R.drawable.yogurt);
                dao.insert(drink);
            });
        }
    };
}