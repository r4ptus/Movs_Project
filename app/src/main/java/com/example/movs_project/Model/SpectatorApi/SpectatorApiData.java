package com.example.movs_project.Model.SpectatorApi;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpectatorApiData {

    @SerializedName("gameId")
    @Expose
    public long gameId;
    @SerializedName("gameStartTime")
    @Expose
    public long gameStartTime;
    @SerializedName("platformId")
    @Expose
    public String platformId;
    @SerializedName("gameMode")
    @Expose
    public String gameMode;
    @SerializedName("mapId")
    @Expose
    public int mapId;
    @SerializedName("gameType")
    @Expose
    public String gameType;
    @SerializedName("gameQueueConfigId")
    @Expose
    public int gameQueueConfigId;
    @SerializedName("observers")
    @Expose
    public Observers observers;
    @SerializedName("participants")
    @Expose
    public List<Participant> participants = new ArrayList<>();
    @SerializedName("gameLength")
    @Expose
    public long gameLength;
    @SerializedName("bannedChampions")
    @Expose
    public List<BannedChampion> bannedChampions = new ArrayList<>();

    @Override
    public String toString() {
        return "SpectatorApiData{" +
                "gameId=" + gameId +
                ", gameStartTime=" + gameStartTime +
                ", platformId='" + platformId + '\'' +
                ", gameMode='" + gameMode + '\'' +
                ", mapId=" + mapId +
                ", gameType='" + gameType + '\'' +
                ", gameQueueConfigId=" + gameQueueConfigId +
                ", observers=" + observers +
                ", participants=" + participants +
                ", gameLength=" + gameLength +
                ", bannedChampions=" + bannedChampions +
                '}';
    }
}
