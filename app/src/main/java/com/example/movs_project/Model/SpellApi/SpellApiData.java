package com.example.movs_project.Model.SpellApi;

import com.example.movs_project.Model.ChampionsApi.Champion;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpellApiData {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("version")
    @Expose
    public String version;
    @SerializedName("data")
    @Expose
    public Map<String,Spell> data;

    public List<Spell> getSpells(){
        if(data != null){
            return new ArrayList<>(data.values());
        }
        return null; // you can set return new ArrayList<>(); to avoid null exception
    }
}
