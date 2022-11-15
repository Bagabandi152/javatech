package dasgal01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    int port = 8000;
    ObjectInputStream inputFromClient;
    ServerSocket server;
    Socket socket;

    DataOutputStream out;

    Server() throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);

        while (true) {
            // Listen for a new connection request
            socket = server.accept();

            // Create an input stream from the socket
            inputFromClient = new ObjectInputStream(socket.getInputStream());

            // Read from input
            Object object = inputFromClient.readObject();

            out = new DataOutputStream(socket.getOutputStream());

            // Calc body mass
            String bodyMass = calcBodyMass((Body) object);
            out.writeUTF(bodyMass);
        }
    }

    final double KILOGRAMS_PER_POUND = 0.45359237; // Constant
    final double METERS_PER_INCH = 0.0254; // Constant

    String calcBodyMass(Body obj) {
        // Compute BMI
        double weightInKilograms = obj.getWeight() * KILOGRAMS_PER_POUND;
        double heightInMeters = obj.getHeight() * METERS_PER_INCH;
        double bmi = weightInKilograms / (heightInMeters * heightInMeters);

        // Display result
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
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
