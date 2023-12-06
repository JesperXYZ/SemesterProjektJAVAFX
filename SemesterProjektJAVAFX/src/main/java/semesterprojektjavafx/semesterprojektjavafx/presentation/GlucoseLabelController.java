package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

public class GlucoseLabelController {
    @FXML
    public Label label2 = new Label();
    @FXML
    public Label label1 = new Label();

    public void initialize(){
        label1.setText("Glucose level: ");
        label2.setText("test");
    }

   public void labelset (){
        label2.setText(String.valueOf(ItemsDescription.getGlucoseLevel()));
    }

    public void setLabel2(){
        label2.setText(String.valueOf(ItemsDescription.getGlucoseLevel()));
    }
}
