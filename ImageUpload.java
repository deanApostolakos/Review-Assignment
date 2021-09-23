/*
 * Name: Dean
 * Course: ICS4U1
 * Teacher: Mr. Naccarto
 * Date: September 22, 2021
 * Program Description: Searches for and uploads and image from a file name and creates and returns an ImageView object of
 * the image.
*/

// Import
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageUpload 
{
    public static ImageView imageUpload(String imageFileName, int imageSize)
    {
        
        try {
            //Creating the image object
            InputStream stream = new FileInputStream(imageFileName);
            Image image = new Image(stream);
            //Creating the image view
            ImageView imageView = new ImageView();
            //Setting image to the image view
            imageView.setImage(image);
            //Setting the image view parameters
            imageView.setX(10);
            imageView.setY(10);
            imageView.setFitWidth(imageSize);
            imageView.setPreserveRatio(true);

            // Returns the imageview image object
            return imageView;
        }
        // If the image file is not found
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
