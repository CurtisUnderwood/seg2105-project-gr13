package com.example.seg2105_project_gr13;

public class Account {

    private String username, password;

    public Account(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Account(){
        // empty constructor
    }

    public void setPassword(String password) { this.password = password; }

    public void setUsername(String username) { this.username = username; }

    public String getUsername(){ return username; }

    public String getPassword(){ return password; }


}
