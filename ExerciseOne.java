/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 10, 2021
 * Program Description: Program gets user to input an integer larger than 2, then displays a table with all integers
 * from 0 to the users and a column with all the doubles between 0 and the users number.
*/

// Import Scanner
import java.util.Scanner;

// Create Class
class ExerciseOne
{
    // Create main
    public static void main(String[] args)
    {
        // Initialize Scanner
        Scanner reader = new Scanner(System.in);

        // Print directions for user
        System.out.println("Please enter the number you wish to end with");
        System.out.println("Please enter an integer");

    
        boolean error = true;

        String userInput = "";

        // For the user to re-enter input if their input was incorrect
        while (error == true)
        {
            // Get user input
            userInput = reader.nextLine();
            // Takes input and checks for errors in input type and value
            error = ErrorChecking(reader, userInput);
        }

        // Change input from a string to an int
        int userIntInput = Integer.parseInt(userInput);
        
        PrintTableOfValues(userIntInput);


        // Close reader
        reader.close();

    }

    /*
     * Method: PrintTableOfValues
     * Description: displays a table with all integers from 0 to the users and a column with all the doubles between 0 and the users number.
     * Parameters: Int
     * Returns: Void
    */
    public static void PrintTableOfValues(int userIntInput)
    {
        // Print table title
        System.out.println("Integer     Double");
        System.out.println("__________________");

        // Initialize variables
        int nextInteger = 0;
        double nextDouble = 0.0;

        // While loop runs until the last double in the list is printed
        while (nextDouble <= userIntInput)
        {

            //If the integer column reaches the input value it stops printing the integer and only prints the double
            if (nextInteger > userIntInput)
            {  
                System.out.println("            " + nextDouble);
            }
            // Prints the integer and double values in the table
            else if (nextInteger <= userIntInput)
            {
                System.out.println(nextInteger + "           " + nextDouble);
            }
            // Increase integer and double value for the next row
            nextInteger += 1;
            nextDouble += 0.1;
        }
    }



    /*
     * Method: ErrorChecking
     * Description: Gets the user input and checks for errors in input type and value, then returns a boolean
     * Parameters: Scanner, String
     * Returns: Boolean
    */
    public static boolean ErrorChecking(Scanner reader, String userInput)
    {
        // Encased in a try and catch to check if the user input is an int
        try
        {   
            // Changes the input from string to int to check if the user entered an int
            int integer = Integer.parseInt(userInput);

            // Checks if the user input is greater than 2
            // If less than 2 it returns an error and runs the input and error check again
            if (integer <= 2)
            {
                System.out.println("The number you entered needs to be larger than 2");
                System.out.println("Please enter an integer");
                return true;
            }
            // If the input is greater than 2 it returns no errors and the program continues
            else
            {
                return false;
            }
            
        }
        // Catches exceptions if the user input string cannot be converted into an int
        // Then returns an error  and runs the input and error check again
        catch(Exception e)
        {
            System.out.println("The input you entered needs to be an integer");
            System.out.println("Please enter an integer");
            return true;
        }
        
    }
}
