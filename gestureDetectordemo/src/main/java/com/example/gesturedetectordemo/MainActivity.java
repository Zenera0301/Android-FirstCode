package com.example.gesturedetectordemo;

import android.gesture.Gesture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

//1.让MainActivity实现GestureDetector.OnGestureListener接口及全部方法
public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    Animation[] animation = new Animation[4];
    final int distance = 50;
    private int[] images = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09,};
   ViewFlipper flipper;
   //2.定义一个全局的手势检测器
   GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector = new GestureDetector(MainActivity.this,this);
        //3.将要显示的图片加载到viewFlipper中，并且初始化动画数组
        flipper = findViewById(R.id.flipper);
        for (int i = 0;i<images.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        animation[0] = AnimationUtils.loadAnimation(this,R.anim.slide_in_left);
        animation[1] = AnimationUtils.loadAnimation(this,R.anim.slide_out_left);
        animation[2] = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        animation[3] = AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //4.通过触摸事件的X坐标判断左滑右滑，为其设置动画
        if (e1.getX()-e2.getX()>distance){//从右向左滑
            flipper.setInAnimation(animation[2]);//图片右入
            flipper.setOutAnimation(animation[1]);//图片左出
            flipper.showPrevious();
            return true;
        }else if (e2.getX()-e1.getX()>distance){//从左向右滑
            flipper.setInAnimation(animation[0]);
            flipper.setOutAnimation(animation[3]);
            flipper.showPrevious();
            return true;
        }
        return false;
    }
    //5.将Activity上的触摸事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }
}
