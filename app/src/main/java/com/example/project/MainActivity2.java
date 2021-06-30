package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends Activity {

    TextView idView;
    EditText productBox;
    EditText priceBox;
    ListView productlist;
    ArrayList<Course> listItem;
    mAdapter adapter;
    private static MyDBHandler m;
    private static ArrayList<Course> course;
    private static MainActivity2 n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // set variables to the ids of .xml elements
        idView = (TextView) findViewById(R.id.ID);
        productBox = (EditText) findViewById(R.id.coursecode);
        priceBox = (EditText) findViewById(R.id.coursename);
        productlist = (ListView) findViewById(R.id.productListView);

        MyDBHandler dbHandler = new MyDBHandler(this);
        listItem = new ArrayList<>();

        // call the viewData() method to display the existing products
        viewData();
        m = new MyDBHandler(this);
        course= new ArrayList<>();
        n=this;
    }

    public static MainActivity2 getn(){
        return n;
    }
    public static ArrayList<Course> getcourseaftereidtCourseHour(String coursename, String coursecode,String instructorname,String CourseHour){
        course=m.eidtCourseHour ( coursename,  coursecode, instructorname, CourseHour);

        return course;
    }

    public static ArrayList<Course> getcourseaftereidtCourseDay(String coursename, String coursecode,String instructorname,String CourseDay){
        course=m.eidtCourseDay ( coursename,  coursecode, instructorname, CourseDay);

        return course;
    }

    public static ArrayList<Course> getcourseafterStudentCapcity(String coursename, String coursecode,String instructorname,String StudentCapcity){
            course=m.eidtStudentCapcity ( coursename,  coursecode, instructorname, StudentCapcity);

        return course;
    }

    public static ArrayList<Course> getcourseafterCourseDescription(String coursename, String coursecode,String instructorname,String CourseDescription){
            course=m.eidtCourseDescription( coursename,  coursecode, instructorname, CourseDescription);

        return course;
    }
    public static ArrayList<Course> getcourseafterunassignCourse(String coursename, String coursecode,String instructorname){
            course=m.unassignCourse( coursename,  coursecode, instructorname);

        return course;
    }
    public static ArrayList<Course> getcourseafterassignCourse(String coursename, String coursecode,String instructorname){
        course=m.assignCourse( coursename,  coursecode, instructorname);

        return course;
    }

    public static ArrayList<Course> getcourseafterfindCourse2(String coursename, String coursecode){

        course=m.findCourse2( coursename,  coursecode);

        return course;
    }
    public static ArrayList<Course> getcourseafterfindCourse3(String coursename){

        course=m.findCourse3( coursename);

        return course;
    }
    public static ArrayList<Course> getcourseafterfindCourse4(String coursecode){

        course=m.findCourse4(coursecode);

        return course;
    }
    public void newProduct1 (String price,String productBox) {
        MyDBHandler dbHandler = new MyDBHandler(this);
        Course product = new Course(productBox, price);

        // add to database with the addProduct() method from MyDBHandler.java
        dbHandler.addProduct(product);
    }
    // we use onClick for the Add button in our layout to call this method

    public void newProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        // get price from the text box
        if(!(productBox.getText().toString().equals("") || priceBox.getText().toString().equals(""))) {
            if (dbHandler != null) {
                Cursor varify = dbHandler.findCourse(priceBox.getText().toString(),productBox.getText().toString());
                if (varify == null) {
                    String price = priceBox.getText().toString();

                    // get product name from the text box
                    // use the constructor from Product.java
                    Course product = new Course(productBox.getText().toString(), price);

                    // add to database with the addProduct() method from MyDBHandler.java
                    dbHandler.addProduct(product);

                    // clear the text boxes
                    productBox.setText("");
                    priceBox.setText("");

                    // clearing the list of products
                    // calling viewData() method to display the updated list of products
                    // this means what is displayed in the ListView is always current
                    listItem.clear();
                    viewData();

                } else if (!(varify.moveToFirst())) {
                    String price = priceBox.getText().toString();

                    // get product name from the text box
                    // use the constructor from Product.java
                    Course product = new Course(productBox.getText().toString(), price);

                    // add to database with the addProduct() method from MyDBHandler.java
                    dbHandler.addProduct(product);

                    // clear the text boxes
                    productBox.setText("");
                    priceBox.setText("");

                    // clearing the list of products
                    // calling viewData() method to display the updated list of products
                    // this means what is displayed in the ListView is always current
                    listItem.clear();
                    viewData();
                } else {
                    Toast.makeText(this, "course code and course name are already exist", Toast.LENGTH_SHORT).show();
                }
            } else if (dbHandler == null) {
                String price = priceBox.getText().toString();

                // get product name from the text box
                // use the constructor from Product.java
                Course product = new Course(productBox.getText().toString(), price);

                // add to database with the addProduct() method from MyDBHandler.java
                dbHandler.addProduct(product);

                // clear the text boxes
                productBox.setText("");
                priceBox.setText("");

                // clearing the list of products
                // calling viewData() method to display the updated list of products
                // this means what is displayed in the ListView is always current
                listItem.clear();
                viewData();
            }
        }else{
            Toast.makeText(this, "course code and course name can't be empty", Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
        startActivity(intent);
        m = new MyDBHandler(this);
    }

    // we use onClick for the Find button in our layout to call this method
    public void editCourse (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        // get product in the database using findProduct() method from MyDBHandler.java
        dbHandler.editProduct(productBox.getText().toString(),priceBox.getText().toString());

        // if found, then display the product details
        // if not, display "No Match Found"

            idView.setText(String.valueOf(""));
            productBox.setText("");
            priceBox.setText(String.valueOf(""));

        listItem.clear();
        viewData();
        Intent intent=new Intent(MainActivity2.this , MainActivity2.class);
        startActivity(intent);
        m = new MyDBHandler(this);
    }

    // we use onClick for the Delete button in our layout to call this method
    public void removeProduct (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this);

        // delete product in the database using deleteProduct() method from MyDBHandler.java
        boolean result = dbHandler.deleteProduct(productBox.getText().toString());

        // clearing the list of products
        // calling viewData() method to display the updated list of products
        // this means what is displayed in the ListView is always current
        listItem.clear();
        viewData();

        // "Record Deleted" or "No Match Found"
        if (result) {
            idView.setText("Record Deleted");
            productBox.setText("");
            priceBox.setText("");
        }
        else
            idView.setText("No Match Found");
        Intent intent=new Intent(MainActivity2.this , MainActivity2.class);
        startActivity(intent);
        m = new MyDBHandler(this);
    }

    private void viewData(){
        MyDBHandler dbHandler = new MyDBHandler(this);

        // call the viewData() method in MyDBHandler that runs the query
        Cursor cursor = dbHandler.viewData();

        // if there are no products in the table a toast says there is no data to show
        // otherwise, while there are products, keep moving to the next product
        if(cursor.getCount() == 0){
            Toast.makeText(this, "Not data to show", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                // I just want to display the product name so I only get column 1 from the table row
                Course x=new Course(Integer.valueOf(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                listItem.add(x);
            }
            // create an array adapter that provides a view for each item
            // simple_list_item_1 is a built-in xml layout from Android
            // I decided to use this instead of creating my own .xml file for items of the ListView
            adapter = new mAdapter(this,R.layout.myadapter_layout , listItem);

            // attaching the adapter to the ListView
            productlist.setAdapter(adapter);
        }
    }

}