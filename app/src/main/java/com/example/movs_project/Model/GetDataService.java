package com.example.movs_project.Model;

import com.example.movs_project.Model.ChampionMasteryApi.ChampionMasteryApiData;
import com.example.movs_project.Model.ChampionScoreApi.ChampionMasteryScoreApiData;
import com.example.movs_project.Model.ChampionsApi.Champions;
import com.example.movs_project.Model.LeagueApi.LeagueApiData;
import com.example.movs_project.Model.MasteryApi.MasteriesApiData;
import com.example.movs_project.Model.SpectatorApi.SpectatorApiData;
import com.example.movs_project.Model.SummonerApi.SummonerApiData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GetDataService {

    @GET("lol/summoner/v4/summoners/by-name/{player}")
    Call<SummonerApiData> getSummoner(@Path("player") String summoner);

    @GET("lol/champion-mastery/v4/scores/by-summoner/{encryptedSummonerId}")
    Call<ChampionMasteryScoreApiData> getChampionScore(@Path("encryptedSummonerId") String id);

    @GET("lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}/by-champion/{championId}")
    Call<ChampionMasteryApiData> getChampionMastery(@Path("encryptedSummonerId") String summonerId, @Path("championId") int championId);

    @GET("lol/spectator/v4/active-games/by-summoner/{encryptedSummonerId}")
    Call<SpectatorApiData> getSpectator(@Path("encryptedSummonerId") String id);

    @GET("lol/league/v4/positions/by-summoner/{encryptedSummonerId}")
    Call<List<LeagueApiData>> getLeague(@Path("encryptedSummonerId") String id);

    @GET()
    Call<Champions> getChampions(@Url String s);

    @GET()
    Call<List<MasteriesApiData>> getMasteries(@Url String s);

}
