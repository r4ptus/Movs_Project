package com.example.movs_project.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Player implements Serializable {


    private String id;
    private String summonerName;
    private String rank;
    private String wlRatio;
    private Long championPoints;
    private int playerIcon;
    private int championIcon;
    private int spell1;
    private int spell2;
    private int primaryMastery;
    private int primaryMastery1;
    private int primaryMastery2;
    private int primaryMastery3;
    private int primaryMastery4;
    private int perk1;
    private int perk2;
    private int perk3;
    private int subMastery;
    private int subMastery1;
    private int subMastery2;
    private int queueType;
    private int championLvl;
    private String gameType;

    public String getId(){return id;}

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public int getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(int playerIcon) {
        this.playerIcon = playerIcon;
    }

    public int getChampionIcon() {
        return championIcon;
    }

    public void setChampionIcon(int championIcon) {
        this.championIcon = championIcon;
    }

    public int getSpell1() {
        return spell1;
    }

    public void setSpell1(int spell1) {
        this.spell1 = spell1;
    }

    public int getSpell2() {
        return spell2;
    }

    public void setSpell2(int spell2) {
        this.spell2 = spell2;
    }

    public int getPrimaryMastery() {
        return primaryMastery;
    }

    public void setPrimaryMastery(int primaryMastery) {
        this.primaryMastery = primaryMastery;
    }

    public int getSubMastery() {
        return subMastery;
    }

    public void setSubMastery(int subMastery) {
        this.subMastery = subMastery;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getWlRatio() {
        return wlRatio;
    }

    public void setWlRatio(String wlRatio) {
        this.wlRatio = wlRatio;
    }

    public Long getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(Long championPoints) {
        this.championPoints = championPoints;
    }

    public int getPrimaryMastery1() {
        return primaryMastery1;
    }

    public void setPrimaryMastery1(int primaryMastery1) {
        this.primaryMastery1 = primaryMastery1;
    }

    public int getPrimaryMastery2() {
        return primaryMastery2;
    }

    public void setPrimaryMastery2(int primaryMastery2) {
        this.primaryMastery2 = primaryMastery2;
    }

    public int getPrimaryMastery3() {
        return primaryMastery3;
    }

    public void setPrimaryMastery3(int primaryMastery3) {
        this.primaryMastery3 = primaryMastery3;
    }

    public int getSubMastery1() {
        return subMastery1;
    }

    public void setSubMastery1(int subMastery1) {
        this.subMastery1 = subMastery1;
    }

    public int getSubMastery2() {
        return subMastery2;
    }

    public void setSubMastery2(int subMastery2) {
        this.subMastery2 = subMastery2;
    }

    public int getPrimaryMastery4() {
        return primaryMastery4;
    }

    public void setPrimaryMastery4(int primaryMastery4) {
        this.primaryMastery4 = primaryMastery4;
    }

    public int getPerk1() {
        return perk1;
    }

    public void setPerk1(int perk1) {
        this.perk1 = perk1;
    }

    public int getPerk2() {
        return perk2;
    }

    public void setPerk2(int perk2) {
        this.perk2 = perk2;
    }

    public int getPerk3() {
        return perk3;
    }

    public void setPerk3(int perk3) {
        this.perk3 = perk3;
    }

    public int getQueueType(){return queueType;}

    public int getChampionLvl() {
        return championLvl;
    }

    public void setChampionLvl(int championLvl) {
        this.championLvl = championLvl;
    }

    public String getGameType() {
        return gameType;
    }

    public Player(String id, String name, int playerIcon)
    {
        this.id = id;
        summonerName = name;
        this.playerIcon = playerIcon;
    }

    public Player(String id,String summonerName, String rank, String wlRatio, Long championPoints, int playerIcon, int championIcon, int spell1, int spell2, int primaryMastery, int primaryMastery1, int primaryMastery2, int primaryMastery3, int primaryMastery4, int perk1, int perk2, int perk3, int subMastery, int subMastery1, int subMastery2,int queueType,String gameType) {
        this.id = id;
        this.summonerName = summonerName;
        this.rank = rank;
        this.wlRatio = wlRatio;
        this.championPoints = championPoints;
        this.playerIcon = playerIcon;
        this.championIcon = championIcon;
        this.spell1 = spell1;
        this.spell2 = spell2;
        this.primaryMastery = primaryMastery;
        this.primaryMastery1 = primaryMastery1;
        this.primaryMastery2 = primaryMastery2;
        this.primaryMastery3 = primaryMastery3;
        this.primaryMastery4 = primaryMastery4;
        this.perk1 = perk1;
        this.perk2 = perk2;
        this.perk3 = perk3;
        this.subMastery = subMastery;
        this.subMastery1 = subMastery1;
        this.subMastery2 = subMastery2;
        this.queueType = queueType;
        this.gameType = gameType;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", summonerName='" + summonerName + '\'' +
                ", rank='" + rank + '\'' +
                ", wlRatio='" + wlRatio + '\'' +
                ", championPoints=" + championPoints +
                ", playerIcon=" + playerIcon +
                ", championIcon=" + championIcon +
                ", spell1=" + spell1 +
                ", spell2=" + spell2 +
                ", primaryMastery=" + primaryMastery +
                ", primaryMastery1=" + primaryMastery1 +
                ", primaryMastery2=" + primaryMastery2 +
                ", primaryMastery3=" + primaryMastery3 +
                ", primaryMastery4=" + primaryMastery4 +
                ", perk1=" + perk1 +
                ", perk2=" + perk2 +
                ", perk3=" + perk3 +
                ", subMastery=" + subMastery +
                ", subMastery1=" + subMastery1 +
                ", subMastery2=" + subMastery2 +
                '}';
    }
}
