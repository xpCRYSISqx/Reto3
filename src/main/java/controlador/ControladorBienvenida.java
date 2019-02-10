package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Linea;
import modelo.Modelo;
import vista.MainFrame;

public class ControladorBienvenida implements ActionListener {
	
	private MainFrame vista;
	private Modelo modelo;
	private ArrayList<Linea> lineas;
	
	public ControladorBienvenida(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	// añadimos listeners a los botones del panel 'bienvenida'
	public void addListeners() {
		vista.bienvenida.btnContinuar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) { 
		
		// muestra el siguiente panel 'sel_linea'
		vista.sel_linea.setVisible(true);
		vista.bienvenida.setVisible(false);
		
		// carga las lineas de la BBDD y las muestra en el JList
		lineas = modelo.consultas.getLineas(); //Carga la informacion de las lineas desde la base de datos
		vista.sel_linea.modeloLineas.removeAllElements(); //Limpia la lista de las lineas en la interfaz
		for(int i=0; i<lineas.size(); i++) { //Recorre el ArrayList de lineas para poder utilizar sus componentes
			String nombre = lineas.get(i).getCodLinea(); //Guarda el codigo de la linea en una variable para poder utilizarla
			vista.sel_linea.modeloLineas.addElement(nombre);
			vista.sel_linea.listLineas.setModel(vista.sel_linea.modeloLineas);
		}
		
	}
}
