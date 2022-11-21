module com.example.guessnumber {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guessnumber to javafx.fxml;
    exports com.example.guessnumber;
    exports com.example.guessnumber.controller;
    opens com.example.guessnumber.controller to javafx.fxml;
}