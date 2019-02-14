package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.*;
import vista.MainFrame;

public class ControladorBillete implements ActionListener {
	
	public MainFrame vista;
	public Modelo modelo;
	private ArrayList<Parada> paradas;
	Linea linea;
	Parada paradaOrigen;
	Parada paradaDestino;
	boolean billeteSimple;
	
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
				
				// comprobamos que los campos no estan vacios
				if(validarDatos()) {
					
					// actualizamos los componentes del siguiente panel y lo hacemos visible
					actualizarFrame(paradaOrigen, paradaDestino, billeteSimple);
					
					// guardamos los datos en el modelo
					guardarDatos(linea, paradaOrigen, paradaDestino, billeteSimple);
					
				}
				
				break;
			
			}
	
		} else if (sourceObject instanceof JComboBox) {
			
			String comboBox = ((JComboBox) sourceObject).getActionCommand();
		   
			// guarda la linea seleccionada
			Linea linea = (Linea) vista.sel_billete.boxLineas.getSelectedItem();
			
			if (linea != null) {
				
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
	
	public boolean validarDatos() {
		
		// guardar linea
		this.linea = (Linea) vista.sel_billete.boxLineas.getSelectedItem();
		
		// guardar parada de origen
		if (vista.sel_billete.listaOrigen.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(vista, "Ninguna parada de origen seleccionada.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.paradaOrigen = (Parada) vista.sel_billete.listaOrigen.getSelectedValue();
		}
		
		// guardar parada de destino
		if (vista.sel_billete.listaDestino.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(vista, "Ninguna parada de destino seleccionada.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.paradaDestino = (Parada) vista.sel_billete.listaDestino.getSelectedValue();
		}
		
		// comprobar que la parada de origen y destino no sean la misma
		if (this.paradaOrigen.getCodParada() == this.paradaDestino.getCodParada()) {
			JOptionPane.showMessageDialog(vista, "Las paradas de origen y destino no pueden ser iguales", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		// guardar tipo de billete
		if (!vista.sel_billete.rbtnIda.isSelected() && !vista.sel_billete.rbtnVuelta.isSelected()) {
			JOptionPane.showMessageDialog(vista, "Ningun tipo de billete seleccionado.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			this.billeteSimple = vista.sel_billete.rbtnIda.isSelected();
		}
		
		return true;
		
	}
	
	public void guardarDatos(Linea linea, Parada paradaOrigen, Parada paradaDestino, boolean simple) {
		
		modelo.linea = linea;
		modelo.paradaOrigen = paradaOrigen;
		modelo.paradaDestino = paradaDestino;
		modelo.billeteIda = new Billete();
		modelo.billeteIda.setCodLinea(linea.getCodLinea());
		modelo.billeteIda.setCodParadaInicio(paradaOrigen.getCodParada());
		modelo.billeteIda.setCodParadaFin(paradaDestino.getCodParada());
		modelo.billeteIda.setNTrayecto(1);
		
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
			modelo.billeteVuelta.setCodParadaInicio(paradaDestino.getCodParada());
			modelo.billeteVuelta.setCodParadaFin(paradaOrigen.getCodParada());
			modelo.billeteVuelta.setNTrayecto(2);
			
		}
		
	}
	
	public void actualizarFrame(Parada paradaOrigen, Parada paradaDestino, boolean simple) {
		
		// limpia los textFields de la siguiente pantalla
		vista.sel_fecha.txtOrigen.removeAll();
		vista.sel_fecha.txtDestino.removeAll();
		
		// carga los nombres de las paradas en la siguiente pantalla
		vista.sel_fecha.txtOrigen.setText(paradaOrigen.getNombre());
		vista.sel_fecha.txtDestino.setText(paradaDestino.getNombre());
		
		// creamos una fecha limite
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date fechaLimite = null;
		try {
			fechaLimite = new Date(df.parse("12-31-2020").getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// actualizamos las fechas disponibles para la ida
		vista.sel_fecha.fechaIda.setSelectableDateRange(new Date(),fechaLimite);
		
		// comprobamos si existe billete de vuelta
		if (simple) {
			
			// ocultamos el JCalendar para la fecha de vuelta en la siguiente pantalla
			vista.sel_fecha.panFechaVuelta.setVisible(false);
			
		} else {
			
			// mostramos el JCalendar para la fecha de vuelta en la siguiente pantalla
			vista.sel_fecha.panFechaVuelta.setVisible(true);
			
			// actualizamos las fechas disponibles para la ida
			vista.sel_fecha.fechaVuelta.setSelectableDateRange(new Date(),fechaLimite);
			
		}
		
		// muestra el siguiente panel 'sel_fecha'
		vista.sel_fecha.setVisible(true);
		vista.sel_billete.setVisible(false);
		
	}
	
}
