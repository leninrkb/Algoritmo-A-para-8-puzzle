import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author lenin
 */
public class Utils {

    /**
     * copia todos los elementos de una lista a otra con una nueva referencia
     * 
     * @param lista lista a copiar
     * @return lista con elentos copiados
     */
    static List<NodoPuzzle> copiarLista(List<NodoPuzzle> lista) {
        List<NodoPuzzle> nueva = new ArrayList<>();
        for (NodoPuzzle nodoPuzzle : lista) {
            nueva.add(nodoPuzzle);
        }
        return nueva;
    }

    /**
     * agrega los elementos de una lista muestra a una lista general
     * para llevar cuenta de todos los nodos hijos
     * 
     * @param lista_general lista con todos los hijos
     * @param lista_muestra lista con los hijos de un nodo
     * @return void
     */
    static void agregarHijosLista(List<NodoPuzzle> lista_general, List<NodoPuzzle> lista_muestra) {
        for (NodoPuzzle nodoPuzzle : lista_muestra) {
            lista_general.add(nodoPuzzle);
        }
    }

    /**
     * elimina el nodo que sea igual a que se pasa por parametro
     * 
     * @param lista_general lista con todos los hijos
     * @param eliminar      nodo a compara y eliminar desntro de la lista general
     * @return void
     */
    static void eliminarHijoLista(List<NodoPuzzle> lista_general, NodoPuzzle eliminar) {
        for (NodoPuzzle nodoPuzzle : lista_general) {
            if (nodoPuzzle == eliminar) {
                lista_general.remove(nodoPuzzle);
                break;
            }
        }
    }

    /**
     * determina el nodo con menor F(n) de la lista de nodos
     * 
     * @param nodos lista de nodos
     * @return nodo
     */
    static NodoPuzzle determinarNodoExpandir(List<NodoPuzzle> nodos) {
        Integer menor_fn = nodos.get(0).getFn();
        NodoPuzzle menor = nodos.get(0);
        for (NodoPuzzle nodo : nodos) {
            if (nodo.getFn() < menor_fn) {
                menor_fn = nodo.getFn();
                menor = nodo;
            }
        }
        return menor;
    }

    /**
     * verifica si el nodo ya se expandio
     * 
     * @param lista lista de nodos en la que se buscara el nodo pasado comom
     *              parametro
     * @param nodos nodo a buscar en la lista para saber si ya fue expandido
     * @return falso si el nodo no se ha expandido antes, true si ya se ha expandido
     */
    static Boolean verificarRepetido(List<Integer[][]> estados, Integer[][] e) {
        int c = 0;
        for (Integer[][] estado : estados) {
            for (int i = 0; i < estado.length; i++) {
                if (estado[i] != e[i]) {
                    c++;
                }
            }
        }
        if (c == 0) {
            return true;
        }
        return false;
    }

    /**
     * busca estados repetidos dentro de la lista
     * 
     * @param lista lista de nodos
     * @return falso si el nodo no se ha expandido antes, true si ya se ha expandido
     */
    static void verificarTodosHijos(List<NodoPuzzle> lista) {
        HashMap<Integer[][], String> mapa = new HashMap<>();
        for (NodoPuzzle nodo : lista) {
            if (!mapa.containsValue(nodo.getPuzzle())) {
                mapa.put(nodo.getPuzzle(), "");
            } else {
                lista.remove(nodo);
            }
        }
        mapa.clear();
    }

    /**
     * mueve el cero hacia la izquierda y lo intercambia con el numero que haya
     * estado en esa posicion
     *
     * @param matriz[][]
     * @return matriz[][]
     */
    static Integer[][] moverCeroIzquierda(Integer[][] matriz, PosicionCero pos) {
        Integer dato = matriz[pos.getPosicioni()][pos.getPosicionj() - 1];
        matriz[pos.getPosicioni()][pos.getPosicionj()] = dato;
        matriz[pos.getPosicioni()][pos.getPosicionj() - 1] = 0;
        return matriz;
    }

    /**
     * mueve el cero hacia la derecha y lo intercambia con el numero que haya
     * estado en esa posicion
     *
     * @param matriz[][]
     * @return matriz[][]
     */
    static Integer[][] moverCeroDerecha(Integer[][] matriz, PosicionCero pos) {
        Integer dato = matriz[pos.getPosicioni()][pos.getPosicionj() + 1];
        matriz[pos.getPosicioni()][pos.getPosicionj()] = dato;
        matriz[pos.getPosicioni()][pos.getPosicionj() + 1] = 0;
        return matriz;
    }

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
     * mueve el cero hacia abajo y lo intercambia con el numero que haya estado
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
    static List<Integer[][]> generarEstadosPosibles(Integer[][] matriz, PosicionCero pos) {
        PosicionCero posc = determinarPosCero(matriz);
        List<Integer[][]> lista = new ArrayList<>();

        switch (posc.getPosicion()) {
            case "ezquina superior izquierda":
                Integer[][] m1 = moverCeroDerecha(copiarMatriz(matriz), pos);
                Integer[][] m2 = moverCeroAbajo(copiarMatriz(matriz), pos);
                lista.add(m1);
                lista.add(m2);
                break;
            case "borde superior":
                Integer[][] m3 = moverCeroIzquierda(copiarMatriz(matriz), pos);
                Integer[][] m4 = moverCeroAbajo(copiarMatriz(matriz), pos);
                Integer[][] m5 = moverCeroDerecha(copiarMatriz(matriz), pos);
                lista.add(m3);
                lista.add(m4);
                lista.add(m5);
                break;
            case "ezquina superior derecha":
                Integer[][] m6 = moverCeroIzquierda(copiarMatriz(matriz), pos);
                Integer[][] m7 = moverCeroAbajo(copiarMatriz(matriz), pos);
                lista.add(m6);
                lista.add(m7);
                break;
            case "borde izquierda":
                Integer[][] m8 = moverCeroArriba(copiarMatriz(matriz), pos);
                Integer[][] m9 = moverCeroDerecha(copiarMatriz(matriz), pos);
                Integer[][] m10 = moverCeroAbajo(copiarMatriz(matriz), pos);
                lista.add(m8);
                lista.add(m9);
                lista.add(m10);
                break;
            case "centro":
                Integer[][] m11 = moverCeroArriba(copiarMatriz(matriz), pos);
                Integer[][] m12 = moverCeroAbajo(copiarMatriz(matriz), pos);
                Integer[][] m13 = moverCeroIzquierda(copiarMatriz(matriz), pos);
                Integer[][] m14 = moverCeroDerecha(copiarMatriz(matriz), pos);
                lista.add(m11);
                lista.add(m12);
                lista.add(m13);
                lista.add(m14);
                break;
            case "borde derecha":
                Integer[][] m15 = moverCeroArriba(copiarMatriz(matriz), pos);
                Integer[][] m16 = moverCeroIzquierda(copiarMatriz(matriz), pos);
                Integer[][] m17 = moverCeroAbajo(copiarMatriz(matriz), pos);
                lista.add(m15);
                lista.add(m16);
                lista.add(m17);
                break;
            case "ezquina inferior izquierda":
                Integer[][] m18 = moverCeroArriba(copiarMatriz(matriz), pos);
                Integer[][] m19 = moverCeroDerecha(copiarMatriz(matriz), pos);
                lista.add(m18);
                lista.add(m19);
                break;
            case "borde inferior":
                Integer[][] m20 = moverCeroIzquierda(copiarMatriz(matriz), pos);
                Integer[][] m21 = moverCeroArriba(copiarMatriz(matriz), pos);
                Integer[][] m22 = moverCeroDerecha(copiarMatriz(matriz), pos);
                lista.add(m20);
                lista.add(m21);
                lista.add(m22);
                break;
            case "ezquina inferior derecha":
                Integer[][] m23 = moverCeroArriba(copiarMatriz(matriz), pos);
                Integer[][] m24 = moverCeroIzquierda(copiarMatriz(matriz), pos);
                lista.add(m23);
                lista.add(m24);
                break;

            default:
                throw new AssertionError();
        }
        return lista;
    }

    /**
     * calcula fn
     * 
     * @param gn costo para el siguiente estado
     * @param hn costo en funcion del objetivo
     * @return fn costo total del camino
     */
    static Integer determinarFn(Integer gn, Integer hn) {
        return gn + hn;
    }

    /**
     * genera los objetos hijos de tipo NodoPuzzle
     * con referencia al padre
     * 
     * @param lista           matrices
     * @param padre           nodo que le precede
     * @param matriz_objetivo matriz solucion
     * @return lista con los hijos generado
     */
    static List<NodoPuzzle> generarHijos(List<Integer[][]> lista, NodoPuzzle padre, Integer[][] matriz_objetivo) {
        List<NodoPuzzle> hijos = new ArrayList<>();
        for (Integer[][] nueva_matriz : lista) {
            NodoPuzzle hijo = new NodoPuzzle();
            hijo.setPuzzle(nueva_matriz);
            hijo.setPadre(padre);
            hijo.setHn(determinarEuristicaPosiciones(matriz_objetivo, nueva_matriz));
            hijo.setGn(determinarCosto(hijo, hijo.getGn()));
            hijo.setFn(determinarFn(hijo.getGn(), hijo.getHn()));
            hijos.add(hijo);
        }
        return hijos;
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
     * determina el costo al siguiente nodo sumando el camino de los nodos
     * anteriores
     *
     * @param nodo
     * @return costo del camino
     */
    static Integer determinarCosto(NodoPuzzle nodo, Integer gn) {
        gn++;
        if (nodo.getPadre() != null) {
            return determinarCosto(nodo.getPadre(), gn);
        }
        return gn;
    }

    /**
     * compara la posicion de la matriz objetivo con la actual para saber si el
     * dato que esta en la matriz actual es el que deberia estar, si no, se
     * recorre los espacios hasta averiguar en posicion estaba, mientras tanto
     * la var hn sigue aumentando
     *
     * @param matriz_objetivo[][] matriz a la cual se desea llegar
     * @param matriz_actual[][]   matriz en la que se encuentra en el momento
     * @return la euristica en funcion de las matrices
     */
    static Integer determinarEuristica(Integer[][] matriz_objetivo, Integer[][] matriz_actual) {
        Integer[] vec_obj = pasarMatrizVector(matriz_objetivo);
        Integer[] vec_act = pasarMatrizVector(matriz_actual);
        Integer longitud = vec_obj.length;
        Integer hn = 0;

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
     * determina la distancia euclidiana de cada punto
     *
     * @param matriz_objetivo[][] matriz a la cual se desea llegar
     * @param matriz_actual[][]   matriz en la que se encuentra en el momento
     * @return la euristica en funcion de las matrices
     */
    static Integer determinarEuristicaEuclides(Integer[][] matriz_objetivo, Integer[][] matriz_actual) {
        Integer[] vec_obj = pasarMatrizVector(matriz_objetivo);
        Integer[] vec_act = pasarMatrizVector(matriz_actual);
        Integer longitud = vec_obj.length;
        Double hn = 0.0;

        for (int i = 0; i < longitud; i++) {
            if (vec_obj[i] != vec_act[i]) {
                for (int j = 0; j < longitud; j++) {
                    if (vec_obj[i] == vec_act[j]) {
                        Double d = Double.valueOf(j - i);
                        hn += Math.sqrt(Math.pow(d, 2));
                        break;
                    }
                }
            }
        }
        String str = String.valueOf(Math.round(hn));
        Integer hnEntero = Integer.valueOf(str);
        return hnEntero;
    }

    /**
     * determina los espacios errones de cada dato
     *
     * @param matriz_objetivo[][] matriz a la cual se desea llegar
     * @param matriz_actual[][]   matriz en la que se encuentra en el momento
     * @return la euristica en funcion de las matrices
     */
    static Integer determinarEuristicaPosiciones(Integer[][] matriz_objetivo, Integer[][] matriz_actual) {
        Integer[] vec_obj = pasarMatrizVector(matriz_objetivo);
        Integer[] vec_act = pasarMatrizVector(matriz_actual);
        Integer longitud = vec_obj.length;
        Integer hn = 0;

        for (int i = 0; i < longitud; i++) {
            if (vec_obj[i] != vec_act[i]) {
                hn++;
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
     * imprime una matriz
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

    static private List<NodoPuzzle> paraImprimir = new ArrayList<>();

    static void imprimirCamino(NodoPuzzle nodo) {
        ordenarCamino(nodo);
        for (int i = paraImprimir.size() - 1; i >= 0; i--) {
            imprimirNodo(paraImprimir.get(i));
        }
    }

    static void imprimirNodo(NodoPuzzle n) {
        imprimirMatriz(n.getPuzzle());
        System.out.print("gn: " + n.getGn() + " / ");
        System.out.print("hn: " + n.getHn() + " / ");
        System.out.print("fn: " + n.getFn());
        System.out.println("\n");
    }

    static void ordenarCamino(NodoPuzzle nodo) {
        if (nodo.getPuzzle() != null && nodo.getPadre() != null) {
            paraImprimir.add(nodo);
            ordenarCamino(nodo.getPadre());
        }
    }

    static void imprimirListaNodos(List<NodoPuzzle> lista) {
        System.out.println("--------------------- inicio impresion lista nodos ---------------------");
        for (NodoPuzzle nodoPuzzle : lista) {
            imprimirNodo(nodoPuzzle);
        }
        System.out.println("--------------------- fin inicio impresion lista nodos ---------------------");
    }
}
