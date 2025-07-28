import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {

            serverSocket = new ServerSocket(5001);
            serverSocket.setReuseAddress(true);

            while (true) {

                //socekt client to recieve incoming client requests
                Socket client = serverSocket.accept();

                //display new connected client
                System.out.println("New client connected: " + client.getInetAddress().getHostAddress());

                //create new thread obj here
                ClientHandler clientSock = new ClientHandler(client);

                new Thread(clientSock).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
