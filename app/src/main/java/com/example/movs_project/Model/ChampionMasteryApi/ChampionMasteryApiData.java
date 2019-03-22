package com.example.movs_project.Model.ChampionMasteryApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChampionMasteryApiData {

    @SerializedName("championLevel")
    @Expose
    public int championLevel;
    @SerializedName("chestGranted")
    @Expose
    public boolean chestGranted;
    @SerializedName("championPoints")
    @Expose
    public int championPoints;
    @SerializedName("championPointsSinceLastLevel")
    @Expose
    public int championPointsSinceLastLevel;
    @SerializedName("championPointsUntilNextLevel")
    @Expose
    public int championPointsUntilNextLevel;
    @SerializedName("summonerId")
    @Expose
    public String summonerId;
    @SerializedName("tokensEarned")
    @Expose
    public int tokensEarned;
    @SerializedName("championId")
    @Expose
    public int championId;
    @SerializedName("lastPlayTime")
    @Expose
    public long lastPlayTime;

    @Override
    public String toString() {
        return "ChampionMasteryApiData{" +
                "championLevel=" + championLevel +
                ", chestGranted=" + chestGranted +
                ", championPoints=" + championPoints +
                ", championPointsSinceLastLevel=" + championPointsSinceLastLevel +
                ", championPointsUntilNextLevel=" + championPointsUntilNextLevel +
                ", summonerId='" + summonerId + '\'' +
                ", tokensEarned=" + tokensEarned +
                ", championId=" + championId +
                ", lastPlayTime=" + lastPlayTime +
                '}';
    }
}
