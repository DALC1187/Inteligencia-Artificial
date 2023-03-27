package puzzle;

import java.util.Scanner;



public class Puzzle8 {

    public static String estadoInicial = "123456 78";
    public static String estadoFinal = "12345678 ";
   
    
    public static void main(String[] args) {
    	ArbolBusqueda a = new ArbolBusqueda(new Nodo(estado), estadoFinal);
        
	System.out.println(a.busquedaPorAnchura());
	System.out.println(a.busquedaAnchuraH());
	System.out.println(a.busquedaPorProfundidad());
       
    }
    
    
    
    
    
    
    
}
