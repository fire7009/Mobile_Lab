package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    EditText edit;
    TextView view;
    TextView result;
private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = (Button) findViewById(R.id.calculate);
        edit = (EditText) findViewById(R.id.edit);
        view = (TextView) findViewById(R.id.view);
        result = (TextView) findViewById(R.id.result);
        calculate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int num,sum=1;
                String getText=edit.getText().toString();
                num=Integer.parseInt(getText);
                value=num;
                new CountDownTask().execute();
            }
        });

    }
    private class CountDownTask extends AsyncTask<Void,Integer,Void>{
        @Override
        protected void onPreExecute(){
            view.setText("");
        }
        @Override
        protected Void doInBackground(Void... params) {
            for(int i=value; i>=1; i--){
            try{Thread.sleep(500);
                publishProgress(i);}catch (Exception e){}            }
                return null;
            }
            @Override
            protected void onProgressUpdate(Integer... values){
                view.append(Integer.toString(values[0].intValue())+" ");

            }
            @Override
        protected void onPostExecute(Void aVoid){
                int r=1;
                for(int i=value;i>=1;i--){
                    r=r*i;
                }
                String back=Integer.toString(r);
                result.setText(back);
            }
    }
    }


