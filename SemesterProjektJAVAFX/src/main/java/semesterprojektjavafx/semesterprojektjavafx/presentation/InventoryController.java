package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;
import java.net.URL;

public class InventoryController {
    GridPane gridPane = new GridPane();
    int row = 0;
    int col = 0;
    public void initialize (){
        if (Inventory.inventoryStorage.contains("milk")){
            ImageView milk = new ImageView(getClass().getResource("semesterprojektjavafx/semesterprojektjavafx/billeder/milk.png").toExternalForm());
            gridPane.add(milk,row,col);
            if (col==2){
                col = 0;
                row++;
                }
        }
        if (Inventory.inventoryStorage.contains("icetea")){
            ImageView milk = new ImageView(getClass().getResource("/billeder/icedtea.png").toExternalForm());
            gridPane.add(milk,row,col);
            if (col==2){
                col = 0;
                row++;
            }
        }
        if (Inventory.inventoryStorage.contains("almonds")){
            ImageView milk = new ImageView(getClass().getResource("src/main/resources/semesterprojektjavafx/semesterprojektjavafx/billeder/milk.png").toExternalForm());
            gridPane.add(milk,row,col);
            if (col==2){
                col = 0;
                row++;
            }
        }
        if (Inventory.inventoryStorage.contains("apple")){
            ImageView milk = new ImageView(getClass().getResource("src/main/resources/semesterprojektjavafx/semesterprojektjavafx/billeder/milk.png").toExternalForm());
            gridPane.add(milk,row,col);
            if (col==2){
                col = 0;
                row++;
            }
        }
        if (Inventory.inventoryStorage.contains("glucosemeter")){
            ImageView milk = new ImageView(getClass().getResource("src/main/resources/semesterprojektjavafx/semesterprojektjavafx/billeder/milk.png").toExternalForm());
            gridPane.add(milk,row,col);
            if (col==2){
                col = 0;
                row++;
            }
        }
        if (Inventory.inventoryStorage.contains("insulininjector")){
            ImageView milk = new ImageView(getClass().getResource("src/main/resources/semesterprojektjavafx/semesterprojektjavafx/billeder/milk.png").toExternalForm());
            gridPane.add(milk,row,col);
            if (col==2){
                col = 0;
                row++;
            }
        }

    }
}