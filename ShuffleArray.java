/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 22, 2021
 * Program Description: Shuffles an arrays elements around within the array
 * Parameters are a String[]
 * Returns a shuffled String[]
*/

// Import random
import java.util.Random;

public class ShuffleArray 
{
    public static String[] mixUpArray(String[] arr)
    {
        // Initialize random
        Random rand = new Random();

        // Create new array to store mixed values
        String[] mixedArray = new String[3];

        // Goes through the length of the array
        for (int i = 0; i < arr.length; i++)
        {
            // Gets random number from 0 to the length of the array
            int randomNumber = rand.nextInt(arr.length);

            // Adds a random image to each element of the mixed array
            mixedArray[i] = arr[randomNumber];
        }

        // Returns the mixed array
        return mixedArray;
    }
}
