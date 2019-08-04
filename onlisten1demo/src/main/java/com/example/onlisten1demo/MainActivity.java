package com.example.onlisten1demo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.将长按事件注册到菜单中，并打开菜单
        Button button = findViewById(R.id.button1);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                registerForContextMenu(v);
                openContextMenu(v);
                return false;
            }
        });
    }
    //1.重写创建选项菜单的方法
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("收藏");
        menu.add("举报");
    }
/*
    //重写onkeydown方法，判断按下的是哪个按键，如果按下的是
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            exit();
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }
    //创建退出方法,如果两次按下的时间差大于两秒，再次弹出消息提示框，否则退出应用
    public void exit(){
        if ((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        }else{
            finish();
            System.exit(0);
        }
    }*/
    /*
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "触摸", Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Toast.makeText(this, "按下", Toast.LENGTH_SHORT).show();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Toast.makeText(this, "抬起", Toast.LENGTH_SHORT).show();
        return super.onKeyUp(keyCode, event);
    }*/
}
