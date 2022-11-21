module com.example.guessnumber {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.guessnumber to javafx.fxml;
    exports com.example.guessnumber;
}