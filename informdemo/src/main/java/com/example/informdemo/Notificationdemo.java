package com.example.informdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Notificationdemo extends AppCompatActivity {
    final int NOTIFYID = 0x123;//通知ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        //创建并发送通知
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//获取一个通知管理器
        Notification.Builder notification = new Notification.Builder(this);//创建一个通知对象
        notification.setAutoCancel(true);//设置通知打开后自动消失
        notification.setSmallIcon(R.drawable.packet);//设置通知图标
        notification.setContentTitle("奖励百万红包!!");//设置通知的内容标题
        notification.setContentText("点击查看详情！");//设置通知的内容
        notification.setWhen(System.currentTimeMillis());//设置发送时间
        notification.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE);//设置声音和振动
        //创建一个启动详细页面的Intent对象
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
        notification.setContentIntent(pendingIntent);//设置通知栏点击跳转
        notificationManager.notify(NOTIFYID,notification.build());//发送通知 需要minSdkVersion 16

    }
}
