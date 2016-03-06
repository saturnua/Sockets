import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.util.ListIterator;

public class Server extends Thread {

	public List<String> myList = new LinkedList<String>();
    ServerSocket server;

	public void run() {

        try {
            server = new ServerSocket(1111);
		} catch (Exception e) {
			System.out.println("ERRSOCK+" + e);
		}

		while (true) {
                    Socket s = null;
                    try {
                        System.out.println("Wait for clients");
                        s = server.accept();

                        ObjectOutputStream  oos = new ObjectOutputStream(s.getOutputStream());
                        oos.writeObject(myList);
                        oos.close();

                        System.out.println("Connection ended, myList sended ");
                    } catch (Exception e) {
                        System.out.println("ACCEPTER" + e);
			}


        }
	}

    public void printList (){
       Thread printList = new Thread(new Runnable() {
           @Override
           public void run() {
               ListIterator<String> itr = myList.listIterator();
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

	public static void main(String args[])

	{

			Server serverStart = new Server();

            serverStart.myList.add("First listElement");

		    serverStart.start();
            System.out.println("Start");



	}
}




