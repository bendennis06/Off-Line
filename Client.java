import java.io.*;
import java.net.*;
import java.util.*;

 class Client {
    public static void main(String[] args) throws IOException {

        try(Socket socket = new Socket("localhost", 5001)){
            //writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            //reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scnr = new Scanner(System.in);
            String line = null;

            while(!"exit".equalsIgnoreCase(line)){
                line = scnr.nextLine();

                //sending user input to the server
                out.println(line);
                out.flush();

                //print user input
                System.out.println("Server replied: " + in.readLine());
            }

            scnr.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
