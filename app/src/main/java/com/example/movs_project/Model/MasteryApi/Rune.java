package com.example.movs_project.Model.MasteryApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rune {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("key")
    @Expose
    public String key;
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("shortDesc")
    @Expose
    public String shortDesc;
    @SerializedName("longDesc")
    @Expose
    public String longDesc;

    @Override
    public String toString() {
        return "Rune{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }
}
