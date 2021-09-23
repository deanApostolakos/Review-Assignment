/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 22, 2021
 * Program Description: Creates window, displays a slot machine, user can press button to play the slot machine, 
 * images get cycled on screen, the result is displayed, a message appers showing whether the user won or lost
*/

//Java Imports
import java.util.Scanner;
import java.io.IOException;

// Javafx imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;


public class ExerciseSix extends Application
{

    // Main method launches javafx application
    public static void main(String[] args) throws IOException
	{
		// Launches GUI Application
        launch(args);		
	}

    // Start method, where the main program is written
	@Override
    public void start(Stage primaryStage) throws Exception
    {
        
        // Stage the window
        Stage window = primaryStage;

        // Initialize scanner
        Scanner reader = new Scanner(System.in);
        
        // Sets title of window
        window.setTitle("Slots");
		

		// Create grid layout in the window
		GridPane grid = new GridPane();
		grid.setHgap(30);
		grid.setVgap(20);

        // Creates slots title image
        ImageView slotsTitle = ImageUpload.imageUpload("Image Resources/slotstitle.jpg", 300);


        // Button
        // Press play button to play the slots
        Button playButton = new Button("Play");





        // When button pressed, the game is played
        playButton.setOnAction(e -> {

            // Initialize image file names
            String cherriesName = "Image Resources/Cherries.png";
            String sevenName = "Image Resources/7.png";
            String barName = "Image Resources/Bar.png";

            // Store the image names in an array
            String[] imageNameArray = {cherriesName, sevenName, barName};

            // Initialize the empty square image
            String emptySquare = "Image Resources/EmptySquare.png";

            // Store the empty squares in an array
            String[] imageArray = {emptySquare, emptySquare, emptySquare};

            // Initialize image sizes
            int imgSize = 155;

            // Shuffles array of image names making it random
            // each column can have up to 2 bar images, 2 cherry images, and 1 seven image
            imageArray = ShuffleArray.mixUpArray(imageNameArray);
            
            // Create ImageView objects using one image in the leftmost column
            ImageView imageTL = ImageUpload.imageUpload(imageArray[0], imgSize);
            ImageView imageCL = ImageUpload.imageUpload(imageArray[1], imgSize);
            ImageView imageBL = ImageUpload.imageUpload(imageArray[2], imgSize);

            // Stores the images that are in the left column
            String[] leftColumn = {imageArray[0], imageArray[1], imageArray[2]};

            // Shuffles array of image names making it random
            imageArray = ShuffleArray.mixUpArray(imageNameArray);
            
            // Create ImageView objects using one image in the center column
            ImageView imageTC = ImageUpload.imageUpload(imageArray[0], imgSize);
            ImageView imageCC = ImageUpload.imageUpload(imageArray[1], imgSize);
            ImageView imageBC = ImageUpload.imageUpload(imageArray[2], imgSize);

            // Stores the images that are in the center column
            String[] centerColumn = {imageArray[0], imageArray[1], imageArray[2]};

            // Shuffles array of image names making it random
            imageArray = ShuffleArray.mixUpArray(imageNameArray);
            
            // Create ImageView objects using one image in the center column
            ImageView imageTR = ImageUpload.imageUpload(imageArray[0], imgSize);
            ImageView imageCR = ImageUpload.imageUpload(imageArray[1], imgSize);
            ImageView imageBR = ImageUpload.imageUpload(imageArray[2], imgSize);

            // Stores the images that are in the right column
            String[] rightColumn = {imageArray[0], imageArray[1], imageArray[2]};

            // Adds the random images to their spots in the slots
            // Top row of images
            grid.add(imageTL, 2, 1, 1, 1);
            grid.add(imageTC, 3, 1, 1, 1);
            grid.add(imageTR, 4, 1, 1, 1);
            // Center row of images
            grid.add(imageCL, 2, 2, 1, 1);
            grid.add(imageCC, 3, 2, 1, 1);
            grid.add(imageCR, 4, 2, 1, 1);
            // Bottom row of images
            grid.add(imageBL, 2, 3, 1, 1);
            grid.add(imageBC, 3, 3, 1, 1);
            grid.add(imageBR, 4, 3, 1, 1);


            // **Extra Feature**
            // If there is a winning row, column or diagonal, those images are given a gold border on each image
            // Gets the result of any winning rows, columns or diagonals
            String[] winningRow = SlotsResults.rowGameResult(leftColumn, centerColumn, rightColumn);
            String[] winningColumn = SlotsResults.columnGameResult(leftColumn, centerColumn, rightColumn);
            String[] winningDiagonal = SlotsResults.diagonalGameResult(leftColumn, centerColumn, rightColumn);

            // Changes all the regular slot images into ones with borders
            winningRow = goldImageChange(winningRow);
            winningColumn = goldImageChange(winningColumn);
            winningDiagonal = goldImageChange(winningDiagonal);

            /*
             * "nnn" system uses the results found in the gameResult method and describes which row or column won. "n" means none.
             * Reason for this being that multiple rows can win at the same time
             * Example: "01n" == first row, second row, none            or   ==   first column, second column, none
             * Example: "012" == first row, second row, third row       or   ==   first column, second column, third column
             * Example: "nn2" == none, none, third row                  or   ==   none, none, third column
            */
            
            // Whether the player won or lost
            String message = "";

            // Checking for first row win
            if (winningRow[0].equals("0nn") || winningRow[0].equals("01n") || winningRow[0].equals("012") || winningRow[0].equals("0n2"))
            {
                // Uploads the gold winning image
                ImageView goldimageTL = ImageUpload.imageUpload(winningRow[1], imgSize);
                ImageView goldimageTC = ImageUpload.imageUpload(winningRow[1], imgSize);
                ImageView goldimageTR = ImageUpload.imageUpload(winningRow[1], imgSize);
                // Adds the gold image to the scene
                grid.add(goldimageTL, 2, 1, 1, 1);
                grid.add(goldimageTC, 3, 1, 1, 1);
                grid.add(goldimageTR, 4, 1, 1, 1);

                message = "You Win!";
            }
            // Checking for second row win
            if(winningRow[0].equals("n1n") || winningRow[0].equals("01n") || winningRow[0].equals("012") || winningRow[0].equals("n12"))
            {
                // Uploads the gold winning image
                ImageView goldimageCL = ImageUpload.imageUpload(winningRow[2], imgSize);
                ImageView goldimageCC = ImageUpload.imageUpload(winningRow[2], imgSize);
                ImageView goldimageCR = ImageUpload.imageUpload(winningRow[2], imgSize);
                // Adds the gold image to the scene
                grid.add(goldimageCL, 2, 2, 1, 1);
                grid.add(goldimageCC, 3, 2, 1, 1);
                grid.add(goldimageCR, 4, 2, 1, 1);

                message = "You Win!";
            }
            // Checking for third row win
            if(winningRow[0].equals("nn2") || winningRow[0].equals("0n2") || winningRow[0].equals("012") || winningRow[0].equals("n12"))
            {
                // Uploads the gold winning image
                ImageView goldimageBL = ImageUpload.imageUpload(winningRow[3], imgSize);
                ImageView goldimageBC = ImageUpload.imageUpload(winningRow[3], imgSize);
                ImageView goldimageBR = ImageUpload.imageUpload(winningRow[3], imgSize);
                // Adds the gold image to the scene
                grid.add(goldimageBL, 2, 3, 1, 1);
                grid.add(goldimageBC, 3, 3, 1, 1);
                grid.add(goldimageBR, 4, 3, 1, 1);

                message = "You Win!";
            }



            // Checking for first column win
            if (winningColumn[0].equals("0nn") || winningColumn[0].equals("01n") || winningColumn[0].equals("012") || winningColumn[0].equals("0n2"))
            {
                // Uploads the gold winning image
                ImageView goldimageTL = ImageUpload.imageUpload(winningColumn[1], imgSize);
                ImageView goldimageCL = ImageUpload.imageUpload(winningColumn[1], imgSize);
                ImageView goldimageBL = ImageUpload.imageUpload(winningColumn[1], imgSize);
                
                // Adds the gold image to the scene
                grid.add(goldimageTL, 2, 1, 1, 1);
                grid.add(goldimageCL, 2, 2, 1, 1);
                grid.add(goldimageBL, 2, 3, 1, 1);

                message = "You Win!";
                
            }
            // Checking for second column win
            if(winningColumn[0].equals("n1n") || winningColumn[0].equals("01n") || winningColumn[0].equals("012") || winningColumn[0].equals("n12"))
            {
                // Uploads the gold winning image
                ImageView goldimageTC = ImageUpload.imageUpload(winningColumn[2], imgSize);
                ImageView goldimageCC = ImageUpload.imageUpload(winningColumn[2], imgSize);
                ImageView goldimageBC = ImageUpload.imageUpload(winningColumn[2], imgSize);
                // Adds the gold image to the scene
                grid.add(goldimageTC, 3, 1, 1, 1);
                grid.add(goldimageCC, 3, 2, 1, 1);
                grid.add(goldimageBC, 3, 3, 1, 1);

                message = "You Win!";
            }
            // Checking for third column win
            if(winningColumn[0].equals("nn2") || winningColumn[0].equals("0n2") || winningColumn[0].equals("012") || winningColumn[0].equals("n12"))
            {
                // Uploads the gold winning image
                ImageView goldimageTR = ImageUpload.imageUpload(winningColumn[3], imgSize);
                ImageView goldimageCR = ImageUpload.imageUpload(winningColumn[3], imgSize);
                ImageView goldimageBR = ImageUpload.imageUpload(winningColumn[3], imgSize);
                // Adds the gold image to the scene
                grid.add(goldimageTR, 4, 1, 1, 1);
                grid.add(goldimageCR, 4, 2, 1, 1);
                grid.add(goldimageBR, 4, 3, 1, 1);

                message = "You Win!";
            }




            // Checking for first diagonal win
            if (winningDiagonal[0].equals("012"))
            {
                // Uploads the gold winning image
                ImageView goldimageTL = ImageUpload.imageUpload(winningDiagonal[1], imgSize);
                ImageView goldimageCC = ImageUpload.imageUpload(winningDiagonal[1], imgSize);
                ImageView goldimageBR = ImageUpload.imageUpload(winningDiagonal[1], imgSize);
                
                // Adds the gold image to the scene
                grid.add(goldimageTL, 2, 1, 1, 1);
                grid.add(goldimageCC, 3, 2, 1, 1);
                grid.add(goldimageBR, 4, 3, 1, 1);

                message = "You Win!";
            }

            // Checking for second diagonal win
            if (winningDiagonal[0].equals("210"))
            {
                // Uploads the gold winning image
                ImageView goldimageTR = ImageUpload.imageUpload(winningDiagonal[1], imgSize);
                ImageView goldimageCC = ImageUpload.imageUpload(winningDiagonal[1], imgSize);
                ImageView goldimageBL = ImageUpload.imageUpload(winningDiagonal[1], imgSize);
                
                // Adds the gold image to the scene
                grid.add(goldimageTR, 4, 1, 1, 1);
                grid.add(goldimageCC, 3, 2, 1, 1);
                grid.add(goldimageBL, 2, 3, 1, 1);

                message = "You Win!";
            }

            // Decides whether the slots machine won or lost and displays a message in a pop-up window.
            if (message == "")
            {
                message = "You Lost...";
            }

            GameMessage.display(message);

            // End of players spin
        });
 






      

        // Gets empty square image name
        String emptySquare = "Image Resources/EmptySquare.png";
        // Initialize empty square image size in scene
        int imgSize = 150;

        // Uploads the empty square image
        // Left Column
        ImageView imageTL = ImageUpload.imageUpload(emptySquare, imgSize);
        ImageView imageCL = ImageUpload.imageUpload(emptySquare, imgSize);
        ImageView imageBL = ImageUpload.imageUpload(emptySquare, imgSize);
        // Center Column
        ImageView imageTC = ImageUpload.imageUpload(emptySquare, imgSize);
        ImageView imageCC = ImageUpload.imageUpload(emptySquare, imgSize);
        ImageView imageBC = ImageUpload.imageUpload(emptySquare, imgSize);
        // Right Column
        ImageView imageTR = ImageUpload.imageUpload(emptySquare, imgSize);
        ImageView imageCR = ImageUpload.imageUpload(emptySquare, imgSize);
        ImageView imageBR = ImageUpload.imageUpload(emptySquare, imgSize);
        

        // Adds slot title image to scene
        grid.add(slotsTitle, 6, 1, 1, 1);
        
        // Adds empty square image to screen
        // This happens first
        // grid.add(object, x, y, grid width x, grid width y);
        // Top Row
        grid.add(imageTL, 2, 1, 1, 1);
        grid.add(imageTC, 3, 1, 1, 1);
        grid.add(imageTR, 4, 1, 1, 1);
        // Center Row
        grid.add(imageCL, 2, 2, 1, 1);
        grid.add(imageCC, 3, 2, 1, 1);
        grid.add(imageCR, 4, 2, 1, 1);
        // Bottom Row
        grid.add(imageBL, 2, 3, 1, 1);
        grid.add(imageBC, 3, 3, 1, 1);
        grid.add(imageBR, 4, 3, 1, 1);

        // Adds play button to scene
        grid.add(playButton, 6, 2, 1, 1);
        

        // Aligns the grid to the top left of the screen
        grid.setAlignment(Pos.TOP_LEFT);
        
        // Sets an inset around the edges of the window, 25px
        Insets insets = new Insets(25);
        grid.setPadding(insets);
        
		

        // Sets and shows slots game window
        Scene scene = new Scene(grid, 1000, 600);
        window.setScene(scene);   
        window.show();

        // Close reader
        reader.close();
    }


    

    // Replaces the regular slot images with those same images with a gold border indicating a win
    // Takes a String[] and returns a String[]
    public static String[] goldImageChange(String[] winningImages)
    {
        // Creates array to hold gold images
        String[] goldImagesArray = new String[4];

        // First element holds the "nnn" value, so it is added to the new array
        goldImagesArray[0] = winningImages[0];

        // Goes through each value and replaces each image as they appear
        for (int i = 0; i < winningImages.length; i++)
        {
            if (winningImages[i].equals("Image Resources/Cherries.png"))
            {
                winningImages[i] = "Image Resources/goldcherries.png";
            }
            else if (winningImages[i].equals("Image Resources/7.png"))
            {
                winningImages[i] = "Image Resources/gold7.png";
            }
            else if (winningImages[i].equals("Image Resources/Bar.png"))
            {
                winningImages[i] = "Image Resources/goldbar.png";
            }
            else
            {
            }
        }

        goldImagesArray = winningImages;

        // Returns the gold border image array
        return goldImagesArray;
    }
}