package com.example.databasedemo;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private DBOpenHelper dbOpenHelper;  //定义DBOpenHelper,用于与数据库连接
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //创建DBOpenHelper对象,指定名称、版本号并保存在databases目录下
        dbOpenHelper = new DBOpenHelper(AddActivity.this, "db_dict", null, 1);//与MainActivity中的后3个参数一模一样//实例化DBOpenHelper对象，用来创建数据库

        final EditText  etWord=(EditText)findViewById(R.id.add_word);           //获取添加单词的编辑框
        final EditText etInterpret=(EditText)findViewById(R.id.add_interpret);  //获取添加解释的编辑框
        ImageButton btn_Save= (ImageButton) findViewById(R.id.save_btn);      //获取保存按钮
        ImageButton btn_Cancel= (ImageButton) findViewById(R.id.cancel_btn1); //获取取消按钮

        btn_Save.setOnClickListener(new View.OnClickListener() {  //实现将添加的单词解释保存在数据库中
            @Override
            public void onClick(View v) {
                String word = etWord.getText().toString();  //获取填写的生词
                String interpret = etInterpret.getText().toString(); //获取填写的解释
                if (word.equals("")||interpret.equals("")){  //如果填写的单词或者解释为空时
                    Toast.makeText(AddActivity.this, "填写的单词或解释为空", Toast.LENGTH_SHORT).show();
                }else {
                    // 调用insertData()方法，实现插入生词数据
                    insertData(dbOpenHelper.getReadableDatabase(), word, interpret);
                    // 显示提示信息
                    Toast.makeText(AddActivity.this, "添加生词成功！", Toast.LENGTH_LONG).show();
                }

            }
        });
        btn_Cancel.setOnClickListener(new View.OnClickListener() {  //实现返回查询单词界面
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddActivity.this,MainActivity.class);  //通过Intent跳转查询单词界面
                startActivity(intent);
            }
        });
    }
    //创建insertData()方法实现插入数据
    private void insertData(SQLiteDatabase sqLiteDatabase, String word, String interpret) {
        ContentValues values=new ContentValues();
        values.put("word", word);       //保存单词
        values.put("detail", interpret);  //保存解释
        sqLiteDatabase.insert("tb_dict",null,values);//执行插入操作
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbOpenHelper != null){
            dbOpenHelper.close();//关闭数据库连接
        }
    }
}

