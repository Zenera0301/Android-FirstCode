package com.example.chronometerdemo;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Chronometer ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //设置全屏显示
        ch = (Chronometer) findViewById(R.id.chronometer);
        ch.setBase(SystemClock.elapsedRealtime());
        ch.setFormat("%s");
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-ch.getBase()>=60000){
                    ch.stop();
                }
            }
        });

    }
}
