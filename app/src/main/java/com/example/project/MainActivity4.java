package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    EditText coursecode;
    EditText coursename;
    EditText detail;
    EditText courseday;
    EditText coursehourstart;
    EditText coursehourend;
    String x;
    String y;
    ListView productlist;
    ArrayList<Course> listItem;
    mAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        coursecode = (EditText) findViewById(R.id.tv10);
        coursename = (EditText) findViewById(R.id.tv11);
        detail = (EditText) findViewById(R.id.tv12);
        productlist= (ListView) findViewById(R.id.ListView);
        courseday= (EditText) findViewById(R.id.tv13);
        coursehourstart= (EditText) findViewById(R.id.tv14);
        coursehourend= (EditText) findViewById(R.id.tv15);
        y=MDBHandler.getP();
        x=MainActivity.getX();
        tv1.setText("Welcome"+ x +"!You are logged in as ‘instructor ’.");
        tv3.setText("name:"+y);
        tv4.setText("username:"+x);
        listItem = new ArrayList<>();

        ArrayList<Course> result = new ArrayList<>();
        MainActivity2 n=MainActivity2.getn();
        MyDBHandler m=new MyDBHandler(n);
        SQLiteDatabase db = m.getReadableDatabase();
        String query = "SELECT * FROM " + "course";

        // passing the query
        Cursor y2 = db.rawQuery(query, null);
        while (y2.moveToNext()) {
            Course x1=new Course(Integer.valueOf(y2.getString(0)),y2.getString(1),y2.getString(2)
                    ,y2.getString(3),y2.getString(4),y2.getString(5),y2.getString(6),
                    y2.getString(7));
            result.add(x1);
        }
        adapter = new mAdapter(this,R.layout.myadapter_layout , result);
        productlist.setAdapter(adapter);
    }
    public void editCoursetime (View view) {
        int m0=0;
        boolean c = true;
        String inputCourseHour = "";
        String inputcourseday = "";

        if (coursecode.getText().toString() != null && coursename.getText().toString() != null && courseday.getText().toString() != null
                && coursehourstart.getText().toString() != null && coursehourend.getText().toString() != null) {
            String z = courseday.getText().toString();
            String w = coursehourstart.getText().toString();
            String d = coursehourend.getText().toString();
            char[] e = w.toCharArray();
            char[] f = d.toCharArray();
            if (!(z.toLowerCase().equals("monday") || z.toLowerCase().equals("tuesday") || z.toLowerCase().equals("thursday")
                    || z.toLowerCase().equals("wednesday") || z.toLowerCase().equals("friday"))) {
                c = false;
            }

            for (int i = 0; i < e.length; i++) {
                if (e.length != 4 && e.length!=5) {
                    c = false;
                    break;
                } else if (!((e[i] <= '9' && e[i] >= '0') || (e[i]==':'))) {
                    c = false;
                    break;
                } else if (e.length == 4 && !((e[0] == '8' ||e[0] == '9'))) {
                    c = false;
                    break;
                }else if (!(e[0]=='1' &&(e[1] <= '8' &&e[1] >= '0'))&& e.length == 5) {
                    c = false;
                    break;
                }
            }
            for (int i = 0; i < f.length; i++) {
                if (f.length!=5) {
                    c = false;
                    break;
                } else if (!((f[i] <= '9' && f[i] >= '0') || (f[i]==':'))) {
                    c = false;
                    break;
                } else if (f[0] == '1' && !((f[1] <= '9' && f[1] >= '0'))) {
                    c = false;
                    break;
                }else if (f[0]=='2' && !(f[1] == '0')) {
                    c = false;
                    break;
                }else if (f[0]>'2') {
                    c = false;
                    break;
                }
            }
            if (c) {
                ArrayList<Course> g = MainActivity2.getcourseafterfindCourse2(coursename.getText().toString(), coursecode.getText().toString());


                inputCourseHour = inputCourseHour + w + " - " + d + " ";
                inputcourseday = inputcourseday + z + " ";
                MainActivity2.getcourseaftereidtCourseHour(coursename.getText().toString(), coursecode.getText().toString(), y, inputCourseHour);
                ArrayList<Course> h = MainActivity2.getcourseaftereidtCourseDay(coursename.getText().toString(), coursecode.getText().toString(), y, inputcourseday);
                m0=1;
                adapter = new mAdapter(this, R.layout.myadapter_layout, h);
                productlist.setAdapter(adapter);


            }
        } else {
            Toast.makeText(this, "course hour end,course hour start,course day, course code and course name cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if(m0!=1){
            Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();
        }
    }
    public void addCoursetime (View view) {
        boolean c = true;
        String inputCourseHour="";
        String inputcourseday="";
        int m0=0;
        if (coursecode.getText().toString() != null && coursename.getText().toString() != null && courseday.getText().toString() != null
                && coursehourstart.getText().toString() != null && coursehourend.getText().toString() != null) {
            String z = courseday.getText().toString();
            String w = coursehourstart.getText().toString();
            String d = coursehourend.getText().toString();
            char[] e = w.toCharArray();
            char[] f = d.toCharArray();
            if(!(z.toLowerCase().equals("monday") || z.toLowerCase().equals("tuesday") || z.toLowerCase().equals("thursday")
                    || z.toLowerCase().equals("wednesday") || z.toLowerCase().equals("friday"))){
                c = false;}

            for (int i = 0; i < e.length; i++) {
                if (e.length != 4 && e.length!=5) {
                    c = false;
                    break;
                } else if (!((e[i] <= '9' && e[i] >= '0') || (e[i]==':'))) {
                    c = false;
                    break;
                } else if (e.length == 4 && !((e[0] == '8' ||e[0] == '9'))) {
                    c = false;
                    break;
                }else if (!(e[0]=='1' &&(e[1] <= '8' &&e[1] >= '0'))&& e.length == 5) {
                    c = false;
                    break;
                }
            }
            for (int i = 0; i < f.length; i++) {
                if (f.length!=5) {
                    c = false;
                    break;
                } else if (!((f[i] <= '9' && f[i] >= '0') || (f[i]==':'))) {
                    c = false;
                    break;
                } else if (f[0] == '1' && !((f[1] <= '9' && f[1] >= '0'))) {
                    c = false;
                    break;
                }else if (f[0]=='2' && !(f[1] == '0')) {
                    c = false;
                    break;
                }else if (f[0]>'2') {
                    c = false;
                    break;
                }
            }
            if (c) {
                ArrayList<Course> g = MainActivity2.getcourseafterfindCourse2( coursename.getText().toString(),coursecode.getText().toString());

                if(g.get(0).getcoursedays()!=null &&g.get(0).getcoursehours()!=null){
                inputCourseHour=inputCourseHour+g.get(0).getcoursehours()+w+" - "+d+" ";
                inputcourseday=inputcourseday+g.get(0).getcoursedays()+z+" ";
                    MainActivity2.getcourseaftereidtCourseHour(coursename.getText().toString(),coursecode.getText().toString(),y,inputCourseHour);
                    ArrayList<Course> h=MainActivity2.getcourseaftereidtCourseDay(coursename.getText().toString(),coursecode.getText().toString(),y,inputcourseday);

                m0=1;
                adapter = new mAdapter(this,R.layout.myadapter_layout , h);
                productlist.setAdapter(adapter);
                }else if(g.get(0).getcoursedays()==null ||g.get(0).getcoursehours()==null){
                        inputCourseHour=inputCourseHour+w+" - "+d+" ";
                        inputcourseday=inputcourseday+z+" ";
                    MainActivity2.getcourseaftereidtCourseHour(coursename.getText().toString(),coursecode.getText().toString(),y,inputCourseHour);
                    ArrayList<Course> h=MainActivity2.getcourseaftereidtCourseDay(coursename.getText().toString(),coursecode.getText().toString(),y,inputcourseday);
                    m0=1;
                        adapter = new mAdapter(this,R.layout.myadapter_layout , h);
                        productlist.setAdapter(adapter);
                    }

            }
        }else {
                Toast.makeText(this, "course hour end,course hour start,course day, course code and course name cannot be empty", Toast.LENGTH_SHORT).show();
            }
        if(m0!=1){
            Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();
        }
        }

    public void changeStudentCapcity (View view) {
        boolean c=true;
        int m0=0;
        if(coursecode.getText().toString()!=null && coursename.getText().toString()!=null &&detail.getText().toString()!=null) {
            String z = detail.getText().toString();
            char[] a = z.toCharArray();
            for (int i = 0; i < a.length; i++) {
                if (a.length > 3) {
                    c = false;
                    break;
                } else if (!(a[i] <= '9' && a[i] >= '0')) {
                    c = false;
                    break;
                } else if (a[0] > '1' && a.length ==3) {
                    c = false;
                    break;
                }
            }
            if (c) {

                ArrayList<Course> d = MainActivity2.getcourseafterStudentCapcity( coursename.getText().toString(),  coursecode.getText().toString(), y, detail.getText().toString());
                if(d!=null){
                    m0=1;
                    adapter = new mAdapter(this,R.layout.myadapter_layout , d);
                    productlist.setAdapter(adapter);
                }else {
                    Toast.makeText(this, "input course name or course error", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "input course name or course error", Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "detail,course code and course name cannot be empty", Toast.LENGTH_SHORT).show();
        }

        if(m0!=1){
            Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();
        }
    }
    public void findCourse(View view) {
        int m0 = 0;
        ArrayList<Course> locallistItem = new ArrayList<>();
        Course q = new Course();
        String op=""+coursecode.getText().toString();
        String po=""+coursename.getText().toString();
        if (op != "" && po != "") {

            ArrayList<Course> d = MainActivity2.getcourseafterfindCourse2(coursename.getText().toString(), coursecode.getText().toString());
            if (d != null) {
                m0 = 1;
                adapter = new mAdapter(this, R.layout.myadapter_layout, d);
                productlist.setAdapter(adapter);
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "input course name or course error", Toast.LENGTH_SHORT).show();
            }
        }
        else if( po != "") {
            ArrayList<Course> e = MainActivity2.getcourseafterfindCourse3(coursename.getText().toString());
            if (e != null) {
                m0 = 1;
                adapter = new mAdapter(this, R.layout.myadapter_layout, e);
                productlist.setAdapter(adapter);
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            }
        }else if( op != "") {
            ArrayList<Course> f = MainActivity2.getcourseafterfindCourse4(coursecode.getText().toString());
            if (f != null) {
                m0 = 1;
                adapter = new mAdapter(this, R.layout.myadapter_layout, f);
                productlist.setAdapter(adapter);
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            }
        }
        if(m0!=1){

                Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();
            }


    }
    public void unassignInstructorname(View view) {
int m0=1;
        if(y!=null && coursecode.getText().toString()!=null && coursename.getText().toString()!=null ){
            ArrayList<Course> z=MainActivity2.getcourseafterunassignCourse(coursename.getText().toString(), coursecode.getText().toString(),y);
            if(z!=null){
                m0=1;
                adapter = new mAdapter(this,R.layout.myadapter_layout , z);
                productlist.setAdapter(adapter);
            }else{
                Toast.makeText(this, "this course hasn't been assign by you or input course name or course error", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "course code and course name cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if(m0!=1){
            Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();
        }
    }
    public void eidtInstructorname(View view) {
        int m0=0;
        if(y!=null && coursecode.getText().toString()!=null && coursename.getText().toString()!=null ){
            ArrayList<Course> x=MainActivity2.getcourseafterassignCourse(coursename.getText().toString(), coursecode.getText().toString(),y);
            if(x!=null){
                m0=1;
                adapter = new mAdapter(this,R.layout.myadapter_layout , x);
                productlist.setAdapter(adapter);
            }else{
                Toast.makeText(this, "this course has been assign by other instructor or input course name or course error", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "course code and course name cannot be empty", Toast.LENGTH_SHORT).show();
        }
        if(m0!=1){
            Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();
        }
    }
    public void eidtCourseDescription(View view) {
        int m0=0;
            if(detail.getText().toString()!=null && coursecode.getText().toString()!=null && coursename.getText().toString()!=null ){
                ArrayList<Course> z=MainActivity2.getcourseafterCourseDescription(coursename.getText().toString(), coursecode.getText().toString(),y,detail.getText().toString());
            if(z==null){
                    Toast.makeText(this, "this course has been assign by you or input course name or course error", Toast.LENGTH_SHORT).show();
                }else{
                m0=1;
                adapter = new mAdapter(this,R.layout.myadapter_layout , z);
                productlist.setAdapter(adapter);
                }
            }else{
                Toast.makeText(this, "detail, course code and course name cannot be empty", Toast.LENGTH_SHORT).show();
            }
        if(m0!=1){
            Toast.makeText(this, "input error", Toast.LENGTH_SHORT).show();
        }
    }


}