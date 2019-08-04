package com.example.creategesture;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

//2.让MainActivity实现GestureOverlayView.OnGesturePerformedListener接口，并重写OnGesturePerformed（）方法
public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {
    private GestureLibrary library;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3.加载raw文件夹中的手势文件，如果失败退出应用
        library = GestureLibraries.fromRawResource(MainActivity.this,R.raw.gestures);
        editText = findViewById(R.id.editText);
        if (!library.load()){
            finish();
        }
        //4.获得GestureOverlayView组件，并为其设置属性值和事件监听器
        GestureOverlayView gestureOverlayView = findViewById(R.id.gesture);
        gestureOverlayView.setGestureColor(Color.BLACK);
        gestureOverlayView.setFadeOffset(1000);
        gestureOverlayView.addOnGesturePerformedListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        //5.获取最佳匹配进行显示，并更新编辑框
        ArrayList<Prediction> gestures = library.recognize(gesture);
        int index = 0;
        double score = 0.0;
        for (int i = 0;i<gestures.size();i++){
            Prediction result = gestures.get(i);
            if (result.score > score){
                index = i;
                score = result.score;
            }
        }
        String text = editText.getText().toString();
        text+=gestures.get(index).name;
        editText.setText(text);
    }
}
