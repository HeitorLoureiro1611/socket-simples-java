import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {
    public static void main(String[] args) throws IOException {
        {
            // cria o socket e inicializa ele na porta 4000
            Socket cliente;
            ServerSocket server = new ServerSocket(4000);

            // cria a pasta onde vai organizar os arquivos
            File logs = new File("log");
            if (!logs.exists())
                logs.mkdir();

            // cria o arquivo
            FileWriter escrevedor = new FileWriter(new File(logs, "tarefas.txt"), true);

            // só pra mostrar algumas informações
            System.out.println("Servidor iniciado em " + server.getInetAddress().getHostAddress() + ":" + server.getLocalPort());
            InetAddress inet = server.getInetAddress();
            System.out.println("HostAddress=" + inet.getHostAddress());
            System.out.println("HostName=" + inet.getHostName());
            System.out.println("Porta = " + server.getLocalPort());
            System.out.println("Está aberto?: " + server.isBound());

            // função assincrona que espera a conexão do cliente
            cliente = server.accept();
            Scanner mensagem = new Scanner(cliente.getInputStream());
            System.out.println("\n\nCliente: " + cliente.getInetAddress());
            System.out.println("\n");

            while (mensagem.hasNextLine()) {
                String linha = mensagem.nextLine();
                System.out.println(cliente.getLocalAddress() + " - " + linha);
                escrevedor.append(String.valueOf(cliente.getLocalAddress())).append(linha).append(System.lineSeparator());
                // System.lineSeparator() desconcatena as mensagens
                escrevedor.flush(); // fazer flush no buffer
            }
            server.close();
        }
    }
}