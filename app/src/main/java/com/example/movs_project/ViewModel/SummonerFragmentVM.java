package com.example.movs_project.ViewModel;

import android.util.Log;

import com.example.movs_project.Model.ChampionMasteryApi.ChampionMasteryApiData;
import com.example.movs_project.Model.ChampionScoreApi.ChampionMasteryScoreApiData;
import com.example.movs_project.Model.GetDataService;
import com.example.movs_project.Model.LeagueApi.LeagueApiData;
import com.example.movs_project.Model.Maps;
import com.example.movs_project.Model.Player;
import com.example.movs_project.Model.RetrofitClientInstance;
import com.example.movs_project.R;
import com.example.movs_project.View.SummonerFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SummonerFragmentVM extends ViewModel {

    private static final String TAG = SummonerFragment.class.getSimpleName();

    public MutableLiveData<Player> player = new MutableLiveData<>();
    public MutableLiveData<LeagueApiData> soloQ = new MutableLiveData<>();
    public MutableLiveData<LeagueApiData> flex5 = new MutableLiveData<>();
    public MutableLiveData<LeagueApiData> flex3 = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();
    public MutableLiveData<ChampionMasteryApiData> champion1 = new MutableLiveData<>();
    public MutableLiveData<ChampionMasteryApiData> champion2 = new MutableLiveData<>();
    public MutableLiveData<ChampionMasteryApiData> champion3 = new MutableLiveData<>();
    public MutableLiveData<Integer> score = new MutableLiveData<>();


    public void setPlayer(Player player) {
        this.player.setValue(player);
    }

    GetDataService service = RetrofitClientInstance.getRetrofitInstanceLOL().create(GetDataService.class);

    public void getRankedStats(){
        soloQ.setValue(new LeagueApiData());
        flex5.setValue(new LeagueApiData());
        flex3.setValue(new LeagueApiData());
        Call<List<LeagueApiData>> call = service.getLeague(player.getValue().getId());
        call.enqueue(new Callback<List<LeagueApiData>>() {
            @Override
            public void onResponse(Call<List<LeagueApiData>> call, Response<List<LeagueApiData>> response) {
                Maps.CALLS++;
                if(response.isSuccessful()){
                    for (LeagueApiData l:response.body()) {
                        switch (l.queueType){
                            case "RANKED_SOLO_5x5":
                                l.tierImageID = Maps.tiers.get(l.tier.toUpperCase());
                                soloQ.setValue(l);
                                break;
                            case "RANKED_FLEX_SR":
                                l.tierImageID = Maps.tiers.get(l.tier.toUpperCase());
                                flex5.setValue(l);
                                break;
                            case "RANKED_FLEX_TT":
                                l.tierImageID = Maps.tiers.get(l.tier.toUpperCase());
                                flex3.setValue(l);
                                break;
                        }
                    }
                    Log.d(TAG,"loaded LeagueData");
                }
                else {
                    errorMessage.setValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<LeagueApiData>> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
            }
        });

    }

    public void getChampionPoints(){
        Call<List<ChampionMasteryApiData>> call = service.getChampionMastarties(player.getValue().getId());
        call.enqueue(new Callback<List<ChampionMasteryApiData>>() {
            @Override
            public void onResponse(Call<List<ChampionMasteryApiData>> call, Response<List<ChampionMasteryApiData>> response) {
                Maps.CALLS++;
                if(response.isSuccessful()) {
                    champion1.setValue(response.body().get(0));
                    champion2.setValue(response.body().get(1));
                    champion3.setValue(response.body().get(2));
                }
                else {
                    errorMessage.setValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ChampionMasteryApiData>> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
            }
        });

    }
    public void getMasteryScore(){
        Call<ChampionMasteryScoreApiData> call = service.getChampionScore(player.getValue().getId());
        call.enqueue(new Callback<ChampionMasteryScoreApiData>() {
            @Override
            public void onResponse(Call<ChampionMasteryScoreApiData> call, Response<ChampionMasteryScoreApiData> response) {
                Maps.CALLS++;
                if(response.isSuccessful()){
                    score.setValue(response.body().championScore);
                }
                else {
                    errorMessage.setValue(response.message());
                }
            }

            @Override
            public void onFailure(Call<ChampionMasteryScoreApiData> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
            }
        });
    }
}
