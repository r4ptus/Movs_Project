package com.example.movs_project.Model.SummonerApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SummonerApiData {

    @SerializedName("profileIconId")
    @Expose
    public int profileIconId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("puuid")
    @Expose
    public String puuid;
    @SerializedName("summonerLevel")
    @Expose
    public int summonerLevel;
    @SerializedName("accountId")
    @Expose
    public String accountId;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("revisionDate")
    @Expose
    public long revisionDate;

    @Override
    public String toString() {
        return "SummonerApiData{" +
                "profileIconId=" + profileIconId +
                ", name='" + name + '\'' +
                ", puuid='" + puuid + '\'' +
                ", summonerLevel=" + summonerLevel +
                ", accountId='" + accountId + '\'' +
                ", id='" + id + '\'' +
                ", revisionDate=" + revisionDate +
                '}';
    }
}