package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import modelo.Modelo;
import modelo.Paradas;
import vista.MainFrame;

public class ControladorBillete implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	private ArrayList<Paradas> paradas;
	
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
				
				// limpia el JList
				vista.sel_fecha.txtOrigen.removeAll();
				vista.sel_fecha.txtDestino.removeAll();
				
				// guarda las paradas seleccionadas
				String origen = (String) vista.sel_billete.listaOrigen.getSelectedValue();
				String destino = (String) vista.sel_billete.listaDestino.getSelectedValue();
				
				// carga las paradas en la siguiente pantalla
				vista.sel_fecha.txtOrigen.setText(origen);
				vista.sel_fecha.txtDestino.setText(destino);
				
				// guarda el tipo de billete seleccionado
				boolean simple = vista.sel_billete.rbtnIda.isSelected();
				boolean idaVuelta = vista.sel_billete.rbtnVuelta.isSelected();
				
				// ocultar el panel de la fecha de vuelta si se elige billete de tipo simple
					if (simple) {
						vista.sel_fecha.panFechaVuelta.setVisible(false);
					} else {
						vista.sel_fecha.panFechaVuelta.setVisible(true);
					}
					
					break;
			
			}
	
		} else if (sourceObject instanceof JComboBox) {
			
			String comboBox = ((JComboBox) sourceObject).getActionCommand();
		   
			// guarda la linea seleccionada
			String codLinea = vista.sel_billete.boxLineas.getSelectedItem().toString();
			
			// limpia el JList
			vista.sel_billete.modeloOrigen.removeAllElements();
			vista.sel_billete.modeloDestino.removeAllElements();
			
			// carga las paradas de la linea selecciona desde la BBDD y las muestra en el JList
			paradas = modelo.consultas.getParadasByLinea(codLinea); 			
			
			// carga las paradas de la linea selecciona desde la BBDD y las muestra en el JList
			for(int i=0; i<paradas.size(); i++) {

				// carga las paradas en el jlist origen
				vista.sel_billete.modeloOrigen.addElement(paradas.get(i).getNombre());
				vista.sel_billete.listaOrigen.setModel(vista.sel_billete.modeloOrigen);
				
				// carga las paradas en el jlist destino
				vista.sel_billete.modeloDestino.addElement(paradas.get(i).getNombre());
				vista.sel_billete.listaDestino.setModel(vista.sel_billete.modeloDestino);
				
			}
		  
		}
		
	}
	
}
