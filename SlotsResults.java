/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 22, 2021
 * Program Description: Determines if there was a row, column, or diagonal line with the same slot images
 * Each method has parameters of string arrays containing the left column, center column, and right column images
 * Each method returns a string containing the "nnn" system I created to know where images lie on each column and row,
 * and the rest of the array hold the image names for each spot.
*/




public class SlotsResults 
{
    public static String[] rowGameResult(String[] leftColumn, String[] centerColumn, String[] rightColumn)
    {
        // Creates array to hold winning values and names
        String[] winningRow = {"nnn", "", "", ""};

        // Checks if the first row is a match
        if (leftColumn[0].equals(centerColumn[0]) && centerColumn[0].equals(rightColumn[0]))
        {
            winningRow[0] = "0nn";
            winningRow[1] =  leftColumn[0];
            // Checks if the first row and second row have a match
            if (leftColumn[1].equals(centerColumn[1]) && centerColumn[1].equals(rightColumn[1]))
            {
                winningRow[0] = "01n";
                winningRow[2] = leftColumn[1];
                // Checks if the first row, second row, and third row have a match
                if (leftColumn[2].equals(centerColumn[2]) && centerColumn[2].equals(rightColumn[2]))
                {
                    winningRow[0] = "012";
                    winningRow[3] = leftColumn[2];
                }
            }
            // Checks if the first row and third row have a match
            else if (leftColumn[2].equals(centerColumn[2]) && centerColumn[2].equals(rightColumn[2]))
            {
                winningRow[0] = "0n2";
                winningRow[2] = leftColumn[2];
            }
            
        }
        // Checks if the second row has a match
        else if (leftColumn[1].equals(centerColumn[1]) && centerColumn[1].equals(rightColumn[1]))
        {
            winningRow[0] = "n1n";
            winningRow[2] =  leftColumn[1];
            // Checks if the second row and third row have a match
            if (leftColumn[2].equals(centerColumn[2]) && centerColumn[2].equals(rightColumn[2]))
            {
                winningRow[0] = "n12";
                winningRow[3] = leftColumn[2];

            }
            
        }
        // Checks if the third row has a match
        else if (leftColumn[2].equals(centerColumn[2]) && centerColumn[2].equals(rightColumn[2]))
        {
            winningRow[0] = "nn2";
            winningRow[3] =  leftColumn[2];
            
        }


        // Returns the results
        return winningRow;

    }



    public static String[] columnGameResult(String[] leftColumn, String[] centerColumn, String[] rightColumn)
    {
        // Does the same thing as the rowGameResult method but for the columns
        String[] winningColumn = {"nnn", "", "", ""};

        if (leftColumn[0].equals(leftColumn[1]) && leftColumn[0].equals(leftColumn[2]))
        {
            winningColumn[0] = "0nn";
            winningColumn[1] =  leftColumn[0];

            if (centerColumn[0].equals(centerColumn[1]) && centerColumn[0].equals(centerColumn[2]))
            {
                winningColumn[0] = "01n";
                winningColumn[2] = centerColumn[0];

                if (rightColumn[0].equals(rightColumn[1]) && rightColumn[0].equals(rightColumn[2]))
                {
                    winningColumn[0] = "012";
                    winningColumn[3] = rightColumn[0];
                }
            }

            else if (rightColumn[0].equals(rightColumn[1]) && rightColumn[0].equals(rightColumn[2]))
            {
                winningColumn[0] = "0n2";
                winningColumn[3] = rightColumn[0];
            }
            
        }

        else if (centerColumn[0].equals(centerColumn[1]) && centerColumn[0].equals(centerColumn[2]))
        {

            winningColumn[0] = "n1n";
            winningColumn[2] =  centerColumn[0];

            if (rightColumn[0].equals(rightColumn[1]) && rightColumn[0].equals(rightColumn[2]))
            {
                winningColumn[0] = "n12";
                winningColumn[3] = rightColumn[0];

            }
            
        }

        else if (rightColumn[0].equals(rightColumn[1]) && rightColumn[0].equals(rightColumn[2]))
        {
            winningColumn[0] = "nn2";
            winningColumn[3] =  rightColumn[2];
            
        }

        // Returns the results
        return winningColumn;

    }



    public static String[] diagonalGameResult(String[] leftColumn, String[] centerColumn, String[] rightColumn)
    {
        String[] winningDiagonal = {"nnn", "", "", ""};

        // Checks if the diagonal images are the same from top left to bottom right
        if (leftColumn[0].equals(centerColumn[1]) && leftColumn[0].equals(rightColumn[2]))
        {
            winningDiagonal[0] = "012";
            winningDiagonal[1] =  leftColumn[0];
            winningDiagonal[2] =  leftColumn[0];
            winningDiagonal[3] =  leftColumn[0];
        }

        // Checks if the diagonal images are the same from top right to bottom left
        else if (leftColumn[2].equals(centerColumn[1]) && leftColumn[2].equals(rightColumn[0]))
        {
            winningDiagonal[0] = "210";
            winningDiagonal[1] =  leftColumn[2];
            winningDiagonal[2] =  leftColumn[2];
            winningDiagonal[3] =  leftColumn[2];
        }

        // Returns the results
        return winningDiagonal;
    }
}
