/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//This class has methods used to test user credentials and status

/**
 *
 * @author lab_services_student
 */
public class Login {
    public static User getSet = new User();
	
	public static boolean checkUserName(String username) //This method checks that the user name entered meets the rules 
	{
		int userLength = username.length();
		
		if(userLength <= 5)
		{
		Pattern underscore = Pattern.compile("[_]");
		Matcher hasUnderscore = underscore.matcher(username);
		return  hasUnderscore.find();
		}else
			return false;
	} 
	
	public static boolean checkPasswordComplexity(String password) //This method checks that the entered password meets the rules
	{
		int length = password.length(); 
		
		if(length >= 8)
		{
		Pattern letter = Pattern.compile("[A-Z]");//sets condition that the entered password must follow
		Pattern digit = Pattern.compile("[0-9]");//sets condition that the entered password must follow
		Pattern special = Pattern.compile("[!@#$%^&*()_+=|<>?{}\\[\\]~-]");//sets condition that the entered password must follow
		
		Matcher hasLetter = letter.matcher(password);//matches the condition with the password
		Matcher hasDigit = digit.matcher(password);//matches the condition with the password
		Matcher hasSpecial = special.matcher(password);//matches the condition with the password
		
		return hasLetter.find() && hasDigit.find() && hasSpecial.find();
		}
		else
			return false;
		
	}
	//This method returns messages regarding registration process and sets user credentials if approved
	public String registerUser(String firstName, String lastName, String username, String password) {
		

		String USERNAME_SUCCESS = "Username successfully captured\n";
		String USERNAME_ERROR = "Username is not correctly formatted, ensure that username is not above 5 characters and contains an underscore\n";
		String PASSWORD_SUCCESS = "Password successfully captured";
		String PASSWORD_ERROR = "Password is not correctly formatted, ensure that it contains at least 8 characters, a capital letter, a special character and a number";
		String registrationMessage = "";
		
		if(!checkUserName(username))
			registrationMessage += USERNAME_ERROR + "\n";
		
		if(!checkPasswordComplexity(password))
			registrationMessage += PASSWORD_ERROR + "\n";
		
		if(registrationMessage.equals("")) {
			getSet.setUserFirstName(firstName);
			getSet.setUserLastName(lastName);
			getSet.setUserUsername(username);
			getSet.setUserPassword(password);
			
			registrationMessage = USERNAME_SUCCESS + "\n" + PASSWORD_SUCCESS + "\n";
		}
		return registrationMessage;
	}
	
	//This method logs in user by checking if credentials match with those entered during registration
	public static boolean loginUser(String username, String password) {
		
		
		boolean valid = false;
		
		if((username.equals(getSet.getUserUsername()) && password.equals(getSet.getUserPassword()))){
				valid = true;	
		} return valid;
	}
	//Method responsible for returning the users login status
	public String returnLoginStatus(boolean loggedIn, String username) {
		
		String loginMessageStatus;
		
		if(loggedIn) {
			loginMessageStatus = "Welcome " + getSet.getUserFirstName() + " " + getSet.getUserLastName() + " It's great to see you again";
		}else {
			loginMessageStatus = "Username or password incorrect, " + "Please try again";
		}return loginMessageStatus;
	}
	


}

