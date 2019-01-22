package controlador;

import java.util.ArrayList;

import modelo.*;

/*
 * Esta clase hace uso del paquete vista que no estara disponible hasta que hagamos merge con la rama interfaz
 * Todas las instancias de la clase vista estan comentadas 
 */
public class Controlador {
	
	public Modelo modelo;
	//public Vista vista;
	
	public Controlador(Modelo modelo/*, Vista vista*/) {
		
		this.modelo = modelo;
		//this.vista = vista;
		
	}
	
	public void inicializarEventos() {
		
		/*
		 * El siguiente codigo es de PRUEBA, para probar los metodos del modelo antes de usarlos con las vistas
		 */
		
		// carga y muestra las lineas
		ArrayList<Linea> lineas = modelo.getLineas();
		
		for (int i = 0; i < lineas.size(); i++) { 		      
	      System.out.print(lineas.get(i).getCodLinea()+": ");
	      System.out.println(lineas.get(i).getNombre()); 
		}
		
		// carga y muestra las paradas de la linea seleccionada
		ArrayList<Parada> paradas = modelo.getParadasByLinea("L1");
		
		for (int i = 0; i < paradas.size(); i++) { 		      
		      System.out.print(paradas.get(i).getCodParada()+": ");
		      System.out.print(paradas.get(i).getNombre()+", ");
		      System.out.print(paradas.get(i).getCalle()+", ");
		      System.out.print(paradas.get(i).getLatitud()+", ");
		      System.out.println(paradas.get(i).getLongitud());
		}
		
		// carga y muestra los autobuses de la linea seleccionada
		ArrayList<Autobus> autobuses = modelo.getAutobusesByLinea("L3");
		
		for (int i = 0; i < autobuses.size(); i++) { 		      
		      System.out.print(autobuses.get(i).getCodBus()+": ");
		      System.out.print(autobuses.get(i).getNumPlazas()+", ");
		      System.out.print(autobuses.get(i).getConsumo()+", ");
		      System.out.println(autobuses.get(i).getColor());
		}
		
	}

}
