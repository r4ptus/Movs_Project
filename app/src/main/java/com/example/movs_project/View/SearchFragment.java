package com.example.movs_project.View;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.movs_project.R;
import com.example.movs_project.ViewModel.SearchFragmentVM;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment implements OnBackPressedCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //for preventing double click
    private long mLastClickTime = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private SearchFragmentVM searchFragmentVM;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        // This callback will only be called when MyFragment is at least Started.
        requireActivity().addOnBackPressedCallback(this, new OnBackPressedCallback() {
            @Override
            public boolean handleOnBackPressed() {
                return true; // return true if event was handled
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        searchFragmentVM = ViewModelProviders.of(requireActivity()).get(SearchFragmentVM.class);

        Button button = view.findViewById(R.id.searchButton);
        final EditText text = view.findViewById(R.id.searchText);

        final Bundle bundle = new Bundle();

        button.setOnClickListener(v -> {

            //MainActivity.start();
            // mis-clicking prevention, using threshold of 1000 ms
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000){
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();

            if(!TextUtils.isEmpty(text.getText().toString())){
                    if(searchFragmentVM.isLiveMatch.getValue() != SearchFragmentVM.IsLiveMatch.RUNNING) {
                        String tmp = text.getText().toString();

                        searchFragmentVM.getSummonerApiData(tmp);

                }
            }
            else{
                Toast.makeText(getContext(),"pls enter a Summonername",Toast.LENGTH_SHORT).show();
            }
        });

        searchFragmentVM.isLiveMatch.observe(getViewLifecycleOwner(), isLiveMatch -> {
            switch (isLiveMatch) {
                case YES:
                    bundle.putSerializable("teamB", searchFragmentVM.teamB);
                    bundle.putSerializable("teamR", searchFragmentVM.teamR);
                    Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_gameInfoFragment, bundle);
                    break;
                case NO:
                    bundle.putSerializable("player", searchFragmentVM.player);
                    Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_summonerFragment, bundle);
                    break;
                case ERROR:
                    Toast.makeText(getContext(), searchFragmentVM.errorMessage, Toast.LENGTH_LONG).show();
            }
        });
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

    @Override
    public boolean handleOnBackPressed() {
        return false;
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
