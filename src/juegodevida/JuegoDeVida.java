/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodevida;

import java.util.Scanner;

/**
 *
 * @author DaniCasado
 */
public class JuegoDeVida {

    int[][] mundo;
    int[][] copia_temporal;
    
    
    public JuegoDeVida(int vida, int no_vida) {

        mundo = new int[8][8];
        copia_temporal = new int[8][8];
        
        for (int i = 0; i < mundo.length; i++){
            for(int j = 0; j < mundo[i].length; j++){
                
                mundo[i][j] = (int) Math.floor(Math.random()*(vida - no_vida + 1) + no_vida);
            }
        } 
    }
    
    static int gen;

    public static void main(String args[]) {

        Scanner leer = new Scanner(System.in);
        System.out.print("Introduzca el número de generaciones: ");
        gen = leer.nextInt();

        while (gen < 0 || gen == 0) {

            System.out.println("Error, el numero de generaciones tiene que ser positivo y mayor que cero");
            System.out.print("Introduzca el numero de generaciones: ");
            gen = leer.nextInt();
        }
        
        Vida vida = new Vida();

        for (int i = 1; i <= gen; i++) {

            vida.mostrarMundo(i);
            vida.proximaGeneracion();
            vida.copiarMundoSinOrillas();
        }
    }
    
    public int[][] getMundo() {
        
        return mundo;
    }
    
    public int[][] getCopia() {
        
        return copia_temporal;
    }
}
