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
import modelo.Modelo;
import vista.MainFrame;

/**
 * 
 * @author Laura, Ustaritz
 * 
 * @param vista: Instancia del main frame para poder utilizarlo
 * @param modelo: instancia del modelo para poder utilizarlo
 * @param botonPulsado: Se utiliza para poder reconocer el boton que se esta pulsando
 * @param fDiaLog: Se utiliza para la impresion del billete
 * @param pathBillete: Señala la ruta en la que se va a imprimir el billete
 * @param file: Crea el archivo para guardar el billete
 * @param timer: Declara un temporizador
 * @param task: Declara la tarea que va a realizar el temporizador
 *
 */

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
		
			case "Imprimir":
				
				String filename;
				
				if(modelo.billeteVuelta != null) {
					filename = "Billete-" + modelo.billeteIda.getCodBillete() + "-" + modelo.billeteVuelta.getCodBillete() + ".txt";
				} else {
					filename = "Billete-"+modelo.billeteIda.getCodBillete() + ".txt";
				}
				
				// le pedimos al usuario que eliga donde guardarlo
				FileDialog fDialog = new FileDialog(vista, "Save", FileDialog.SAVE);
				fDialog.setFile(filename);
				fDialog.setVisible(true);
				String pathBillete = fDialog.getDirectory() + fDialog.getFile();
				
				// creamos los archivos de texto
				modelo.funcionesBillete.imprimirBillete(pathBillete);
				
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
			    timer.schedule(task, 10000);
				
				break;
		
		}
		
	}
	
}
