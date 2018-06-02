package com.example.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String s_name,s_number;
    Button save,clear,read;
    EditText sn,name;
    SharedPreferences sh_pref;
    SharedPreferences.Editor toEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sn=findViewById(R.id.sn);
        name=findViewById(R.id.name);
        save=(Button)findViewById(R.id.save);
        clear=(Button)findViewById(R.id.clear);
        read=(Button)findViewById(R.id.read);
        save.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                s_number=sn.getText().toString();
                s_name=name.getText().toString();
                sharedPreferences();
            }
        });
        read.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                applySharedPreference();
            }
        });
     clear.setOnClickListener(new Button.OnClickListener(){
         @Override
         public void onClick(View view){
            removePreferences();
         }
     });
    }
    public void sharedPreferences(){
        sh_pref=getSharedPreferences("Login",MODE_PRIVATE);
        toEdit=sh_pref.edit();
        toEdit.putString("Student_number",s_number);
        toEdit.putString("Student_name",s_name);
        toEdit.commit();
    }
    public void applySharedPreference(){
        sh_pref=getSharedPreferences("Login",MODE_PRIVATE);
        if(sh_pref!=null&&sh_pref.contains("Student_name")){
            String Name=sh_pref.getString("Student_name","noname");
            String Number=sh_pref.getString("Student_number","nonumber");
            sn.setText(Number);
            name.setText(Name);
        }
    }
        private void removePreferences(){
        sh_pref=getSharedPreferences("Login",MODE_PRIVATE);
        SharedPreferences.Editor editor=sh_pref.edit();
        editor.clear();
        editor.commit();
        }

}
