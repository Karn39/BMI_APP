package com.example.cjcu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String temp= getResources().getString(R.string.app_title);
    }

    public void cal_Onclick(View view) {
        //取得身高體重相關資料
        EditText etHeight = (EditText) findViewById(R.id.et_bodyHeight);
        EditText etWeight = (EditText) findViewById(R.id.et_bodyWeight);
        TextView tvBMI = (TextView) findViewById(R.id.tv_BMI);

        //將使用者的輸入儲存到變數
        double height = Double.parseDouble(etHeight.getText().toString());
        double weight = Double.parseDouble(etWeight.getText().toString());
        double bmi = weight / Math.pow(height/100,2);

        //JAVA四捨五入
        DecimalFormat df=new DecimalFormat("##.00");
        bmi=Double.parseDouble(df.format(bmi));

        tvBMI.setText(String.valueOf(bmi));
    }

    public void Author_Onclick(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this , AuthorActivity.class);
        startActivity(intent);
    }
}
