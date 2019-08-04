package com.example.onlisten2demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
//1.创建自定义View，用来绘制帽子的
public class HatView extends View {
    public float bitmapX;
    public float bitmapY;
    public HatView(Context context) {
        super(context);
        bitmapX = 65;
        bitmapY = 0;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.hat);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        if (bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
