package com.example.drawbaledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setTheme(R.style.bgTheme);
        setContentView(R.layout.activity_main);
        Button btn_goto1 = findViewById(R.id.btn_goto1);
        Button btn_goto2 = findViewById(R.id.btn_goto2);
        final EditText editText = findViewById(R.id.editText);//获取密码编辑框
        final Button button = findViewById(R.id.btn_login);//获取登录按钮
        editText.addTextChangedListener(new TextWatcher() {//为编辑框设置监听事件
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText.length() > 0){
                    button.setEnabled(true);
                }else {
                    button.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn_goto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,styledemo.class);
                startActivity(intent);
            }
        });
        btn_goto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,menudemo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this,styledemo.class);
                startActivity(intent);
                break;
            case R.id.regard:
                Intent intent1 = new Intent(MainActivity.this,menudemo.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
