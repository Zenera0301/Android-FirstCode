package com.example.informdemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //*************按钮1 带取消和确定按钮的对话框***************************************
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();//创建alertdialog对象
                alertDialog.setIcon(R.drawable.advise);//设置图标
                alertDialog.setTitle("乔布斯：");//设置标题
                alertDialog.setMessage("活着就是为了改变世界。");//设置内容
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"您单击了否按钮",Toast.LENGTH_SHORT).show();
                    }
                });//取消按钮
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"您单击了是按钮",Toast.LENGTH_SHORT).show();
                    }
                });//确定按钮
                alertDialog.show();
            }
        });
        //*************按钮2 带列表的对话框***************************************
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//带4个列表项的列表对话框
                final String[] items = new String[]{"当你有使命，他会让你更专注","要么出众，要么出局","活着就是要改变世界","求知若饥，虚心若愚"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//创建一个AlertDialogBuilder对象
                builder.setIcon(R.drawable.advise1);//设置图标
                builder.setTitle("请选择你喜欢的名言：");//设置标题
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"您选择了【"+items[which]+"】",Toast.LENGTH_SHORT).show();
                    }
                });//添加列表项
                builder.create().show();//创建显示对话框

            }
        });
        //*************按钮3 带单选列表项的对话框***************************************
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//带单选列表项的对话框
                final String[] items = new String[]{"扎克伯格","乔布斯","马云","希拉里"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//创建alertdialog.builder对象
                builder.setIcon(R.drawable.advise2);//图标
                builder.setTitle("如果让你选择你最想成为：");//标题
                builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "您选择了【"+items[which]+"】", Toast.LENGTH_SHORT).show();
                    }
                });//添加列表项
                builder.setPositiveButton("确定",null);
                builder.create().show();//创建并显示对话框
            }
        });
        //*************按钮4 带多选列表项的对话框***************************************
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//创建多选列表项的对话框
                final boolean[] checkedItems = new boolean[]{false,true,false,true,false};//记录各列表项的状态
                final String[] items = new String[]{"开心消消乐","球球大作战","欢乐斗地主","梦幻西游","植物大战僵尸"};//各选项内容
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);//创建一个alertdialog.builder对象
                builder.setIcon(R.drawable.advise2);//图标
                builder.setTitle("请选择您喜爱的游戏：");//标题
                builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;//改变备操作列表项的状态
                    }
                });//添加的列表项
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";//记录结果的字符串
                        for (int i=0;i<checkedItems.length;i++){
                            if (checkedItems[i]){
                                result+=items[i]+"、";//把列表项的内容添加到result中
                            }
                        }
                        if (!"".equals(result)){
                            Toast.makeText(MainActivity.this, "您选择了【"+result+"】", Toast.LENGTH_SHORT).show();
                        }
                    }
                });//添加确定按钮
                builder.create().show();//创建并显示对话框
            }
        });

        //*************按钮5 跳转到演示Notification功能的活动***************************************
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Notificationdemo.class);
                startActivity(intent);
            }
        });
        //*************按钮6 发送一条广播***************************************
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("zuckerberg");//为intent添加动作zuckerberg
                sendBroadcast(intent);//发送广播
            }
        });
        //*************按钮7 跳转到闹钟界面***************************************
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Alarmdemo.class);
                startActivity(intent);
            }
        });
    }
}
