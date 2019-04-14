package com.topcheer.startactivtyforresultdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn,but_intent;
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
        but_intent=(Button) findViewById(R.id.btn_intent1);
        but_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent("com.example.MainA");
//                intent.addCategory("android.intent.category.MY_CATEGORY");
////                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);


//                Intent intent=new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);


                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("TEL:10086"));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"添加",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this,"删除",Toast.LENGTH_SHORT).show();
                break;
                default:

        }
        return true;
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
