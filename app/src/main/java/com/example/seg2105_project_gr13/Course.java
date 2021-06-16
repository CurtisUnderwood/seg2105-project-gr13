package com.example.seg2105_project_gr13;

public class Course {

    private String name, code;
    private int id;

    public Course(){

    }
    public Course (int id, String name, String code){
        this.name = name;
        this.code = code;
        this.id = id;
    }
    public Course(String name, String code){
        this.name = name;
        this.code = code;
    }


    public void setName(String name) { this.name = name; }

    public void setCode(String code) { this.code = code; }

    public void setID(int id) { this.id = id; }

    public String getName() { return name; }

    public String getCode() { return code; }

    public int getID() { return id; }

}
