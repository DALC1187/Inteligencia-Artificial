package Puzzle8;

import java.util.Collection;

public class Puzzle8 {

    public static String estadoInicial = "3467 215";
    public static String estadoFinal = "12345678 ";
    
    public static void main(String[] args) {
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(new Nodo(estadoInicial), estadoFinal);
        //Ejecuta la busqueda
        a.busquedaPorProfundidad();
        //a.busquedaPorAnchura();
        //Imprime movimientos
        
        /*
        Nodo n = new Nodo(estadoInicial);
        Collection<String> c = n.generaHijos();
        c = c;
        */
    }
    
}
