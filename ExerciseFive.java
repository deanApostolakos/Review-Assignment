/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 20, 2021
 * Program Description: Reads a file, stores each word in an array sorted alphabetically using bubble sort,
 * user can enter a word or phrase and the program will return if that word is in the file and its number of occurances.
*/

// Import Scanner
import java.util.Scanner;

// Create Class
class ExerciseFive
{
    // Create main
    public static void main(String[] args)
    {
        // Initialize Scanner
        Scanner reader = new Scanner(System.in);
        // Initialize poem file
        String fileName = "Text File Resources/ICS 4U Assignment 1.2.txt";

        // Takes all the data in the file and stores it in a string
        String fileDataString = FileI.FileInput(fileName);

        // Takes the string and puts it into an array which stores each word
        String[] fileData = StringToArray.StringChange(fileDataString);

        // Corrects an error where the first element in the array is null
        String[] fileDataCorrected = new String[fileData.length - 1];
        for (int j = 0; j < fileData.length - 1; j++)
        {
            fileDataCorrected[j] = fileData[j+1];
        }

        // Sorts the word array using bubble sort
        String[] sortedArray = BubbleSort.BubbleSortAlgo(fileDataCorrected);

        // Start program loop
        ProgramRunLoop(sortedArray, reader);


        reader.close();
    }
            

    /*
     * Method: ProgramRunLoop
     * Description: Runs the program and keeps it running until exited
     * Parameters: String[], Scanner
     * Returns: Void
    */
    public static void ProgramRunLoop(String[] array, Scanner reader)
    {
        // Creates user search loop while running is true
        boolean running = true;
        while(running)
        {      
            // Prompts user to enter a phrase
            System.out.println("Please enter your phrase (all lowercase):");

            String userPhrase = reader.nextLine();

            // Checks for exit parameters
            if (userPhrase.equals("-1"))
            {
                running = false;
                System.out.println("Program Exited");
            }

            // Takes input, checks for errors, if none then it searches for the word in the poem
            else
            {
                boolean errors = LowerCaseCheck.ErrorCheck(userPhrase);

                if (errors == false)
                {
                    WordSearch(array, userPhrase);
                }
                else
                {
                }
            }

        }
    }   
    
    /*
     * Method: WordSearch
     * Description: Searches for certain words and phrases and counts their occurances
     * Parameters: String[], String
     * Returns: Void
    */
    public static void WordSearch(String[] arr, String phrase)
    {   
        int wordCount = 0;

        // Goes through each word in the array and compares it with the phrase
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].equals(phrase)){
                wordCount += 1;
            }
            else
            {
            }
        }

        // If the word is found output that the word was found and output the number of occurances
        if (wordCount > 0)
        {
            System.out.println("Phrase '" + phrase + "' Found");
            System.out.println("This phrase occurs " + wordCount + " times in the poem");
            System.out.println();
        }
        // If the word is not found output that the word was not found
        else
        {
            System.out.println("Phrase '" + phrase + "' Not Found");
            System.out.println("This phrase does not occur in the poem");
            System.out.println();
        }
    }

}
