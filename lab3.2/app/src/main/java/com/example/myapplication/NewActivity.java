package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView name;
    TextView sex;
    TextView send;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result); name = (TextView) findViewById(R.id.textview1);
        sex = (TextView) findViewById(R.id.textview2);
        send = (TextView) findViewById(R.id.textview3);
        backBtn=(Button)findViewById(R.id.back);
        Intent passedIntent = getIntent();
        if(passedIntent!=null){
            String Name=passedIntent.getStringExtra("name");
            String Sex=passedIntent.getStringExtra("sex");
            String Send=passedIntent.getStringExtra("send");
            name.setText(Name);
            sex.setText(Sex);
            send.setText(Send);
        }
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"돌아가기버튼이 눌렸어요",
                        Toast.LENGTH_LONG).show();
                Intent intent=new Intent();
                setResult(RESULT_OK,intent);
                finish();//뒤로가기
            }
        });
    }
}