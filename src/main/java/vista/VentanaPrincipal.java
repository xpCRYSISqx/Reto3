package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Botones;

import java.awt.CardLayout;
import javax.swing.JComboBox;

public class VentanaPrincipal {

	public JFrame ventana;
	public JPanel bienvenida;
	public JPanel lineas;
	

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		
		ventana = new JFrame();
		ventana.setBounds(100, 100, 1280, 720);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(new CardLayout(0, 0));
		
	}
}