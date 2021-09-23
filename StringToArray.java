/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 20, 2021
 * Program Description: Function which takes a string and puts it into an array which stores each word seperately
*/

public class StringToArray {


    /*
     * Method: StringChange
     * Description: Takes a string and puts it into an array which stores each word seperately
     * Parameters: String
     * Returns: String[]
    */
    public static String[] StringChange(String fileDataString)
    {

        int n = 1;
        
        // Create array to store words
        String[] allFileWordsArray = new String[1];

        // Temporary storage of a word
        String temp = "";
            
        String lineString = fileDataString;

        // stores the poem as lowercase letters for simplicity
        String lowerCaseString = lineString.toLowerCase();
        lineString = lineString.toLowerCase();

        // Goes through each character of the string
        for (int j = 0; j < lineString.length(); j++)
        {
            // Adds the letter to the temp variable if it is a letter or apostrophe
            if (lowerCaseString.charAt(j) >= 'a' && lowerCaseString.charAt(j) <= 'z' || lowerCaseString.substring(j, j+1).equals("'"))
            {
                temp += lineString.substring(j, j+1);
                        
            }
            
            else
            {
                if (temp.equals(""))
                {
                }
                // Adds the word to the array
                else
                {
                    // Adds another word into the array by adding an element, returns array with added word
                    allFileWordsArray = AddWordToArray(allFileWordsArray, n, temp);

                    n += 1;
                    temp = "";
                }
            }

        }
                
        return allFileWordsArray;
    }


    /*
     * Method: AddWordToArray
     * Description: Adds another word into the array by adding an element, returns array with added word
     * Parameters: String[] (Array of words), int (n), String (Word to add)
     * Returns: String[]
    */
    public static String[] AddWordToArray(String[] wordArray, int n, String word)
    {

        // Creates new temporary array 1 element larger that the word array
        String[] tempArray = new String[n+1];

        // Copies the words from the word array to the temp array
        for (int i = 0; i < wordArray.length; i++)
        {
            tempArray[i] = wordArray[i];
            
        }

        // Adds new word to new element
        tempArray[n] = word;
        

        return tempArray;
    }
}
