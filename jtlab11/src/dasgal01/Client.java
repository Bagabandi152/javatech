package dasgal01;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    int port = 8000;
    String host = "localhost";
    Socket socket;
    Scanner input;

    DataInputStream in;
    Client() throws IOException {
        input = new Scanner(System.in);

        socket = new Socket(host, port);

        System.out.print("Enter a weight: ");
        double weight = input.nextDouble();
        System.out.print("Enter a height: ");
        double height = input.nextDouble();

        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

        // Create a Student object and send to the server
        Body body = new Body(weight,height);
        toServer.writeObject(body);

        in = new DataInputStream
                (socket.getInputStream());

        System.out.println("BMI: " + in.readUTF());
    }

    public static void main(String[] args) {
        try {
            new Client();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
