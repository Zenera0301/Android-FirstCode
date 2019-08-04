package com.example.imageswitcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;//图像切换器
    private int[] arrayPicture = new int[]{R.drawable.img01, R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,
            R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09};//定义数组
    private int index;//用于索引图片
    private float touchDownX;//手指按下的X坐标
    private float touchUpX;//手指抬起的X坐标
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示

        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitcher);
        //实现图片工厂
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(arrayPicture[index]);
                return imageView;
            }
        });
        //触摸监听器
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    touchDownX = event.getX();
                    return true;
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    touchUpX = event.getX();
                    if (touchUpX - touchDownX > 100){//从左向右滑动
                        index = index==0 ? arrayPicture.length-1 : index-1;//索引=0吗（是最开始那张图片吗）？，如果等于0，就变成最后一张图片；如果不等于0，就让索引减1；
                        //imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_left));
                        //imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_out_right));
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.abc_fade_in));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.abc_fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }else if (touchDownX - touchUpX > 100){//从右向左滑动
                        index = index==arrayPicture.length-1 ? 0 : index+1;//索引=0吗（是最开始那张图片吗）？，如果等于0，就变成最后一张图片；如果不等于0，就让索引减1；
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_right));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_out_left));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }
                    return true;
                }

                return false;
            }
        });

      /*两幅图片淡入淡出切换
      imageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitcher);
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_out));//淡出
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_in));//淡入
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.img01);
                return imageView;
            }
        });
        imageSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageSwitcher)v).setImageResource(R.drawable.img02);
            }
        });*/



    }
}
