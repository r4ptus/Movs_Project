package com.example.movs_project.Model.LeagueApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MiniSeries {

    @SerializedName("wins")
    @Expose
    public int wins;
    @SerializedName("losses")
    @Expose
    public int losses;
    @SerializedName("target")
    @Expose
    public int target;
    @SerializedName("progress")
    @Expose
    public String progress;

    @Override
    public String toString() {
        return "MiniSeries{" +
                "wins=" + wins +
                ", losses=" + losses +
                ", target=" + target +
                ", progress='" + progress + '\'' +
                '}';
    }
}
