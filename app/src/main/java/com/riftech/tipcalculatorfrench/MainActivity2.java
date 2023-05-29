package com.riftech.tipcalculatorfrench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txt1=(TextView) findViewById(R.id.textView4);
        TextView txt2=(TextView) findViewById(R.id.textView6);
        TextView txt3=(TextView) findViewById(R.id.textView8);


        Intent intent = getIntent();
        String bill =intent.getStringExtra("bill");
        String tip = intent.getStringExtra("tip");
        String total = intent.getStringExtra("total");




        txt1.setText(bill);
        txt2.setText(tip);
        txt3.setText(total);

    }
}