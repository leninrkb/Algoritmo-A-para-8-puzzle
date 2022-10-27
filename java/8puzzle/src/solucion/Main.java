/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package solucion;

/**
 *
 * @author lenin
 */
public class Main {

    public static void main(String[] args) {
        PosicionCero posc = new PosicionCero();
        posc.setPosicioni(0);
        posc.setPosicionj(0);
        Integer[][] puzzleInicial = {
            {0, 2, 3},
            {1, 1, 5},
            {2, 7, 8}};
        Integer[][] puzzleObjetivo = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}};

        Utils.imprimirMatriz(puzzleInicial);
        System.out.println("");
        
        Utils.moverCeroAbajo(Utils.copiarMatriz(puzzleInicial), posc);
        
        Utils.imprimirMatriz(puzzleInicial);

        if (Utils.esSolucionable(puzzleInicial)) {
            System.out.println("Solvable");
        } else {
            System.out.println("Not Solvable");
        }

    }
}
