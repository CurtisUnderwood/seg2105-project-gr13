package com.example.seg2105_project_gr13;

public class User {
    private int _id;
    private String _username;
    private String _password;
    private String _role;

    //constructor
    public User(){

    }

    public User(int id, String username, String password, String role){
        _id = id;
        _username = username;
        _password = password;
        _role = role;
    }

    public User(String username, String password, String role){
        _username = username;
        _password = password;
        _role = role;
    }

    //setters and getters
    public void setID(int id) { _id = id;}
    public int getID() { return _id;}
    public void setUsername(String username) { _username = username;}
    public String getUsername() { return _username;}
    public void setPassword(String password) { _password = password;}
    public String getPassword() { return _password;}
    public void setRole(String role) { _role = role;}
    public String getRole() { return _role;}
}
