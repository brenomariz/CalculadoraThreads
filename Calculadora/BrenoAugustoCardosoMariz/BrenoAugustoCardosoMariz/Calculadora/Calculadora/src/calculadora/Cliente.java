/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Breno Mariz
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String IPServidor = "localhost";
            int PortaServidor = 2223;

            ProxyCalculadora proxy = new ProxyCalculadora(IPServidor, PortaServidor); 
            

            /* TABELA OPERAÇÕES:
            1 - SOMA
            2 - SUBTRAÇÃO
            3 - MULTIPLICAÇÃO
            4 - DIVISÃO
            5 - MULTIPLICAÇÃO DE MATRIZ
            6 - BHASKARA */
            
            double resultado;
            int op = 1; 
            
         
            switch(op) {
                case 1:
                    resultado = proxy.soma(2, 3);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 2: 
                    resultado = proxy.subtracao(7, 2);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 3:
                    resultado = proxy.multiplicacao(25, 121);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 4:
                    resultado = proxy.divisao(6, 3);
                    System.out.println("Resultado: " + resultado);
                    break;
                    
                case 5:
                    Scanner reader = new Scanner(System.in);
                    System.out.println("Número de linhas da matriz 1: ");
                    int lin1 = reader.nextInt();
                    System.out.println("Número de colunas da matriz 1: ");
                    int col1 = reader.nextInt();
                    System.out.println("Número de linhas da matriz 2: ");
                    int lin2 = reader.nextInt();
                    System.out.println("Número de colunas da matriz 2: ");
                    int col2 = reader.nextInt();
                    
                    double a[][]  = new double[lin1][col1];
                    double b[][]  = new double[lin2][col2];

                    for (int x = 0; x<=lin1; x++) {
                        for (int y = 0; y <= col1; y++) {
                            System.out.println("Insira elementos na matriz 1: ");
                            a[x][y] = reader.nextInt();
                        }
                    }
                    
                       for (int x = 0; x<=lin2; x++) {
                        for (int y = 0; y<=col2; y++) {
                            System.out.println("Insira elementos na matriz 2: ");
                            b[x][y] = reader.nextInt();
                        }
                    }
                    
                    double[][] resultadoMatriz = proxy.multiplicacaoMatriz(a, b);
                    System.out.println("Resultado: " + resultadoMatriz);
                    break;
                    
                case 6:
                    double[] resultBhaskara = proxy.bhaskara(1, -5, 6);
                    System.out.println("Resultado: " + resultBhaskara);
                    break;
            }

            
        } catch (Exception e) { 
            System.out.println("O seguinte problema ocorreu : \n" + e.toString());
        }
    }
    
}
