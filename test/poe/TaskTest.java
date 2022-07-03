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
public class TaskTest {
    
    public TaskTest() {
    }

    @Test
    public void testCheckTaskDescription() {
        Task ts = new Task();
        boolean output = ts.checkTaskDescription("Create login to authenticate users");
        assertEquals(true, output);
    }

    @Test
    public void testPrintTaskDetails() {
        Task ts = new Task();
        String expected = ts.printTaskDetails("To-do", "Login feature", "AD:1:BYN", "Create login to authenticate users", "Mike", 0, 0);
        String actual = ts.printTaskDetails(expected, expected, expected, expected, expected, 0, 0);
        assertEquals(expected, actual);
 
    }

    @Test
    public void testReturnTotalHours() {
        Task ts = new Task();
        int expected = ts.returnTotalHours(0, 0);
        int actual = ts.returnTotalHours(0, 0);
        assertEquals(expected, actual);
    
    }

    @Test
    public void testCreateTaskID() {
        Task ts = new Task();
        String expected = ts.createTaskID("Allan", 0, "Fred");
        String actual = ts.createTaskID(expected, 0, expected);
        assertEquals(expected, actual);
    }
    
}
