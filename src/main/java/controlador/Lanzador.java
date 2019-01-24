package controlador;

import javax.swing.JFrame;

import vista.FramePrincipal;

public class Lanzador {

	FramePrincipal vista;
	JFrame ventana;
	
	public static void main(String[] args) {
		Lanzador iniciar = new Lanzador();
		iniciar.Iniciar();
	}
	
	private void Iniciar() {
		vista = new FramePrincipal();
		vista.ventana.setVisible(true);
	}
}