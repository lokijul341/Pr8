package com.example.myapplication110.data.database.Entity;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication110.data.models.Drinks2;

@Entity(tableName = "drinks2_table")
public class Drinks2Entity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String volume;
    private int img;
    public Drinks2Entity(@NonNull String name, String volume, int img) {
        this.name = name;
        this.volume = volume;
        this.img = img;
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
    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }
    public String getVolume() {
        return volume;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public Drinks2 toDr(){
        return new Drinks2(this.name,this.volume,this.img);
    }
}





