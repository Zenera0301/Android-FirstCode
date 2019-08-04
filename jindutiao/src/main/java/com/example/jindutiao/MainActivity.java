package com.example.jindutiao;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int mProgress = 0;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0x111){
                    progressBar.setProgress(mProgress);//更新进度
                }else{
                    Toast.makeText(MainActivity.this, "耗时操作已经完成", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);//设置进度条不显示
                }
            }
        };
    new Thread(new Runnable() {//编写线程
        @Override
        public void run() {
            while(true){
                mProgress = doWork();//假装在做事情，返回做的进度
                Message m = new Message();
                if(mProgress<100){
                    m.what = 0x111;
                    mHandler.sendMessage(m);
                }else{
                    m.what= 0x110;
                    mHandler.sendMessage(m);
                    break;
                }
            }
        }
        private int doWork(){
            mProgress += Math.random()*10;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return mProgress;
        }
    }).start();//开启线程
    }
}
