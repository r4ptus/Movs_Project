package com.example.movs_project.Model;

import android.text.format.Time;

import com.example.movs_project.Model.ChampionsApi.Champion;
import com.example.movs_project.Model.MasteryApi.Rune;
import com.example.movs_project.R;

import java.util.GregorianCalendar;
import java.util.HashMap;

public class Maps {

    public static HashMap<Integer,String> perks = new HashMap<>() ;
    public static HashMap<Integer,String> perksDesc = new HashMap<>() ;
    public static HashMap<Integer,String> spells = new HashMap<>() ;
    public static HashMap<Integer, Champion> champions = new HashMap<>() ;
    public static HashMap<Integer,String> masteries = new HashMap<>();
    public static HashMap<String,Integer> tiers = new HashMap<>();
    public static HashMap<Integer, Rune> test = new HashMap<>();
    public static String PERKS_URL ="http://ddragon.leagueoflegends.com/cdn/img/perk-images/StatMods/";
    public static String SPELLS_URL = "http://ddragon.leagueoflegends.com/cdn/";//9.6.1/img/spell/";
    public static String CHAMPION_URL = "http://ddragon.leagueoflegends.com/cdn/";//9.6.1/img/champion/";
    public static String MASTERY_URL = "http://ddragon.leagueoflegends.com/cdn/img/";
    public static String BASE_URL = "http://ddragon.leagueoflegends.com/cdn/";//9.6.1/data/en_US/";
    public static String VERSION;
    public static int CALLS;

    public Maps(){
        initMaps();
    }

    private void initMaps(){
        //Summoner Spells
        /*spells.put(21,"SummonerBarrier.png");
        spells.put(1,"SummonerBoost.png");
        spells.put(14,"SummonerDot.png");
        spells.put(3,"SummonerExhaust.png");
        spells.put(4,"SummonerFlash.png");
        spells.put(6,"SummonerHaste.png");
        spells.put(7,"SummonerHeal.png");
        spells.put(13,"SummonerMana.png");
        spells.put(11,"SummonerSmite.png");
        spells.put(32,"SummonerSnowball.png");
        spells.put(12,"SummonerTeleport.png");*/

        //Perks
        perks.put(5008,"StatModsAdaptiveForceIcon.png");
        perks.put(5003,"StatModsMagicResIcon.png");
        perks.put(5002,"StatModsArmorIcon.png");
        perks.put(5001,"StatModsHealthScalingIcon.png");
        perks.put(5007,"StatModsCDRScalingIcon.png");
        perks.put(5005,"StatModsAttackSpeedIcon.png");

        //PerksDesc
        perksDesc.put(5008,"+9 Adaptive Force");
        perksDesc.put(5003,"+8 Magic Resist");
        perksDesc.put(5002,"+6 Armor");
        perksDesc.put(5001,"+15-90 Health");
        perksDesc.put(5007,"+1-10% CDR");
        perksDesc.put(5005,"+10% Attack Speed");

        //tiers
        tiers.put("IRON", R.drawable.emblem_iron);
        tiers.put("BRONZE", R.drawable.emblem_bronze);
        tiers.put("SILVER", R.drawable.emblem_silver);
        tiers.put("GOLD", R.drawable.emblem_gold);
        tiers.put("PLATINUM", R.drawable.emblem_platinum);
        tiers.put("DIAMOND", R.drawable.emblem_diamond);
        tiers.put("MASTER", R.drawable.emblem_master);
        tiers.put("GRANDMASTER", R.drawable.emblem_grandmaster);
        tiers.put("CHALLENGER",R.drawable.emblem_challenger);


    }

}
