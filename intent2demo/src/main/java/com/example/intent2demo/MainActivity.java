package com.example.intent2demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "GAOWW";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_VIEW);
                startActivity(intent);

                Log.e(TAG,"输出错误信息");
                Log.w(TAG,"输出警告信息");
                Log.i(TAG,"输出普通信息");
                Log.d(TAG,"输出调试信息");
                Log.v(TAG,"输出冗余信息");


            }
        });


    }
}
