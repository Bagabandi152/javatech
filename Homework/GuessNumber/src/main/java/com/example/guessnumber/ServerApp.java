package com.example.guessnumber;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Bagaa
 * @project GuessNumber
 * @created 21/11/2022 - 3:56 PM
 * @purpose
 * @definition
 */
public class ServerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("server.fxml")));
        stage.setTitle("Санасан тоо таах тоглоом (Сервер)");
        stage.setScene(new Scene(root, 600, 370));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}