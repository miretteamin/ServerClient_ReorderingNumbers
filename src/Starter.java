import java.util.Scanner;

public class Starter
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        if (input.next().equals("server"))
        {
            Server server = new Server();

        }
        else
        {
            Client client = new Client();
        }
        input.close();
    }
}
