package Puzzle8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Mario R�os
 */
public class ArbolBusqueda {
    
    Nodo raiz;
    String objetivo;
    
    public ArbolBusqueda(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    //Busqueda por Anchura
    public void busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                    
                    System.out.println(hijo);

                    String sSubCadena1 = hijo.substring(0,3);
                  //  String sSubCadena2 = hijo.substring(2);

                    String sSubCadena3 = hijo.substring(3,6);
                    //String sSubCadena4 = hijo.substring(5);

                    String sSubCadena5 = hijo.substring(6,9);
                    //String sSubCadena6 = hijo.substring(8);

                    System.out.println("----------------------------------------");
                    System.out.println(sSubCadena1);

                    System.out.println(sSubCadena3);

                    System.out.println(sSubCadena5);
                    System.out.println("----------------------------------------");
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
          
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }
    
    public void busquedaPorProfundidad()
    {
    	Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                    
                    System.out.println(hijo);

                    String sSubCadena1 = hijo.substring(0,3);
                  //  String sSubCadena2 = hijo.substring(2);

                    String sSubCadena3 = hijo.substring(3,6);
                    //String sSubCadena4 = hijo.substring(5);

                    String sSubCadena5 = hijo.substring(6,9);
                    //String sSubCadena6 = hijo.substring(8);

                    System.out.println("----------------------------------------");
                    System.out.println(sSubCadena1);

                    System.out.println(sSubCadena3);

                    System.out.println(sSubCadena5);
                    System.out.println("----------------------------------------");
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
          
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.getEstado());
    }
    	
    
    
}
