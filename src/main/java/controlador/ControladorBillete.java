package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modelo.*;
import vista.MainFrame;

public class ControladorBillete implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	private ArrayList<Parada> paradas;
	
	public ControladorBillete(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;		
	}
	
	// añadimos listeners a los botones del panel 'sel_billete'
	public void addListeners() {
		vista.sel_billete.btnCancelar.addActionListener(this);
		vista.sel_billete.btnLogin.addActionListener(this);
		vista.sel_billete.btnRegistro.addActionListener(this);
		vista.sel_billete.btnContinuar.addActionListener(this);
		vista.sel_billete.boxLineas.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
				
		Object sourceObject = e.getSource();
		
		if (sourceObject instanceof JButton) {
			
			String botonPulsado = ((JButton) sourceObject).getActionCommand();
		   
			// comprobamos que boton se ha pulsado y ejecutamos sus acciones
			switch (botonPulsado) {
			
			case "Cancelar":
				
				vista.bienvenida.setVisible(true);
				vista.sel_billete.setVisible(false);
				break;
				
			case "Inicio Sesión":
				
				vista.login.setVisible(true);
				vista.sel_billete.setVisible(false);
				ControladorLogin.panelOrigen = vista.sel_billete;
				break;
				
			case "Registro":
				
				vista.registro.setVisible(true);
				vista.sel_billete.setVisible(false);
				ControladorRegistro.panelOrigen = vista.sel_billete;
				break;
				
			case "Continuar":
				
				// muestra el siguiente panel 'sel_fecha'
				vista.sel_fecha.setVisible(true);
				vista.sel_billete.setVisible(false);
				
				// guarda la linea seleccionada
				Linea linea = (Linea) vista.sel_billete.boxLineas.getSelectedItem();
				
				// guardamos las paradas seleccionadas
				Parada origen = (Parada) vista.sel_billete.listaOrigen.getSelectedValue();
				Parada destino = (Parada) vista.sel_billete.listaDestino.getSelectedValue();
				
				// guardamos el tipo de billete seleccionado
				boolean simple = vista.sel_billete.rbtnIda.isSelected();
				boolean idaVuelta = vista.sel_billete.rbtnVuelta.isSelected();
				
				// limpia los textFields de la siguiente pantalla
				vista.sel_fecha.txtOrigen.removeAll();
				vista.sel_fecha.txtDestino.removeAll();
				
				// carga las paradas en la siguiente pantalla
				vista.sel_fecha.txtOrigen.setText(origen.getNombre());
				vista.sel_fecha.txtDestino.setText(destino.getNombre());
				
				// añadimos los datos al objeto billeteIda
				modelo.billeteIda = new Billete();
				modelo.billeteIda.setCodLinea(linea.getCodLinea());
				modelo.billeteIda.setCodParadaInicio(origen.getCodParada());
				modelo.billeteIda.setCodParadaFin(destino.getCodParada());
				
				// comprobamos si se ha seleccionado billete de tipo 'simple' o 'ida y vuelta'
				if (simple) {
					
					// ocultamos el JCalendar para la fecha de vuelta en la siguiente pantalla
					vista.sel_fecha.panFechaVuelta.setVisible(false);
					
				} else {
					
					// mostramos el JCalendar para la fecha de vuelta en la siguiente pantalla
					vista.sel_fecha.panFechaVuelta.setVisible(true);
					
					// añadimos los datos al objeto billeteVuelta
					modelo.billeteVuelta = new Billete();
					modelo.billeteVuelta.setCodLinea(linea.getCodLinea());
					modelo.billeteVuelta.setCodParadaInicio(destino.getCodParada());
					modelo.billeteVuelta.setCodParadaFin(origen.getCodParada());
					
				}
				
				break;
			
			}
	
		} else if (sourceObject instanceof JComboBox) {
			
			String comboBox = ((JComboBox) sourceObject).getActionCommand();
		   
			// guarda la linea seleccionada
			Linea linea = (Linea) vista.sel_billete.boxLineas.getSelectedItem();
			String codLinea = linea.getCodLinea();
			
			// limpia los JList de las paradas
			vista.sel_billete.modeloOrigen.removeAllElements();
			vista.sel_billete.modeloDestino.removeAllElements();
			
			// carga las paradas de la linea selecciona desde la BBDD
			paradas = modelo.consultas.getParadasByLinea(codLinea); 			
			
			//muestra las paradas en los JList
			for(int i=0; i<paradas.size(); i++) {

				// carga las paradas en el jlist origen
				vista.sel_billete.modeloOrigen.addElement(paradas.get(i));
				vista.sel_billete.listaOrigen.setModel(vista.sel_billete.modeloOrigen);
				
				// carga las paradas en el jlist destino
				vista.sel_billete.modeloDestino.addElement(paradas.get(i));
				vista.sel_billete.listaDestino.setModel(vista.sel_billete.modeloDestino);
				
			}
		  
		}
		
	}
	
}
