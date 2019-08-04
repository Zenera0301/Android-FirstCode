 package com.example.gridviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

 public class MainActivity extends AppCompatActivity {
    private int[] picture = new int[]{R.drawable.img01, R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,
            R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09,R.drawable.img10,R.drawable.img11,R.drawable.img12};
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
       /* //创建list对象，其列表项是map对象，是通过键值对保存的图像资源
        List<Map<String,Object>> listitem = new ArrayList<Map<String, Object>>();
        //通过for循环把map对象添加到list中
        for (int i = 0; i<picture.length; i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("image",picture[i]);
            listitem.add(map);
        }
        //创建一个SimpleAdapter对象
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitem,R.layout.cell,new String[]{"image"},new int[]{R.id.image});
        //通过setAdapter方法为网格视图设置适配器
        gridView.setAdapter(simpleAdapter);*/
    }

    //图片适配器的编写
    public class ImageAdapter extends BaseAdapter{
        private Context mContext;
        public ImageAdapter(Context c){
            mContext=c;
        }
        @Override
        public int getCount() {
            return picture.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(100,90));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }else {
                imageView = (ImageView)convertView;
            }
            imageView.setImageResource(picture[position]);
            return imageView;
        }
    }

}
