// Zachery Stout
// INFO-C 211

package Project;

import java.util.Scanner;
import java.util.ArrayList;

public class tracker {
	// Variables and array lists
	static int logIn = -1;
	static Scanner scan = new Scanner(System.in);
	static ArrayList<UserProfile> profileList = new ArrayList<>();
	
	// Adding a new profile to the profileList
	public static void addNewProfile(ArrayList<UserProfile> profileList2) {
		System.out.println("Please enter your name: ");
		String newName = scan.next();
		System.out.println("Please enter your age: ");
		int newAge = scan.nextInt();
		System.out.println("Please enter your weight(kgs): ");
		double newWeight = scan.nextDouble();
		
		UserProfile newUser = new UserProfile(newName, newAge, newWeight);
		profileList.add(newUser);
		
	}
	
	// Adding a log in class to give the user a more personal experience
	public static int logIn(ArrayList<UserProfile> list) {
		int count = 0;
		System.out.println("Please select your profile: ");
		for(UserProfile UserProfile: profileList ) {
			System.out.println(count + ": " + UserProfile.getUserName());
			count++;
		}
		logIn = scan.nextInt();
		while(logIn < 0 || logIn > profileList.size()-1) {
			System.out.println("User not found. Please try again.");
			logIn = scan.nextInt();
		}
		
		return logIn;
	}
	
	public static void main(String[] args) {
		// Adding variables and profiles
		boolean active = true;
		int choice;
		profileList.add(new UserProfile("Shawn", 23, 55.25));
		profileList.add(new UserProfile("Angelica", 29, 42.00));
		profileList.add(new UserProfile("Mark", 31, 102.00));
		
		// This while loop is the main program that asks a the user what they would like to do.
		while(active == true) {
			if(logIn == -1) {
				choice = -1;
				System.out.println("Hello, what would you like to do?");
				System.out.println("1.Create a profile \n2.Select a profile \n0.Exit Program");
				choice = scan.nextInt();
				switch(choice) {
					case 0:
						active = false;
						break;
					case 1:
						addNewProfile(profileList);
						break;
					case 2:
						logIn(profileList);
					default:
						System.out.println("Incorrect input, please try again.");
						break;
				}
			}	
			// This while loop is when a user is logged in
			while (logIn != -1) {
				choice = -1;
				System.out.println("Hello " + profileList.get(logIn).getUserName() + "!");
				System.out.println("What would you like to do today?");
				System.out.println("1.View exercises \n2.Select exercise \n3.Log out \n0.Exit program");
				choice = scan.nextInt();
				switch(choice) {
					case 0:
						logIn = -1;
						active = false;
						break;
					case 1:
						Exercise.displayPredefinedExercises();
						break;
					case 2:
						Exercise.selectExercise();
						break;
					case 3:
						logIn = -1;
						break;
					default:
						System.out.println("Invalid option. Please try again.");
					}
			}
		}
	}	
}
