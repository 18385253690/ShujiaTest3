package com.example.liuyueyue.shujiatest3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import static android.R.attr.data;

/**
 * Created by liuyueyue on 2017/7/14.
 */

public class Sactivity extends Activity {
    private Button bt;
    private String content = "你好";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        /*什么时候给第一个页面回传数据
        * 回传第一个页面的实际上是一个Intent*/
        bt = (Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("data",content);
                setResult(2,data);
                //结束当前页面
                finish();
            }
        });

    }
}
