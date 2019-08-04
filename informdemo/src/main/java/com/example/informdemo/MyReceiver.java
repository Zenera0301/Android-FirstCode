package com.example.informdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String ACTION1 = "zuckerberg";//动作1
    private static final String ACTION2 = "mayun";//动作2
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION1)){
            Toast.makeText(context, "MyReceiver收到：扎克伯格的广播", Toast.LENGTH_SHORT).show();
        }else if (intent.getAction().equals(ACTION2)){
            Toast.makeText(context, "MyReceiver收到：马云的广播", Toast.LENGTH_SHORT).show();
        }
    }
}
