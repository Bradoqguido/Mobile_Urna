package com.example.jefer.urnatesi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Finaliza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaliza);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Finaliza.this.finish();
            }
        }, 4000);
    }
}
