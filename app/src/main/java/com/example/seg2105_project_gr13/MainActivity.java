package com.example.seg2105_project_gr13;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;


import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameBox, passwordBox;
    private Button loginBtn, signupBtn;
    private DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameBox = findViewById(R.id.editTextLogInUsername);
        passwordBox = findViewById(R.id.editTextLogInPass);
        signupBtn = findViewById(R.id.btnSignUp);
        loginBtn = findViewById(R.id.btnLogIn);

        db = new DBHandler(this);

        loginUser();
    }

    private void loginUser(){
        //On Click Listeners

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create User Object to Log In
                User user = new User(usernameBox.getText().toString(), passwordBox.getText().toString());
                boolean exists = db.checkUser(user);
                if(exists){
                    //Switch to Logged In Activity
                }else
                {
                    //Error
                }

            }
        });
    }

    private void registerUser(){
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create User Object
                User user = new User(usernameBox.getText().toString(), passwordBox.getText().toString());
                boolean registered = db.registerUser(user);

                if(registered){
                    //Registered
                    Toast.makeText(MainActivity.this, "User Registered.", Toast.LENGTH_SHORT).show();
                }else
                {
                    //Error Message
                    Toast.makeText(MainActivity.this, "Registration Error.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}