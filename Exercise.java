package Project;

import java.util.Scanner;

public class Exercise {
    private int id;                 // Unique ID for each exercise
    private static int nextId = 1;  // Static counter for generating unique IDs
    private String name;            // Name of the exercise
    private String category;        // Category of the exercise (e.g., Strength, Cardio)
    private int sets;               // Number of sets
    private int reps;               // Number of repetitions per set
    private double duration;        // Duration of the exercise in minutes
    private String difficulty;      // Difficulty level of the exercise (e.g., Beginner, Intermediate)

    // Array of predefined exercises
    private static final String[][] predefinedExercises = {
		{ "Push-ups", "Strength" }, { "Squats", "Strength" }, { "Deadlifts", "Strength" },
		{ "Bench Press", "Strength" }, { "Running", "Cardio" }, { "Jump Rope", "Cardio" }, { "Cycling", "Cardio" },
		{ "Zumba", "Cardio" }, { "Yoga", "Flexibility" }, { "Hamstring Stretch", "Flexibility" },
		{ "Shoulder Stretch", "Flexibility" },
    };

    // Constructor
    public Exercise(String name, String category, int sets, int reps, double duration, String difficulty) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.sets = sets >= 0 ? sets : 0;         // Ensure non-negative value for sets
        this.reps = reps >= 0 ? reps : 0;         // Ensure non-negative value for reps
        this.duration = duration >= 0 ? duration : 0; // Ensure non-negative value for duration
        this.difficulty = difficulty;
    } // End of constructor

    // Getters
    public int getId() {
        return id;
    } // end of getID

    public String getName() {
        return name;
    } // End of getName

    public String getCategory() {
        return category;
    } // end of getCategory

    public int getSets() {
        return sets;
    } // end of getSets

    public int getReps() {
        return reps;
    } // end of getReps

    public double getDuration() {
        return duration;
    } // end of getDuration

    public String getDifficulty() {
        return difficulty;
    } // end of getDifficulty

    // Start of Setters
    public void setSets(int sets) {
        if (sets >= 0) {
            this.sets = sets;
        } else {
            System.out.println("Number of sets cannot be negative. No changes have been made.");
        }
    } // end of setSets

    public void setReps(int reps) {
        if (reps >= 0) {
            this.reps = reps;
        } else {
            System.out.println("Number of reps cannot be negative. No changes have been made.");
        }
    } // end of setReps

    public void setDuration(double duration) {
        if (duration >= 0) {
            this.duration = duration;
        } else {
            System.out.println("Duration cannot be negative. No changes have been made.");
        }
    } // end of setDuration
    
    // Display predefined exercises
    public static void displayPredefinedExercises() {
        System.out.println("Available Exercises: ");
        for (int i = 0; i < predefinedExercises.length; i++) {
            System.out.println((i + 1) + ". " + predefinedExercises[i][0] + " (" + predefinedExercises[i][1] + ")");
        }
    } // end of displayPredefinedExercises

        public static Exercise selectExercise() {
        Scanner scan = new Scanner(System.in);

        while (true) {
        	int choice;
            try {
                System.out.print("Enter the number of the exercise you'd like to select: ");
                choice = scan.nextInt();

                if (choice > 0 && choice < predefinedExercises.length) {
                    String selected = predefinedExercises[choice-1][0];
                    String type = predefinedExercises[choice-1][1];
                    //scan.close(); // Close scanner
                    System.out.println("You are doing " + selected);
                    return new Exercise(selected, type, 0, 0, 0, "Beginner");
                }
            }
             catch (Exception e) {
            	System.out.println("Invalid selection. Please choose a number between 1 and " + predefinedExercises.length);
                scan.nextLine(); // Clear invalid input
            }
        }
    } // end of selectExercises

    // ToString Method
	@Override
	public String toString() {
		return "Exercise ID: " + id + " | Name: " + name + " | Category: " + category + " | Sets: " + sets + " | Reps: "
				+ reps + " | Duration: " + duration + " mins" + " | Difficulty: " + difficulty;
	} // end of toString

    // Test Method
	public static void testExercise() {
	    displayPredefinedExercises(); // Show the predefined list
	    Exercise selectedExercise = selectExercise(); // User can choose
	    System.out.println("Exercise selected: " + selectedExercise);

	    // Testing setters
	    selectedExercise.setSets(5);
	    selectedExercise.setReps(12);
	    selectedExercise.setDuration(30.0);
	    System.out.println("Updated Exercise: " + selectedExercise);

	    // Invalid input tests
	    selectedExercise.setSets(-1);
	    selectedExercise.setReps(-5);
	    selectedExercise.setDuration(-10.0);
	} // end of testExercise
} // end of Exercise
