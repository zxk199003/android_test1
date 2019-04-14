package com.topcheer.startactivtyforresultdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                等同于下面的写法
//                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);
                startActivityForResult(new Intent(MainActivity.this,SecondActivity.class),1);
            }
        });
        textView=(TextView) findViewById(R.id.tv);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1&&resultCode==4){
            String str=data.getStringExtra("value");
            textView.setText(str);
        }else{
            Toast.makeText(MainActivity.this,"没有收到传值",Toast.LENGTH_SHORT).show();
        }
    }
}
