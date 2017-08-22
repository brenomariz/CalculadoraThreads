package calculadora;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Breno Mariz
 */
public class AdapterCalculadora implements Runnable{
    private Socket socket;
    private Interface calc;

    public AdapterCalculadora(Socket socket) {
        this.socket = socket;
        this.calc = new CalculadoraImplement();
    }

    @Override
    public void run() {

        ObjectInputStream entrada = null;
        try {
            entrada = new ObjectInputStream(socket.getInputStream());
            int op = entrada.readInt();
            double a, b, c;
            Object result = null;
            double[][] x, y;
            switch (op) {
                case 1:
                    a = entrada.readDouble();
                    b = entrada.readDouble();
                    result = calc.soma(a, b);
                    break;

                case 2:
                    a = entrada.readDouble();
                    b = entrada.readDouble();
                    result = calc.subtracao(a, b);
                    break;

                case 3:
                    a = entrada.readDouble();
                    b = entrada.readDouble();
                    result = calc.divisao(a, b);
                    break;

                case 4:
                    a = entrada.readDouble();
                    b = entrada.readDouble();
                    result = calc.multiplicacao(a, b);
                    break;

                case 5:
                    x = (double[][]) entrada.readObject();
                    y = (double[][]) entrada.readObject();
                    result = calc.multiplicacaoMatriz(x, y);
                    break;    
                
                case 6:
                    a = entrada.readDouble();
                    b = entrada.readDouble();
                    c = entrada.readDouble();
                    result = calc.bhaskara(a, b, c);
                    break;

                
            }

            ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
            saida.writeObject(result);
            saida.flush();

            socket.close();
            System.out.println("Conexão fechada");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro:" + e.getMessage());
        } finally {
            try {
                entrada.close();
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

    }
        
}
