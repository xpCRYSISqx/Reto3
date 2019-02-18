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

/**
 * Esta clase se utiliza pra controlar el panel de billete y enlazarlo con el modelo
 * 
 * @author Ustaritz, Laura, Mikel
 * 
 * @param vista: Instancia del main frame para poder utilizarlo
 * @param modelo: Instancia del modelo para poder utilizarlo
 * @param paradas: ArrayList del objeto paradas, se utiliza para almacenar la informacion de las diferentes paradas
 * @param linea: Crea el objeto linea, para almacenar la informacion que seleccione el usuario
 * @param paradaOrigen: Crea el objeto paradaOrigen, para guardar la parada de origen del usuario
 * @param paradaDestino: Crea el objeto paradaDestino, para guardar la informacion de la parada de destino del usuario
 * @param billeteSimple: Le dice al programa si el usuario ha seleccionado una billete simple o uno de ida y vuelta
 * @param botonPulsado: Se utiliza para poder saber que boton es el que ha sido pulsado
 * @param df: Es utilizado para indicar el formato de la fechaç
 * @param fechaLimite: Almacena la informacion de la fecha seleccionada
 *
 */
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
				reset();
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
		
		ArrayList<Autobus> autobuses;
		ArrayList<Municipio> municipios;
		ArrayList<Integer> codParadas;
		
		// creamos el billete de ida
		if (modelo.billeteIda == null) {
			modelo.billeteIda = new Billete();
		}
		
		// guardamos los datos de la linea en el modelo
		modelo.linea = linea;
		autobuses = modelo.consultas.getAutobusesByLinea(linea.getCodLinea());
		municipios = modelo.consultas.getMunicipiosByLinea(linea.getCodLinea());
		
		// cargamos los codigos de las paradas
		for(int i = 0;i<municipios.size();i++) {
			codParadas = new ArrayList<Integer>();
			paradas = modelo.consultas.getParadasByMunicipio(municipios.get(i).getCodPostal());
			for(int j = 0;j<paradas.size();j++) {
				codParadas.add(paradas.get(j).getCodParada());
			}
			municipios.get(i).setCodParadas(codParadas);
		}
		linea.setAutobuses(autobuses);
		linea.setMunicipios(municipios);

		// guardamos los datos de las paradas en el modelo
		modelo.paradaOrigen = paradaOrigen;
		modelo.paradaDestino = paradaDestino;
		
		// guardamos los datos del billete de ida en el modelo
		modelo.billeteIda.setCodLinea(linea.getCodLinea());
		modelo.billeteIda.setCodParadaInicio(paradaOrigen.getCodParada());
		modelo.billeteIda.setCodParadaFin(paradaDestino.getCodParada());
		modelo.billeteIda.setNTrayecto(1);
		
		// comprobamos si se ha seleccionado billete de tipo 'simple' o 'ida y vuelta'
		if (!simple) {
			
			// creamos el billete de vuelta
			if (modelo.billeteVuelta == null) {
				modelo.billeteVuelta = new Billete();
			}
			
			// guardamos los datos del billete de vuelta en el modelo
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
		if (!simple) {
			
			// mostramos el JCalendar para la fecha de vuelta en la siguiente pantalla
			vista.sel_fecha.panFechaVuelta.setVisible(true);
			
			// actualizamos las fechas disponibles para la ida
			vista.sel_fecha.fechaVuelta.setSelectableDateRange(new Date(),fechaLimite);
			
		}
		
		// muestra el siguiente panel 'sel_fecha'
		vista.sel_fecha.setVisible(true);
		vista.sel_billete.setVisible(false);
		
	}
	
	public void reset() {
		modelo.cliente = null;
		modelo.billeteIda = null;
		modelo.billeteVuelta = null;
		modelo.linea = null;
		modelo.paradaOrigen = null;
		modelo.paradaDestino = null;
		modelo.autobus = null;
		modelo.precioTotal = 0;
		
		vista.sel_billete.rbtnIda.setSelected(true);
		vista.sel_billete.rbtnVuelta.setSelected(false);
		
		vista.login.userField.setText("");
		vista.login.password.setText("");
		
		vista.registro.txtNombre.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.rbtnMasc.setSelected(false);
		vista.registro.rbtnFem.setSelected(false);
		vista.registro.txtDni.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
	}
	
}
