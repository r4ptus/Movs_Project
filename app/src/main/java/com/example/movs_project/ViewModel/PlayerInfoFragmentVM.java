package com.example.movs_project.ViewModel;

import android.util.Log;

import com.example.movs_project.Model.ChampionMasteryApi.ChampionMasteryApiData;
import com.example.movs_project.Model.ChampionScoreApi.ChampionMasteryScoreApiData;
import com.example.movs_project.Model.GetDataService;
import com.example.movs_project.Model.LeagueApi.LeagueApiData;
import com.example.movs_project.Model.Player;
import com.example.movs_project.Model.RetrofitClientInstance;
import com.example.movs_project.Model.SummonerApi.SummonerApiData;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerInfoFragmentVM extends ViewModel {

    public MutableLiveData<Player> player = new MutableLiveData<>();

    private static String TAG = PlayerInfoFragmentVM.class.getSimpleName();

    enum QueueType{
        SOLO_Q,
        RANKED_FLEX,
        RANKED_3,
        DRAFT,
        BLIND,
        BLIND_3,
        Default,
        ARAM;

        public static QueueType fromInteger(int x) {
            switch(x) {
                case 420:
                    return SOLO_Q;
                case 440:
                    return RANKED_FLEX;
                case 470:
                    return RANKED_3;
                case 400:
                    return DRAFT;
                case 430:
                    return BLIND;
                case 460:
                    return BLIND_3;
                case 450:
                    return ARAM;
                    default:
                        return Default;

            }
        }
    }

    public void setPlayer(Player player) {
        this.player.setValue(player);
    }

    GetDataService service = RetrofitClientInstance.getRetrofitInstanceLOL().create(GetDataService.class);

    public void getChampionPoints(){
        Call<ChampionMasteryApiData> call = service.getChampionMastery(player.getValue().getId(),player.getValue().getChampionIcon());
        call.enqueue(new Callback<ChampionMasteryApiData>() {
            @Override
            public void onResponse(Call<ChampionMasteryApiData> call, Response<ChampionMasteryApiData> response) {
                if(response.isSuccessful()){
                    Player tmp = player.getValue();
                    tmp.setChampionPoints((long)response.body().championPoints);
                    tmp.setChampionLvl(response.body().championLevel);
                    player.setValue(tmp);
                    Log.d(TAG,"loaded ChampionMasterypoints");
                }
            }

            @Override
            public void onFailure(Call<ChampionMasteryApiData> call, Throwable t) {

            }
        });

    }
    public void getRankedStats(){
        Call<List<LeagueApiData>> call = service.getLeague(player.getValue().getId());
        call.enqueue(new Callback<List<LeagueApiData>>() {
            @Override
            public void onResponse(Call<List<LeagueApiData>> call, Response<List<LeagueApiData>> response) {
                if(response.isSuccessful()){
                    QueueType queueType = QueueType.fromInteger(player.getValue().getQueueType());
                    switch (queueType){
                        case SOLO_Q:
                            for (LeagueApiData l: response.body()) {
                                if(l.queueType.matches("RANKED_SOLO_5x5")){
                                    Player tmp = player.getValue();
                                    tmp.setRank(l.tier + " " + l.rank);
                                    tmp.setWlRatio("W: "+l.wins+" L: "+l.losses);
                                    player.setValue(tmp);
                                }
                            }
                            break;
                        case RANKED_FLEX:
                            for (LeagueApiData l: response.body()) {
                                if(l.queueType.matches("RANKED_FLEX_SR")){
                                    Player tmp = player.getValue();
                                    tmp.setRank(l.tier + " " + l.rank);
                                    tmp.setWlRatio("W: "+l.wins+" L: "+l.losses);
                                    player.setValue(tmp);
                                }
                            }
                            break;
                        case RANKED_3:
                            for (LeagueApiData l: response.body()) {
                                if(l.queueType.matches("RANKED_FLEX_TT")){
                                    Player tmp = player.getValue();
                                    tmp.setRank(l.tier + " " + l.rank);
                                    tmp.setWlRatio("W: "+l.wins+" L: "+l.losses);
                                    player.setValue(tmp);
                                }
                            }
                            break;
                        case DRAFT:
                            for (LeagueApiData l: response.body()) {
                                if(l.queueType.matches("RANKED_SOLO_5x5")){
                                    Player tmp = player.getValue();
                                    tmp.setRank(l.tier + " " + l.rank);
                                    tmp.setWlRatio("W: "+l.wins+" L: "+l.losses);
                                    player.setValue(tmp);
                                }
                            }
                            break;
                        case BLIND:
                            for (LeagueApiData l: response.body()) {
                                if(l.queueType.matches("RANKED_SOLO_5x5")){
                                    Player tmp = player.getValue();
                                    tmp.setRank(l.tier + " " + l.rank);
                                    tmp.setWlRatio("W: "+l.wins+" L: "+l.losses);
                                    player.setValue(tmp);
                                }
                            }
                            break;
                        case BLIND_3:
                            for (LeagueApiData l: response.body()) {
                                if(l.queueType.matches("RANKED_FLEX_TT")){
                                    Player tmp = player.getValue();
                                    tmp.setRank(l.tier + " " + l.rank);
                                    tmp.setWlRatio("W: "+l.wins+" L: "+l.losses);
                                    player.setValue(tmp);
                                }
                            }
                            break;
                        case ARAM:
                            for (LeagueApiData l: response.body()) {
                                if(l.queueType.matches("RANKED_SOLO_5x5")){
                                    Player tmp = player.getValue();
                                    tmp.setRank(l.tier + " " + l.rank);
                                    tmp.setWlRatio("W: "+l.wins+" L: "+l.losses);
                                    player.setValue(tmp);
                                }
                            }
                            break;
                            default:
                                player.getValue().setRank("Unranked");
                                player.getValue().setWlRatio("");
                                break;
                    }


                    Log.d(TAG,"loaded LeagueData");
                }
            }

            @Override
            public void onFailure(Call<List<LeagueApiData>> call, Throwable t) {

            }
        });

    }
}
