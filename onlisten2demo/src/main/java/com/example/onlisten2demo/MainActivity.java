package com.example.onlisten2demo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.创建并实例化帽子类的对象，并为其添加触摸事件监听器，在重写的触摸方法中根据触摸位置重绘帽子
        final HatView hat = new HatView(MainActivity.this);
        hat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hat.bitmapX = event.getX()-80;
                hat.bitmapY = event.getY()-80;
                hat.invalidate();
                return true;
            }
        });

        //3.把帽子添加到布局管理器中
        RelativeLayout rl = findViewById(R.id.relativeLayout);
        rl.addView(hat);
    }
}
