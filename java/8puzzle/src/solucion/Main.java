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
public class Main {

    public static void main(String[] args) {
        Integer[][] puzzleInicial = {
            {0, 2, 4},
            {5, 1, 6},
            {8, 3, 7}};
        Integer[][] puzzleObjetivo = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}};

        if (Utils.esSolucionable(puzzleInicial)) {
            System.out.println("Solvable");
        } else {
            System.out.println("Not Solvable");
        }

        NodoPuzzle raiz = new NodoPuzzle();
        raiz.setPuzzle(puzzleInicial);
        raiz.setPadre(null);
        raiz.setHn(Utils.determinarEuristica(puzzleObjetivo, puzzleInicial));
        raiz.setGn(Utils.determinarCosto(raiz));
        
        
        List<NodoPuzzle> hijos = Utils.generarHijos(
                    Utils.generarEstadosPosibles(Utils.copiarMatriz(raiz.getPuzzle()), 
                    Utils.determinarPosCero(raiz.getPuzzle())
                ), 
                raiz, 
                puzzleObjetivo);
        Utils.imprimirCamino(hijos.get(0));

    }
}
