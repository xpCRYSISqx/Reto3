package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import modelo.Linea;
import modelo.Modelo;
import vista.MainFrame;

/**
 * Esta clase se encarga de controlar los eventos del panel de bienvenida, y tambien de enlazar la vista y el modelo en el panel de bienvenida
 * 
 * @author Laura, Mikel, Ustaritz
 * 
 * @param vista: Instancia de la vista, para poder utilizarla
 * @param modelo: Instancia del modelo, para poder utilizarlo
 * @param lineas: ArrayList que se utiliza para guardar una lista de objetos lineas, cada uno contiene la informacion de las diferentes lineas
 *
 */

public class ControladorBienvenida implements ActionListener {
	
	private MainFrame vista;
	private Modelo modelo;
	private ArrayList<Linea> lineas;
	
	public ControladorBienvenida(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	// a�adimos listeners a los botones del panel 'bienvenida'
	public void addListeners() {
		vista.bienvenida.btnContinuar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) { 
		
		// muestra el siguiente panel 'sel_linea'
		vista.sel_billete.setVisible(true);
		vista.bienvenida.setVisible(false);
		
		// carga las lineas de la BBDD y las muestra en el JList
		lineas = modelo.consultas.getLineas();
		
		//Limpia la lista de las lineas en la interfaz
		vista.sel_billete.boxLineas.removeAllItems();
		
		//Recorre el ArrayList de lineas y los muestra en el JComboBox de la pantalla 'sel_billete'
		for(int i=0; i<lineas.size(); i++) {
			Linea linea = lineas.get(i);
			vista.sel_billete.boxLineas.addItem(linea);
		}
		
	}
}