/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 10, 2021
 * Program Description: User enters a string of any character, then each character is printed on its own line
*/

// Import Scanner
import java.util.Scanner;

// Create Class
class ExerciseTwo
{
    // Create main
    public static void main(String[] args)
    {
        // Initialize Scanner
        Scanner reader = new Scanner(System.in);

        // Print directions for user
        System.out.println("Please enter a word or phrase");
        // Take user input
        String userInput = reader.nextLine();

        // Substring the string so each character is printed out once per line
        for (int i = 0; i < userInput.length(); i++){
            System.out.println(userInput.substring(i, i+1));
        }

        // Close reader
        reader.close();
    }
}
