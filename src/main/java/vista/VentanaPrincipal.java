package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;

public class VentanaPrincipal {

	public JFrame ventana;
	

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 1280, 720);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(new CardLayout(0, 0));
		
		Bienvenida bienvenida = new Bienvenida();
		bienvenida.CrearBienvenida();
		ventana.getContentPane().add(bienvenida.PasarBienvenida());
	}
}