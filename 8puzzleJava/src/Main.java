import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lenin
 */
public class Main {

    public static void main(String[] args) {
        Integer[][] puzzleInicial = {
            { 2, 4, 3 },
            { 6, 7, 8 },
            { 0, 1, 5 } };
        // Integer[][] puzzleInicial = {
        //     { 3, 1, 2 },
        //     { 4, 7, 0 },
        //     { 6, 8, 5 } };
        Integer[][] puzzleObjetivo = {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 } };

        // nodo raiz/padre con el estado inicial
        NodoPuzzle raiz = new NodoPuzzle();
        raiz.setPuzzle(puzzleInicial);
        raiz.setPadre(null);
        raiz.setHn(Utils.determinarEuristica(puzzleObjetivo, puzzleInicial));
        raiz.setGn(Utils.determinarCosto(raiz, raiz.getGn()));

        // llevo cuenta de los nodos hijos, elimino los que ya se expanden
        List<NodoPuzzle> todosHijos = new ArrayList<>();
        List<Integer[][]> estadosExpandidos = new ArrayList<>();

        NodoPuzzle nodoExpandir = raiz;
        do {
            if (nodoExpandir.getHn() == 0) {
                break;
            }
            estadosExpandidos.add(nodoExpandir.getPuzzle());
            List<NodoPuzzle> hijos = Utils.generarHijos(Utils.generarEstadosPosibles(Utils.copiarMatriz(nodoExpandir.getPuzzle()),Utils.determinarPosCero(nodoExpandir.getPuzzle())),nodoExpandir,puzzleObjetivo);

            Utils.agregarHijosLista(todosHijos, hijos);
            nodoExpandir = Utils.determinarNodoExpandir(todosHijos);
            while(Utils.verificarRepetido(estadosExpandidos, nodoExpandir.getPuzzle())){
                Utils.eliminarHijoLista(todosHijos, nodoExpandir);
                nodoExpandir = Utils.determinarNodoExpandir(todosHijos);
            }
            Utils.eliminarHijoLista(todosHijos, nodoExpandir);

            if (Utils.determinarEuristica(puzzleObjetivo, nodoExpandir.getPuzzle()) == 0) {
                break;
            }
        } while (true);


        Utils.imprimirCamino(nodoExpandir);

    }
}
