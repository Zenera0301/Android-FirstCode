package com.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.mylayout);//获取布局管理器mylayout
        final RabbitView rabbit = new RabbitView(this);
        rabbit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                rabbit.bitmapX = event.getX();
                rabbit.bitmapY = event.getY();
                rabbit.invalidate();//重绘兔子
                return true;
            }
        });

        frameLayout.addView(rabbit);
    }
}
