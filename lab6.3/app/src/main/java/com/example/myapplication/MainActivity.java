package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SQLiteDatabase db;
MySQLiteOpenHelper helper;
EditText name,sn;
Button add,delete;
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       name=findViewById(R.id.name);
       sn=findViewById(R.id.number);
       add=(Button) findViewById(R.id.add);
       delete=(Button)findViewById(R.id.delete);
       list=findViewById(R.id.list);
        helper = new MySQLiteOpenHelper(MainActivity.this, "person.db", null, 1);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String n_name=name.getText().toString();
                String n_num=sn.getText().toString();
                if(n_name.length()<1||n_num.length()<1){
                    Toast.makeText(MainActivity.this, "데이터를 모두 입력해주세요", Toast.LENGTH_LONG).show();
                }
                else{
                    int number=Integer.parseInt(n_num);
                    name.setText("");
                    sn.setText("");
                    insert(n_name,number);
                    invalidate();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String n_name=name.getText().toString();
                if(n_name.length()<1) {//if name is empty...
                    Toast.makeText(MainActivity.this, "이름을 입력해 주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    name.setText("");
                    sn.setText("");
                    delete(n_name);
                    invalidate();
                }
            }
        });
    }
    public void insert(String name, int number){
        db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("studentNo",number);
        db.insert("student",null,values);
    }
    public void update(String name, int studentNo) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("studentNo", studentNo);
        values.put("name", name);
        db.update("student", values, "name=?", new String[]{name});
    }

    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
    }

    public String[] select() {
        db = helper.getReadableDatabase();
        Cursor cr = db.query("student", null, null, null, null, null, null);
        String[] items = new String[cr.getCount()];

        int count = 0;
        while(cr.moveToNext()) {
            items[count] = cr.getString(cr.getColumnIndex("name")) +  " " + cr.getString(cr.getColumnIndex("studentNo"));
            count++;
        }
        cr.close();
        return items;
    }

    public void invalidate() {
        String[] items = select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
    }

}
