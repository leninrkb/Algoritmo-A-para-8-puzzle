import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenin
 */
public class Main {

    public static void main(String[] args) {
        Integer[][] puzzleInicial = {
            { 1, 4, 2 },
            { 3, 5, 8 },
            { 6, 0, 7 } };
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

        int i = 0;
        NodoPuzzle nodoExpandir = raiz;
        // do {
        //     if (nodoExpandir.getHn() == 0) {
        //         break;
        //     }
        //     List<NodoPuzzle> hijos = Utils.generarHijos(
        //             Utils.generarEstadosPosibles(Utils.copiarMatriz(nodoExpandir.getPuzzle()),
        //                     Utils.determinarPosCero(nodoExpandir.getPuzzle())),
        //             nodoExpandir,
        //             puzzleObjetivo);

        //     Utils.agregarHijosLista(todosHijos, hijos);
        //     nodoExpandir = Utils.determinarNodoExpandir(todosHijos);
        //     Utils.eliminarHijoLista(todosHijos, nodoExpandir);
        // } while (true);


        // Integer in = Utils.determinarCosto(nodoExpandir, nodoExpandir.getGn());
        // System.out.println("costo " + in);
        Utils.imprimirCamino(nodoExpandir);

        Integer qwe = Utils.determinarEuristica(puzzleObjetivo, puzzleInicial);

        Double asd = Utils.determinarEuristicaEuclides(puzzleObjetivo, puzzleInicial);
        System.out.println("eu: " + asd);
        System.out.println("man: " + qwe);

    }
}
