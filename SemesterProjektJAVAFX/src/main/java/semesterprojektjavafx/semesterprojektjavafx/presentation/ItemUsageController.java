package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.HBox;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;
import javafx.scene.control.Button;

import java.io.IOException;

public class ItemUsageController {
    Button button = new Button("use insulin injector");
    Button glucosemeter = new Button("use glucosemeter");
    HBox hbox = new HBox();
    Label label = new Label(" Tal");

    String glucoselevel = String.valueOf(ItemsDescription.getGlucoseLevel());
    @FXML
    void UseInsulinInjector(ActionEvent event) {
       if (Inventory.inventoryStorage.contains("insulininjector"));
            ItemsDescription.impactGlucoseLevel("insulininjector");

    }

    @FXML
    void UseGlucoseMeter(ActionEvent event){
    //if (Inventory.inventoryStorage.contains("glucosemeter"));
            label.setText(" "+glucoselevel);
        }


    }
