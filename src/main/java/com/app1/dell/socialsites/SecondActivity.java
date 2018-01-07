package com.app1.dell.socialsites;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.app1.dell.socialsites.R.*;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
 Button login,signup;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        login=(Button)findViewById(R.id.logbtn);
        signup=(Button)findViewById(R.id.signbtn);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);


        }






    public void ChangeFragment(View view) {
        Fragment fragment;
        if (view == findViewById(R.id.aboutappbtn)) {

            fragment = new FragmentOne();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_palce, fragment);
            ft.commit();


        }
        if (view == findViewById(R.id.aboutdeveloperbtn)) {

            fragment = new FragmentTwo();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_palce, fragment);
            ft.commit();
        }
    }

    @Override
    public void onClick(View v) {
        if(v==login){
            Intent i=new Intent(SecondActivity.this,LoginPage.class);
            startActivity(i);
        }
        if(v==signup){
            Intent x = new Intent(SecondActivity.this,SignupPage.class);
            startActivity(x);
        }
    }

   /* @Override
    public void onClick(View v) {
        Fragment fragment;
        if(v==log){

            fragment = new FragmentOne();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_palce, fragment);
            ft.commit();

        if(v==sign){

            fragment = new FragmentOne();
            FragmentManager fmm = getFragmentManager();
            FragmentTransaction ftt = fmm.beginTransaction();
            ftt.replace(R.id.fragment_palce, fragment);
            ft.commit();*/

        }



