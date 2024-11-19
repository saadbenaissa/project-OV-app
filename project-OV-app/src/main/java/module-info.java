module com.example.projectovapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectovapp to javafx.fxml;
    exports com.example.projectovapp;
}