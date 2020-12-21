import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    Client()
    {
        try
        {
            InetAddress ip = InetAddress.getLocalHost();
            Socket server = new Socket(ip, 22000);

            Scanner scan = new Scanner(System.in);

            DataInputStream input = new DataInputStream(System.in);
            DataInputStream ServerRead = new DataInputStream(server.getInputStream());
            DataOutputStream ServerWrite = new DataOutputStream(server.getOutputStream());
            ObjectOutputStream sendobject = new ObjectOutputStream(ServerWrite);

            List<Integer> arr = new ArrayList<Integer>(10);

            System.out.println(ServerRead.readUTF());

            //Reading 10 numbers
            for(int i =0;i < 10; i++)
            {
                arr.add(scan.nextInt());
            }
            //Sending 10 numbers
            sendobject.writeObject(arr);

            System.out.println(ServerRead.readUTF());

            ServerRead.close();
            ServerWrite.close();
            server.close();
        }
        catch (IOException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null, ex);
       }
    }
}