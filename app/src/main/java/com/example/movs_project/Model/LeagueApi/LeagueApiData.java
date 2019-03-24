package com.example.movs_project.Model.LeagueApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LeagueApiData {

    @SerializedName("tier")
    @Expose
    public String tier;
    @SerializedName("summonerName")
    @Expose
    public String summonerName;
    @SerializedName("hotStreak")
    @Expose
    public boolean hotStreak;
    @SerializedName("wins")
    @Expose
    public int wins;
    @SerializedName("veteran")
    @Expose
    public boolean veteran;
    @SerializedName("losses")
    @Expose
    public int losses;
    @SerializedName("rank")
    @Expose
    public String rank;
    @SerializedName("leagueName")
    @Expose
    public String leagueName;
    @SerializedName("inactive")
    @Expose
    public boolean inactive;
    @SerializedName("freshBlood")
    @Expose
    public boolean freshBlood;
    @SerializedName("position")
    @Expose
    public String position;
    @SerializedName("leagueId")
    @Expose
    public String leagueId;
    @SerializedName("queueType")
    @Expose
    public String queueType;
    @SerializedName("summonerId")
    @Expose
    public String summonerId;
    @SerializedName("leaguePoints")
    @Expose
    public int leaguePoints;
    @SerializedName("miniSeries")
    @Expose
    public MiniSeries miniSeries;

    public int tierImageID;

    public LeagueApiData() {
    }

    @Override
    public String toString() {
        return "LeagueApiDatum{" +
                "tier='" + tier + '\'' +
                ", summonerName='" + summonerName + '\'' +
                ", hotStreak=" + hotStreak +
                ", wins=" + wins +
                ", veteran=" + veteran +
                ", losses=" + losses +
                ", rank='" + rank + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", inactive=" + inactive +
                ", freshBlood=" + freshBlood +
                ", position='" + position + '\'' +
                ", leagueId='" + leagueId + '\'' +
                ", queueType='" + queueType + '\'' +
                ", summonerId='" + summonerId + '\'' +
                ", leaguePoints=" + leaguePoints +
                ", miniSeries=" + miniSeries +
                '}';
    }
}
