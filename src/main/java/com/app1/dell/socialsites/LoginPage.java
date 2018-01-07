package com.app1.dell.socialsites;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity implements View.OnClickListener{
    EditText user_name,pass_word;
    Button sub_mit,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user_name=(EditText)findViewById(R.id.username);
        pass_word=(EditText)findViewById(R.id.password);
        sub_mit=(Button)findViewById(R.id.submitbtn);
        home=(Button)findViewById(R.id.homebtn);
        sub_mit.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==sub_mit){
            String s1=user_name.getText().toString();
            String s2=pass_word.getText().toString();
            if(TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2)) {
                if (TextUtils.isEmpty(s1))
                    user_name.setError("fill it");
                if(TextUtils.isEmpty(s2)) {
                    pass_word.setError("fill password");
                    //Toast.makeText(LoginPage.this, "please fill all data", Toast.LENGTH_SHORT).show();

                }
            }
              else
              {

                  SQLiteDatabase data =openOrCreateDatabase("net",MODE_PRIVATE,null);
                  data.execSQL("create table if not exists camp(name varchar,password varchar,email varchar)");
                  String s3="select * from camp where name=' "+s1+" 'and password=' "+s2+" '";
                  Cursor cursor =data.rawQuery(s3,null);
                  cursor.moveToFirst();

                  if(cursor.getCount()>0)
                  {
                      Toast.makeText(LoginPage.this,"logging you in",Toast.LENGTH_SHORT).show();
                      Intent i=new Intent(LoginPage.this,FinalPage.class);
                      startActivity(i);

                  }
                  else
                  {
                      Toast.makeText(getApplicationContext(),"wrong Credentials",Toast.LENGTH_SHORT).show();
                  }
              }


        }

        if(v==home){
            Intent x =new Intent(LoginPage.this,MainActivity.class);
            startActivity(x);
        }
    }
}
