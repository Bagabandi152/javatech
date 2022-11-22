module com.example.guessnumber {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.guessnumber.controller;
    opens com.example.guessnumber.controller to javafx.fxml;
    exports com.example.guessnumber.thread;
    opens com.example.guessnumber.thread to javafx.fxml;
    exports com.example.guessnumber;
    opens com.example.guessnumber to javafx.fxml;
}