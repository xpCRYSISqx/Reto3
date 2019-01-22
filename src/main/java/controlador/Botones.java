package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Botones {
	
	public void BotonContinuarBienvenida(JButton boton, JPanel panSalida, JPanel panDeseado) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
				TimerTask tarea=new TimerTask(){
					public void run(){
						panDeseado.setVisible(false);
						panSalida.setVisible(true);
					}
				};
				//se crea un objeto de tipo timer
				Timer tiempo=new Timer();
				//se indica la tarea a ejecutar y el retardo
				tiempo.schedule(tarea, 60000);
			}
		});
	}
	public void BotonContinuarLineas(JButton boton, JPanel panSalida, JPanel panDeseado) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
			}
		});
	}
	public void BotonContinuarBillete(JButton boton, JPanel panSalida, JPanel panDeseado) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
			}
		});
	}
	public void BotonContinuarFechas(JButton boton, JPanel panSalida, JPanel panDeseado) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
			}
		});
	}
	public void BotonContinuarConfirmacion(JButton boton, JPanel panSalida, JPanel panDeseado) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
			}
		});
	}
}