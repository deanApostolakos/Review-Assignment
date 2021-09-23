/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 20, 2021
 * Program Description: Function which reads a file, stores and returns a string with the enire file contents
*/

// Import Scanner, File, and FileNotFoundException
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class FileI{

    /*
     * Method: FileInput
     * Description: Reads a file and stores the contents in a string
     * Parameters: String (File Name)
     * Returns: String
    */
    public static String FileInput(String fileName)
    {
        // Surrounded in a try catch for file not found exceptions
        try 
        {   
            // Initialize the file
            File textFile = new File(fileName);

            // Initialize Scanner
            Scanner fileReader = new Scanner(textFile);

            String totalFileContents = "";

            // Loops through each line of the file until there are none left
            while (fileReader.hasNextLine()) 
            {
                //Reads current line in the file and stores it in a string
                String lineString = fileReader.nextLine();
                    
                totalFileContents += lineString;
                totalFileContents += " ";

            }

            // Close reader
            fileReader.close();

            return totalFileContents;
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return "";
        }
    }
}