/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;
//This class acts to store and retrieve user credentials
/**
 *
 * @author lab_services_student
 */
public class User {
    //Private fields declared to null
	private String userFirstName;
	private String userLastName;
	private String userUsername;
	private String userPassword;
	
	//access methods
	public String getUserFirstName() {
		return userFirstName;
	}
	
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getUserLastName() {
		return userLastName;
	}
	
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	
	public String getUserUsername() {
		return userUsername;
	}
	
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}

