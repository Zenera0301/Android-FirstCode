package com.example.buttonsigledemo;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.bt);
        rg=(RadioGroup)findViewById(R.id.rg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<rg.getChildCount();i++){
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                    if (radioButton.isChecked()){
                        if (radioButton.getText().equals("B: 100")){
                            Toast.makeText(MainActivity.this, "回答正确", Toast.LENGTH_SHORT).show();
                        }else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("回答错误，正确答案是B");
                            builder.setPositiveButton("确定",null).show();
                        }
                        break;
                    }
                }
            }
        });



    }
}
