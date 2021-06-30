package com.example.project;
import android.content.Context;
import android.database.Cursor;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
public class ExampleTest {
    @Test
    public void TestPeople() {
        People x= new People(1, "a", "b","c","d");

        assertEquals("Clickadd failed", "a", x.getUserName());
        assertEquals("Clickadd failed", "b", x.getPassWord());
        assertEquals("Clickadd failed", "c", x.getTeacherOrStudent());
        assertEquals("Clickadd failed", "d", x.getName());


    }
    @Test
    public void TestPeoplesetName() {
        People x= new People(1, "a", "b","c","d");

        assertEquals("Clickadd failed", "a", x.getUserName());
        assertEquals("Clickadd failed", "b", x.getPassWord());
        assertEquals("Clickadd failed", "c", x.getTeacherOrStudent());
        assertEquals("Clickadd failed", "d", x.getName());
        x.setName("e");
        assertEquals("Clickadd failed", "e", x.getName());


    }
    @Test
    public void TestnewProduct() {
        Course x= new Course(1, "a", "b");

        assertEquals("Clickadd failed", "a", x.getCourseCode());
        assertEquals("Clickadd failed", "b", x.getCourseName());
        x.setcourseName("e");
        assertEquals("Clickadd failed", "e", x.getCourseName());


    }

    @Test
    public void TestgetX() {
        MainActivity x= new MainActivity();
        x.setX("a");
        assertEquals("Clickadd failed", "a", x.getX());

    }
    @Test
    public void TestaddProduct1() {
        MainActivity y= new MainActivity();
        MDBHandler x= new MDBHandler(y);
        x.setP("a");
        assertEquals("Clickadd failed", "a", x.getP());

    }

}
