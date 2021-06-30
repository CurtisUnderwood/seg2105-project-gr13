package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    EditText UserName;
    EditText Password;
    public static String x;
    public static String z;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = (EditText) findViewById(R.id.UserName);
        Password = (EditText) findViewById(R.id.Password);
    }
    public void validateUser(View view){
        x=UserName.getText().toString();
        z=Password.getText().toString();
        int u=MainActivity3.getO();
            if(UserName.getText().toString().equals("admin") && Password.getText().toString().equals("admin123")){
            Intent intent=new Intent(MainActivity.this , MainActivity2.class);
            startActivity(intent);
        }else if(u==2){
                Intent intent=new Intent(MainActivity.this , MainActivity4.class);
                startActivity(intent);
            }else if(u==3){
                Intent intent=new Intent(MainActivity.this , MainActivity5.class);
                startActivity(intent);
            }
            else if(u==0){
            Toast.makeText(this, "username or password error", Toast.LENGTH_SHORT).show();
        }
}
    public static void setX(String r){
         x=r;
    }
    public static String getX(){
        return x;
    }
    public static String getZ(){
        return z;
    }
    public void signUp(View view){

        Intent intent=new Intent(MainActivity.this , MainActivity3.class);
        startActivity(intent);
    }

}