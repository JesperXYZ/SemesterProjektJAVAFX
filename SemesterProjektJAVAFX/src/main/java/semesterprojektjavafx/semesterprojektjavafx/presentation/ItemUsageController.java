package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

public class ItemUsageController {


    String glucoselevel = String.valueOf(ItemsDescription.getGlucoseLevel());

    @FXML
    void UseInsulinInjector(ActionEvent event) {
       if (Inventory.inventoryStorage.contains("insulininjector"));
            ItemsDescription.impactGlucoseLevel("insulininjector");
    }

    @FXML
    void UseGlucoseMeter(ActionEvent event){

        }


    }
