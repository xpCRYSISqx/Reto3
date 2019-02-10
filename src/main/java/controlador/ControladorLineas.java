package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Modelo;
import modelo.Parada;
import vista.MainFrame;

public class ControladorLineas implements ActionListener, ListSelectionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	private ArrayList<Parada> paradas;
	
	public ControladorLineas(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;	
	}
	
	// añadimos listeners a los botones del panel 'sel_linea'
	public void addListeners() {
		vista.sel_linea.btnCancelar.addActionListener(this);
		vista.sel_linea.btnLogin.addActionListener(this);
		vista.sel_linea.btnRegistro.addActionListener(this);
		vista.sel_linea.btnContinuar.addActionListener(this);
		vista.sel_linea.listLineas.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {			
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.sel_linea.setVisible(false);
				break;
				
			case "Inicio Sesión":
				
				vista.login.setVisible(true);
				vista.sel_linea.setVisible(false);
				ControladorLogin.panelOrigen = vista.sel_linea;
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.sel_linea.setVisible(false);
				ControladorRegistro.panelOrigen = vista.sel_linea;
				break;
				
			case "Continuar":
				
				// muestra el siguiente panel 'sel_billete'
				vista.sel_billete.setVisible(true);
				vista.sel_linea.setVisible(false);
				
				// limpia el JList
				vista.sel_billete.modeloOrigen.removeAllElements();
				vista.sel_billete.modeloDestino.removeAllElements();
				
				// guarda la linea seleccionada
				String codLinea = vista.sel_linea.listLineas.getSelectedValue();
				
				// carga las paradas de la linea selecciona desde la BBDD y las muestra en el JList
				paradas = modelo.consultas.getParadasByLinea(codLinea); 				
				for(int i=0; i<paradas.size(); i++) {
					vista.sel_billete.modeloOrigen.addElement(paradas.get(i).getNombre());
					vista.sel_billete.listaOrigen.setModel(vista.sel_billete.modeloOrigen);
					vista.sel_billete.modeloDestino.addElement(paradas.get(i).getNombre());
					vista.sel_billete.listaDestino.setModel(vista.sel_billete.modeloDestino);
				}
				
				break;
		
		}
		
	}
	
	public void valueChanged(ListSelectionEvent arg0) {
		
		// limpia el JList
		vista.sel_linea.modeloParadas.removeAllElements();
		
		// guarda la linea seleccionada
		String codLinea = vista.sel_linea.listLineas.getSelectedValue();
		
		// carga las paradas de la linea selecciona desde la BBDD y las muestra en el JList
		paradas = modelo.consultas.getParadasByLinea(codLinea);
		for(int i=0; i<paradas.size(); i++) {
			vista.sel_linea.modeloParadas.addElement(paradas.get(i).getNombre());
			vista.sel_linea.listParadas.setModel(vista.sel_linea.modeloParadas);
		}
		
	}
	
}
