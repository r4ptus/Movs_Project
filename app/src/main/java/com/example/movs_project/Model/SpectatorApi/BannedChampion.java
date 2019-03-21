package com.example.movs_project.Model.SpectatorApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BannedChampion {

    @SerializedName("teamId")
    @Expose
    public int teamId;
    @SerializedName("championId")
    @Expose
    public int championId;
    @SerializedName("pickTurn")
    @Expose
    public int pickTurn;

    @Override
    public String toString() {
        return "BannedChampion{" +
                "teamId=" + teamId +
                ", championId=" + championId +
                ", pickTurn=" + pickTurn +
                '}';
    }
}
