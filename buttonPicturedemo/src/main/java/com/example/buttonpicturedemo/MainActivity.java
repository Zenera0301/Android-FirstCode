package com.example.buttonpicturedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示
        ImageButton start = (ImageButton) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {//通过匿名内部类
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "您单击了开始游戏按钮", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton switch1 = (ImageButton) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {//通过匿名内部类
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "您单击了切换账号按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
