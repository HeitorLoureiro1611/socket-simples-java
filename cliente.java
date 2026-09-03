import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente
{
    public static void main() throws IOException {
        Socket client = new Socket("127.0.0.1", 3030);
        PrintStream envio = new PrintStream(client.getOutputStream());
        Scanner mensagem = new Scanner(System.in);
        while(true)
        {
            envio.println(mensagem.nextLine());
        }


        //envio.close();
        //client.close();
    }
}
