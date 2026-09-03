import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server
{
     static void main() throws IOException{
         Socket cliente;
        ServerSocket server = new ServerSocket(3030);
        if(!server.isBound()){
            server.bind(new InetSocketAddress("192.168.0.1", 0));
        }

         System.out.println("Servidor iniciado em " + server.getInetAddress().getHostAddress() + ":" + server.getLocalPort());
         InetAddress inet = server.getInetAddress();
         System.out.println("HostAddress="+inet.getHostAddress());
         System.out.println("HostName="+inet.getHostName());
         System.out.println("Porta = "+server.getLocalPort());
         System.out.println("Está aberto?: "+ server.isBound());

         cliente = server.accept();
         Scanner mensagem = new Scanner(cliente.getInputStream());

         System.out.println("Cliente: " + cliente.getInetAddress());
        System.out.println("\n");

        while(mensagem.hasNextLine()){
            System.out.println(cliente.getLocalAddress() + " - " + mensagem.nextLine());
        }

        server.close();
     }
}