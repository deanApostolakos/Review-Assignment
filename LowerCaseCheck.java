/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 20, 2021
 * Program Description: Function which checks if the input phrase only consists of lowercase letters
*/

public class LowerCaseCheck {
    
    /*
     * Method: ErrorCheck
     * Description: Checks for errors such as entering a number or punctuation
     * Parameters: String
     * Returns: Boolean
    */
    public static boolean ErrorCheck(String phrase)
    {   

        boolean error = false;

        // Goes through each character in the word
        for(int i = 0; i < phrase.length(); i++)
        {
            // Surrounded in try catch so when the character is attemped to be
            // turned into an int it throws an error because it is a string, which means the character passed.
            try
            {
                char tempChar = phrase.charAt(i);
                String tempString = "";
                tempString += tempChar;

                // Exception for apostrophes as they can be used in certain words
                if (tempString.equals("'"))
                {
                }
                // Checks if the character is a punctuation
                else if (tempString.equals(".") || tempString.equals(",") || tempString.equals("!") || tempString.equals("?") || tempString.equals("-") || tempString.equals(";") || tempString.equals(":") || tempString.equals(" "))
                {
                    error = true;
                }
                // Checks if the character is uppercase
                else if ('A' <= tempChar && tempChar <= 'Z')
                {
                    error = true;
                }
                // Checks if the character can be turned into an int
                else
                {
                    int tempInt = Integer.parseInt(tempString);
                    // If the character is able to be an int then the input is incorrect
                    error = true;
                    tempInt = 0;
                }

            }
            catch(Exception e)
            {
            }
        }

        // Shows error message if error is found
        if(error)
        {
            System.out.println("Phrase entered contained character(s) not allowed for search");
            System.out.println("Please enter one word without numbers, punctuation, spaces, or capital letters");
            System.out.println();
        }

        // Returns results of error check
        return error;
    }

}
