package com.example.project;

public class Course {
        private int _id;
        private String _coursecode;
        private String _coursename;
    private String instructorname;
    private String coursedays;
    private String coursehours;
    private String coursedescription;
    private String studentcapacity;

        // constructors
        public Course() {
        }
        public Course(int id, String coursecode, String coursename) {
            _id = id;
            _coursecode = coursecode;
            _coursename = coursename;
        }
        public Course(int id,String coursecode, String coursename,String instructorname, String coursedays,String coursehours, String coursedescription,String studentcapacity) {
            _id = id;
            _coursecode = coursecode;
            _coursename = coursename;
            this.instructorname = instructorname;
            this.coursedays = coursedays;
            this.coursehours = coursehours;
            this.coursedescription = coursedescription;
            this.studentcapacity = studentcapacity;

        }
    public Course(String coursecode, String coursename) {
        _coursecode = coursecode;
        _coursename = coursename;
    }
        // setters and getters
        public void setID(int id) {
            _id = id;
        }
        public int getID() {
            return _id;
        }
        public void setCourseCode(String coursecode) {
            _coursecode = coursecode;
        }
        public String getCourseCode() {
            return _coursecode;
        }
        public void setcourseName(String coursename) {
            _coursename = coursename;
        }
        public String getCourseName() {
            return _coursename;
        }

    public void setinstructorname(String instructorname) {
        this.instructorname = instructorname;
    }
    public String getinstructorname() {
        return instructorname;
    }

    public void setcoursedays(String coursedays) {
        this.coursedays = coursedays;
    }
    public String getcoursedays() {
        return coursedays;
    }

    public void setcoursehours(String coursehours) {
        this.coursehours = coursehours;
    }
    public String getcoursehours() {
        return coursehours;
    }

    public void setcoursedescription(String coursedescription) {
        this.coursedescription = coursedescription; }
    public String getcoursedescription() {
        return coursedescription;
    }

    public void setstudentcapacity(String studentcapacity) {
        this.studentcapacity = studentcapacity;
    }
    public String getstudentcapacity() {
        return studentcapacity;
    }
    }


