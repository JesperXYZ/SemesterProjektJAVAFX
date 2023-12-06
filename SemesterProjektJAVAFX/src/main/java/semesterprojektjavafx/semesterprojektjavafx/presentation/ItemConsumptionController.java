package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandConsume;
import semesterprojektjavafx.semesterprojektjavafx.domain.Game;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;
import semesterprojektjavafx.semesterprojektjavafx.domain.Space;

import java.io.IOException;

public class ItemConsumptionController {
    @FXML
    MenuItem item1;
    @FXML
    MenuItem item2;
    @FXML
    MenuItem item3;
    @FXML
    MenuItem item4;
    @FXML
    MenuButton Consume;

    public void initialize() {
        Consume.setText("Consume");
        updateItemVisibilityAll();
    }

    private void updateItemVisibility(String itemName, MenuItem item) {
        if (Inventory.inventoryStorage.contains(itemName)) {
            item.setVisible(true);
            item.setText(itemName);
        } else {
            item.setVisible(false);
        }
    }

    private boolean hasEdibleItems() {
        return Inventory.inventoryStorage.contains("milk") ||
                Inventory.inventoryStorage.contains("ice tea") ||
                Inventory.inventoryStorage.contains("almonds") ||
                Inventory.inventoryStorage.contains("apple");
    }

    public void updateItemVisibilityAll() {
        if (hasEdibleItems()) {
            updateItemVisibility("milk", item1);
            updateItemVisibility("ice tea", item2);
            updateItemVisibility("almonds", item3);
            updateItemVisibility("apple", item4);
        } else {
            item1.setDisable(true);
            item2.setVisible(false);
            item3.setVisible(false);
            item4.setVisible(false);
            item1.setText("You currently have no food or drink.");
        }
    }

    @FXML
    void consumeItem1(ActionEvent event) throws IOException {
        consumeItem("milk");
        reloadScene(event);
    }

    @FXML
    void consumeItem2(ActionEvent event) throws IOException {
        consumeItem("ice tea");
        reloadScene(event);
    }

    @FXML
    void consumeItem3(ActionEvent event) throws IOException {
        consumeItem("almonds");
        reloadScene(event);
    }

    @FXML
    void consumeItem4(ActionEvent event) throws IOException {
        consumeItem("apple");
        reloadScene(event);
    }

    private void consumeItem(String itemName) throws IOException {
        CommandConsume commandConsume = new CommandConsume();
        if (Inventory.inventoryStorage.contains(itemName)) {
            commandConsume.consumeWhat(itemName);
        }
        updateItemVisibilityAll();
    }

    private void reloadScene(ActionEvent event) throws IOException {
        //Logic to convert the currentSpaceName to the absolute path of its fxml file
        Space currentSpace = Game.context.getCurrent();
        String currentSpaceName = currentSpace.getName();
        String nameWithoutTHE;
        if (currentSpaceName.contains("The ")) {
            nameWithoutTHE = currentSpaceName.substring(4);
        } else {
            nameWithoutTHE = currentSpaceName;
        }
        String nameWithoutTHELowerCase = nameWithoutTHE.toLowerCase();
        String nameWithoutTHELowerCaseWithoutSpace = nameWithoutTHELowerCase.replace(" ", "");
        String nameWithoutTHELowerCaseWithoutSpace2;
        if (nameWithoutTHELowerCaseWithoutSpace.contains("entry")) {
            nameWithoutTHELowerCaseWithoutSpace2 = "houseEntry";
        } else if (nameWithoutTHELowerCaseWithoutSpace.contains("party")) {
            nameWithoutTHELowerCaseWithoutSpace2 = "birthdayParty";
        } else {
            nameWithoutTHELowerCaseWithoutSpace2 = nameWithoutTHELowerCaseWithoutSpace;
        }
        String pathName = "/semesterprojektjavafx/semesterprojektjavafx/" + nameWithoutTHELowerCaseWithoutSpace2 + ".fxml";

        // Reloads the scene to initialize the label in GlucoseLabelController immediately
        FXMLLoader loader = new FXMLLoader(getClass().getResource(pathName));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

        stage.setScene(scene);
        stage.show();
    }
}

