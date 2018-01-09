package com.example.farisauzan.curiculumvitae;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;


public class Splash extends AppCompatActivity {
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.getIndeterminateDrawable().setColorFilter(Color.parseColor("#e62f17"), PorterDuff.Mode.SRC_ATOP);

        Thread mySplash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        mySplash.start();

    }
}
