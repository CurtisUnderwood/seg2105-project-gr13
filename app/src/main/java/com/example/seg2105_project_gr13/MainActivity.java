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

        Admin a = new Admin();
        boolean registered = db.registerUser(a);

        loginUser();
    }

    private void loginUser(){
        //On Click Listeners

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create User Object to Log In
                String usr = usernameBox.getText().toString(), pword = passwordBox.getText().toString();

                if(usr.equals("admin") && pword.equals("admin123")) { setContentView(R.layout.activity_admin); }

                else{
                    User user = new User(usr, pword);
                    boolean exists = db.checkUser(user);
                    if(exists){
                        //Switch to Logged In Activity
                        setContentView(R.layout.activity_welcome);
                    }
                    else{ //Error
                    }
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
                    setContentView(R.layout.activity_welcome);
                }else
                {
                    //Error Message
                    Toast.makeText(MainActivity.this, "Registration Error.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}