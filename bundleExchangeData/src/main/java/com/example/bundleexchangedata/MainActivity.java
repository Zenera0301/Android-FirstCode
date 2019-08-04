package com.example.bundleexchangedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sitel = ((EditText)findViewById(R.id.et_mail)).getText().toString();
                if(!"".equals(sitel)){
                    Intent intent = new Intent(MainActivity.this,AddressActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("sitel",sitel);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"请填写邮编！",Toast.LENGTH_SHORT);
                }
            }
        });

    }
}
