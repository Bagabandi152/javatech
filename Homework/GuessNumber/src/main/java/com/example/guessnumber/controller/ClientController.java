package com.example.guessnumber.controller;

import com.example.guessnumber.model.Client;
import com.example.guessnumber.model.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    private static int guessCount = 0;

    @FXML
    private static TextField guess;

    @FXML
    private static TextField username;
    @FXML
    private static Text guessCounterText;
    @FXML
    private static ImageView upArrow;
    @FXML
    private static ImageView downArrow;
    @FXML
    private static ImageView correct;

    private Alert infoAlert;
    private Client client;
    int port = 8000;
    String host = "localhost";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        correct.setVisible(false);

        infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle(null);
        String s = "Сервер 1-100 хооронд нэг тоо санах бөгөөд та үүнийг \nхамгийн ихдээ 5 оролдлогоор бусад тоглогчдоос түрүүлж, \nтааж чадвал хожино.";
        infoAlert.setContentText(s);

        try {
            client = new Client(new Socket(host, port));
            System.out.println("Connected to server.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void checkGuess(ActionEvent event) {
        if (!username.getText().isEmpty()) {
            if (isNumeric(guess.getText())) {
                client.sendMessageToServer(username.getText() + ":" + guess.getText());
                client.receiveMessageFromServer();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(null);
                String s = "Зөвхөн бүхэл оруулах шаардлагатай.";
                alert.setContentText(s);
                alert.showAndWait();
                resetPlayer();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            String s = "Нэр оруулах шаардлагатай.";
            alert.setContentText(s);
            alert.showAndWait();
            resetPlayer();
        }
    }

    public static void checkAnswer(String messageFromServer) {
        if (messageFromServer.equals("=")) {
            downArrow.setVisible(false);
            upArrow.setVisible(false);
            correct.setVisible(true);
        } else if (messageFromServer.equals(">")) {
            downArrow.setVisible(true);
            upArrow.setVisible(false);
            correct.setVisible(false);
        } else if (messageFromServer.equals("<")) {
            downArrow.setVisible(false);
            upArrow.setVisible(true);
            correct.setVisible(false);
        }
        guessCount++;
        guessCounterText.setText("Оролдлого: " + guessCount);

        if (guessCount == 5) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(null);
            String s = "Таны оролдлогын тоо дууслаа.";
            alert.setContentText(s);
            alert.showAndWait();
            resetPlayer();
        }
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.equals("")) {
            return false;
        }
        try {
            int intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            ex.fillInStackTrace();
        }
        return false;
    }

    @FXML
    void reset(ActionEvent event) {
        guess.setText("");
        username.setText("");
    }

    public static void resetPlayer() {
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        correct.setVisible(false);
        guess.setText("");
        username.setText("");
        guessCount = 0;
        guessCounterText.setText("Оролдлого: " + guessCount);
    }

    @FXML
    void openInfo(MouseEvent event) {
        infoAlert.showAndWait();
    }
}