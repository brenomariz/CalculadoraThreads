/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Breno Mariz
 */
public class CalculadoraImplement implements Interface{

    @Override
    public double soma(double a, double b) {
        return a + b;
    }

    @Override
    public double subtracao(double a, double b) {
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }

    @Override
    public double multiplicacao(double a, double b) {
        return a * b;
    }

    @Override
    public double divisao(double a, double b) {
        return a / b;
    }

    @Override
    public double[][] multiplicacaoMatriz(double[][] a, double[][] b) {
        if (a[0].length != b.length) {
            System.out.println("Dimensões inconsistentes. Impossível multiplicar as matrizes");
            System.exit(0);
        }

        double[][] result = new double[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int count = 0; count < a[0].length; count++) {
                    result[i][j] += (a[i][count] * b[count][j]);
                }
            }
        }

        return result;
    }

    @Override
    public double[] bhaskara(double a, double b, double c) {
        double[] resultado;
        double delta = Math.pow(b, 2);
        if (delta < 0) {
            System.out.println("Operação não permitida");
            System.exit(0);
        }
        double x1 = ((0 - b) + Math.sqrt(delta)) / (2 * a);
        double x2 = ((0 - b) - Math.sqrt(delta)) / (2 * a);
        resultado = new double[2];
        resultado[0] = x1;
        resultado[1] = x2;
        

        return resultado;
    }
    
}
