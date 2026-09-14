import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) throws IOException {
        {
            // inicialização do cliente
            Socket client = new Socket("127.0.0.1", 4000);
            //stream representa o sistema de menságeria
            PrintStream envio = new PrintStream(client.getOutputStream(), true); // autoflush ativo com o true
            // scanner pra receber o input do usuário
            Scanner mensagem = new Scanner(System.in);

            System.out.println("Mensageria aberta, envie as menságens para o servidor");
            System.out.println("Para fechar a conexão basta fechar o programa (CTRL + C)");

            // sistema incrível do envio das menságens
            while (true) {
                envio.println(mensagem.nextLine());
            }
        }
    }
}
