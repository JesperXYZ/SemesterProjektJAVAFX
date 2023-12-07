package semesterprojektjavafx.semesterprojektjavafx.presentation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventoryController {

private List<Label> labellist = new ArrayList<>();

    @FXML
    Label label1 = new Label();
    @FXML
    Label label2 = new Label();
    @FXML
    Label label3 = new Label();
    @FXML
    Label label4 = new Label();
    @FXML
    Label label5 = new Label();
    @FXML
    Label label6 = new Label();
    @FXML
    Label label7 = new Label();
    @FXML
    Label label8 = new Label();




    public void initialize(){
        labellist.add(label1);
        labellist.add(label2);
        labellist.add(label3);
        labellist.add(label4);
        labellist.add(label5);
        labellist.add(label6);
        labellist.add(label7);
        labellist.add(label8);

        for (int i = 0; i<labellist.size(); i++){
            if (i<Inventory.inventoryStorage.size()){
                if (Objects.equals(Inventory.inventoryStorage.get(i), "milk")) {
                    labellist.get(i).setText("Milk (250 ml)");
                }
                else if (Objects.equals(Inventory.inventoryStorage.get(i), "ice tea")) {
                    labellist.get(i).setText("Ice tea (250 ml)");
                }
                else if (Objects.equals(Inventory.inventoryStorage.get(i), "almonds")) {
                    labellist.get(i).setText("Almonds (15 g)");
                }
                else if (Objects.equals(Inventory.inventoryStorage.get(i), "apple")) {
                    labellist.get(i).setText("Apple (110 g)");
                }
                else if (Objects.equals(Inventory.inventoryStorage.get(i), "glucosemeter")) {
                    labellist.get(i).setText("Glucose meter");
                }
                else if (Objects.equals(Inventory.inventoryStorage.get(i), "insulininjector")) {
                    labellist.get(i).setText("Insulin injector");
                }
                else {
                    labellist.get(i).setText("Illegal item wtf");
                }
            } else
                labellist.get(i).setText(" ");
        }

    }

    }