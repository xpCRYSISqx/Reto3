package controlador;

import javax.swing.JFrame;

import vista.VentanaPrincipal;

public class Lanzador {

	VentanaPrincipal vista;
	JFrame ventana;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lanzador iniciar = new Lanzador();
		iniciar.Iniciar();
	}
	
	private void Iniciar() {
		vista = new VentanaPrincipal();
		vista.ventana.setVisible(true);
	}
}