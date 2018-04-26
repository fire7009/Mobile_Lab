package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioGroup radGroup;
    RadioButton radMan;
    RadioButton radWoman;
    CheckBox sms;
    CheckBox mail;
    Button accept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        radGroup=(RadioGroup)findViewById(R.id.sex);
        radMan=(RadioButton)findViewById(R.id.man);
        radWoman=(RadioButton)findViewById(R.id.woman);
        sms=(CheckBox)findViewById(R.id.sms);
        mail=(CheckBox)findViewById(R.id.mail);
        accept=(Button)findViewById(R.id.accept);
        accept.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View v){
            String userName = name.getText().toString();
            String sex = "";
            String send = "";
            int radioId=radGroup.getCheckedRadioButtonId();
            if (radMan.getId()==radioId) {
                sex =radMan.getText().toString();
            }
            if (radWoman.getId()==radioId) {
                sex =radWoman.getText().toString();
            }
            if (sms.isChecked()) {
                send +=(" " + sms.getText().toString()); ;
            }
            if (mail.isChecked()) {
                send += (" " + mail.getText().toString()); ;;
            }
            Intent intent = new Intent(getApplicationContext(), NewActivity.class);
            intent.putExtra("name",userName);
            intent.putExtra("sex",sex);
            intent.putExtra("send",send);
            startActivityForResult(intent,1);
        }
            });
        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //원래 선택된 값들 모두 초기화
        name.setText("");
        radGroup.clearCheck();
        sms.setChecked(false);
        mail.setChecked(false);
    }

    }
