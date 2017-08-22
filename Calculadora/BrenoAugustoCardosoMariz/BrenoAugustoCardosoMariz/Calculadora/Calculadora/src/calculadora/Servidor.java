package calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Breno Mariz
 */
public class Servidor{

    public static void main(String[] args) {
        try {
            System.out.println("Aguardando conexao...");
            ServerSocket s = new ServerSocket(2223);
            			
            Socket p = s.accept(); 
            System.out.println("Conectado ao cliente ->" + p.toString());
            
            AdapterCalculadora adapter = new AdapterCalculadora(p);
            new Thread(adapter).start();
 
            s.close();
            System.out.println("Conexao finalizada...");

        } catch (Exception e) { 
            System.out.println("O seguinte problema ocorreu : \n" + e.toString());
            e.printStackTrace();
        }
    }
   
    
}
