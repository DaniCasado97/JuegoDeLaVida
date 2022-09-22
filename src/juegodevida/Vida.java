/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegodevida;

/**
 *
 * @author DaniCasado
 */
public class Vida {

    final int VIDA = 1;
    final int NO_VIDA = 0;
    int vecinos = 0;
    int contador_vida;
    int cont = 0;

    JuegoDeVida jdv = new JuegoDeVida(VIDA, NO_VIDA);

    int[][] mundo = jdv.getMundo();
    int[][] copia_temporal = jdv.getCopia();

    void mostrarMundo(int num_generacion) {

        System.out.println("Generación: " + num_generacion);
        System.out.println(" -------------------------------");

        for (int i = 0; i < mundo.length; i++) {

            for (int j = 0; j < mundo[i].length; j++) {

                switch (cont) {
                    case 0:
                        System.out.print("| " + mundo[i][j] + " + ");
                        cont++;
                        break;
                    case 7:
                        System.out.print(mundo[i][j] + " |");
                        cont = 0;
                        break;
                    default:
                        System.out.print(mundo[i][j] + " + ");
                        cont++;
                        break;
                }
            }
            System.out.println("");
        }
        System.out.println(" -------------------------------");
        System.out.println("\n");
    }

    void proximaGeneracion() {

        for (int i = 1; i < (copia_temporal.length - 1); i++) {
            for (int j = 1; j < (copia_temporal[i].length - 1); j++) {

                vecinos = contarVecinos(i, j);

                //NACIMIENTO
                if (vecinos == 3 && mundo[i][j] == NO_VIDA) {

                    copia_temporal[i][j] = VIDA;
                } //MUERTE
                else if (vecinos <= 1 || vecinos >= 4) {

                    if (mundo[i][j] == VIDA) {

                        copia_temporal[i][j] = NO_VIDA;
                    }
                } //SUPERVIVENCIA
                else if (vecinos == 2 || vecinos == 3) {

                    if (mundo[i][j] == VIDA) {

                        copia_temporal[i][j] = VIDA;
                    }
                }
            }
        }
    }

    int contarVecinos(int fila, int columna) {

        contador_vida = 0;

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (mundo[i][j] == VIDA) {
                    contador_vida++;
                }
            }
        }

        return contador_vida;
    }

    void copiarMundoSinOrillas() {

        for (int i = 1; i < (mundo.length - 1); i++) {
            for (int j = 1; j < (mundo[i].length - 1); j++) {

                mundo[i][j] = copia_temporal[i][j];
            }
        }
    }
}
