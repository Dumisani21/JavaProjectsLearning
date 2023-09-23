import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server {

    public static void main(String args[]) {
        try {
            System.out.println("Waiting for connection!");
            ServerSocket ss = new ServerSocket(5000);
            Socket socket = ss.accept();
            System.out.println("New connection made!");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String messageFromClient = in.readLine();
            System.out.println("Client: " + messageFromClient);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String o = "Hi my name is Server nice to meet you.";
            out.println(o);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}