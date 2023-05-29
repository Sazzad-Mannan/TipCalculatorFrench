package com.riftech.tipcalculatorfrench;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn=(Button) findViewById(R.id.button);
        EditText et1=(EditText)findViewById(R.id.editTextNumberDecimal);
        EditText et2=(EditText)findViewById(R.id.editTextNumberDecimal2);
        ProgressBar pgsBar = (ProgressBar) findViewById(R.id.pBar);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String s1=String.valueOf(et1.getText());
                String s2=String.valueOf(et2.getText());
                if(s1.equals("") || s2.equals("") ){
                    Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.toast), Toast.LENGTH_SHORT);
                    toast.show();

                }else{
                    double bill=Double.parseDouble(s1);
                    double per=Double.parseDouble(s2);

                    per=per/100;
                    double tip=bill*per;
                    double total=bill+tip;
                    //double bill1=Math.round(bill * 10.0) / 10.0;
                    //double tip1=Math.round(tip * 10.0) / 10.0;
                    //double total1=Math.round(total * 10.0) / 10.0;
                    DecimalFormat format = new DecimalFormat("0.#");
                    String s3=format.format(bill);
                    String s4=format.format(tip);
                    String s5=format.format(total);


                    Intent i=new Intent(getBaseContext(), MainActivity2.class);
                    i.putExtra("bill",s3);
                    i.putExtra("tip",s4);
                    i.putExtra("total",s5);


                    pgsBar.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {



                            pgsBar.setVisibility(View.GONE);
                            startActivity(i);

                            //main.setVisibility(View.VISIBLE);
                        }
                    }, 4000);



                }



            }
        });

    }
}