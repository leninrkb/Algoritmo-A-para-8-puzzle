import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenin
 */
public class Main {

    public static void main(String[] args) {
        Integer[][] puzzleInicial = {
                { 1, 2, 0 },
                { 3, 4, 5 },
                { 6, 7, 8 } };
        Integer[][] puzzleObjetivo = {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 } };

        // if (Utils.esSolucionable(puzzleInicial)) {
        //     System.out.println("Solvable");
        // } else {
        //     System.out.println("Not Solvable");
        // }

        // nodo raiz/padre con el estado inicial
        NodoPuzzle raiz = new NodoPuzzle();
        raiz.setPuzzle(puzzleInicial);
        raiz.setPadre(null);
        raiz.setHn(Utils.determinarEuristica(puzzleObjetivo, puzzleInicial));
        raiz.setGn(Utils.determinarCosto(raiz, raiz.getGn()));

        // llevo cuenta de los nodos hijos, elimino los que ya se expanden
        List<NodoPuzzle> todosHijos = new ArrayList<>();

        int i = 0;
        NodoPuzzle nodoExpandir = raiz;
        do {

            List<NodoPuzzle> hijos = Utils.generarHijos(
                    Utils.generarEstadosPosibles(Utils.copiarMatriz(nodoExpandir.getPuzzle()),
                            Utils.determinarPosCero(nodoExpandir.getPuzzle())),
                    nodoExpandir,
                    puzzleObjetivo);

            Utils.agregarHijosLista(todosHijos, hijos);
            nodoExpandir = Utils.determinarNodoExpandir(todosHijos);
            Utils.eliminarHijoLista(todosHijos, nodoExpandir);

            i++;
            System.out.println(i);
        //} while (i < 10000);
        } while (Utils.determinarEuristica(nodoExpandir.getPuzzle(), puzzleObjetivo) != 0);

        //Integer in = Utils.determinarCosto(nodoExpandir, nodoExpandir.getGn());
        //System.out.println("costo " + in);
        Utils.imprimirCamino(nodoExpandir);

    }
}
