package app;

import controlador.Controlador;
import modelo.Modelo;

public class App {

	public static void main(String[] args) {
		
		Modelo modelo = new Modelo();
//		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo/*,vista*/);
		controlador.inicializarEventos();

	}
}