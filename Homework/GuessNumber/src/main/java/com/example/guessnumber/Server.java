package com.example.guessnumber;

import com.example.guessnumber.model.Request;
import com.example.guessnumber.thread.ThreadServer;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Bagaa
 * @project GuessNumber
 * @created 21/11/2022 - 6:56 PM
 * @purpose
 * @definition
 */
public class Server {
    int port = 8000;
    ObjectInputStream inputFromClient;
    ServerSocket server;
    Socket socket;
    DataOutputStream out;

    final Random random = new Random();

    int randomNumber;

    Server() throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        randomNumber = random.nextInt(1, 100);
        System.out.println("Сервер аслаа...");
        System.out.println("Санасан тоо: " + randomNumber);

        while (true) {
            // Listen for a new connection request
            socket = server.accept();

            // Create an input stream from the socket
            inputFromClient = new ObjectInputStream(socket.getInputStream());

            // Read from input
            Object object = inputFromClient.readObject();

            out = new DataOutputStream(socket.getOutputStream());

            // Check to guess the number
            String result = checkNumber((Request) object);
            out.writeUTF(result);
        }
    }

    String checkNumber(Request obj) {
        // check to guess the number
        String name = obj.getUsername();
        Integer guess = obj.getGuess();

        // display username
        System.out.println(name + " тоглогч холбогдлоо.");

        // return result
        if (guess == randomNumber) return "=";
        else if (guess > randomNumber) return ">";
        else return "<";
    }

    public static void main(String[] args) {
        try {
            new Server();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
