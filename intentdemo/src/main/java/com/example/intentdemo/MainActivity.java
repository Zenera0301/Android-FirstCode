package com.example.intentdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        Button guanbi = findViewById(R.id.guanbi);

        guanbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
                //ComponentName componentName = new ComponentName("com.example.intentdemo","com.example.intentdemo.DetailActivity");
                //intent.setComponent(componentName);
                //startActivity(intent);
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);

                ImageButton imageButton = findViewById(R.id.imageButton_phone);
                ImageButton imageButton1 = findViewById(R.id.imageButton_sms);
                imageButton.setOnClickListener(l);
                imageButton1.setOnClickListener(l);
            }
            View.OnClickListener l =new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    ImageButton imageButton = (ImageButton)v;
                    switch (imageButton.getId()){
                        case R.id.imageButton_phone:
                            intent.setAction(intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:10086"));
                            startActivity(intent);
                            break;
                        case R.id.imageButton_sms:
                            intent.setAction(intent.ACTION_SENDTO);
                            intent.setData(Uri.parse("smsto:10086"));
                            intent.putExtra("sms_body","Welcome to NJAU!");
                            startActivity(intent);
                            break;
                    }
                }
            };
        });
    }
}
