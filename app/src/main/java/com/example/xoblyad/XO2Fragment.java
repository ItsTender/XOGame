package com.example.xoblyad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link XO2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class XO2Fragment extends Fragment {

    Button Play;

    String User1,User2;
    int Score1,Score2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public XO2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment XO2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static XO2Fragment newInstance(String param1, String param2) {
        XO2Fragment fragment = new XO2Fragment();
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
        View view = inflater.inflate(R.layout.fragment_x_o2, container, false);


        Bundle bundle= this.getArguments();

        User1=bundle.getString("team1");
        User2=bundle.getString("team2");
        Score1=bundle.getInt("score1");
        Score2=bundle.getInt("score2");


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Play= getView().findViewById(R.id.btnPlay2);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment gtn=new XOFragment();
                Bundle bundle= new Bundle();

                bundle.putString("team1",User1);
                bundle.putString("team2",User2);
                bundle.putInt("score1",Score1);
                bundle.putInt("score2",Score2);

                gtn.setArguments(bundle);
                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayoutMain, gtn);
                ft.commit();
            }
        });
    }
}