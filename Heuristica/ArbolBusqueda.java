
package puzzle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class ArbolBusqueda {
    
    Nodo raiz;
    String objetivo;
    
    public ArbolBusqueda(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    
   
    //Busqueda por Anchura
    public String busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        contador = 0;
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
        	contador++;
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
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
      
        return "YA SE ENCONTRO EL NODO OBJETIVO\n"+nodoActual.imprimeSolucion(nodoActual,raiz)
        +"\nCantidad de veces que se entro al ciclo de busqueda "+contador;
        
    }
    public String busquedaAnchuraH()
    {
        Nodo nodoActual = raiz;
 	Comparator<Nodo> comparador = new Comparator<Nodo>() {
			@Override
			public int compare(Nodo o1, Nodo o2) {
				if(Heuristica(o1.getEstado()) > Heuristica(o2.getEstado())) {
					return -1;
				}else {
					return 1;
				}
			}
    	};
        Collection<String> estadosVisitados = new ArrayList<String>();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>(comparador);
        contador = 0;
        //Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
        	contador++;
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
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        return "YA SE ENCONTRO EL NODO OBJETIVO\n"+nodoActual.imprimeSolucion(nodoActual,raiz)
        +"\nCantidad de veces que se entro al ciclo de busqueda "+contador;
        
    }
    //Busqueda por Profundidad
    public void busquedaPorProfundidad()
    {
        int contador = 0;
    	Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
        while(!nodoActual.getEstado().equals(objetivo))
        {
        	contador++;
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	
            //hijos = heuristica1(hijos);
        
            for (String hijo : hijos) {
            	 if(!estadosVisitados.contains(hijo))
                 {
                     //System.out.println("---Metiendo nuevo Nodo");
                     //Crear nuevo Nodo.
                     Nodo nHijo = new Nodo(hijo);
                     nHijo.setPadre(nodoActual);
                     estadosPorVisitar.add(nHijo);
                  
                 }	
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.imprimeSolucion(nodoActual,raiz));
        System.out.println("Cantidad de veces que se entro al ciclo de busqueda "+contador);
 
    }
    
    public int Heuristica(String estado) {
  	  int Com =0;
  	  for(int i = 0; i < objetivo.length(); i++) {
  		  if(estado.charAt(i) == objetivo.charAt(i)) {
  			 Com++;
  		  }
  			 
  	  }
  	  return Com;
    }
    

   
   
    
    
    
    
    
}
