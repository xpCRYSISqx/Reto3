package controlador;

import javax.swing.JButton;
import javax.swing.JPanel;
import vista.VentanaPrincipal;
import vista.Bienvenida;

public class Botones {
	Bienvenida bienvenida;
	
	public void BotonContinuarBienvenida(JButton boton) {
		bienvenida = new Bienvenida();
		
	}
}