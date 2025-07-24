import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",5001),1000);
        System.out.println("Connection succeful");

        //passing and recieving messages
        DataInputStream dataIn = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
        dataOut.writeUTF("Hi this is cumming from the client");
        String serverMessage = dataIn.readUTF();
        System.out.println(serverMessage);

        dataIn.close();
        dataOut.close();
        socket.close();

    }
}
