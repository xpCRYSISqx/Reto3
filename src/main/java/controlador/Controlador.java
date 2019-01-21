package controlador;

import java.util.ArrayList;

import modelo.Linea;
import modelo.Modelo;

public class Controlador {
	
	public Modelo modelo;
	//public Vista vista;
	
	public Controlador(Modelo modelo/*, Vista vista*/) {
		
		this.modelo = modelo;
		//this.vista = vista;
		
	}
	
	public void inicializarEventos() {
		
		ArrayList<Linea> lineas = modelo.getLineas();
		
		for (int i = 0; i < lineas.size(); i++) { 		      
	      System.out.print(lineas.get(i).getCodLinea()+": ");
	      System.out.println(lineas.get(i).getNombre()); 
		}
		
	}

}
