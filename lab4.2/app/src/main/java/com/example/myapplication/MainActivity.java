package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout basic;
LinearLayout slid;
Button button;
int changeSlid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basic=(LinearLayout)findViewById(R.id.basic);
        slid=(LinearLayout)findViewById(R.id.slid);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Animation open= AnimationUtils.loadAnimation(
                        getApplicationContext(),R.anim.trans1);
                Animation close= AnimationUtils.loadAnimation(
                        getApplicationContext(),R.anim.trans2);
                switch(changeSlid) {
                    case 0:
                        button.setText("Close");
                        changeSlid += 1;
                        slid.setVisibility(View.VISIBLE);
                        slid.startAnimation(open);
                        break;
                    case 1:
                        button.setText("Open");
                        changeSlid-=1;
                        slid.setVisibility(View.GONE);
                        slid.startAnimation(close);
                        break;
                }

            }
        });
    }
}
