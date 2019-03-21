package com.example.movs_project.Model.SpectatorApi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Perks {

    @SerializedName("perkStyle")
    @Expose
    public int perkStyle;
    @SerializedName("perkIds")
    @Expose
    public List<Integer> perkIds = null;
    @SerializedName("perkSubStyle")
    @Expose
    public int perkSubStyle;

    @Override
    public String toString() {
        return "Perks{" +
                "perkStyle=" + perkStyle +
                ", perkIds=" + perkIds +
                ", perkSubStyle=" + perkSubStyle +
                '}';
    }
}
