package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

import vista.MainFrame;

public class Botones {
	public MainFrame vista;
	
	public void BotonContinuar(JButton boton, JPanel panSalida, JPanel panDeseado) {
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
	public void BotonContinuarFinal(JButton boton, JPanel panSalida, JPanel panDeseado, JPanel panContador) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
				TimerTask tarea=new TimerTask(){
					public void run(){
						panDeseado.setVisible(false);
						panContador.setVisible(true);
					}
				};
				//se crea un objeto de tipo timer
				Timer tiempo=new Timer();
				//se indica la tarea a ejecutar y el retardo
				tiempo.schedule(tarea, 5000);
			}
		});
	}
	public void BotonRegistro(JButton boton, JPanel panSalida, JPanel panInicioSesion) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panInicioSesion.setVisible(true);
				panSalida.setVisible(false);
			}
		});
	}
	public void BotonInicioSesion(JButton boton, JPanel panSalida, JPanel panInicioSesion) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panInicioSesion.setVisible(true);
				panSalida.setVisible(false);
			}
		});
	}
}