package controlador;

import java.util.ArrayList;

import modelo.*;

public class Controlador {
	
	public Modelo modelo;
	//public Vista vista;
	
	public Controlador(Modelo modelo/*, Vista vista*/) {
		
		this.modelo = modelo;
		//this.vista = vista;
		
	}
	
	public void inicializarEventos() {
		
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
		
	}

}
