package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandPickUp;
import semesterprojektjavafx.semesterprojektjavafx.domain.DayCount;
import semesterprojektjavafx.semesterprojektjavafx.domain.Game;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

import java.io.IOException;
import java.util.Objects;

public class AvailabilityController {
    @FXML
    MenuItem item1;
    @FXML
    MenuItem item2;
    @FXML
    MenuItem item3;
    @FXML
    MenuItem item4;
    @FXML
    MenuButton availableItems;
    public void initialize() {
        availableItems.setText("Available items");
        if(Objects.equals(Game.context.getCurrent().getName(), "The Bedroom"))
        {
            item1.setText("Glucose meter");
            item2.setText("Insulin injector");
            item1.setVisible(true);
            item2.setVisible(true);
            item3.setVisible(false);
            item4.setVisible(false);
        }
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            item1.setText("Milk (250 ml)");
            item2.setText("Almonds (15 g)");
            item3.setText("Ice tea (250 ml)");
            item4.setText("Apple (110)");
            item1.setVisible(true);
            item2.setVisible(true);
            item3.setVisible(true);
            item4.setVisible(true);
        }
        else
        {
            item1.setText("No items are currently available");
            item1.setDisable(true);
            item2.setVisible(false);
            item3.setVisible(false);
            item4.setVisible(false);
        }
    }
    @FXML
    void grabItem1(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Bedroom"))
        {
            CommandPickUp.grabWhat("glucosemeter");
        }
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("milk");
        }
    }
    @FXML
    void grabItem2(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Bedroom"))
        {
            CommandPickUp.grabWhat("insulininjector");
        }
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("almonds");
        }
    }
    @FXML
    void grabItem3(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("ice tea");
        }
    }
    @FXML
    void grabItem4(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("apple");
        }
    }
}
