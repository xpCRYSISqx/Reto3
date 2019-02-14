package controlador;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

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
		String urlBilleteIda = "";
		String urlBilleteVuelta = "";
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "Imprimir":
				
				// le pedimos al usuario que eliga donde guardarlo
				FileDialog fDialog = new FileDialog(vista, "Save", FileDialog.SAVE);
				fDialog.setFile("Billete-"+modelo.billeteIda.getCodBillete() + ".txt");
				fDialog.setVisible(true);
				String pathBilleteIda = fDialog.getDirectory() + fDialog.getFile();
				String pathBilleteVuelta = "";
				
				// creamos los archivos de texto
				modelo.ficheros.imprimirBillete(modelo.billeteIda, modelo.cliente, pathBilleteIda);
				
				if(modelo.billeteVuelta != null) {
					
					// le pedimos al usuario que eliga donde guardarlo
					fDialog.setFile("Billete-"+modelo.billeteVuelta.getCodBillete());
					fDialog.setVisible(true);
					pathBilleteVuelta = fDialog.getDirectory() + fDialog.getFile();
					
					// creamos los archivos de texto
					modelo.ficheros.imprimirBillete(modelo.billeteVuelta, modelo.cliente, pathBilleteVuelta);
				}				
				
				
				// abrimos los archivos en el programa predeterminado
				File file1 = new File(pathBilleteIda);
				File file2 = new File(pathBilleteVuelta);
				
				try {
					Desktop.getDesktop().open(file1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try {
					Desktop.getDesktop().open(file2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				// mostrar siguiente panel 'agur'
				vista.agur.setVisible(true);
				vista.fin_pago.setVisible(false);
				
				break;
		
		}
		
	}
	
}
