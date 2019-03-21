package com.example.movs_project.Model.SpectatorApi;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participant {

    @SerializedName("profileIconId")
    @Expose
    public int profileIconId;
    @SerializedName("championId")
    @Expose
    public int championId;
    @SerializedName("summonerName")
    @Expose
    public String summonerName;
    @SerializedName("gameCustomizationObjects")
    @Expose
    public List<Object> gameCustomizationObjects = new ArrayList<>();
    @SerializedName("bot")
    @Expose
    public boolean bot;
    @SerializedName("perks")
    @Expose
    public Perks perks;
    @SerializedName("spell2Id")
    @Expose
    public int spell2Id;
    @SerializedName("teamId")
    @Expose
    public int teamId;
    @SerializedName("spell1Id")
    @Expose
    public int spell1Id;
    @SerializedName("summonerId")
    @Expose
    public String summonerId;

    @Override
    public String toString() {
        return "Participant{" +
                "profileIconId=" + profileIconId +
                ", championId=" + championId +
                ", summonerName='" + summonerName + '\'' +
                ", gameCustomizationObjects=" + gameCustomizationObjects +
                ", bot=" + bot +
                ", perks=" + perks +
                ", spell2Id=" + spell2Id +
                ", teamId=" + teamId +
                ", spell1Id=" + spell1Id +
                ", summonerId='" + summonerId + '\'' +
                '}';
    }
}
