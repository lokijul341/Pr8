package com.example.myapplication110.data.database.Entity;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication110.data.models.Drinks1;

@Entity(tableName = "drinks1_table")
public class Drinks1Entity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int photo;
    public Drinks1Entity(@NonNull String name, int photo) {
        this.name = name;
        this.photo = photo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @NonNull
    public String getName() {
        return this.name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }
    public void setPhoto(int photo) {
        this.photo = photo;
    }
    public Drinks1 toDr(){
        return new Drinks1(this.name,this.photo);
    }
}






