/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 10, 2021
 * Program Description: Reads a file, counts the number of characters, excluding white spaces, then displays the resultz
*/

// Import Scanner, File, and FileNotFoundException
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Create Class
class ExerciseThree
{
    // Create main
    public static void main(String[] args)
    {

        // Surrounded in a try catch for file not found exceptions
        try 
        {   
            // Initialize the file
            File textFile = new File("Text File Resources/ICS 4U Assignment 1.1.txt");

            // Initialize Scanner
            Scanner fileReader = new Scanner(textFile);

            int characterCount = CountCharacters(fileReader);

            // Prints total characters
            System.out.println("There are " + characterCount + " characters in the poem.");

            // Close reader
            fileReader.close();
		
		} 
        // Throws an error if the file is not found
        catch (FileNotFoundException e) 
        {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

    /*
     * Method: CountCharacters
     * Description: Goes through each line of the file, counts and totals each character
     * Parameters: Scanner (File Reader Scanner)
     * Returns: Int
    */
    public static int CountCharacters(Scanner fileReader)
    {
        
        // Create variable to count characters
        int characterCount = 0;

        // Loops through each line of the file until there are none left
        while (fileReader.hasNextLine()) 
        {
            //Reads current line in the file and stores it
            String lineString = fileReader.nextLine();
        
            // Adds number of characters in line to the total
            characterCount += lineString.length();
                        
            // Goes through each character in the line
            // If it finds a blank space it subtracts one character from the total
            for (int i = 0; i < lineString.length(); i++)
            {
                if (lineString.substring(i,i+1).equals(" "))
                {
                    characterCount -= 1;
                }
                else
                {
                }
            }
        }

        return characterCount;
    }
}
