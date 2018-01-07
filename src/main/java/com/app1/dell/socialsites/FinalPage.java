package com.app1.dell.socialsites;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.HttpURLConnection;
import java.net.URL;

public class FinalPage extends AppCompatActivity implements View.OnClickListener {
    ImageView fbbtn,instabtn,twitterimg,linkedimage,utubeimage,pinimage,blogimage,googleimage,quoraimage;
    TextView fbtv,instatv,twitbtn,linkedintv,utubetext,pintext,blogtext,googletext,quoratext;
    Button logout;
   //ScrollView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
       // sv=(ScrollView)findViewById(R.id.sv1);
        fbbtn=(ImageView) findViewById(R.id.fb);
        fbtv=(TextView)findViewById(R.id.fbtext);
        instatv=(TextView)findViewById(R.id.instatext);
        instabtn=(ImageView)findViewById(R.id.insta);
        twitbtn=(TextView)findViewById(R.id.twittext);
        twitterimg=(ImageView)findViewById(R.id.twiimage);
        utubeimage=(ImageView)findViewById(R.id.utubeimg);
        utubetext=(TextView)findViewById(R.id.utubetxt);
       linkedintv=(TextView)findViewById(R.id.linkedtxt);
        linkedimage=(ImageView)findViewById(R.id.linkedimg);
        pinimage=(ImageView)findViewById(R.id.pinid);
        pintext=(TextView)findViewById(R.id.pintv);
        blogimage=(ImageView)findViewById(R.id.blogimg);
        blogtext=(TextView)findViewById(R.id.blogid);
        googleimage=(ImageView)findViewById(R.id.googleimgid);
        googletext=(TextView)findViewById(R.id.googletxt);
        quoraimage=(ImageView)findViewById(R.id.quoraimgid);
        quoratext=(TextView)findViewById(R.id.quoratxtid);
        logout=(Button)findViewById(R.id.logoutbtn);


        fbbtn.setOnClickListener(this);
        instabtn.setOnClickListener(this);
        twitterimg.setOnClickListener(this);
        utubeimage.setOnClickListener(this);
        linkedimage.setOnClickListener(this);
        pinimage.setOnClickListener(this);
        blogimage.setOnClickListener(this);
        googleimage.setOnClickListener(this);
        quoraimage.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==fbbtn) {
        Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.facebook.com"));
            startActivity(intent);
            }
           /* try {
                URL u = new URL("http://www.facebook.com/");
                HttpURLConnection http = (HttpURLConnection) u.openConnection();
                http.connect();*/
           //}catch (Exception e){
              //  e.getMessage();
               // e.printStackTrace();
           // }
           if(v==instabtn){
               Intent intent = new Intent();
               intent.setAction(Intent.ACTION_VIEW);
               intent.addCategory(Intent.CATEGORY_BROWSABLE);
               intent.setData(Uri.parse("http://www.instagram.com"));
               startActivity(intent);

           }
        if(v==twitterimg){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.twitter.com"));
            startActivity(intent);


        }
        if(v==utubeimage){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.youtube.com"));
            startActivity(intent);
        }

        if(v==linkedimage){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.linkedin.com"));
            startActivity(intent);

        }
        if(v==pinimage){
            Intent intent =  new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.pinterest.com"));
            startActivity(intent);
        }
        if(v==blogimage){
            Intent intent =  new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.blogspot.com"));
            startActivity(intent);

        }
        if(v==googleimage){
            Intent intent =  new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("http://www.plus.google.com"));
            startActivity(intent);

        }
        if(v==quoraimage){
            Intent intent =  new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://www.quora.com"));
            startActivity(intent);

        }
        if(v==logout){

            AlertDialog.Builder adb = new AlertDialog.Builder(this);

            adb.setTitle("DON'T FORGET TO FOLLOW !");

            adb.setIcon(android.R.drawable.ic_dialog_alert);



            adb.setPositiveButton("follow here", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent =  new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                   // intent.setData(Uri.parse("https://twitter.com/intent/follow?screen_name=ImRo45"));it workss...wow
                    intent.setData(Uri.parse("http://www.instagram.com/prakash_tiwaari"));
                    startActivity(intent);




                    //Toast.makeText(FinalPage.this, et.getText(), Toast.LENGTH_SHORT).show();
                } });


            adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                      Toast.makeText(getApplicationContext(),"Thanks for using this app.",Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(FinalPage.this,MainActivity.class);
                    startActivity(i);

                    finish();
                } });
            adb.show();



        }




        }
    }

