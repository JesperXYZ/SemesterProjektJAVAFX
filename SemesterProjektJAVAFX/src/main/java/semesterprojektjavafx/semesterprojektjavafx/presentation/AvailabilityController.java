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
    Label dayCount = new Label(""+DayCount.getDay());
    @FXML
    Label hungerLevel = new Label(""+ ItemsDescription.getHungerLevelInt());
    @FXML
    static MenuItem item1 = new MenuItem("");
    @FXML
    static MenuItem item2 = new MenuItem("");
    @FXML
    static MenuItem item3 = new MenuItem("");
    @FXML
    static MenuItem item4 = new MenuItem("");
    @FXML
    MenuButton availableItems = new MenuButton("Available items");


    public static void updateAvailableItems() {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Bedroom"))
        {
            item1.setText("Glucose meter");
            item2.setText("Insulin injector");
            item3.disableProperty();
            item4.disableProperty();
        }
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            item1.setText("Milk (250 ml)");
            item2.setText("Almonds (15 g)");
            item3.setText("Ice tea (250 ml)");
            item4.setText("Apple (110)");
        }
        else
        {
            item1.disableProperty();
            item2.disableProperty();
            item3.disableProperty();
            item4.disableProperty();
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
