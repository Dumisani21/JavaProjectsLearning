import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Client {

    public static void main(String args[]) {
        try {
            System.out.println("Client started!");
            Socket socket = new Socket("localhost", 5000);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your message:");
            String messageToSend = input.readLine();
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println(messageToSend);
            out.flush();
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messageFromServer = inputStream.readLine();
            System.out.println(String.format("Server says: %s", messageFromServer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}