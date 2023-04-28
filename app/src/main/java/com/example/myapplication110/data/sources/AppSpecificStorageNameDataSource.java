package com.example.myapplication110.data.sources;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppSpecificStorageNameDataSource {
    private File app_specific_storage_file;

    public AppSpecificStorageNameDataSource(Context context) {
        File app_specific_directory = context.getFilesDir();
        app_specific_storage_file = new File(app_specific_directory, "user_names1.txt");
    }

    public void addNameAppSpecific(String dr){
        try {
            FileWriter writer = new FileWriter(app_specific_storage_file);
            writer.write(dr);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
