package com.example.xoblyad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoToXO();

    }

    private void GoToXO() {
        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain, new XOFragment());
        ft.commit();
    }

}