package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.*;
import vista.*;


public class InteraccionesInterfaz {
	private MainFrame vista;
	private Modelo modelo;
	private ArrayList<Linea> lineas1;

	public InteraccionesInterfaz (Modelo modelo, MainFrame vista) {
		this.vista = vista;
		this.modelo = modelo;
	}

	
	
	public void ListaMostrarLinea(JList<?> lineas, JButton boton) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lineas.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						lineas1 = modelo.consultas.getLineas();
						String nombre;
						for(int i=0; i<lineas1.size(); i++) {
							nombre = lineas1.get(i).getNombre();
							System.out.println(i);
							vista.sel_linea.modeloLineas.addElement(nombre);
						}
//						vista.sel_linea.listLineas.setModel(vista.sel_linea.modelo);
					}
			
				});
			}
		});
		
		
	}
}
