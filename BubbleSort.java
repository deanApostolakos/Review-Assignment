/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 20, 2021
 * Program Description: Bubble sorting function, sorts an String array alphabetically
*/

public class BubbleSort {
        
    /*
     * Method: BubbleSortAlgo
     * Description: Sorts the array alphabetically using bubble sort
     * Parameters: String[]
     * Returns: String[]
    */
    public static String[] BubbleSortAlgo(String[] unsortedArray)
    {   
        String[] sortedArray = unsortedArray;
        int n = sortedArray.length;
        String temp;
        
        // Bubble Sort
        // Goes through each element
        for(int i = 0; i < n - 1 ; i++)
        {
            // Compares the current element with the next one and replaces it if the current element is larger
            for (int j = i + 1; j < n; j++)
            {
                // If the element is larger alphabetically the compareTo method returns > 0
                if (sortedArray[i].compareTo(sortedArray[j]) > 0)
                {
                    // Stores the current word in temp
                    temp = sortedArray[i];
                    // Replaces the current words place with the word being compared
                    sortedArray[i] = sortedArray[j];
                    // the current word is moved up to the next spot in the array
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }
}
