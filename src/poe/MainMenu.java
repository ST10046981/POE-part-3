/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poe;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author lab_services_student
 */
public class MainMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Login login = new Login();
		processMenuOptions();
		
	}
	//Method gives options to register, login or quit
	public static void processMenuOptions() {
		Scanner sc = new Scanner(System.in);
		int option = Integer.parseInt(JOptionPane.showInputDialog(null,"Do you want to register, login or quit\n" + 
				"to register enter 1\nto login enter 2\nto quit enter 3"));
		while(option != 3) {
			if(option == 1) {
				processRegisterOption();
				System.out.println("To register enter 1\nto login enter 2\nto quit enter 3");
				option = sc.nextInt();
			}
			if(option == 2) {
				processLoginOption();
				System.out.println("To quit enter 3");
				option = sc.nextInt();
			}
			
			
		}
		
	}
	// method registers the user
	public static void processRegisterOption() {
		Login login = new Login();
		
		String registerStatus;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String firstname = sc.nextLine();
		System.out.println("Enter your last name: ");
		String lastName = sc.nextLine();
		System.out.println("Enter a user name you intend to use\n" + 
		"ensure that your username is no more than 5 characters and contains an underscore");
		String username = sc.nextLine();
		System.out.println("Enter a strong password you intend to use\n" + 
		"ensure that your password contains at least 8 characters, a capital letter, a special character and a number");
		String password = sc.nextLine();
		
		registerStatus = login.registerUser(firstname, lastName, username, password);
		System.out.println(registerStatus);
	}
	
	//method logs in the user
	public static void processLoginOption() {
		Login login = new Login();
                Task ts = new Task();
		String taskName;
		String devFirstName;
		String devLastName;
		int hours;
		String description;
		int taskStatus;
		String currentStatus = "";
		int taskNumber = 0;
		int totalHours = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your username");
		String username = sc.nextLine();
		System.out.println("Please enter your password");
		String password = sc.nextLine();
		
		boolean loggedIn = login.loginUser(username, password);
		String message = login.returnLoginStatus(loggedIn, username);
		System.out.println(message);
                
                if(loggedIn == true) {
			
		System.out.println("\nEnter 1 to add tasks\n" + "Enter 2 to show report\n" + "Enter 3 to quit");
			int choice = sc.nextInt();
			System.out.println("How many tasks do you expect to do and/or expect(this is so further processing can take place)");
			int numberOfTasks = sc.nextInt();
			String theTaskName[]= new String[numberOfTasks];
			String theDeveloper[] = new String[numberOfTasks];
			int theHours[] = new int[numberOfTasks];
			String theStatus[] = new String[numberOfTasks];
			String theTaskID[] = new String[numberOfTasks];
				if(choice == 1) {
					System.out.println("How many tasks will you be doing");
						numberOfTasks = sc.nextInt();
						for(taskNumber = 0; taskNumber < numberOfTasks; taskNumber++) {
						System.out.println("Enter task name: ");
						sc.nextLine();
						taskName = sc.nextLine();
						theTaskName[taskNumber] = taskName;
						
						System.out.println("Enter task description, it must be less than 50 characters");
						description = sc.nextLine();
						if(ts.checkTaskDescription(description)) {
							System.out.println("Task successfully captured");
							String theDescription[] = new String[numberOfTasks];
							theDescription[taskNumber] = description;
						}
						while(!ts.checkTaskDescription(description)) {
							System.out.println("Please enter a task description, it must be less than 50 characters");
							description = sc.nextLine();
						}
						System.out.println("Enter developer first and last name: ");
						devFirstName = sc.nextLine();
						theDeveloper[taskNumber] = devFirstName;
						
						System.out.println("Enter estimated hours: ");
						hours = sc.nextInt();
						theHours[taskNumber] = hours;
						
						totalHours = ts.returnTotalHours(hours, totalHours);
						System.out.println("Task status:\n1)To-Do\n2)Doing\n3)Done");
						taskStatus = sc.nextInt();
						if(taskStatus == 1) {
							currentStatus = "To-do";
							theStatus[taskNumber] = currentStatus;	
						}
						if(taskStatus == 2) {
							currentStatus = "Doing";
							theStatus[taskNumber] = currentStatus;
						}
						if(taskStatus == 3) {
							currentStatus = "Done";
							theStatus[taskNumber] = currentStatus;
						}
				
						
				
					String taskID = ts.createTaskID(taskName, taskNumber, devFirstName);
					System.out.println(taskID.toUpperCase());
					theTaskID[taskNumber] = taskID;
					
					String print = ts.printTaskDetails(currentStatus, taskName, taskID, description, devFirstName, hours, totalHours);
					JOptionPane.showMessageDialog(null, print);
					
					}	
				}
				
				System.out.println("\nEnter 1 to add tasks\n" + "Enter 2 to show report\n" + "Enter 3 to quit");
				choice = sc.nextInt();
				if(choice == 2) {
					TaskMethods tm = new TaskMethods();
					int pick;
					System.out.println("To see tasks with a status of done enter '6'" +
										"\nTo see the highest duration and developer enter '7'" +
										"\nTo search task details by task name enter '8'" + 
										"\nTo see developer's tasks and status enter '9'" + 
										"\nTo delete a task using task name enter '10'" + 
										"\nTo display a report that lists all details of all tasks enter '11'");
					pick = sc.nextInt();
					
					switch(pick) {
					case 6 :
						for(int i = 0; i < numberOfTasks; i++) {
							if(theStatus[i] == "Done") {
								System.out.println(theDeveloper[i] + ", " + theHours[i] + ", " + theTaskName[i] + "\n");
							}
						}
						break;
					case 7 :
						String statement = tm.nameDuration(theHours, theDeveloper, numberOfTasks);
						System.out.println(statement);
						break;
					case 8 : 
						System.out.println("Enter task name to show the task's developer and status");
						sc.nextLine();
						String input = sc.nextLine();
						String searchT = tm.searchTask(theTaskName, theDeveloper, theStatus, numberOfTasks, input);
						System.out.println(searchT);
						break;
					case 9 :
						System.out.println("Enter the developer's name to get their tasks and task statuses");
						sc.nextLine();
						String devName = sc.nextLine();
						for(int i = 0; i < numberOfTasks; i++) {
							if(theDeveloper[i].equals(devName)) {
								System.out.println(theDeveloper[i] + ":\n" + "Task name: " + theTaskName[i] + "\n" + "Task status: " + theStatus[i] + "\n");
							}
						}
						break;
					case 10 :
						System.out.println("To delete a task enter its task name: ");
						sc.nextLine();
						String delete = sc.nextLine();
						String deletion = tm.deleteTask(theTaskName, numberOfTasks, delete);
						System.out.println(deletion);
						break;
					case 11 :
						tm.displayAllTaskDetails(theTaskName, theDeveloper, theHours, theStatus, theTaskID, numberOfTasks);
						break;
					}
				}
				
				System.out.println("\nEnter 1 to add tasks\n" + "Enter 2 to show report\n" + "Enter 3 to quit");
				choice = sc.nextInt();
				if(choice == 3) {
					System.out.println("Goodbye");
				}
		
			
			}
		
	}

}

	