package com.example.movs_project.Adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movs_project.Model.Maps;
import com.example.movs_project.Model.Player;
import com.example.movs_project.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.PlayerViewHolder> {

    private ArrayList<Player> dataList;

    public TeamAdapter(ArrayList<Player> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.player_card,parent,false);

        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        holder.summonerName.setText(dataList.get(position).getSummonerName());

        if(!TextUtils.isEmpty(dataList.get(position).getPlayerIcon()+"")){
            Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/"+Maps.VERSION+"/img/profileicon/" + dataList.get(position).getPlayerIcon() + ".png")
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.playerIcon);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getChampionIcon()+"")){
            Picasso.get().load(Maps.CHAMPION_URL + Maps.VERSION +"/img/champion/"+ Maps.champions.get(dataList.get(position).getChampionIcon()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(holder.championIcon);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getSpell1()+"")){
            Picasso.get().load(Maps.SPELLS_URL + Maps.VERSION +"/img/spell/"+ Maps.spells.get(dataList.get(position).getSpell1()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(holder.spellOne);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getSpell2()+"")){
            Picasso.get().load(Maps.SPELLS_URL + Maps.VERSION +"/img/spell/"+ Maps.spells.get(dataList.get(position).getSpell2()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(holder.spellTwo);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getPrimaryMastery()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.masteries.get(dataList.get(position).getPrimaryMastery()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(holder.mainMastery);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getSubMastery()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.masteries.get(dataList.get(position).getSubMastery()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(holder.subMastery);
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("Player",dataList.get(position));

        holder.cardView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameInfoFragment_to_playerInfoFragment,bundle));
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView playerIcon,championIcon,spellOne,spellTwo,mainMastery,subMastery;
        TextView summonerName;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.playerCard);
            playerIcon = itemView.findViewById(R.id.playerIcon);
            championIcon = itemView.findViewById(R.id.championIcon);
            spellOne = itemView.findViewById(R.id.spell1);
            spellTwo = itemView.findViewById(R.id.spell2);
            mainMastery = itemView.findViewById(R.id.mainMastery);
            subMastery = itemView.findViewById(R.id.subMastery);
            summonerName = itemView.findViewById(R.id.summonerName);
        }
    }
}
