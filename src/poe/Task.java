/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;
//this is a task class
import java.util.Scanner;
/**
 *
 * @author lab_services_student
 */
public class Task {
    Scanner sc = new Scanner(System.in);
	//method processes the task description and evaluates whether it meets conditions
	public static boolean checkTaskDescription(String description) {
		
		int descriptionLength = description.length();
		if(descriptionLength <= 50) {
			return true;
		}else
			return false;
			
	}
	//Method Prints details of the tasks
	public String printTaskDetails(String taskStatus, String taskName, String taskID, String taskDes, String devFirstName,int duration, int totalHours) {
		
		String details = "Task name: " + taskName + "\nTask ID:  " + taskID.toUpperCase() + "\nTask Description: " + taskDes + 
				"\nDeveloper details: " + devFirstName + " " + "\nTask Duration: " + duration + "hrs" + "\nTask status: " + taskStatus + "\nTotal hours of tasks: " + totalHours + "hrs";
		return details;
	}
	//returns calculated total hours
	public static int returnTotalHours(int hours, int totalHours) {
		
		totalHours = totalHours + hours;
		
		return totalHours;
	}
	//this method creates the task ID
public static String createTaskID(String task, int taskNo, String name) {
		
		String printStatement;
		char letter1 = task.charAt(0);
		char letter2 = task.charAt(1);
		
		
		char last = name.charAt(name.length() - 1);
		char secondLast = name.charAt(name.length() - 2);
		char thirdLast = name.charAt(name.length() - 3);
		
		printStatement = letter1 + "" + letter2 + ":" + taskNo + ":" + thirdLast + secondLast + last;
		return printStatement;

	}

}


