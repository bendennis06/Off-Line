import java.net.*;
import java.io.*;

//TCP server
public class Main {
    public static void main(String[] args) throws IOException {
    //create a socket named socket
        ServerSocket serverSocket = new ServerSocket(5001);
        System.out.println("Listening for clients...");
        Socket clientSocket = serverSocket.accept();
        String clientSocketIP = clientSocket.getInetAddress().toString();
        int clientSocketPort = clientSocket.getPort();
        System.out.println("[IP: " + clientSocketIP + " ,port: " + clientSocketPort + "] Client connected");

        DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

        String clientMessage = dataIn.readUTF();
        System.out.println(clientMessage);
        String serverMessage = "This is cumming from server";
        dataOut.writeUTF(serverMessage);

        dataIn.close();
        dataOut.close();
        serverSocket.close();
        clientSocket.close();

        }
    }
