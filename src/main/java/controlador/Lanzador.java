package controlador;

import vista.VentanaPrincipal;

public class Lanzador {

	VentanaPrincipal vista;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lanzador iniciar = new Lanzador();
		iniciar.Iniciar();
	}
	
	private void Iniciar() {
		vista = new VentanaPrincipal();
	}
}