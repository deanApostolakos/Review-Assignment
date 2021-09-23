/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 22, 2021
 * Program Description: Creates window, 
*/

//Java Imports
import java.io.IOException;

// Javafx imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ExerciseSeven extends Application
{

	// Initialize label and textfield variables
	Label productOutputLabel = new Label("Here is your ");
	Label changeOutputLabel = new Label("Here is your change: $");

	TextField textField = new TextField();


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
        
        // Sets title of window
        window.setTitle("Vending Machine");

		
		
		// Create grid layout in the scene
		GridPane grid = new GridPane();
		grid.setHgap(20);
		grid.setVgap(20);

		
		// Gets all the info from the vending machine file and stores it in a string
		String allInfo = FileI.FileInput("Text File Resources/VendingMachineInfo.csv");
		
		// Turns the string into an array with the product name in an element and the price in the next element
		String[] infoArray = productStringToArray(allInfo);
		
		// Fixes the array which has a null first element
		String[] allInfoArray = new String[infoArray.length - 1];
        for (int j = 0; j < infoArray.length - 1; j++)
        {
            allInfoArray[j] = infoArray[j+1];
        }

		// Creates two arrays to store the product names and the product prices
		String[] productNameArray = new String[(allInfoArray.length/2)];
		Double[] productPriceArray = new Double[(allInfoArray.length/2)];


		int n = 0;

		// Puts each product name in the array
		for (int i = 0; i < allInfoArray.length; i+=2)
		{
			productNameArray[n] = allInfoArray[i];
			n+=1;
		}
		n = 0;
		// Puts each product price in the array
		for (int j = 1; j < allInfoArray.length; j+=2)
		{
			// Turns the string price into a double
			productPriceArray[n] = Double.parseDouble(allInfoArray[j]);
			n+=1;
		}


		// Creates vending machine image
        ImageView vendingMachine = ImageUpload.imageUpload("Image Resources/vendingmachine.png", 400);
		
		// Assign specific background colour
		Color colour = Color.web("#F4F4F4");
		
		// Sets the propmt text of the textfield
		textField.setPromptText("Enter Money");



        // Buttons
        // Press coke button to order a coke
        Button cokeButton = new Button(productNameArray[0] + "\n$" + productPriceArray[0]);
        cokeButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[0], textField.getText());

			// Sets any output label text on the screen to blank
			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[0]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				// Sets the label colour to black
				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();
			}
			else
			{
			}

		});
		
		// Create pepsi button
		Button pepsiButton = new Button(productNameArray[1] + "\n$" + productPriceArray[1]);
        pepsiButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[1], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[1]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});

		// Create seven up button
		Button sevenupButton = new Button(productNameArray[2] + "\n$" + productPriceArray[2]);
        sevenupButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[2], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[2]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});

		// Create canada dry up button
		Button canadaDryButton = new Button(productNameArray[3] + "\n$" + productPriceArray[3]);
        canadaDryButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[3], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[3]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});

		// Create fanta button
		Button fantaButton = new Button(productNameArray[4] + "\n$" + productPriceArray[4]);
        fantaButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[4], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[4]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});


		// Create mountain dew button
		Button mountainDewButton = new Button(productNameArray[5] + "\n$" + productPriceArray[5]);
        mountainDewButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[5], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[5]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});

		// Create nestea button
		Button nesteaButton = new Button(productNameArray[6] + "\n$" + productPriceArray[6]);
        nesteaButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[6], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[6]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});

		// Create water button
		Button waterButton = new Button(productNameArray[7] + "\n$" + productPriceArray[7]);
        waterButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[7], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[7]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});

		// Create A&W button
		Button aWButton = new Button(productNameArray[8] + "\n$" + productPriceArray[8]);
        aWButton.setOnAction(e -> 
		{
			// Gets the change of the transaction
			double change = CalculateChange.getChange(productPriceArray[8], textField.getText());

			productOutputLabel.setTextFill(colour);
			changeOutputLabel.setTextFill(colour);

			// If the change returned -100 then there was an error and the error message cameup
			if (change != -100)
			{
				// Create output labels
				productOutputLabel = new Label("Here is your " + productNameArray[8]);
				changeOutputLabel = new Label("Here is your change: $" + change);

				productOutputLabel.setTextFill(Color.BLACK);
				changeOutputLabel.setTextFill(Color.BLACK);
				// Add the labels to the scene
				grid.add(productOutputLabel, 3, 7, 5, 1);
				grid.add(changeOutputLabel, 3, 8, 5, 1);
				textField.clear();

			}
			else
			{
			}
		});


		// Upload images of each drink
		ImageView coke = ImageUpload.imageUpload("Image Resources/coke.png", 21);
		ImageView pepsi = ImageUpload.imageUpload("Image Resources/pepsi.png", 28);
		ImageView canadaDry = ImageUpload.imageUpload("Image Resources/canadadry.png", 28);
		ImageView sevenUp = ImageUpload.imageUpload("Image Resources/7up.png", 32);
		ImageView fanta = ImageUpload.imageUpload("Image Resources/fanta.png", 25);
		ImageView mountainDew = ImageUpload.imageUpload("Image Resources/mountaindew.png", 50);
		ImageView nestea = ImageUpload.imageUpload("Image Resources/nestea.png", 26);
		ImageView water = ImageUpload.imageUpload("Image Resources/water.png", 30);
		ImageView aW = ImageUpload.imageUpload("Image Resources/aw.png", 40);



		// Add the vending machine image to scene
		grid.add(vendingMachine, 0, 2, 1, 10);

        // Adds drink buttons and images to scene
        grid.add(cokeButton, 3, 2, 1, 1);
		grid.add(coke, 4, 2, 1, 1);

		grid.add(pepsiButton, 5, 2, 1, 1);
		grid.add(pepsi, 6, 2, 1, 1);

		grid.add(sevenupButton, 7, 2, 1, 1);
		grid.add(canadaDry, 8, 2, 1, 1);

		grid.add(canadaDryButton, 3, 3, 1, 1);
		grid.add(sevenUp, 4, 3, 1, 1);

		grid.add(fantaButton, 5, 3, 1, 1);
		grid.add(fanta, 6, 3, 1, 1);

		grid.add(mountainDewButton, 7, 3, 1, 1);
		grid.add(mountainDew, 8, 3, 1, 1);

		grid.add(nesteaButton, 3, 4, 1, 1);
		grid.add(nestea, 4, 4, 1, 1);

		grid.add(waterButton, 5, 4, 1, 1);
		grid.add(water, 6, 4, 1, 1);

		grid.add(aWButton, 7, 4, 1, 1);
		grid.add(aW, 8, 4, 1, 1);

		// Adds text field to scene
		grid.add(textField, 3, 5, 3, 1);




        // Aligns the grid to the top left of the screen
        grid.setAlignment(Pos.TOP_LEFT);
        
        // Sets an inset around the edges of the window, 50px
        grid.setPadding(new Insets(50));
        
		
        // Sets and shows vending machine window
        Scene scene = new Scene(grid, 1000, 600);
        window.setScene(scene);   
        window.show();
    }



	// productStringToArray method takes a string of data and puts each word seperated by a space into an array element
	// I already made the equivalent of this method in its own class, but it would not have worked for this program
	public static String[] productStringToArray(String fileDataString)
    {

        int n = 1;
        
        // Create array to store string
        String[] allFileWordsArray = new String[1];

        // Temporary storage of a string
        String temp = "";
            
        String lineString = fileDataString;

        // Goes through each character of the string
        for (int j = 0; j < lineString.length(); j++)
        {
            // Adds the character to the temp
            if (lineString.charAt(j) != ' ')
            {
                temp += lineString.substring(j, j+1);       
            }
            
            else
            {
				// Accounts for two word drinks
				if (temp.equals("Canada"))
				{
					temp = "Canada ";
				}
				else if (temp.equals("Mountain"))
				{
					temp = "Mountain ";
				}
                else if (temp.equals(""))
                {
                }
                // Adds the word to the array
                else
                {
                    // Adds another word into the array by adding an element, returns array with added word
                    allFileWordsArray = StringToArray.AddWordToArray(allFileWordsArray, n, temp);

                    n += 1;
                    temp = "";
                }
            }

        }
        // Return the array
        return allFileWordsArray;
    }

}