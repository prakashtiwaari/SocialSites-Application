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

public class SignupPage extends AppCompatActivity implements View.OnClickListener {
    EditText useret, passet, emailet;
    Button register, hoome;
    String s1, s2, s3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        useret = (EditText) findViewById(R.id.userid);
        passet = (EditText) findViewById(R.id.passid);
        emailet = (EditText) findViewById(R.id.emli);
        register = (Button) findViewById(R.id.regbtn);
        hoome = (Button) findViewById(R.id.mainbtn);
        register.setOnClickListener(this);
        hoome.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == hoome) {
            Intent i = new Intent(SignupPage.this, MainActivity.class);
            startActivity(i);
            //  finish();
        }

        if (v == register) {
            String s1 = useret.getText().toString();
            String s2 = passet.getText().toString();
            String s3 = emailet.getText().toString();

            if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3)) {
                // Toast.makeText(SignupPage.this, "I recommend you to please fill all details", Toast.LENGTH_SHORT).show();
                if (TextUtils.isEmpty(s1))
                    useret.setError("fill it");
                if (TextUtils.isEmpty(s2))
                    passet.setError("fill it");
                if (TextUtils.isEmpty(s3))
                    emailet.setError("fill it");

            } else {
                if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(s3).matches())) {
                    Toast.makeText(SignupPage.this, "Invalid Email-id", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase data = openOrCreateDatabase("net", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists camp(name varchar,password varchar,email varchar)");
                    String s4 = "select * from camp where name=' " + s1 + " 'or email=' " + s3 + " '";
                    Cursor cursor = data.rawQuery(s4, null);

                    if (cursor.getCount() > 0) {
                        Toast.makeText(SignupPage.this, "User of this email or username already exist.", Toast.LENGTH_SHORT).show();

                    } else {
                        data.execSQL("insert into camp values(' " + s1 + " ', ' " + s2 + " ' ,' " + s3 + " ')");
                        Toast.makeText(SignupPage.this, "you are registered.", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignupPage.this, FinalPage.class);
                        startActivity(i);
                        finish();
                    }
                }

            }
        }
    }
}