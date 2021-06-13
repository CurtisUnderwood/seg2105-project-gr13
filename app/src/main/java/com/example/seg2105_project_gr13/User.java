package com.example.seg2105_project_gr13;

public class User {
    private int _id;
    private String _username;
    private String _password;

    //constructor
    public User(){

    }

    public User(int id, String username, String password){
        _id = id;
        _username = username;
        _password = password;
    }

    public User(String username, String password){
        _username = username;
        _password = password;
    }


    //setters and getters
    public void setID(int id) { _id = id;}
    public int getID() { return _id;}
    public void setUsername(String username) { _username = username;}
    public String getUsername() { return _username;}
    public void setPassword(String password) { _password = password;}
    public String getPassword() { return _password;}
}
