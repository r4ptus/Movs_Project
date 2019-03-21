package com.example.movs_project.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movs_project.Model.Player;
import com.example.movs_project.R;
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

        TextView name = view.findViewById(R.id.summonerName_PLayerInfo);
        TextView rank = view.findViewById(R.id.rank_PlaerInfo);
        TextView wlRatio = view.findViewById(R.id.winLose_PlayerInfo);
        TextView championPoints = view.findViewById(R.id.championPoints_PlayerInfo);

        ImageView playerIcon = view.findViewById(R.id.playerIcon_PLayerInfo);
        ImageView mainMastery = view.findViewById(R.id.mainMastery_PlayerInfo);
        ImageView mainMastery1 = view.findViewById(R.id.mainMastery1_PlayerInfo);
        ImageView mainMastery2 = view.findViewById(R.id.mainMastery2_PlayerInfo);
        ImageView mainMastery3 = view.findViewById(R.id.mainMastery3_PlayerInfo);
        ImageView subMastery = view.findViewById(R.id.subMastery_PlayerInfo);
        ImageView subMastery1 = view.findViewById(R.id.subMastery1_PlayerInfo);
        ImageView subMastery2 = view.findViewById(R.id.subMastery2_PlayerInfo);

        if(!TextUtils.isEmpty(player.getSummonerName())){
            name.setText(player.getSummonerName());
        }
        if(!TextUtils.isEmpty(player.getRank())){
            rank.setText(player.getRank());
        }
        if(!TextUtils.isEmpty(player.getWlRatio())){
            wlRatio.setText(player.getWlRatio());
        }
        if(!TextUtils.isEmpty(player.getChampionPoints()+"")){
            championPoints.setText(player.getChampionPoints()+"");
        }

        if(!TextUtils.isEmpty(player.getPlayerIcon()+"")){
            Picasso.get().load(player.getPlayerIcon())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(playerIcon);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery()+"")){
            Picasso.get().load(player.getPrimaryMastery())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(mainMastery);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery1()+"")){
            Picasso.get().load(player.getPrimaryMastery1())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(mainMastery1);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery2()+"")){
            Picasso.get().load(player.getPrimaryMastery2())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(mainMastery2);
        }
        if(!TextUtils.isEmpty(player.getPrimaryMastery2()+"")){
            Picasso.get().load(player.getPrimaryMastery2())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(mainMastery3);
        }
        if(!TextUtils.isEmpty(player.getSubMastery()+"")){
            Picasso.get().load(player.getSubMastery())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(subMastery);
        }
        if(!TextUtils.isEmpty(player.getSubMastery1()+"")){
            Picasso.get().load(player.getSubMastery1())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(subMastery1);
        }
        if(!TextUtils.isEmpty(player.getSubMastery2()+"")){
            Picasso.get().load(player.getSubMastery2())
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(subMastery2);
        }
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
