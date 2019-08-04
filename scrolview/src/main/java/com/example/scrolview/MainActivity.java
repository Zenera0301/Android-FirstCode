package com.example.scrolview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);//获取根布局管理器
        LinearLayout linearLayout1 = new LinearLayout(MainActivity.this);//创建了一个新的线性布局管理器实例
        linearLayout1.setOrientation(LinearLayout.VERTICAL);//垂直的线性布局管理器
        ScrollView scrollView = new ScrollView(MainActivity.this);//创建一个滚动视图
        linearLayout.addView(scrollView);//将滚动视图添加到根布局管理器
        scrollView.addView(linearLayout1);//将新的垂直线性布局管理器添加到滚动视图
        //为新的垂直线性布局管理器添加图像视图和文本框组件 
        ImageView imageView = new ImageView(MainActivity.this);//创建一个图像视图实例
        imageView.setImageResource(R.drawable.cidian);//设置要显示的图片
        linearLayout1.addView(imageView);//将图片视图添加到垂直线性布局管理器中
        TextView textView = new TextView(MainActivity.this);//创建一个文本框组件
        textView.setText(R.string.cidian);//文本框组件中要显示的文本
        linearLayout1.addView(textView);//将文本框组件添加到垂直线性布局管理器中

    }
}
