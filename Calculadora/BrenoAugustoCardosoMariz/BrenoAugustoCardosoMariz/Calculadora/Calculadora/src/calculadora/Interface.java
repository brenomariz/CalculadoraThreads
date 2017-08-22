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
public interface Interface {
    public double soma(double a, double b);
    public double subtracao(double a, double b);
    public double multiplicacao(double a, double b);
    public double divisao(double a, double b);
    public double[][] multiplicacaoMatriz(double a[][], double b[][]);
    public double[] bhaskara(double a, double b, double c);
}
