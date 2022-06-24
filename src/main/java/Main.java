import java.util.Scanner; //import the scanner class
import java.util.InputMismatchException;
//import java.lang.Math; //import the Math class
import java.util.Random; //import the Random class

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in); // create a scanner object
        // Get user level
        // System.out.println("This is the get user level method");
        try {
            int user1 = getUserLevel(reader);
            // displays the game level to the user
            gameLevel(user1);
        } catch (InputMismatchException ime) {
            System.out.println("This input is not a number");
            return;

        } // close try

        // Get user guess
        // System.out.println("This is the get user input method");
        try {
            int user_guess = getUserInput(reader);

            // Generate random number
            // System.out.println("This is the generate rand number method");
            int num = generateRandomNumber();

            // Determine who wins and displays results
            gameLogic(user_guess, num);

            // display an error message, if the user_guess is not in the desired range.
            if (user_guess > 10 || user_guess < 0) {
                System.out.println(
                        "Error message: Your guess is out of range, please try again with an integer between 1 and 10");
            }
        } catch (InputMismatchException ime) {
            System.out.println("This input is not a number");
            return;
        }
        
        reader.close();// close the scanner

    }// end of main method

    public static int getUserInput(Scanner reader) {
        // this method is used to return the int, given by the user
        // Scanner reader = new Scanner(System.in); // Create a Scanner Object
        System.out.println("Please enter an integer between (1 - 10): "); // print to console
        int user_int = reader.nextInt(); // Read user input
        System.out.println("Your number is: " + user_int); // Output user input
        return user_int; // method returns user input
    }// close getUserInput

    public static int getUserLevel(Scanner reader) {
        // this method is used to return the difficulty level, given by the user
        System.out.println("Select a level to begin: 1 - Easy, 2 - Medium, 3 - Hard"); // print to console
        int user_lvl = reader.nextInt(); // Read user input
        System.out.println("You chose level: " + user_lvl); // output user input to console
        return user_lvl;
    }// close getUserLevel

    public static int generateRandomNumber() {
        // this method is used to generate random number between 1-10
        Random rand = new Random();
        int rand_int1 = rand.nextInt(10);
        System.out.println("System number is: " + rand_int1);
        return rand_int1;

    }// close generateRandomNumber

    public static void gameLevel(int user_lvl) {
        // Create an Array
        String[] gamelevel = {
                "Easy: guess a number - program will tell you if it was higher or equal (you win) or lower (computer wins) than the program's number.",
                "Medium: guess a number - program will tell you if it was strictly higher (you win) or lower or equal (computer wins) than the program's number.",
                "Hard: guess a number - program will tell you if it was equal (you win) or not (you lose) to the program's number." };
        // logic for gamelevel
        if (user_lvl == 1) {
            System.out.println("You chose " + gamelevel[0]);
        } else if (user_lvl == 2) {
            System.out.println("You chose " + gamelevel[1]);
        } else if (user_lvl == 3) {
            System.out.println(" You chose " + gamelevel[2]);
        } else {
            return;
        }
    }// close gameLevel

    public static void gameLogic(int user_int, int rand_int1) {
        // logic for the game
        if (user_int < rand_int1) {
            System.out.println("Sorry! You lose!");
        } else if (user_int >= rand_int1) {
            System.out.println("Congrats! You won!");

        } else {
            return;
        }
    }// close GameLogic

}// close Main Class
