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
            { 3, 0, 2 },
            { 4, 1, 7 },
            { 6, 8, 5 } };
        // Integer[][] puzzleInicial = {
        //         { 3, 4, 1 },
        //         { 0, 8, 2 },
        //         { 6, 7, 5 } };
        Integer[][] puzzleObjetivo = {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 } };

        // nodo raiz/padre con el estado inicial
        NodoPuzzle padre = new NodoPuzzle();
        padre.setPuzzle(puzzleInicial);
        padre.setPadre(null);
        padre.setHn(Utils.determinarEuristicaPosiciones(puzzleObjetivo, puzzleInicial));
        padre.setGn(Utils.determinarCosto(padre, padre.getGn()));
        padre.setFn(padre.getGn() + padre.getHn());

        // llevo cuenta de los nodos hijos, elimino los que ya se expanden
        List<NodoPuzzle> todosHijos = new ArrayList<>();

        solve(padre, puzzleObjetivo, todosHijos);
        //solvePasos(padre, puzzleObjetivo, todosHijos);

        
        
        

    }


    static void solve(NodoPuzzle n, Integer[][] puzzleObjetivo, List<NodoPuzzle> todosHijos){
        NodoPuzzle nodoExpandir = n;
        do {
            if (nodoExpandir.getHn() == 0) {
                break;
            }

            List<NodoPuzzle> hijos = Utils
                    .generarHijos(Utils.generarEstadosPosibles(Utils.copiarMatriz(nodoExpandir.getPuzzle()),
                            Utils.determinarPosCero(nodoExpandir.getPuzzle())), nodoExpandir, puzzleObjetivo);

            Utils.agregarHijosLista(todosHijos, hijos);
            Utils.verificarTodosHijos(todosHijos);
            nodoExpandir = Utils.determinarNodoExpandir(todosHijos);
            Utils.eliminarHijoLista(todosHijos, nodoExpandir);

            if (Utils.determinarEuristica(puzzleObjetivo, nodoExpandir.getPuzzle()) == 0) {
                break;
            }
        } while (true);

        Utils.imprimirCamino(nodoExpandir);
    }

    static void solvePasos(NodoPuzzle n, Integer[][] puzzleObjetivo, List<NodoPuzzle> todosHijos){
        Scanner in = new Scanner(System.in);
        NodoPuzzle nodoExpandir = n;
        char sn = 's';
        do {
            if (nodoExpandir.getHn() == 0) {
                break;
            }

            System.out.println("***se expande: ***");
            Utils.imprimirNodo(nodoExpandir);
            System.out.println("******************");

            List<NodoPuzzle> hijos = Utils
                    .generarHijos(Utils.generarEstadosPosibles(Utils.copiarMatriz(nodoExpandir.getPuzzle()),
                            Utils.determinarPosCero(nodoExpandir.getPuzzle())), nodoExpandir, puzzleObjetivo);

            Utils.imprimirListaNodos(hijos);

            Utils.agregarHijosLista(todosHijos, hijos);
            Utils.verificarTodosHijos(todosHijos);
            nodoExpandir = Utils.determinarNodoExpandir(todosHijos);
            Utils.eliminarHijoLista(todosHijos, nodoExpandir);

            if (Utils.determinarEuristica(puzzleObjetivo, nodoExpandir.getPuzzle()) == 0) {
                break;
            }

            

            System.out.print("continuar: ");
            sn = in.nextLine().charAt(0);
        } while (sn == 's');

        Utils.imprimirCamino(nodoExpandir);
    }
}
