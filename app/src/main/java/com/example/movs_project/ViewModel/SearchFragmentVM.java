package com.example.movs_project.ViewModel;

import android.util.Log;

import com.example.movs_project.Model.GetDataService;
import com.example.movs_project.Model.SpectatorApi.Participant;
import com.example.movs_project.Model.Player;
import com.example.movs_project.Model.RetrofitClientInstance;
import com.example.movs_project.Model.SpectatorApi.SpectatorApiData;
import com.example.movs_project.Model.SummonerApi.SummonerApiData;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragmentVM extends ViewModel {

    private SummonerApiData summonerApiData;

    public String errorMessage = "";

    private final static String TAG = SearchFragmentVM.class.getSimpleName();

    public enum IsLiveMatch{
        YES,
        NO,
        ERROR,
        RUNNING,
        UNDEFINED
    }

    public final MutableLiveData<IsLiveMatch> isLiveMatch = new MutableLiveData<>();

    public Player player;

    public ArrayList<Player> teamB ;
    public ArrayList<Player> teamR ;

    private GetDataService service = RetrofitClientInstance.getRetrofitInstanceLOL().create(GetDataService.class);

    public SearchFragmentVM(){
        teamR = new ArrayList<>();
        teamB = new ArrayList<>();
        isLiveMatch.setValue(IsLiveMatch.UNDEFINED);
    }

    public void getSummonerApiData(String name){
        isLiveMatch.setValue(IsLiveMatch.RUNNING);
        Call<SummonerApiData> call = service.getSummoner(name);
        call.enqueue(new Callback<SummonerApiData>() {
            @Override
            public void onResponse(Call<SummonerApiData> call, Response<SummonerApiData> response) {
                if(response.isSuccessful()){
                    summonerApiData = response.body();
                    Log.d(TAG,"start Spectator");
                    getSpectator();
                }
                else {
                    errorMessage = response.message();
                    isLiveMatch.setValue(IsLiveMatch.ERROR);

                }

            }

            @Override
            public void onFailure(Call<SummonerApiData> call, Throwable t) {
                errorMessage = t.getMessage();
                isLiveMatch.setValue(IsLiveMatch.ERROR);

            }
        });
    }
    private void getSpectator(){
        //GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<SpectatorApiData> call = service.getSpectator(summonerApiData.id);
        call.enqueue(new Callback<SpectatorApiData>() {
            @Override
            public void onResponse(Call<SpectatorApiData> call, Response<SpectatorApiData> response) {

                if(response.isSuccessful()){

                    Log.d(TAG,"initStart");

                    initTeams(response.body());

                    isLiveMatch.setValue(IsLiveMatch.YES);
                    Log.d(TAG,"Yes is Livematch");
                }
                else{
                    player = new Player(summonerApiData.id,summonerApiData.name,summonerApiData.profileIconId);
                    isLiveMatch.setValue(IsLiveMatch.NO);
                    Log.d(TAG,"No Livematch");
                }
            }

            @Override
            public void onFailure(Call<SpectatorApiData> call, Throwable t) {
                errorMessage = t.getMessage();
                isLiveMatch.setValue(IsLiveMatch.ERROR);
            }
        });
    }
    private void initTeams( SpectatorApiData data){

        Log.d(TAG,"LoopStart");

        teamR.clear();
        teamB.clear();

        for (Participant participant : data.participants){

            Player player = new Player(participant.summonerId,participant.summonerName,"","",0l,
                    participant.profileIconId,participant.championId,participant.spell1Id,participant.spell2Id,
                    participant.perks.perkStyle,participant.perks.perkIds.get(0),participant.perks.perkIds.get(1),participant.perks.perkIds.get(2),participant.perks.perkIds.get(3),
                    participant.perks.perkIds.get(6),participant.perks.perkIds.get(7),participant.perks.perkIds.get(8),
                    participant.perks.perkSubStyle,participant.perks.perkIds.get(4),participant.perks.perkIds.get(5),data.gameQueueConfigId,data.gameMode);
            Log.d(TAG,"player initialised");
            if(participant.teamId == 100){
                teamB.add(player);
            }
            else{
                teamR.add(player);
            }
        }
    }

}
