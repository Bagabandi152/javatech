package com.example.guessnumber.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    private final Random random = new Random();
    private int randomNumber;
    private int guessCount = 0;

    @FXML
    private TextField guess;
    @FXML
    private Text guessCounterText;
    @FXML
    private ImageView upArrow;
    @FXML
    private ImageView downArrow;
    @FXML
    private ImageView correct;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        randomNumber = random.nextInt(100);
        System.out.println(randomNumber);
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        correct.setVisible(false);
    }

    @FXML
    void checkGuess(ActionEvent event) {
        if (isNumeric(guess.getText())) {
            if (Integer.parseInt(guess.getText()) == randomNumber) {
                downArrow.setVisible(false);
                upArrow.setVisible(false);
                correct.setVisible(true);
            } else if (Integer.parseInt(guess.getText()) > randomNumber) {
                downArrow.setVisible(true);
                upArrow.setVisible(false);
                correct.setVisible(false);
            } else if (Integer.parseInt(guess.getText()) < randomNumber) {
                downArrow.setVisible(false);
                upArrow.setVisible(true);
                correct.setVisible(false);
            }
            guessCount++;
            guessCounterText.setText("Оролдлого: " + guessCount);

            if (guessCount == 3) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(null);
                String s = "Таны оролдлогын тоо дууслаа.";
                alert.setContentText(s);
                alert.showAndWait();
                resetPlayer();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(null);
            String s = "Зөвхөн бүхэл оруулах шаардлагатай.";
            alert.setContentText(s);
            alert.showAndWait();
            resetPlayer();
        }
    }

    public static boolean isNumeric(String string) {
        System.out.println(String.format("Parsing string: \"%s\"", string));
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
        resetPlayer();
    }

    void resetPlayer() {
        randomNumber = random.nextInt(100);
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        correct.setVisible(false);
        guessCount = 0;
        guessCounterText.setText("Оролдлого: " + guessCount);
    }
}