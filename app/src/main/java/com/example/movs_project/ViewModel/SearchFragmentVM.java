package com.example.movs_project.ViewModel;

import android.util.Log;

import com.example.movs_project.Model.ChampionsApi.Champion;
import com.example.movs_project.Model.ChampionsApi.Champions;
import com.example.movs_project.Model.GetDataService;
import com.example.movs_project.Model.Maps;
import com.example.movs_project.Model.MasteryApi.MasteriesApiData;
import com.example.movs_project.Model.MasteryApi.Rune;
import com.example.movs_project.Model.MasteryApi.Slot;
import com.example.movs_project.Model.SpectatorApi.Participant;
import com.example.movs_project.Model.Player;
import com.example.movs_project.Model.RetrofitClientInstance;
import com.example.movs_project.Model.SpectatorApi.SpectatorApiData;
import com.example.movs_project.Model.SummonerApi.SummonerApiData;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragmentVM extends ViewModel {

    private String id;

    final static String TAG = SearchFragmentVM.class.getSimpleName();

    public enum IsLiveMatch{
        YES,
        NO
    }

    public final MutableLiveData<IsLiveMatch> isLiveMatch = new MutableLiveData<>();

    public ArrayList<Player> teamB = new ArrayList<>();
    public ArrayList<Player> teamR = new ArrayList<>();

    GetDataService service = RetrofitClientInstance.getRetrofitInstanceLOL().create(GetDataService.class);

    public void getSummonerApiData(String name){

        Call<SummonerApiData> call = service.getSummoner(name);
        call.enqueue(new Callback<SummonerApiData>() {
            @Override
            public void onResponse(Call<SummonerApiData> call, Response<SummonerApiData> response) {
                if(response.isSuccessful()){
                    SummonerApiData data = response.body();
                    id = data.id;
                    Log.d(TAG,"start Spectator");
                    getSpectator();
                }
            }

            @Override
            public void onFailure(Call<SummonerApiData> call, Throwable t) {

            }
        });
    }


    private void getSpectator(){
        //GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<SpectatorApiData> call = service.getSpectator(id);
        call.enqueue(new Callback<SpectatorApiData>() {
            @Override
            public void onResponse(Call<SpectatorApiData> call, Response<SpectatorApiData> response) {
                Log.d(TAG,response.body().toString());
                if(response.isSuccessful()){

                    Log.d(TAG,"initStart");

                    initTeams(response.body());

                    isLiveMatch.setValue(IsLiveMatch.YES);
                    Log.d(TAG,"Yes is Livematch");
                }
                else{
                    isLiveMatch.setValue(IsLiveMatch.NO);
                    Log.d(TAG,"No Livematch");
                }
            }

            @Override
            public void onFailure(Call<SpectatorApiData> call, Throwable t) {

            }
        });
    }
    private void initTeams( SpectatorApiData data){

        Log.d(TAG,"LoopStart");

        for (Participant participant : data.participants){

            Player player = new Player(participant.summonerName,"","",0l,
                    participant.profileIconId,participant.championId,participant.spell1Id,participant.spell2Id,
                    participant.perks.perkStyle,participant.perks.perkIds.get(0),participant.perks.perkIds.get(1),participant.perks.perkIds.get(2),participant.perks.perkIds.get(3),
                    participant.perks.perkIds.get(6),participant.perks.perkIds.get(7),participant.perks.perkIds.get(8),
                    participant.perks.perkSubStyle,participant.perks.perkIds.get(4),participant.perks.perkIds.get(5));
            Log.d(TAG,"player initialised");
            if(participant.teamId == 100){
                teamB.add(player);
            }
            else{
                teamR.add(player);
            }
        }
    }
    public void getChampions() {
        Call<Champions> call = service.getChampions(RetrofitClientInstance.BASE_URL+"champion.json");
        call.enqueue(new Callback<Champions>() {

            @Override
            public void onResponse(Call<Champions> call, Response<Champions> response) {

                if(response.isSuccessful())
                {
                    List<Champion> tmp = response.body().getChampions();
                    for (Champion c : tmp) {
                        Maps.champions.put(c.key,c.image.full);
                    }
                    Log.d(TAG,"loaded champions");
                }
            }

            @Override
            public void onFailure(Call<Champions> call, Throwable t) {

            }
        });
    }
    public void getMasteries() {
        Call<List<MasteriesApiData>> call = service.getMasteries(RetrofitClientInstance.BASE_URL+"runesReforged.json");
        call.enqueue(new Callback<List<MasteriesApiData>>() {

            @Override
            public void onResponse(Call<List<MasteriesApiData>> call, Response<List<MasteriesApiData>> response) {

                if(response.isSuccessful()){
                    List<MasteriesApiData> data =  response.body();
                    for (MasteriesApiData md : data) {
                        Maps.masteries.put(md.id,md.icon);
                        for (Slot s: md.slots) {
                            for (Rune r: s.runes) {
                                Maps.masteries.put(r.id,r.icon);
                            }
                        }
                    }
                }
                Log.d(TAG,"Added Masteries");
            }

            @Override
            public void onFailure(Call<List<MasteriesApiData>> call, Throwable t) {

            }
        });
    }
}
