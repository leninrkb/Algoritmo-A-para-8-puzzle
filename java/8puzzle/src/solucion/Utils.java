/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenin
 */
public class Utils {

    /**
     * mueve el cero hacia arriba y lo intercambia con el numero que haya estado
     * en esa posicion
     *
     * @param matriz[][]
     * @return matriz[][]
     */
    static Integer[][] moverCeroArriba(Integer[][] matriz, PosicionCero pos) {
        Integer dato = matriz[pos.getPosicioni() - 1][pos.getPosicionj()];
        matriz[pos.getPosicioni()][pos.getPosicionj()] = dato;
        matriz[pos.getPosicioni() - 1][pos.getPosicionj()] = 0;
        return matriz;
    }

    /**
     * mueve el cero hacia arriba y lo intercambia con el numero que haya estado
     * en esa posicion
     *
     * @param matriz[][]
     * @return matriz[][]
     */
    static Integer[][] moverCeroAbajo(Integer[][] matriz, PosicionCero pos) {
        Integer dato = matriz[pos.getPosicioni() + 1][pos.getPosicionj()];
        matriz[pos.getPosicioni()][pos.getPosicionj()] = dato;
        matriz[pos.getPosicioni() + 1][pos.getPosicionj()] = 0;
        return matriz;
    }

    /**
     * copia una matriz para no modificar la original al copiar la referencia
     *
     * @param matriz[][]
     * @return nueva matriz[][]
     */
    static Integer[][] copiarMatriz(Integer[][] matriz) {
        Integer[][] nueva = new Integer[matriz.length][matriz.length];
        for (int i = 0; i < nueva.length; i++) {
            for (int j = 0; j < nueva.length; j++) {
                nueva[i][j] = matriz[i][j];
            }
        }
        return nueva;
    }

    /**
     * genera los estados posibles de la matriz en funcion de la posicion del
     * cero
     *
     * @param matriz
     * @return
     */
    static List<Integer[][]> generarEstadosPosibles(Integer[][] matriz) {
        PosicionCero posc = determinarPosCero(matriz);
        List<Integer[][]> lista = new ArrayList<>();

        switch (posc.getPosicion()) {
            case "ezquina superior izquierda":

                break;
            case "borde superior":

                break;
            case "ezquina superior derecha":

                break;
            case "borde izquierda":

                break;
            case "centro":

                break;
            case "borde derecha":

                break;
            case "ezquina inferior izquierda":

                break;
            case "borde inferior":

                break;
            case "ezquina inferior derecha":

                break;

            default:
                throw new AssertionError();
        }
        return lista;
    }

    /**
     * determina en que posicion se encuentra el cero
     *
     * @param matriz[][]
     * @return cadena vacia si no entra al for
     */
    static PosicionCero determinarPosCero(Integer[][] matriz) {
        PosicionCero posc = new PosicionCero();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        posc.setPosicion("ezquina superior izquierda");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }
                    if (i == 0 && j == 1) {
                        posc.setPosicion("borde superior");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }
                    if (i == 0 && j == 2) {
                        posc.setPosicion("ezquina superior derecha");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }

                    if (i == 1 && j == 0) {
                        posc.setPosicion("borde izquierda");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }
                    if (i == 1 && j == 1) {
                        posc.setPosicion("centro");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }
                    if (i == 1 && j == 2) {
                        posc.setPosicion("borde derecha");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }

                    if (i == 2 && j == 0) {
                        posc.setPosicion("ezquina inferior izquierda");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }
                    if (i == 2 && j == 1) {
                        posc.setPosicion("borde inferior");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }
                    if (i == 2 && j == 2) {
                        posc.setPosicion("ezquina inferior derecha");
                        posc.setPosicioni(i);
                        posc.setPosicionj(j);
                        return posc;
                    }
                }
            }
        }
        return posc;
    }

    /**
     * lee una matriz y mueve cada entero a un ventor
     *
     * @param matriz[][]
     * @return vector con los datos de la matriz
     */
    static Integer[] pasarMatrizVector(Integer[][] matriz) {
        Integer longitud = (matriz.length * matriz.length);
        Integer[] vec = new Integer[longitud];

        int contador = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                vec[contador] = matriz[i][j];
                contador++;
            }
        }
        return vec;
    }

    /**
     * compara la posicion de la matriz objetivo con la actual para saber si el
     * dato que esta en la matriz actual es el que deberia estar, si no, se
     * recorre los espacios hasta averiguar en posicion estaba, mientras tanto
     * la var hn sigue aumentando
     *
     * @param matriz_objetivo[][] matriz a la cual se desea llegar
     * @param matriz_actual[][] matriz en la que se encuentra en el momento
     * @return la euristica en funcion de las matrices
     */
    static Integer getEuristica(Integer[][] matriz_objetivo, Integer[][] matriz_actual) {
        Integer[] vec_obj = pasarMatrizVector(matriz_objetivo);
        Integer[] vec_act = pasarMatrizVector(matriz_actual);
        Integer longitud = vec_obj.length;
        Integer hn = 0;
        Boolean salir = false;

        for (int i = 0; i < longitud; i++) {
            Integer j = i;
            if (vec_obj[i] == vec_act[j]) {
            } else {
                for (int k = i; k < longitud; k++) {
                    Integer obj = vec_obj[i];
                    Integer act = vec_act[k];
                    if (obj == act) {
                        break;
                    }
                    hn++;
                    if ((k + 1) == longitud) {
                        k = -1;
                    }
                }
            }
        }
        return hn;
    }

    /**
     * algoritmo que determina si la matriz
     *
     * @param matriz
     * @return un entero
     */
    static Integer getInvCount(Integer[][] arr) {
        int inv_count = 0;
        for (int i = 0; i < 3 - 1; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (arr[j][i] > 0
                        && arr[j][i] > arr[i][j]) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    /**
     * determina si una matriz se puede resolver en el juego 8puzzle
     *
     * @param matriz[][]
     * @return boleano, true si la matriz se puede resolver
     */
    static Boolean esSolucionable(Integer[][] puzzle) {
        Integer invCount = getInvCount(puzzle);
        return (invCount % 2 == 0);
    }

    /**
     * imoerime una matriz
     *
     * @param matriz[][]
     */
    static void imprimirMatriz(Integer[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
