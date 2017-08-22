
package calculadora;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Breno Mariz
 */
public class ProxyCalculadora implements Interface{
    
    Socket socket;
    ObjectOutputStream saida;


    public ProxyCalculadora(String IPServidor,int PortaServidor) throws IOException {
        this.socket = new Socket(IPServidor, PortaServidor);
        this.saida = new ObjectOutputStream(socket.getOutputStream());
    }

    private Object Resultado() throws IOException, ClassNotFoundException {
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        Object resultado = entrada.readObject();
        return resultado;
    }
    
    @Override
    public double soma(double a, double b) {
        
        double resultado = 0;
        try{ 
        saida.writeInt(1);
        saida.writeDouble(a);
        saida.writeDouble(b);
        saida.flush();
        resultado = (double) this.Resultado();
        } catch(IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally {
            return resultado;
        }
    }

    @Override
    public double subtracao(double a, double b) {
        double resultado = 0;
        try {
            saida.writeInt(2);
            saida.writeDouble(a);
            saida.writeDouble(b);
            saida.flush();
            resultado = (double) this.Resultado();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    @Override
    public double multiplicacao(double a, double b) {
        double resultado = 0;
        try {
            saida.writeInt(3);
            saida.writeDouble(a);
            saida.writeDouble(b);
            saida.flush();
            resultado = (double) this.Resultado();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    @Override
    public double divisao(double a, double b) {
        double resultado = 0;
        try {
            saida.writeInt(4);
            saida.writeDouble(a);
            saida.writeDouble(b);
            saida.flush();
            resultado = (double) this.Resultado();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            return resultado;
        }
    }

    @Override
    public double[][] multiplicacaoMatriz(double[][] a, double[][] b) {
        double[][] result = new double[a.length][b[0].length];
        try {
            saida.writeInt(5);
            saida.writeObject(a);
            saida.writeObject(b);
            saida.flush();
            result = (double[][]) this.Resultado();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            return result;
        }
    }

    @Override
    public double[] bhaskara(double a, double b, double c) {
        double[] result = new double[2];
        try {
            saida.writeInt(6);
            saida.writeDouble(a);
            saida.writeDouble(b);
            saida.writeDouble(c);
            saida.flush();
            result = (double[]) this.Resultado();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            return result;
        }
    }
      
}
