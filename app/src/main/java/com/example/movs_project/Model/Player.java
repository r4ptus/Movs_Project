package com.example.movs_project.Model;

import java.io.Serializable;

public class Player implements Serializable {

    private String summonerName;
    private String rank;
    private String wlRatio;
    private String championPoints;
    private String playerIcon;
    private String championIcon;
    private String spell1;
    private String spell2;
    private String primaryMastery;
    private String primaryMastery1;
    private String primaryMastery2;
    private String primaryMastery3;
    private String subMastery;
    private String subMastery1;
    private String subMastery2;

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(String playerIcon) {
        this.playerIcon = playerIcon;
    }

    public String getChampionIcon() {
        return championIcon;
    }

    public void setChampionIcon(String championIcon) {
        this.championIcon = championIcon;
    }

    public String getSpell1() {
        return spell1;
    }

    public void setSpell1(String spell1) {
        this.spell1 = spell1;
    }

    public String getSpell2() {
        return spell2;
    }

    public void setSpell2(String spell2) {
        this.spell2 = spell2;
    }

    public String getPrimaryMastery() {
        return primaryMastery;
    }

    public void setPrimaryMastery(String primaryMastery) {
        this.primaryMastery = primaryMastery;
    }

    public String getSubMastery() {
        return subMastery;
    }

    public void setSubMastery(String subMastery) {
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

    public String getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(String championPoints) {
        this.championPoints = championPoints;
    }

    public String getPrimaryMastery1() {
        return primaryMastery1;
    }

    public void setPrimaryMastery1(String primaryMastery1) {
        this.primaryMastery1 = primaryMastery1;
    }

    public String getPrimaryMastery2() {
        return primaryMastery2;
    }

    public void setPrimaryMastery2(String primaryMastery2) {
        this.primaryMastery2 = primaryMastery2;
    }

    public String getPrimaryMastery3() {
        return primaryMastery3;
    }

    public void setPrimaryMastery3(String primaryMastery3) {
        this.primaryMastery3 = primaryMastery3;
    }

    public String getSubMastery1() {
        return subMastery1;
    }

    public void setSubMastery1(String subMastery1) {
        this.subMastery1 = subMastery1;
    }

    public String getSubMastery2() {
        return subMastery2;
    }

    public void setSubMastery2(String subMastery2) {
        this.subMastery2 = subMastery2;
    }

    public Player(String summonerName, String playerIcon, String championIcon, String spell1, String spell2, String primaryMastery, String subMastery) {
        this.summonerName = summonerName;
        this.playerIcon = playerIcon;
        this.championIcon = championIcon;
        this.spell1 = spell1;
        this.spell2 = spell2;
        this.primaryMastery = primaryMastery;
        this.subMastery = subMastery;
    }

    @Override
    public String toString() {
        return "Player{" +
                "summonerName='" + summonerName + '\'' +
                ", rank='" + rank + '\'' +
                ", wlRatio='" + wlRatio + '\'' +
                ", championPoints='" + championPoints + '\'' +
                ", playerIcon='" + playerIcon + '\'' +
                ", championIcon='" + championIcon + '\'' +
                ", spell1='" + spell1 + '\'' +
                ", spell2='" + spell2 + '\'' +
                ", primaryMastery='" + primaryMastery + '\'' +
                ", primaryMastery1='" + primaryMastery1 + '\'' +
                ", primaryMastery2='" + primaryMastery2 + '\'' +
                ", primaryMastery3='" + primaryMastery3 + '\'' +
                ", subMastery='" + subMastery + '\'' +
                ", subMastery1='" + subMastery1 + '\'' +
                ", subMastery2='" + subMastery2 + '\'' +
                '}';
    }
}
