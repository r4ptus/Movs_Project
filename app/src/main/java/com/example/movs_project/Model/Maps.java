package com.example.movs_project.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Maps {

    public static HashMap<Integer,String> perks = new HashMap<>() ;
    public static HashMap<Integer,String> spells = new HashMap<>() ;
    public static HashMap<Integer,String> champions = new HashMap<>() ;
    public static HashMap<Integer,String> masteries = new HashMap<>();
    public static String PERKS_URL ="http://ddragon.leagueoflegends.com/cdn/img/perk-images/StatMods/StatMods/";
    public static String SPELLS_URL = "http://ddragon.leagueoflegends.com/cdn/9.6.1/img/spell/";
    public static String CHAMPION_URL = "http://ddragon.leagueoflegends.com/cdn/9.6.1/img/champion/";
    public static String MASTERY_URL = "http://ddragon.leagueoflegends.com/cdn/img/";

    public Maps(){
        initMaps();
    }

    private void initMaps(){
        //Summoner Spells
        spells.put(21,"SummonerBarrier.png");
        spells.put(1,"SummonerBoost.png");
        spells.put(14,"SummonerDot.png");
        spells.put(3,"SummonerExhaust.png");
        spells.put(4,"SummonerFlash.png");
        spells.put(6,"SummonerHaste.png");
        spells.put(7,"SummonerHeal.png");
        spells.put(13,"SummonerMana.png");
        spells.put(11,"SummonerSmite.png");
        spells.put(32,"SummonerSnowball.png");
        spells.put(12,"SummonerTeleport.png");

        //Perks
        perks.put(5008,"StatModsAdaptiveForceIcon.png");
        perks.put(5003,"StatModsMagicResIcon.png");
        perks.put(5002,"StatModsArmorIcon.png");
        perks.put(5001,"StatModsHealthScalingIcon.png");
        perks.put(5007,"StatModsCDRScalingIcon.png");
        perks.put(5005,"StatModsAttackSpeedIcon.png");

    }

}
