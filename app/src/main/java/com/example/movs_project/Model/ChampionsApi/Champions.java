package com.example.movs_project.Model.ChampionsApi;

import android.renderscript.Sampler;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Champions {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("format")
    @Expose
    public String format;
    @SerializedName("version")
    @Expose
    public String version;
    @SerializedName("data")
    @Expose
    public Map<String,Champion> data;

    public List<Champion> getChampions(){
        if(data != null){
            return new ArrayList<>(data.values());
        }
        return null; // you can set return new ArrayList<>(); to avoid null exception
    }
}
