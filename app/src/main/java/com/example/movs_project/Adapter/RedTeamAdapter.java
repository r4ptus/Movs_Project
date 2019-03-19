package com.example.movs_project.Adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movs_project.Model.Player;
import com.example.movs_project.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

public class RedTeamAdapter extends RecyclerView.Adapter<RedTeamAdapter.PlayerViewHolder> {

    private ArrayList<Player> dataList;

    public RedTeamAdapter(ArrayList<Player> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RedTeamAdapter.PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.player_card,parent,false);

        return new RedTeamAdapter.PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RedTeamAdapter.PlayerViewHolder holder, int position) {
        holder.summonerName.setText(dataList.get(position).getSummonerName());

        if(!TextUtils.isEmpty(dataList.get(position).getPlayerIcon())){
            Picasso.get().load(dataList.get(position).getPlayerIcon())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.playerIcon);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getChampionIcon())){
            Picasso.get().load(dataList.get(position).getChampionIcon())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.championIcon);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getSpell1())){
            Picasso.get().load(dataList.get(position).getSpell1())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.spellOne);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getSpell2())){
            Picasso.get().load(dataList.get(position).getSpell2())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.spellTwo);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getPrimaryMastery())){
            Picasso.get().load(dataList.get(position).getPrimaryMastery())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.mainMastery);
        }
        if(!TextUtils.isEmpty(dataList.get(position).getSubMastery())){
            Picasso.get().load(dataList.get(position).getSubMastery())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(holder.subMastery);
        }

        holder.cardView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_gameInfoFragment_to_playerInfoFragment,null));
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
