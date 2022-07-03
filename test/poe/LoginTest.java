/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static poe.Login.getSet;

/**
 *
 * @author lab_services_student
 */
public class LoginTest {
    
    public LoginTest() {
    
    }

    @Test
    public void testCheckUserName() {
        Login login = new Login();
        boolean output = login.checkUserName("kyl_1");
        assertEquals(true, output);
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        boolean output = login.checkPasswordComplexity("Ch&&sec@ke99");
        assertEquals(true, output);
    }

    @Test
    public void testRegisterUser() {
       Login login = new Login();
       String expected = login.registerUser("Kyle", "Larson", "kyl_1", "Ch&&sec@ke99");
       String actual = login.registerUser(expected, expected, expected, expected);
       assertEquals(expected, actual);
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        boolean output = login.loginUser("kyl_1", "Ch&&sec@ke99");
        assertEquals(false, output);
    }

    @Test
    public void testReturnLoginStatus() {
        Login login = new Login();
        String expected = login.returnLoginStatus(true, "kyl_1");
        String actual = login.returnLoginStatus(true, expected);
        assertEquals(expected, actual);
    }
    
}
