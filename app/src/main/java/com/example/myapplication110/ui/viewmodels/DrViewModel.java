package com.example.myapplication110.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

public class DrViewModel extends AndroidViewModel {
    private DrViewModel mRepository;
    public DrViewModel (Application application) {
        super(application);
        mRepository = new DrViewModel(application);
    }
    public static void addNameAppSpecific(String user_name){
        mRepository.addNameAppSpecific(user_name);
    }

    public static void addNameExternalStorage(String user_name){
        mRepository.addNameExternalStorage(user_name);
    }

    public static void addNameSharedPreferences(String user_name) {
        mRepository.addNameSharedPreferences(user_name);
    }

    public String getUserName(String user_name) {
        return mRepository.getUserName(user_name);
    }
}
