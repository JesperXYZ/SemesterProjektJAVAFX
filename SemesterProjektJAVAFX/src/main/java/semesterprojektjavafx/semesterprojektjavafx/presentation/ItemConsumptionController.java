package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandConsume;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;

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
    }
    @FXML
    void consumeItem2(ActionEvent event) throws IOException {
        consumeItem("ice tea");
    }
    @FXML
    void consumeItem3(ActionEvent event) throws IOException {
        consumeItem("almonds");
    }
    @FXML
    void consumeItem4(ActionEvent event) throws IOException {
        consumeItem("apple");
    }

    private void consumeItem(String itemName) throws IOException {
        CommandConsume commandConsume = new CommandConsume();
        if (Inventory.inventoryStorage.contains(itemName)) {
            commandConsume.consumeWhat(itemName);
        }
        updateItemVisibilityAll();
    }
}
