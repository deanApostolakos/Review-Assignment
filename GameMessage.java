/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 22, 2021
 * Program Description: Displays a pop-up window with a message and an ok button.
*/

// Javafx Imports
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class GameMessage 
{

    public static void display(String message){
        // Stages window
        Stage window = new Stage();

        // Sets the title and size of the window
        window.setTitle("Message");
        window.setMinWidth(300);

        // Create new label to display win or loss message
        Label label = new Label();
        label.setText(message);
        

        // Create ok button
        Button okButton = new Button("Ok");
        
        // When the ok button is pressed, the pop-up window closes
        okButton.setOnAction(e -> {
            window.close();
        });

        // Create new vertical box to display the label and button aligned top center
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, okButton);
        layout.setAlignment(Pos.TOP_CENTER);

        // Creates scene, adds the vbox layout and sets scene
        Scene scene = new Scene(layout, 100, 100);
        window.setScene(scene);
        window.showAndWait();
    }
}
