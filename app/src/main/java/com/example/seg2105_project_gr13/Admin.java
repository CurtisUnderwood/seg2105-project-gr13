package com.example.seg2105_project_gr13;

public class Admin extends Account{

    public Admin(){
        super.setUsername("admin");
        super.setPassword("admin123");
    }

    public void createCourse(String name, String code){
        Course c = new Course(name, code);
        // add to database
    }

    public void editCourse(Course c, String name, String code){
        c.setName(name);
        c.setCode(code);
    }

    public void deleteCourse(Course c){
        // delete
    }

    public void deleteAccount(Account ac){
        // delete
    }

}
