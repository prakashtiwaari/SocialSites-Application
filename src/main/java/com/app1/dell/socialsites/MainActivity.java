package com.app1.dell.socialsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button yes;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes=(Button)findViewById(R.id.wlcmbtn);
        welcome=(TextView)findViewById(R.id.welcm);
        yes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==yes){
            Intent i =new Intent(MainActivity.this,SecondActivity.class);
            startActivity(i);
        }
    }
}
