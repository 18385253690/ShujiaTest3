package com.example.liuyueyue.shujiatest3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.math.MathContext;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.content;
import static android.R.attr.start;

/**
 * Created by liuyueyue on 2017/7/14.
 */

public class Factivity extends Activity {
    private Button bt1;
    private Context mContext;
    private Button bt2;
    private TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        //通过点击bt1实现页面之间的跳转
        //1.startActivity的方式实现
        //2.初始化Intent
        mContext = this;
        bt1= (Button) findViewById(R.id.button1_first);
        bt2= (Button) findViewById(R.id.button2_second);
        tv = (TextView) findViewById(R.id.textView);
        //注册点击事件
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*第一个参数：上下文对象this
                * 第二个参数：目标文件*/
                Intent intent = new Intent(mContext,Sactivity.class);
                startActivity(intent);
            }
        });
        //通过StartActivityForresult方法来进行页面跳转
       bt2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            Intent intent = new Intent(mContext,Sactivity.class);
               /*第一个参数Intent对象
               * 第二个参数请求一个标识*/
           startActivityForResult(intent,1);
           }
       });
    }
     /*通过startActivityForResult跳转，接收返回数据的方法
     * requestCode：请求的标识
     * resuleCode：第二个页面返回的标志*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==2){
          String content =data.getStringExtra("data");
            tv.setText(content);
        }
    }
}
