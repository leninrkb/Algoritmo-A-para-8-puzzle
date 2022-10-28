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
        
        NodoPuzzle nodoExpandir = Utils.determinarNodoExpandir(hijos);

        List<NodoPuzzle> hijos2 = Utils.generarHijos(
                    Utils.generarEstadosPosibles(Utils.copiarMatriz(nodoExpandir.getPuzzle()), 
                    Utils.determinarPosCero(nodoExpandir.getPuzzle())
                ), 
                nodoExpandir, 
                puzzleObjetivo);

        Utils.imprimirCamino(hijos2.get(0));

    }
}
