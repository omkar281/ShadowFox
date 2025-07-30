package task2;
import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            ChatServer.clientWriters.add(out);

            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("📩 Received: " + msg);
                for (PrintWriter writer : ChatServer.clientWriters) {
                    writer.println(msg);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {}
            ChatServer.clientWriters.remove(out);
        }
    }
}
