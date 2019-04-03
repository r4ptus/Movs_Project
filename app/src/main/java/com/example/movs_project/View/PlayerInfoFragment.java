package com.example.movs_project.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movs_project.Model.Maps;
import com.example.movs_project.Model.Player;
import com.example.movs_project.R;
import com.example.movs_project.ViewModel.PlayerInfoFragmentVM;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlayerInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PlayerInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    PlayerInfoFragmentVM playerInfoFragmentVM;

    public PlayerInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayerInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayerInfoFragment newInstance(String param1, String param2) {
        PlayerInfoFragment fragment = new PlayerInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        Player player = (Player) getArguments().getSerializable("Player");

        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);

        playerInfoFragmentVM = ViewModelProviders.of(requireActivity()).get(PlayerInfoFragmentVM.class);

        playerInfoFragmentVM.setPlayer(player);

        playerInfoFragmentVM.getRankedStats();
        playerInfoFragmentVM.getChampionPoints();

        TextView mode = view.findViewById(R.id.game_mode);
        TextView name = view.findViewById(R.id.summonerName_PLayerInfo);
        TextView rank = view.findViewById(R.id.rank_PlaerInfo);
        TextView wlRatio = view.findViewById(R.id.winLose_PlayerInfo);
        TextView championPoints = view.findViewById(R.id.championPoints_PlayerInfo);
        TextView championMastery = view.findViewById(R.id.championMastery_PlayerInfo);
        TextView mainMastery1Text = view.findViewById(R.id.mainMastery1Text_PlayerInfo);
        TextView mainMastery2Text = view.findViewById(R.id.mainMastery2Text_PlayerInfo);
        TextView mainMastery3Text = view.findViewById(R.id.mainMasteryText3_PlayerInfo);
        TextView mainMasteryText = view.findViewById(R.id.mainMasteryText_PlayerInfo);
        TextView subMasteryText = view.findViewById(R.id.subMasteryText_PlayerInfo);
        TextView subMastery1Text = view.findViewById(R.id.subMastery1Text_PlayerInfo);
        TextView perk1Text = view.findViewById(R.id.perk1Text_PlayerInfo);
        TextView perk2Text = view.findViewById(R.id.perk2Text_PlayerInfo);
        TextView perk3Text = view.findViewById(R.id.perk3Text_PlayerInfo);
        TextView rankQText = view.findViewById(R.id.rankQ_Summoner);
        TextView rank5Text = view.findViewById(R.id.rank5_Summoner);
        TextView rank3Text = view.findViewById(R.id.rank3_Summoner);
        TextView wlRatioQ = view.findViewById(R.id.wlRatioQ);
        TextView wlRatio5 = view.findViewById(R.id.wlRatio5);
        TextView wlRatio3 = view.findViewById(R.id.wlRatio3);
        TextView rankQLP = view.findViewById(R.id.rankQ_LP);
        TextView rank5LP = view.findViewById(R.id.rank5_LP);
        TextView rank3LP = view.findViewById(R.id.rank3_LP);

        ImageView championIcon = view.findViewById(R.id.championIcon_PlayerInfo);
        ImageView playerIcon = view.findViewById(R.id.playerIcon_PLayerInfo);
        ImageView mainMastery = view.findViewById(R.id.mainMastery_PlayerInfo);
        ImageView mainMastery1 = view.findViewById(R.id.mainMastery1_PlayerInfo);
        ImageView mainMastery2 = view.findViewById(R.id.mainMastery2_PlayerInfo);
        ImageView mainMastery3 = view.findViewById(R.id.mainMastery3_PlayerInfo);
        ImageView subMastery1 = view.findViewById(R.id.subMastery1_PlayerInfo);
        ImageView subMastery2 = view.findViewById(R.id.subMastery2_PlayerInfo);
        ImageView perk1 = view.findViewById(R.id.perk1);
        ImageView perk2 = view.findViewById(R.id.perk2);
        ImageView perk3 = view.findViewById(R.id.perk3);
        ImageView rankQ = view.findViewById(R.id.soloQ_Summoner);
        ImageView rank5 = view.findViewById(R.id.flex5_Summoner);
        ImageView rank3 = view.findViewById(R.id.flex3_Summoner);

        if(!TextUtils.isEmpty(player.getSummonerName())){
            name.setText(player.getSummonerName());
        }
        if(!TextUtils.isEmpty(player.getChampionPoints()+"")){
            championPoints.setText("Points: " + player.getChampionPoints());
        }
        if(!tabletSize) {
            if (!TextUtils.isEmpty(player.getRank())) {
                rank.setText(player.getRank());
            }
            if (!TextUtils.isEmpty(player.getWlRatio())) {
                wlRatio.setText(player.getWlRatio());
            }

            mainMasteryText.setText(Maps.test.get(player.getPrimaryMastery1()).name);
            mainMastery1Text.setText(Maps.test.get(player.getPrimaryMastery2()).name);
            mainMastery2Text.setText(Maps.test.get(player.getPrimaryMastery3()).name);
            mainMastery3Text.setText(Maps.test.get(player.getPrimaryMastery4()).name);

            subMasteryText.setText(Maps.test.get(player.getSubMastery1()).name);
            subMastery1Text.setText(Maps.test.get(player.getSubMastery2()).name);
        }else {
            rankQText.setText("UNRANKED");
            rank5Text.setText("UNRANKED");
            rank3Text.setText("UNRANKED");

            Picasso.get().load(R.drawable.unranked)
                    .error(R.drawable.unranked)
                    .placeholder(R.drawable.unranked)
                    .into(rankQ);
            Picasso.get().load(R.drawable.unranked)
                    .error(R.drawable.unranked)
                    .placeholder(R.drawable.unranked)
                    .into(rank5);
            Picasso.get().load(R.drawable.unranked)
                    .error(R.drawable.unranked)
                    .placeholder(R.drawable.unranked)
                    .into(rank3);
            mainMasteryText.setText(Maps.test.get(player.getPrimaryMastery1()).name+"\n"+ Html.fromHtml(Maps.test.get(player.getPrimaryMastery1()).shortDesc).toString());
            mainMastery1Text.setText(Maps.test.get(player.getPrimaryMastery2()).name+"\n"+Html.fromHtml(Maps.test.get(player.getPrimaryMastery2()).shortDesc).toString());
            mainMastery2Text.setText(Maps.test.get(player.getPrimaryMastery3()).name+"\n"+Html.fromHtml(Maps.test.get(player.getPrimaryMastery3()).shortDesc).toString());
            mainMastery3Text.setText(Maps.test.get(player.getPrimaryMastery4()).name+"\n"+Html.fromHtml(Maps.test.get(player.getPrimaryMastery4()).shortDesc).toString());

            subMasteryText.setText(Maps.test.get(player.getSubMastery1()).name+"\n"+Html.fromHtml(Maps.test.get(player.getSubMastery1()).shortDesc).toString());
            subMastery1Text.setText(Maps.test.get(player.getSubMastery2()).name+"\n"+Html.fromHtml(Maps.test.get(player.getSubMastery2()).shortDesc).toString());
        }


        perk1Text.setText(Maps.perksDesc.get(player.getPerk1()));
        perk2Text.setText(Maps.perksDesc.get(player.getPerk2()));
        perk3Text.setText(Maps.perksDesc.get(player.getPerk3()));

        if(!TextUtils.isEmpty(player.getPlayerIcon()+"")){
            Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/"+Maps.VERSION+"/img/profileicon/" + player.getPlayerIcon() + ".png")
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(playerIcon);
        }
        if(!TextUtils.isEmpty(player.getChampionIcon()+"")){
            Picasso.get().load(Maps.CHAMPION_URL + Maps.VERSION +"/img/champion/" + Maps.champions.get(player.getChampionIcon()).image.full)
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(championIcon);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery1()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.test.get(player.getPrimaryMastery1()).icon)
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(mainMastery);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery2()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.test.get(player.getPrimaryMastery2()).icon)
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(mainMastery1);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery3()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.test.get(player.getPrimaryMastery3()).icon)
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(mainMastery2);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery4()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.test.get(player.getPrimaryMastery4()).icon)
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(mainMastery3);
        }
        if(!TextUtils.isEmpty(player.getSubMastery1()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.test.get(player.getSubMastery1()).icon)
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(subMastery1);
        }
        if(!TextUtils.isEmpty(player.getSubMastery2()+"")){
            Picasso.get().load(Maps.MASTERY_URL + Maps.test.get(player.getSubMastery2()).icon)
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(subMastery2);
        }
        if(!TextUtils.isEmpty(player.getPerk1()+"")){
            Picasso.get().load(Maps.PERKS_URL + Maps.perks.get(player.getPerk1()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(perk1);
        }
        if(!TextUtils.isEmpty(player.getPerk2()+"")){
            Picasso.get().load(Maps.PERKS_URL + Maps.perks.get(player.getPerk2()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(perk2);
        }
        if(!TextUtils.isEmpty(player.getPerk3()+"")){
            Log.d("test",Maps.PERKS_URL + Maps.perks.get(player.getPerk3()));
            Picasso.get().load(Maps.PERKS_URL + Maps.perks.get(player.getPerk3()))
                    .error(R.drawable.placeholder_all)
                    .placeholder(R.drawable.placeholder_all)
                    .into(perk3);
        }

        if(!tabletSize){
            playerInfoFragmentVM.player.observe(this,player1 -> rank.setText(player1.getRank()));
            playerInfoFragmentVM.player.observe(this,player1 -> wlRatio.setText(player1.getWlRatio()));
        }else {
            playerInfoFragmentVM.soloQ.observe(getViewLifecycleOwner(), leagueApiData -> {
                if (leagueApiData.tier != null) {
                    rankQText.setText(leagueApiData.tier + " " + leagueApiData.rank);//
                    wlRatioQ.setText("W: " + leagueApiData.wins + " L: " + leagueApiData.losses);
                    rankQLP.setText(leagueApiData.leaguePoints + " LP");
                    if (leagueApiData.tierImageID != 0) {
                        Picasso.get().load(leagueApiData.tierImageID)
                                .error(R.drawable.unranked)
                                .placeholder(R.drawable.unranked)
                                .into(rankQ);
                    }
                }
            });
            playerInfoFragmentVM.flex5.observe(getViewLifecycleOwner(), leagueApiData -> {
                if (leagueApiData.tier != null) {
                    rank5Text.setText(leagueApiData.tier + " " + leagueApiData.rank);
                    wlRatio5.setText("W: " + leagueApiData.wins + " L: " + leagueApiData.losses);
                    rank5LP.setText(leagueApiData.leaguePoints + " LP");
                    if (leagueApiData.tierImageID != 0) {
                        Picasso.get().load(leagueApiData.tierImageID)
                                .error(R.drawable.unranked)
                                .placeholder(R.drawable.unranked)
                                .into(rank5);
                    }
                }
            });
            playerInfoFragmentVM.flex3.observe(getViewLifecycleOwner(), leagueApiData -> {
                if (leagueApiData.tier != null) {
                    rank3Text.setText(leagueApiData.tier + " " + leagueApiData.rank);
                    wlRatio3.setText("W: " + leagueApiData.wins + " L: " + leagueApiData.losses);
                    rank3LP.setText(leagueApiData.leaguePoints + " LP");
                    if (leagueApiData.tierImageID != 0) {
                        Picasso.get().load(leagueApiData.tierImageID)
                                .error(R.drawable.unranked)
                                .placeholder(R.drawable.unranked)
                                .into(rank3);
                    }
                }
            });
        }


        playerInfoFragmentVM.player.observe(this,player1 -> championPoints.setText("Points: " + player1.getChampionPoints()));
        playerInfoFragmentVM.player.observe(this,player1 -> championMastery.setText("Mastery: "+ player1.getChampionLvl()));
        playerInfoFragmentVM.errorMessage.observe(this, s -> Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show());
        playerInfoFragmentVM.gameType.observe(this, s -> mode.setText(s));

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
