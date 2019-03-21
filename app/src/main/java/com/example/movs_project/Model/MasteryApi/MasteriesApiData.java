package com.example.movs_project.Model.MasteryApi;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MasteriesApiData {

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
    @SerializedName("slots")
    @Expose
    public List<Slot> slots = new ArrayList<>();

    @Override
    public String toString() {
        return "MasteriesApiData{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", slots=" + slots +
                '}';
    }
}
