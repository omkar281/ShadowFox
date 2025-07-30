package task2;

import java.net.*;
import java.io.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int port = 1234;

        Socket socket = new Socket(serverAddress, port);
        System.out.println("🔗 Connected to the chat server");

        new Thread(new IncomingReader(socket)).start();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = userInput.readLine()) != null) {
            out.println(input);
        }
    }
}

class IncomingReader implements Runnable {
    private BufferedReader in;

    public IncomingReader(Socket socket) {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    public void run() {
        String msg;
        try {
            while ((msg = in.readLine()) != null) {
                System.out.println("📨 " + msg);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading: " + e.getMessage());
        }
    }
}
