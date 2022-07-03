/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class TaskMethodsTest {
    
    public TaskMethodsTest() {
    }

    @Test
    public void testNameDuration() {
       TaskMethods nd = new TaskMethods();
       int theHours[] = new int[1];
       String theDeveloper[] = new String[1];
       String expected = nd.nameDuration(theHours, theDeveloper, 0);
       String actual = nd.nameDuration(new int[1], new String[1], 0);
       assertEquals(expected, actual);
    }

    @Test
    public void testSearchTask() {
         TaskMethods nd = new TaskMethods();
         String theTaskName[] = new String[1];
         String theDeveloper[] = new String[1];
         String theStatus[] = new String[1];
         String expected = nd.searchTask(theTaskName, theDeveloper, theStatus, 0, "Ryan");
         String actual = nd.searchTask(new String[1], new String[1], new String[1], 0, expected);
         assertEquals(expected, actual);
    }

    @Test
    public void testDeleteTask() {
         TaskMethods nd = new TaskMethods();
         String theTaskName[] = new String[1];
         String expected = nd.deleteTask(theTaskName, 0, "create login");
         String actual = nd.deleteTask(new String[1], 0, expected);
         assertEquals(expected, actual);
    }

    @Test
    public void testDisplayAllTaskDetails() {
         TaskMethods nd = new TaskMethods();
    }
    
}
