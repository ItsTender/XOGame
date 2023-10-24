package com.example.xoblyad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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

    Button Reset;
    TextView a1,a2,a3,a4,a5,a6,a7,a8,a9;
    String [] XO= new String[9];
    int status= 1;

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
        return inflater.inflate(R.layout.fragment_x_o, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
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
            }
        });

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a1.getText().toString() != "X" && a1.getText().toString()!= "O") {
                    if (status == 1) {
                        a1.setText("X");
                        status += 1;
                    } else {
                        a1.setText("O");
                        status -= 1;
                    }
                }
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a2.getText().toString() != "X" && a2.getText().toString() != "O") {
                    if (status == 1) {
                        a2.setText("X");
                        status += 1;
                    } else {
                        a2.setText("O");
                        status -= 1;
                    }
                }
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a3.getText().toString() != "X" && a3.getText().toString()!= "O") {
                    if (status == 1) {
                        a3.setText("X");
                        status += 1;
                    } else {
                        a3.setText("O");
                        status -= 1;
                    }
                }
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a4.getText().toString() != "X" && a4.getText().toString()!= "O") {
                    if (status == 1) {
                        a4.setText("X");
                        status += 1;
                    } else {
                        a4.setText("O");
                        status -= 1;
                    }
                }
            }
        });
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a5.getText().toString() != "X" && a5.getText().toString()!= "O") {
                    if (status == 1) {
                        a5.setText("X");
                        status += 1;
                    } else {
                        a5.setText("O");
                        status -= 1;
                    }
                }
            }
        });
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a6.getText().toString() != "X" && a6.getText().toString()!= "O") {
                if (status == 1) {
                    a6.setText("X");
                    status += 1;
                } else {
                    a6.setText("O");
                    status -= 1;
                }
            }
        }
        });
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(a7.getText().toString() != "X" && a7.getText().toString()!= "O") {
                if (status == 1) {
                    a7.setText("X");
                    status += 1;
                } else {
                    a7.setText("O");
                    status -= 1;
                }
            }
        }
        });
        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a8.getText().toString() != "X" && a8.getText().toString()!= "O") {
                    if (status == 1) {
                        a8.setText("X");
                        status += 1;
                    } else {
                        a8.setText("O");
                        status -= 1;
                    }
                }
            }
        });
        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a9.getText().toString() != "X" && a9.getText().toString()!= "O") {
                    if (status == 1) {
                        a9.setText("X");
                        status += 1;
                    } else {
                        a9.setText("O");
                        status -= 1;
                    }
                }
            }
        });


    }
}