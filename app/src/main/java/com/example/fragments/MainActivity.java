package com.example.fragments;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.fragments.R;

import fragment.FirstFragment;
import fragment.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnloadfrg;
    private RelativeLayout rlfrg;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnloadfrg = findViewById(R.id.btnloadfrg);
        rlfrg = findViewById(R.id.rlfrg);

        btnloadfrg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(status)
        {
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.add(R.id.rlfrg,firstFragment);
            fragmentTransaction.commit();
            btnloadfrg.setText("Load Second Fragment");
            status = false;
        }
        else
        {
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.add(R.id.rlfrg,secondFragment);
            fragmentTransaction.commit();
            btnloadfrg.setText("Load First Fragment");
            status = true;
        }

    }
}
