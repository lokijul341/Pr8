package com.example.myapplication110.data.sources;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesStorageDataSource {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesStorageDataSource(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("drink", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void addNameSharedPreferences(String dr) {
        editor.putString("drink", dr);
        editor.apply();
    }

    public String getUserName(String dr) {
        return sharedPreferences.getString(dr, "drink");
    }
}
