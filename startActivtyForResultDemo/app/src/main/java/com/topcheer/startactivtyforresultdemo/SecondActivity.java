package com.topcheer.startactivtyforresultdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {


    private EditText et;
    private Button btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

           setContentView(R.layout.activity_second);

           et=(EditText) findViewById(R.id.et);
           btn2=findViewById(R.id.btn2);
           btn2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent  intent=new Intent();
                   intent.putExtra("value",et.getText().toString().trim());
                   setResult(4,intent);
                   finish();
               }
           });
    }
}
