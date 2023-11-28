module semesterprojektjavafx.semesterprojektjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports semesterprojektjavafx.semesterprojektjavafx.domain;
    opens semesterprojektjavafx.semesterprojektjavafx.domain to javafx.fxml;
    exports semesterprojektjavafx.semesterprojektjavafx.presentation;
    opens semesterprojektjavafx.semesterprojektjavafx.presentation to javafx.fxml;
    /*exports semesterprojektjavafx.semesterprojektjavafx;
    opens semesterprojektjavafx.semesterprojektjavafx to javafx.fxml;*/
}