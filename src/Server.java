import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server
{
    Server(){
        try {
            ServerSocket server = new ServerSocket(22000);
            Socket client = server.accept();

            DataInputStream ClientRead = new DataInputStream(client.getInputStream());
            DataOutputStream ClientWrite = new DataOutputStream(client.getOutputStream());
            ObjectInputStream receiveobject = new ObjectInputStream(ClientRead);
            ClientWrite.writeUTF("You are connected, Please Enter 10 numbers:");

            ArrayList<Integer> arr = new ArrayList<Integer>(11);

            arr = (ArrayList<Integer>) receiveobject.readObject();

            ClientWrite.writeUTF("Server Received the numbers successfully:)");

            //Ascending
            int temp = 0;
            for(int i =0;i < 10; i++)
            {
                for(int j = i+1;j < 10; j++)
                {
                    if (arr.get(j) < arr.get(i)) {
                        temp = arr.get(i);
                        arr.set(i, arr.get(j));
                        arr.set(j, temp);
                    }
                }
            }
            System.out.println("Ascending Order:");
            for(int i = 0;i < 10; i++)
            {
                System.out.println(arr.get(i));
            }
            System.out.print("---------------\n");
            System.out.println("Descending Order:");
            for(int i = 9;i>=0; i--)
            {
                System.out.println(arr.get(i));
            }

            ClientWrite.close();
            ClientRead.close();
            client.close();
        }
        catch (IOException | ClassNotFoundException ex){
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}
