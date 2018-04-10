package com.example.lab11;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText Name;
EditText Age;
Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=(EditText)findViewById(R.id.name);
        Age=(EditText)findViewById(R.id.age);
        Button=(Button)findViewById(R.id.button);

        Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            String UserName=Name.getText().toString();
            String UserAge=Age.getText().toString();
            Intent intent=new Intent(getApplicationContext(),NewActivity.class);
            intent.putExtra("loginName",UserName);//intent로 넘겨줄 값 설정(name)
            intent.putExtra("loginAge",UserAge);//intent로 넘겨줄 값 설정(age)
            startActivity(intent);
            }
        });
    }
}
