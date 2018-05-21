package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ImageView view1;
ImageView view2;
EditText text;
Button button;
Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1=(ImageView)findViewById(R.id.dog);
        view2=(ImageView)findViewById(R.id.dog2);
        text=(EditText)findViewById(R.id.text);
        button=(Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                DogThread thread1=new DogThread(0);
                thread1.start();
                DogThread thread2=new DogThread(1);
                thread2.start();
            }
        });
    }
    class DogThread extends Thread {
        int dogIndex;
        int stateIndex;
        ArrayList<Integer> images = new ArrayList<Integer>();
        public DogThread(int index) {
            dogIndex = index;
            images.add(R.drawable.dog);
            images.add(R.drawable.dog2);
        }
        public void run(){
            stateIndex = 0;
            for (int i = 0; i < 9; i++){
                final String msg = "dog #" + dogIndex + "state:" + stateIndex;
                handler.post(new Runnable(){
                    public void run(){
                        text.append(msg+"\n");
                        if(dogIndex==0){
                            view1.setImageResource(images.get(stateIndex));
                        }
                        else if(dogIndex==1){
                            view2.setImageResource(images.get(stateIndex));
                        }
                    }});
                try{
                    int sleepTime=getRandomTime(500,3000);
                    Thread.sleep(sleepTime);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                stateIndex++;
                if(stateIndex>=images.size()){
                    stateIndex=0;
                }
            }
        }
        public int getRandomTime(int min,int max){
            return min+(int)(Math.random()*(max-min));
        }
       }

}
