package com.example.movs_project.Model.ChampionsApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Champion {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("key")
    @Expose
    public int key;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("image")
    @Expose
    public Image image;

    @Override
    public String toString() {
        return "Champion{" +
                "id='" + id + '\'' +
                ", key=" + key +
                ", name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
