package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

public class UseInsulinInjectorController {
    @FXML
    void UseInsulinInjector(ActionEvent event) {
       if (Inventory.inventoryStorage.contains("insulininjector")) {
           ItemsDescription.impactGlucoseLevel("insulininjector");
       }
    }
}