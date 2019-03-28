package com.example.movs_project.Model.SpellApi;

import com.example.movs_project.Model.ChampionsApi.Image;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Spell {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("tooltip")
    @Expose
    public String tooltip;
    @SerializedName("maxrank")
    @Expose
    public int maxrank;
    @SerializedName("cooldownBurn")
    @Expose
    public String cooldownBurn;
    @SerializedName("costBurn")
    @Expose
    public String costBurn;
    @SerializedName("key")
    @Expose
    public int key;
    @SerializedName("summonerLevel")
    @Expose
    public int summonerLevel;
    @SerializedName("modes")
    @Expose
    public List<String> modes = new ArrayList<>();
    @SerializedName("costType")
    @Expose
    public String costType;
    @SerializedName("maxammo")
    @Expose
    public String maxammo;
    @SerializedName("rangeBurn")
    @Expose
    public String rangeBurn;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("resource")
    @Expose
    public String resource;

    @Override
    public String toString() {
        return "Spell{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tooltip='" + tooltip + '\'' +
                ", maxrank=" + maxrank +
                ", cooldownBurn='" + cooldownBurn + '\'' +
                ", costBurn='" + costBurn + '\'' +
                ", key='" + key + '\'' +
                ", summonerLevel=" + summonerLevel +
                ", modes=" + modes +
                ", costType='" + costType + '\'' +
                ", maxammo='" + maxammo + '\'' +
                ", rangeBurn='" + rangeBurn + '\'' +
                ", image=" + image +
                ", resource='" + resource + '\'' +
                '}';
    }
}
