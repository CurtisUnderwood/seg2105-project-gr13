package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class mAdapter extends ArrayAdapter<Course> {
    private Context mContext;
    int mResource;
    ArrayList<Course> x;
    public mAdapter(Context context, int resource, ArrayList<Course> objects){
        super(context,resource,objects);
        mContext=context;
        mResource=resource;
        this.x=objects;

    }
    @Override
    public View getView(int position,View convertview,ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertview=inflater.inflate(mResource,parent,false);
        int ID=getItem(position).getID();
        String CourseCode=getItem(position).getCourseCode();
        String CourseName=getItem(position).getCourseName();

        String instructorname=getItem(position).getinstructorname();
        String coursedays=getItem(position).getcoursedays();
        String coursehours=getItem(position).getcoursehours();
        String coursedescription=getItem(position).getcoursedescription();
        String studentcapacity=getItem(position).getstudentcapacity();


        TextView tvID=(TextView) convertview.findViewById(R.id.t0);
        TextView tvCourseCode=(TextView) convertview.findViewById(R.id.t1);
        TextView tvCourseName=(TextView) convertview.findViewById(R.id.t2);

        TextView tvstudentcapacity=(TextView) convertview.findViewById(R.id.t3);
        TextView tvinstructorname=(TextView) convertview.findViewById(R.id.t7);

        TextView tvcoursedays=(TextView) convertview.findViewById(R.id.t4);
        TextView tvcoursehours=(TextView) convertview.findViewById(R.id.t5);
        TextView tvcoursedescription=(TextView) convertview.findViewById(R.id.t6);

        tvID.setText(""+ID);
        tvCourseCode.setText(CourseCode);
        tvCourseName.setText(CourseName);

        tvstudentcapacity.setText(studentcapacity);
        tvinstructorname.setText(instructorname);
        tvcoursedays.setText(coursedays);
        tvcoursehours.setText(coursehours);
        tvcoursedescription.setText(coursedescription);

        return convertview;
    }
}
