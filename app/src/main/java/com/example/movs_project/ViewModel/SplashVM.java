package com.example.movs_project.ViewModel;

import android.util.Log;

import com.example.movs_project.Model.ChampionsApi.Champion;
import com.example.movs_project.Model.ChampionsApi.Champions;
import com.example.movs_project.Model.GetDataService;
import com.example.movs_project.Model.Maps;
import com.example.movs_project.Model.MasteryApi.MasteriesApiData;
import com.example.movs_project.Model.MasteryApi.Rune;
import com.example.movs_project.Model.MasteryApi.Slot;
import com.example.movs_project.Model.RetrofitClientInstance;
import com.example.movs_project.Model.SpellApi.Spell;
import com.example.movs_project.Model.SpellApi.SpellApiData;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashVM extends ViewModel {

    public static final String TAG = SplashVM.class.getSimpleName();

    public MutableLiveData<Boolean> completeChampions = new MutableLiveData<>();
    public MutableLiveData<Boolean> completeMasteries = new MutableLiveData<>();
    public MutableLiveData<Boolean> completeSpells = new MutableLiveData<>();

    GetDataService service = RetrofitClientInstance.getRetrofitInstanceLOL().create(GetDataService.class);

    private void getChampions() {
        Call<Champions> call = service.getChampions(Maps.BASE_URL +Maps.VERSION+"/data/en_US/champion.json");
        call.enqueue(new Callback<Champions>() {

            @Override
            public void onResponse(Call<Champions> call, Response<Champions> response) {

                if(response.isSuccessful())
                {
                    List<Champion> tmp = response.body().getChampions();
                    for (Champion c : tmp) {
                        Maps.champions.put(c.key,c.image.full);
                    }
                    completeChampions.setValue(true);
                    Log.d(TAG,"loaded champions");
                }
            }

            @Override
            public void onFailure(Call<Champions> call, Throwable t) {

            }
        });
    }
    public void getVersions(){
        Call<List<String>> call = service.getVersion("https://ddragon.leagueoflegends.com/api/versions.json");
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if(response.isSuccessful()){
                    Maps.VERSION = response.body().get(0);


                    getSpells();
                }
                Log.d(TAG,"get newest Version");
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }
    private void getSpells() {
        Call<SpellApiData> call = service.getSpells(Maps.BASE_URL + Maps.VERSION +"/data/en_US/summoner.json");
        call.enqueue(new Callback<SpellApiData>() {

            @Override
            public void onResponse(Call<SpellApiData> call, Response<SpellApiData> response) {

                if(response.isSuccessful())
                {
                    List<Spell> tmp = response.body().getSpells();
                    for (Spell c : tmp) {
                        Maps.spells.put(c.key,c.image.full);
                    }
                    completeSpells.setValue(true);
                    getMasteries();
                    Log.d(TAG,"loaded spells");
                }
            }

            @Override
            public void onFailure(Call<SpellApiData> call, Throwable t) {

            }
        });
    }

    private void getMasteries() {
        Call<List<MasteriesApiData>> call = service.getMasteries(Maps.BASE_URL + Maps.VERSION +"/data/en_US/runesReforged.json");
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
                                Maps.masteriesName.put(r.id,r.name);
                            }
                        }
                    }
                }
                completeMasteries.setValue(true);
                getChampions();
                Log.d(TAG,"Added Masteries");
            }

            @Override
            public void onFailure(Call<List<MasteriesApiData>> call, Throwable t) {

            }
        });
    }
}
