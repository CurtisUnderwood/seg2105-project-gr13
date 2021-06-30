package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends Activity {
    TextView idView;
    EditText productBox;
    EditText priceBox;
    EditText Box;
    EditText name;
    Button Delete2;
    ListView productlist;
    ArrayList<String> listItem;
    ArrayAdapter<String> adapter;
    boolean isadministratormod = false;
    private static int o=0;
    private static MDBHandler m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // set variables to the ids of .xml elements
        idView = (TextView) findViewById(R.id.ID);
        productBox = (EditText) findViewById(R.id.username1);
        priceBox = (EditText) findViewById(R.id.password1);
        name = (EditText) findViewById(R.id.name);

        Box = (EditText) findViewById(R.id.teacherorstudent1);
        Delete2 = (Button) findViewById(R.id.Delete2);
        productlist = (ListView) findViewById(R.id.productListView2);
        listItem = new ArrayList<>();

        m = new MDBHandler(this);

    }

    public void administratorMod(View view) {
        if (Box.getText().toString().toLowerCase().equals("administrator")
                && productBox.getText().toString().equals("admin")
                && priceBox.getText().toString().equals("admin123") && !(isadministratormod)) {
            idView.setText("Welcome admin!You are logged in as ‘administrator’.");
            productBox.setText("");
            priceBox.setText("");
            Box.setText("");
            isadministratormod = true;
            viewData();
        } else if (isadministratormod) {
            Toast.makeText(this, "you are exit administratormod", Toast.LENGTH_SHORT).show();
            isadministratormod = false;
            listItem.clear();
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
        } else {
            idView.setText("you are not administrator");
            isadministratormod = false;
        }
    }

    // we use onClick for the Add button in our layout to call this method
    public void newPeople(View view) {
        MDBHandler dbHandler = new MDBHandler(this);

        // get price from the text box
        String price = priceBox.getText().toString();
        People product;
        // get product name from the text box
        // use the constructor from Product.java
        if (Box.getText().toString().toLowerCase().equals("instructor") || Box.getText().toString().toLowerCase().equals("student")) {
            if (!(productBox.getText().toString().toLowerCase().equals("") && priceBox.getText().toString().toLowerCase().equals("") &&
                    name.getText().toString().toLowerCase().equals(""))) {
                if (dbHandler.findProduct(productBox.getText().toString())) {
                    product = new People(productBox.getText().toString(), price, Box.getText().toString(), name.getText().toString());
                    dbHandler.addProduct(product);
                    Toast.makeText(this, "account create successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "the username have been used", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "input cannot be empty", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "you are not in this school", Toast.LENGTH_SHORT).show();
        }

        // add to database with the addProduct() method from MyDBHandler.java


        // clear the text boxes
        productBox.setText("");
        priceBox.setText("");
        priceBox.setText("");
        name.setText("");
        // clearing the list of products
        // calling viewData() method to display the updated list of products
        // this means what is displayed in the ListView is always current
        listItem.clear();
    }

    public void removeProduct(View view) {
        if (isadministratormod) {
            MDBHandler dbHandler = new MDBHandler(this);

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
            } else {
                idView.setText("No Match Found");
            }
        } else {
            idView.setText("you are not in administratormod so you cannot use Delete button");
        }
    }

    private void viewData() {
        MDBHandler dbHandler = new MDBHandler(this);

        // call the viewData() method in MyDBHandler that runs the query
        Cursor cursor = dbHandler.viewData();

        // if there are no products in the table a toast says there is no data to show
        // otherwise, while there are products, keep moving to the next product
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Not data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                // I just want to display the product name so I only get column 1 from the table row
                listItem.add(cursor.getString(1));
            }
            // create an array adapter that provides a view for each item
            // simple_list_item_1 is a built-in xml layout from Android
            // I decided to use this instead of creating my own .xml file for items of the ListView
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItem);

            // attaching the adapter to the ListView
            productlist.setAdapter(adapter);
        }
    }

    public static int getO() {
        if(m!=null) {
            o = m.validate(MainActivity.getX(), MainActivity.getZ());
            return o;
        }else{
            return 0;
        }
    }
}