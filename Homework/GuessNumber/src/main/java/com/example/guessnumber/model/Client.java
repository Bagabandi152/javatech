package com.example.guessnumber.model;

import com.example.guessnumber.controller.ClientController;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;

public class Client {

    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public Client(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException ex) {
            System.out.println("Error creating client.");
            ex.printStackTrace();
            close(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessageToServer(String messageToServer) {
        try {
            bufferedWriter.write(messageToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error sending message to the server.");
            close(socket, bufferedReader, bufferedWriter);
        }
    }

    public void receiveMessageFromServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        String messageFromServer = bufferedReader.readLine();
                        ClientController.checkAnswer(messageFromServer);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        System.out.println("Error receiving message from the server.");
                        close(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public void close(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
