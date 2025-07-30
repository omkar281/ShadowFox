package task2;
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 1234;
    static Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("🚀 Chat server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("✅ New client connected: " + socket);
            new ClientHandler(socket).start();
        }
    }
}

