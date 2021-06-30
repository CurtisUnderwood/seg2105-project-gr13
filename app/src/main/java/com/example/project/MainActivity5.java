package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    TextView tv5;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tv7 = (TextView) findViewById(R.id.tv7);
        tv8 = (TextView) findViewById(R.id.tv8);
        String x;
        String y;
        y=MDBHandler.getP();
        x=MainActivity.getX();
        tv5.setText("Welcome"+ x +"!You are logged in as ‘student ’.");
        tv7.setText("name:"+y);
        tv8.setText("username:"+x);

    }
}