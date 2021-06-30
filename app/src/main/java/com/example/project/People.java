package com.example.project;

public class People {
    private int ID;
    private String username;
    private String password;
    private String teacherorstudent;
    private String name;

    // constructors
    public People() {
    }
    public People(int ID, String username, String password,String teacherorstudent,String name) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.teacherorstudent = teacherorstudent;
        this.name=name;
    }
    public People( String username, String password,String teacherorstudent, String name) {
        this.username = username;
        this.password = password;
        this.teacherorstudent = teacherorstudent;
        this.name=name;
    }

    // setters and getters
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public String getUserName() {
        return username;
    }
    public void setPassWord(String password) {
        this.password = password;
    }
    public String getPassWord() {
        return password;
    }
    public void setTeacherOrStudent(String teacherorstudent) {
        this.teacherorstudent = teacherorstudent;
    }
    public String getTeacherOrStudent() {
        return teacherorstudent;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

