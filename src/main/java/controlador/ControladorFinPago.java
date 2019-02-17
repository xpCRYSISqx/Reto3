package controlador;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

import modelo.Funciones;
import modelo.Modelo;
import vista.MainFrame;

public class ControladorFinPago implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	public Funciones funciones;
	
	public ControladorFinPago(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		this.funciones = new Funciones();
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
		
			case "Imprimir":
				
				// le pedimos al usuario que eliga donde guardarlo
				FileDialog fDialog = new FileDialog(vista, "Save", FileDialog.SAVE);
				fDialog.setFile("Billete-"+modelo.billeteIda.getCodBillete() + ".txt");
				fDialog.setVisible(true);
				String pathBillete = fDialog.getDirectory() + fDialog.getFile();
				
				// creamos los archivos de texto
				funciones.imprimirBillete(modelo.billeteIda, modelo.billeteVuelta, modelo.cliente, pathBillete, modelo);
				
				// abrimos los archivos en el programa predeterminado
				File file = new File(pathBillete);
				
				try {
					Desktop.getDesktop().open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				// mostrar siguiente panel 'agur'
				vista.agur.setVisible(true);
				vista.fin_pago.setVisible(false);
				
			    Timer timer = new Timer();

			    TimerTask task = new TimerTask() {
			        @Override
			        public void run(){
			        	vista.bienvenida.setVisible(true);
			        }
			     };
			     
			    // Empezamos dentro de 10ms y luego lanzamos la tarea cada 1000ms
			    timer.schedule(task, 5000);
				
				break;
		
		}
		
	}
	
}
