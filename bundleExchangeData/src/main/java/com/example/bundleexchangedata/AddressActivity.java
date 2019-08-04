package com.example.bundleexchangedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String site = bundle.getString("sitel");
        TextView tv_site = (TextView)findViewById(R.id.site);
        tv_site.setText(site);
    }
}
