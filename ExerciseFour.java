/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 20, 2021
 * Program Description: Program reads a file, counts the number of vowels and consonants, and displays the result
*/


// Create Class
class ExerciseFour
{
    // Create main
    public static void main(String[] args)
    {
        String fileName = "Text File Resources/ICS 4U Assignment 1.1.txt";

        String fileData = FileI.FileInput(fileName);
        
        fileData = fileData.toUpperCase(); 
        
        VowelConsonantCount(fileData);

    }
            
    /*
     * Method: VowelConsonantCount
     * Description: Counts the total vowels and consonants in a string and displays the result
     * Parameters: String
     * Returns: Void
    */
    public static void VowelConsonantCount(String fileData)
    {

        int vowelCount = 0;
        int consonantCount = 0;


        for (int i = 0; i < fileData.length(); i++)
        {
            char character = fileData.charAt(i);
            
            if (character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U' || character == 'Y')
            {
                if (character == 'Y')
                {
                    if (fileData.charAt(i+1) == ' ' || fileData.charAt(i+1) == '.' || fileData.charAt(i+1) == ',' || fileData.charAt(i+1) == '!' || fileData.charAt(i+1) == '?')
                    {
                        vowelCount += 1;
                    }
                    else
                    {
                        consonantCount += 1;
                    }
                }
                else
                {
                    vowelCount += 1;
                }
            }
            else
            {
                if (character >= 'B' && character <= 'Z')
                {
                    consonantCount += 1;
                }
            }
            
        }

        System.out.println("The amount of vowels in your program: " + vowelCount);
        System.out.println("The amount of consonants in your program: " + consonantCount);

    }
}
