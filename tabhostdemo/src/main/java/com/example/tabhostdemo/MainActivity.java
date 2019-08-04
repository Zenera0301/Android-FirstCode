package com.example.tabhostdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);//创建
        tabHost.setup();//初始化
        LayoutInflater inflater = LayoutInflater.from(this);//声明并实例化一个LayoutInflater对象
        inflater.inflate(R.layout.tab1,tabHost.getTabContentView());//通过LayoutInflater这个对象加载两个标签页的布局文件
        inflater.inflate(R.layout.tab2,tabHost.getTabContentView());//第一个参数是布局资源，第二个参数是一个ViewGroup对象
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("精选表情").setContent(R.id.left));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("投稿表情").setContent(R.id.right));

    }
}
