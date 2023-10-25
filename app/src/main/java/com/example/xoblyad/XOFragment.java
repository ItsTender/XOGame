package com.example.xoblyad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link XOFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class XOFragment extends Fragment {

    Button Reset, ResetBegin;
    TextView a1,a2,a3,a4,a5,a6,a7,a8,a9,turn;

    int [] xo= new int[10];
    int status, first; // 1=X , 2=O


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public XOFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment XOFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static XOFragment newInstance(String param1, String param2) {
        XOFragment fragment = new XOFragment();
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
        View view= inflater.inflate(R.layout.fragment_x_o, container, false);

        turn= view.findViewById(R.id.tvTurn);

        Bundle bundle= this.getArguments();

        first = bundle.getInt("team");
        status = bundle.getInt("team");

        if(status==1) turn.setText("Team X's Turn");
        else turn.setText("Team O's Turn");

        return view;
    }


    public void PopupWinner(){
        Fragment gtn=new XOWinnerFragment();
        Bundle bundle= new Bundle();
        bundle.putInt("Team1",first);
        gtn.setArguments(bundle);
        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain, gtn);
        ft.commit();
    }
    public void Popup2Winner(){
        Fragment gtn=new XO2Fragment();
        Bundle bundle= new Bundle();
        bundle.putInt("Team2",first);
        gtn.setArguments(bundle);
        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain, gtn);
        ft.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        // status  1=X , 2=O
        a1=getView().findViewById(R.id.tv1);
        a2=getView().findViewById(R.id.tv2);
        a3=getView().findViewById(R.id.tv3);
        a4=getView().findViewById(R.id.tv4);
        a5=getView().findViewById(R.id.tv5);
        a6=getView().findViewById(R.id.tv6);
        a7=getView().findViewById(R.id.tv7);
        a8=getView().findViewById(R.id.tv8);
        a9=getView().findViewById(R.id.tv9);
        Reset= getView().findViewById(R.id.btnReset);
        ResetBegin= getView().findViewById(R.id.btnResetBeginer);
        turn=getView().findViewById(R.id.tvTurn);

        for(int i=0;i<10;i++)
            xo[i]=0;


        ResetBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayoutMain, new TeamchooserFragment());
                ft.commit();
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setText("");
                a2.setText("");
                a3.setText("");
                a4.setText("");
                a5.setText("");
                a6.setText("");
                a7.setText("");
                a8.setText("");
                a9.setText("");
                for(int i=0;i<10;i++)
                    xo[i]=0;
                status=first;
                if(status==1) turn.setText("Team X's Turn");
                else turn.setText("Team O's Turn");
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a1.getText().toString() != "X" && a1.getText().toString()!= "O") {
                    xo[1]=status;
                    if (status == 1) {
                        a1.setText("X");
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        a1.setText("O");
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[1]==1) {
                        if (xo[1] == xo[2] && xo[1] == xo[3]) PopupWinner();
                        if(xo[1] == xo[5] && xo[1] == xo[9]) PopupWinner();
                        if(xo[1] == xo[4] && xo[1] == xo[7]) PopupWinner();
                    }
                    if(xo[1]==2) {
                        if (xo[1] == xo[2] && xo[1] == xo[3]) Popup2Winner();
                        if(xo[1] == xo[5] && xo[1] == xo[9]) Popup2Winner();
                        if(xo[1] == xo[4] && xo[1] == xo[7]) Popup2Winner();
                    }
                }
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a2.getText().toString() != "X" && a2.getText().toString() != "O") {
                    xo[2]=status;
                    if (status == 1) {
                        a2.setText("X");
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        a2.setText("O");
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[2]==1) {
                        if (xo[2] == xo[1] && xo[2] == xo[3]) PopupWinner();
                        if(xo[2] == xo[5] && xo[2] == xo[8]) PopupWinner();
                    }
                    if(xo[2]==2) {
                        if (xo[2] == xo[1] && xo[2] == xo[3]) Popup2Winner();
                        if(xo[2] == xo[5] && xo[2] == xo[8]) Popup2Winner();
                    }
                }
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a3.getText().toString() != "X" && a3.getText().toString()!= "O") {
                    xo[3]=status;
                    if (status == 1) {
                        a3.setText("X");
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        a3.setText("O");
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[3]==1) {
                        if (xo[3] == xo[2] && xo[1] == xo[3]) PopupWinner();
                        if(xo[3] == xo[6] && xo[3] == xo[9]) PopupWinner();
                        if(xo[3] == xo[5] && xo[3] == xo[7]) PopupWinner();
                    }
                    if(xo[3]==2) {
                        if (xo[3] == xo[2] && xo[3] == xo[3]) Popup2Winner();
                        if(xo[3] == xo[6] && xo[3] == xo[9]) Popup2Winner();
                        if(xo[1] == xo[5] && xo[3] == xo[7]) Popup2Winner();
                    }
                }
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a4.getText().toString() != "X" && a4.getText().toString()!= "O") {
                    xo[4]=status;
                    if (status == 1) {
                        a4.setText("X");
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        a4.setText("O");
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[4]==1) {
                        if (xo[4] == xo[1] && xo[4] == xo[7]) PopupWinner();
                        if(xo[4] == xo[5] && xo[4] == xo[6]) PopupWinner();
                    }
                    if(xo[4]==2) {
                        if (xo[4] == xo[1] && xo[4] == xo[7]) Popup2Winner();
                        if(xo[4] == xo[5] && xo[4] == xo[6]) Popup2Winner();
                    }
                }
            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a5.getText().toString() != "X" && a5.getText().toString()!= "O") {
                    xo[5]=status;
                    if (status == 1) {
                        a5.setText("X");
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        a5.setText("O");
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[5]==1) {
                        if (xo[5] == xo[2] && xo[5] == xo[8]) PopupWinner();
                        if(xo[5] == xo[4] && xo[5] == xo[6]) PopupWinner();
                        if (xo[5] == xo[1] && xo[5] == xo[9]) PopupWinner();
                        if(xo[5] == xo[3] && xo[5] == xo[7]) PopupWinner();
                    }
                    if(xo[5]==2) {
                        if (xo[5] == xo[2] && xo[5] == xo[8]) Popup2Winner();
                        if(xo[5] == xo[4] && xo[5] == xo[6]) Popup2Winner();
                        if (xo[5] == xo[1] && xo[5] == xo[9]) Popup2Winner();
                        if(xo[5] == xo[3] && xo[5] == xo[7]) Popup2Winner();
                    }
                }
            }
        });
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a6.getText().toString() != "X" && a6.getText().toString()!= "O") {
                    xo[6]=status;
                if (status == 1) {
                    a6.setText("X");
                    status += 1;
                    turn.setText("Team O's Turn");
                } else {
                    a6.setText("O");
                    status -= 1;
                    turn.setText("Team X's Turn");
                }
                if(xo[6]==1) {
                    if(xo[6] == xo[3] && xo[6] == xo[9]) PopupWinner();
                    if(xo[6] == xo[5] && xo[6] == xo[4]) PopupWinner();
                }
                if(xo[6]==2) {
                    if(xo[4] == xo[1] && xo[4] == xo[7]) Popup2Winner();
                    if(xo[4] == xo[5] && xo[4] == xo[6]) Popup2Winner();
                }
            }
        }
        });
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(a7.getText().toString() != "X" && a7.getText().toString()!= "O") {
                xo[7]=status;
                if (status == 1) {
                    a7.setText("X");
                    status += 1;
                    turn.setText("Team O's Turn");
                } else {
                    a7.setText("O");
                    status -= 1;
                    turn.setText("Team X's Turn");
                }
                if(xo[7]==1) {
                    if(xo[7] == xo[4] && xo[7] == xo[1]) PopupWinner();
                    if(xo[7] == xo[5] && xo[7] == xo[3]) PopupWinner();
                    if(xo[7] == xo[8] && xo[7] == xo[9]) PopupWinner();
                }
                if(xo[7]==2) {
                    if(xo[7] == xo[4] && xo[7] == xo[1]) Popup2Winner();
                    if(xo[7] == xo[5] && xo[7] == xo[3]) Popup2Winner();
                    if(xo[7] == xo[8] && xo[7] == xo[9]) Popup2Winner();
                }
            }
        }
        });
        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a8.getText().toString() != "X" && a8.getText().toString()!= "O") {
                    xo[8]=status;
                    if (status == 1) {
                        a8.setText("X");
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        a8.setText("O");
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[8]==1) {
                        if(xo[8] == xo[5] && xo[8] == xo[2]) PopupWinner();
                        if(xo[8] == xo[7] && xo[8] == xo[9]) PopupWinner();
                    }
                    if(xo[8]==2) {
                        if(xo[8] == xo[5] && xo[8] == xo[2]) Popup2Winner();
                        if(xo[8] == xo[7] && xo[8] == xo[9]) Popup2Winner();
                    }
                }
            }
        });
        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a9.getText().toString() != "X" && a9.getText().toString()!= "O") {
                    xo[9]=status;
                    if (status == 1) {
                        a9.setText("X");
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        a9.setText("O");
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[9]==1) {
                        if(xo[9] == xo[7] && xo[9] == xo[8]) PopupWinner();
                        if(xo[9] == xo[6] && xo[9] == xo[3]) PopupWinner();
                        if(xo[9] == xo[5] && xo[1] == xo[9]) PopupWinner();
                    }
                    if(xo[9]==2) {
                        if(xo[9] == xo[7] && xo[9] == xo[8]) Popup2Winner();
                        if(xo[9] == xo[6] && xo[9] == xo[3]) Popup2Winner();
                        if(xo[9] == xo[5] && xo[1] == xo[9]) Popup2Winner();
                    }
                }
            }
        });


    }
}