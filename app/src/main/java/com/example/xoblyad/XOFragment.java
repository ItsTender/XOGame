package com.example.xoblyad;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link XOFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class XOFragment extends Fragment {

    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9;
    Button Reset, ResetBegin;
    TextView turn;

    int [] xo= new int[10];
    int status=1,first=1; // 1=X , 2=O


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

        Bundle bundle= this.getArguments();

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

        Reset= getView().findViewById(R.id.btnReset);
        ResetBegin= getView().findViewById(R.id.btnResetBeginer);
        turn=getView().findViewById(R.id.tvTurn);
        iv1=getView().findViewById(R.id.IVa1);
        iv2=getView().findViewById(R.id.IVa2);
        iv3=getView().findViewById(R.id.IVa3);
        iv4=getView().findViewById(R.id.IVa4);
        iv5=getView().findViewById(R.id.IVa5);
        iv6=getView().findViewById(R.id.IVa6);
        iv7=getView().findViewById(R.id.IVa7);
        iv8=getView().findViewById(R.id.IVa8);
        iv9=getView().findViewById(R.id.IVa9);
        turn= getView().findViewById(R.id.tvTurn);

        turn.setText("Team X's Turn");

        for(int i=0;i<10;i++)
            xo[i]=0;

        ResetBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.FrameLayoutMain, new ChooseUsersFragment());
                ft.commit();
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv1.setImageDrawable(null);
                iv2.setImageDrawable(null);
                iv3.setImageDrawable(null);
                iv4.setImageDrawable(null);
                iv5.setImageDrawable(null);
                iv6.setImageDrawable(null);
                iv7.setImageDrawable(null);
                iv8.setImageDrawable(null);
                iv9.setImageDrawable(null);
                for(int i=0;i<10;i++)
                    xo[i]=0;
                status=first;
                if(status==1) turn.setText("Team X's Turn");
                else turn.setText("Team O's Turn");
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv1.getDrawable()==null) {
                    xo[1]=status;
                    if (status == 1) {
                        iv1.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv1.setImageResource(R.drawable.letter_o);
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
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iv2.getDrawable()==null) {
                    xo[2]=status;
                    if (status == 1) {
                        iv2.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv2.setImageResource(R.drawable.letter_o);
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
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iv3.getDrawable()==null) {
                    xo[3]=status;
                    if (status == 1) {
                        iv3.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv3.setImageResource(R.drawable.letter_o);
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                    if(xo[3]==1) {
                        if (xo[3] == xo[2] && xo[1] == xo[3]) PopupWinner();
                        if(xo[3] == xo[6] && xo[3] == xo[9]) PopupWinner();
                        if(xo[3] == xo[5] && xo[3] == xo[7]) PopupWinner();
                    }
                    if(xo[3]==2) {
                        if (xo[3] == xo[2] && xo[1] == xo[3]) Popup2Winner();
                        if(xo[3] == xo[6] && xo[3] == xo[9]) Popup2Winner();
                        if(xo[3] == xo[5] && xo[3] == xo[7]) Popup2Winner();
                    }
                }
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv4.getDrawable()==null) {
                    xo[4]=status;
                    if (status == 1) {
                        iv4.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv4.setImageResource(R.drawable.letter_o);
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
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv5.getDrawable()==null) {
                    xo[5]=status;
                    if (status == 1) {
                        iv5.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv5.setImageResource(R.drawable.letter_o);
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
        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv6.getDrawable()==null) {
                    xo[6]=status;
                    if (status == 1) {
                        iv6.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv6.setImageResource(R.drawable.letter_o);
                        status -= 1;
                        turn.setText("Team X's Turn");
                    }
                if(xo[6]==1) {
                    if(xo[6] == xo[3] && xo[6] == xo[9]) PopupWinner();
                    if(xo[6] == xo[5] && xo[6] == xo[4]) PopupWinner();
                }
                if(xo[6]==2) {
                    if(xo[6] == xo[3] && xo[6] == xo[9]) Popup2Winner();
                    if(xo[6] == xo[5] && xo[6] == xo[4]) Popup2Winner();
                }
            }
        }
        });
        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv7.getDrawable()==null) {
                    xo[7]=status;
                    if (status == 1) {
                        iv7.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv7.setImageResource(R.drawable.letter_o);
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
        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv8.getDrawable()==null) {
                    xo[8]=status;
                    if (status == 1) {
                        iv8.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv8.setImageResource(R.drawable.letter_o);
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
        iv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(iv9.getDrawable()==null) {
                    xo[9]=status;
                    if (status == 1) {
                        iv9.setImageResource(R.drawable.letter_x);
                        status += 1;
                        turn.setText("Team O's Turn");
                    } else {
                        iv9.setImageResource(R.drawable.letter_o);
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