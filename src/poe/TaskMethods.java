/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;

/**
 *
 * @author lab_services_student
 */
public class TaskMethods {
    public static String nameDuration(int[] theHours, String[] theDeveloper, int numberOfTasks) {
		int max = theHours[0];
		String dev = theDeveloper[0];
		String statement;
		for(int i = 0; i < numberOfTasks; i++) {
			if(theHours[i] > max) {
				max = theHours[i];
				dev = theDeveloper[i];
			}
		}
		statement = "Developer: " + dev + ", " + max + "hrs";
		return statement;
	}
	
	public static String searchTask(String[] theTaskName,String[] theDeveloper, String[] theStatus, int numberOfTasks, String input) {
		String theTask;
		String td = theDeveloper[0];
		String ts = theStatus[0];
		for(int i = 0; i < numberOfTasks; i++) {
			if(theTaskName[i].equals(input)) {
				td = theDeveloper[i];
				ts = theStatus[i];
			}		
		}
		theTask = "Developer: " + td + "\n" + "Task status: " + ts;
		return theTask;
	}
	
	public static String deleteTask(String[] theTaskName, int numberOfTasks, String delete) {
		String dTask;
		String d = theTaskName[0];
		for(int i = 0; i < numberOfTasks; i++) {
			if(theTaskName[i].equals(delete)) {
				d = theTaskName[i];
			}
		}
		dTask = "Entry " + d + " has been successfully deleted";
		return dTask;
	}
	
	public static void displayAllTaskDetails(String[] theTaskName, String[] theDeveloper, int[] theHours, String[] theStatus, String[] theTaskID, int numberOfTasks) {
		for(int i = 0; i < numberOfTasks; i++) {
			System.out.println("Task Name: " + theTaskName[i]);
			System.out.println("Developer: " + theDeveloper[i]);
			System.out.println("Duration: " + theHours[i]);
			System.out.println("Task status: " + theStatus[i]);
			System.out.println("Task Id: " + theTaskID[i] + "\n");
		}
	}
	


}

