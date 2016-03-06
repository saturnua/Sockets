import java.net.*;
import java.util.ArrayList;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Client extends Thread {
    LinkedList<String> clientList;

    public void run() {
        Socket s = null;

        try {
            s = new Socket("127.0.0.1", 1111);
            System.out.println("Socket is connected to client");
        } catch (UnknownHostException e) {
            // e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }

       // while (true) {
            try {
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                if (clientList != null) {
                    //clientList = null;
                }
                clientList = (LinkedList<String>) ois.readObject();
               // ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

       // }
    }

    public void printList() {
        Thread printList = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<String> itr = clientList.listIterator();
                try {
                    Thread.sleep(2000);
                    while (itr.hasNext()) {
                        System.out.println(itr.next());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        printList.start();
    }

   public static void main(String[] args) {
        Client client = new Client();
       client.start();
       client.printList();

    }
}