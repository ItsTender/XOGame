package com.example.xoblyad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChooseUsersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseUsersFragment extends Fragment {

    Players players;
    TextView user1,user2;
    Button Play;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChooseUsersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChooseUsersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChooseUsersFragment newInstance(String param1, String param2) {
        ChooseUsersFragment fragment = new ChooseUsersFragment();
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
        return inflater.inflate(R.layout.fragment_choose_users, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        user1=getView().findViewById(R.id.etTeamX);
        user2=getView().findViewById(R.id.etTeamX);
        Play=getView().findViewById(R.id.btnStartGame);
        Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if credential are right
                String X= user1.getText().toString();
                String O= user2.getText().toString();
                if(O.trim().isEmpty()||X.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Some Field Are Missing!", Toast.LENGTH_SHORT).show();
                    return;
                }
                players=new Players(X,O);
                sendDataGoToXO();
            }
        });
    }

    private void sendDataGoToXO(){

        Fragment gtn=new XOFragment();
        Bundle bundle= new Bundle();
        bundle.putInt("team",1);
        gtn.setArguments(bundle);
        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain, gtn);
        ft.commit();
    }
}