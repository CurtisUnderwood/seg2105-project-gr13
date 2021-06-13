package com.example.seg2105_project_gr13;

public class Course {

    private String name, code;

    public Course (String name, String code){
        this.name = name;
        this.code = code;
    }

    public void setName(String name) { this.name = name; }

    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }

    public String getCode() { return code; }

}
