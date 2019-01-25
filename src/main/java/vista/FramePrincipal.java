package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.Botones;

import java.awt.CardLayout;
import javax.swing.JComboBox;

public class FramePrincipal {

	public JFrame ventana;
	public Bienvenida bienvenida;
	public SelecLinea lineas;
	

	/**
	 * Create the application.
	 */
	public FramePrincipal() {
		
		ventana = new JFrame();
		ventana.setBounds(100, 100, 1280, 720);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(new CardLayout(0, 0));
		
		this.bienvenida = new Bienvenida();
		this.ventana.getContentPane().add(bienvenida);
		// this.ventana.setContentPane(bienvenida); Esto va en el controlador para cambiar de panel
	}
}