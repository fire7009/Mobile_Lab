package com.example.lab22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText URL;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        URL=(EditText)findViewById(R.id.URL);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String myUrl=URL.getText().toString();
                Intent intent=new Intent(getApplicationContext(),NewActivity.class);
                intent.putExtra("Url",myUrl);//intent로 Url에 들어간 text를 넘겨줌
                startActivity(intent);
            }
        });
    }
}

