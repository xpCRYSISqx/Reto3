package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import modelo.Billete;
import modelo.Modelo;
import vista.MainFrame;

public class ControladorFinPago implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	
	public ControladorFinPago(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	// añadimos listeners a los botones del panel 'fin_pago'
	public void addListeners() {
		vista.fin_pago.btnImprimir.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "btnImprimir":
				
//				Billete billete = new Billete();
//				modelo.ficheros.imprimirBillete(billete);
				
				vista.agur.setVisible(true);
				vista.fin_pago.setVisible(false);
				
				break;
		
		}
		
	}
	
}
