package com.example.guessnumber.model;

import com.example.guessnumber.controller.ServerController;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

    ServerSocket serverSocket;
    Socket socket;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    Random random = new Random();
    Integer randomNumber;

    public Server(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
        this.randomNumber = random.nextInt(1, 100);
        System.out.println("Санасан тоо: " + this.randomNumber);
        this.socket = serverSocket.accept();
        System.out.println("1");
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("2");
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("3");
    }

    public void sendMessageToClient(String messageToClient) {
        try {
            bufferedWriter.write(messageToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException ex) {
            System.out.println("Error sending message to the client.");
            ex.printStackTrace();
            close(socket, bufferedReader, bufferedWriter);
        }
    }

    public void receiveMessageFromClient(VBox vBox) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()) {
                    try {
                        String messageFromClient = bufferedReader.readLine();
                        ServerController.addLabel(messageFromClient, randomNumber, vBox);
                    } catch (IOException ex) {
                        System.out.println("Error receiving message from the client.");
                        ex.printStackTrace();
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
