package com.example.drawbaledemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class menudemo extends AppCompatActivity {
    TextView introduce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menudemo);
        introduce = findViewById(R.id.textView);
        registerForContextMenu(introduce);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Intent intent = new Intent(this,styledemo.class);
                startActivity(intent);
                break;
            case R.id.regard:
                Intent intent1 = new Intent(this,menudemo.class);
                startActivity(intent1);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
