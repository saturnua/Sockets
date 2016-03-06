import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Client2 extends Thread{

    public static void main (String[] args) {
        Socket s=null;

        try {
            s = new Socket("127.0.0.1", 1111);
            System.out.println("Socket is connected to client2");
        } catch (UnknownHostException e) {
           // e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}