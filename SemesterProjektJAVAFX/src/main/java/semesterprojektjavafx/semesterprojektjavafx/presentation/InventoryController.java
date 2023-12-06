package semesterprojektjavafx.semesterprojektjavafx.presentation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;

import java.util.ArrayList;
import java.util.List;

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
                labellist.get(i).setText(Inventory.inventoryStorage.get(i));
            } else
                labellist.get(i).setText(" ");
        }

    }

    }