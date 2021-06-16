package com.example.seg2105_project_gr13;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import android.os.Bundle;

public class AdminActivity extends AppCompatActivity {

    TextView idView;
    EditText courseNameBox;
    EditText courseCodeBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //Element Ids
        idView = (TextView) findViewById(R.id.txtId);
        courseNameBox = (EditText) findViewById(R.id.editTextCourseName);
        courseCodeBox = (EditText) findViewById(R.id.editTextCourseCode);
    }

    //New Course Func
    public void newCourse(View view){
        DBHandler dbHandler = new DBHandler(this);

        //Get Course Code and Name
        String coursecode = courseCodeBox.getText().toString();
        String coursename = courseNameBox.getText().toString();

        Course course = new Course(coursename,coursecode);

        dbHandler.addCourse(course);

        //Clear Boxes
        courseNameBox.setText("");
        courseCodeBox.setText("");

    }

    public void findCourse(View view){
        DBHandler dbHandler = new DBHandler(this);
        //Find Product
        Course course = dbHandler.findCourse(courseCodeBox.getText().toString());

        //If found display, or display no match found
        if(course !=null){
            idView.setText(String.valueOf(course.getID()));
            courseNameBox.setText(String.valueOf(course.getName()));
        }else{
            idView.setText("Course Not Found");
        }

    }

    public void removeCourse(View view){
        DBHandler dbHandler = new DBHandler(this);

        //Delete Product
        boolean result = dbHandler.deleteCourse(courseCodeBox.getText().toString());

        if(result){
            idView.setText("Course Deleted");
            courseCodeBox.setText("");
            courseNameBox.setText("");
        }else
        {
            idView.setText("Course Not Found");
        }
    }
}