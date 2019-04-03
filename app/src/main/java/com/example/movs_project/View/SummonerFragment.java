package com.example.movs_project.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movs_project.Model.ChampionMasteryApi.ChampionMasteryApiData;
import com.example.movs_project.Model.LeagueApi.LeagueApiData;
import com.example.movs_project.Model.Maps;
import com.example.movs_project.Model.Player;
import com.example.movs_project.R;
import com.example.movs_project.ViewModel.SummonerFragmentVM;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SummonerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SummonerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SummonerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    SummonerFragmentVM summonerFragmentVM;

    public SummonerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SummonerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SummonerFragment newInstance(String param1, String param2) {
        SummonerFragment fragment = new SummonerFragment();
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
        return inflater.inflate(R.layout.fragment_summoner, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Player player = (Player) getArguments().getSerializable("player");

        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);

        summonerFragmentVM = ViewModelProviders.of(requireActivity()).get(SummonerFragmentVM.class);

        summonerFragmentVM.setPlayer(player);

        summonerFragmentVM.getRankedStats();

        if(tabletSize)
            summonerFragmentVM.getChampionPoints();

        ImageView playerIcon = view.findViewById(R.id.summonerIcon_Summoner);
        ImageView rankQ = view.findViewById(R.id.soloQ_Summoner);
        ImageView rank5 = view.findViewById(R.id.flex5_Summoner);
        ImageView rank3 = view.findViewById(R.id.flex3_Summoner);

        ImageView splash  = view.findViewById(R.id.splashChampion);
        ImageView champion1 = view.findViewById(R.id.championIcon_SummonerInfo);
        ImageView champion2 = view.findViewById(R.id.championIcon2_SummonerInfo);
        ImageView champion3 = view.findViewById(R.id.championIcon3_SummonerInfo);

        TextView championName = view.findViewById(R.id.championName_SummonerInfo);
        TextView championName2 = view.findViewById(R.id.championName2_SummonerInfo);
        TextView championName3 = view.findViewById(R.id.championName3_SummonerInfo);
        TextView championMastery = view.findViewById(R.id.championMastery_SummonerInfo);
        TextView championMastery2 = view.findViewById(R.id.championMastery2_SummonerInfo);
        TextView championMastery3 = view.findViewById(R.id.championMastery3_SummonerInfo);
        TextView championPoints = view.findViewById(R.id.championPoints_SummonerInfo);
        TextView championPoints2 = view.findViewById(R.id.championPoints2_SummonerInfo);
        TextView championPoints3 = view.findViewById(R.id.championPoints3_SummonerInfo);

        TextView name = view.findViewById(R.id.summonerName_Summoner);
        TextView level = view.findViewById(R.id.summonerLevel_Summoner);
        TextView score = view.findViewById(R.id.summonerChampionScore_Summoner);

        TextView rankQText = view.findViewById(R.id.rankQ_Summoner);
        TextView rank5Text = view.findViewById(R.id.rank5_Summoner);
        TextView rank3Text = view.findViewById(R.id.rank3_Summoner);
        TextView wlRatioQ = view.findViewById(R.id.wlRatioQ);
        TextView wlRatio5 = view.findViewById(R.id.wlRatio5);
        TextView wlRatio3 = view.findViewById(R.id.wlRatio3);
        TextView rankQLP = view.findViewById(R.id.rankQ_LP);
        TextView rank5LP = view.findViewById(R.id.rank5_LP);
        TextView rank3LP = view.findViewById(R.id.rank3_LP);

        if(!TextUtils.isEmpty(player.getSummonerName()+"")){
            name.setText(player.getSummonerName());
        }

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

        if(!TextUtils.isEmpty(player.getPlayerIcon()+"")) {
            Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/"+ Maps.VERSION +"/img/profileicon/" + player.getPlayerIcon() + ".png")
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(playerIcon);
        }

        if(tabletSize) {
            level.setText("Level: " + player.getLevel());

            summonerFragmentVM.score.observe(getViewLifecycleOwner(), s-> score.setText("Mastery Score: "+s.toString()));

            summonerFragmentVM.champion1.observe(getViewLifecycleOwner(), championMasteryApiData -> {
                championName.setText(Maps.champions.get(championMasteryApiData.championId).name);
                championMastery.setText("Mastery: "+championMasteryApiData.championLevel + "");
                championPoints.setText("Points: "+championMasteryApiData.championPoints + "");
                Picasso.get().load(Maps.CHAMPION_URL + Maps.VERSION + "/img/champion/" + Maps.champions.get(championMasteryApiData.championId).image.full)
                        .error(R.drawable.placeholder)
                        .placeholder(R.drawable.placeholder)
                        .into(champion1);
                Picasso.get().load("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + Maps.champions.get(championMasteryApiData.championId).name + "_0.jpg")
                        .error(R.drawable.placeholder)
                        .placeholder(R.drawable.placeholder)
                        .into(splash);
            });
            summonerFragmentVM.champion2.observe(getViewLifecycleOwner(), championMasteryApiData -> {
                championName2.setText(Maps.champions.get(championMasteryApiData.championId).name);
                championMastery2.setText("Mastery: "+championMasteryApiData.championLevel + "");
                championPoints2.setText("Points: "+championMasteryApiData.championPoints + "");
                Picasso.get().load(Maps.CHAMPION_URL + Maps.VERSION + "/img/champion/" + Maps.champions.get(championMasteryApiData.championId).image.full)
                        .error(R.drawable.placeholder)
                        .placeholder(R.drawable.placeholder)
                        .into(champion2);
            });
            summonerFragmentVM.champion3.observe(getViewLifecycleOwner(), championMasteryApiData -> {
                championName3.setText(Maps.champions.get(championMasteryApiData.championId).name);
                championMastery3.setText("Mastery: "+championMasteryApiData.championLevel + "");
                championPoints3.setText("Points: "+championMasteryApiData.championPoints + "");
                Picasso.get().load(Maps.CHAMPION_URL + Maps.VERSION + "/img/champion/" + Maps.champions.get(championMasteryApiData.championId).image.full)
                        .error(R.drawable.placeholder)
                        .placeholder(R.drawable.placeholder)
                        .into(champion3);
            });
        }

        summonerFragmentVM.soloQ.observe(getViewLifecycleOwner(), leagueApiData -> {
                    if(leagueApiData.tier!=null) {
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
        summonerFragmentVM.flex5.observe(getViewLifecycleOwner(), leagueApiData -> {
                    if(leagueApiData.tier!=null) {
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
        summonerFragmentVM.flex3.observe(getViewLifecycleOwner(), leagueApiData -> {
            if(leagueApiData.tier!=null) {
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

        summonerFragmentVM.errorMessage.observe(this, s -> Toast.makeText(getContext(),s,Toast.LENGTH_LONG).show());
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
