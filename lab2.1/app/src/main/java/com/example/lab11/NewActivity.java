package com.example.lab11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        Intent passedIntent=getIntent();
        if(passedIntent!=null){
            String loginName=passedIntent.getStringExtra("loginName");
            String loginAge=passedIntent.getStringExtra("loginAge");//넘겨받은 intent값을 string으로 저장
            Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge,Toast.LENGTH_LONG).show();
      //toast msg로 String값을 띄워줌
        }
        button2=(Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                 finish();//뒤로가기
            }
        });
    }
}
