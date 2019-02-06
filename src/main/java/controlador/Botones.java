package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import vista.MainFrame;
import modelo.*;

public class Botones {
	public MainFrame vista;
	public Modelo modelo;
	public boolean logeado = false;
	public boolean detalles = false;
	public int registrado;
	private JPanel panDeseadoInicio;
	private ArrayList<Linea> lineas1;
	private ArrayList<Parada> paradas;

	public Botones (Modelo modelo, MainFrame vista) {
		this.vista = vista;
		this.modelo = modelo;
	}
	
	public void BotonContinuar(JButton boton, JPanel panSalida, JPanel panDeseado) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
//				TimerTask tarea=new TimerTask(){
//					public void run(){
//						panDeseado.setVisible(false);
//						panSalida.setVisible(true);
//					}
//				};
//				//se crea un objeto de tipo timer
//				Timer tiempo=new Timer();
//				//se indica la tarea a ejecutar y el retardo
//				tiempo.schedule(tarea, 60000);
			}
		});
	}
	public void BotonIrRegistro(JButton boton, JPanel panSalida, JPanel panRegistro) { //Este boton se utiliza para ir a la ventana de registro desde las otras ventanas, menos de la de log in
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panRegistro.setVisible(true);
				panSalida.setVisible(false);
				setPanDeseado(panSalida);
			}
		});
	}
	public void CancelarRegistro(JButton boton, JPanel panRegistro) { //Este boton se utiliza para volver a la ventana en la que se estaba al darle al boton de cancelar en la ventana de registro
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panDeseado = getPanDeseado(); //Esta bariable saca el panel desde el cual se habia venido al panel de registro para poder volver a el, menos si se estaba en el de inicio de sesion
				panDeseado.setVisible(true);
				panRegistro.setVisible(false);
			}
		});
	}
	public void IrInicioSesionARegistro(JButton boton, JPanel panInicio, JPanel panRegistro) { //Este boton se utiliza para ir de la ventana de inicio de sesion a la de registro, no guarda la ventana en la que se estaba
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panRegistro.setVisible(true);
				panInicio.setVisible(false);
			}
		});
	}
	public void IrDetallesBilleteAPago(JButton boton, JPanel detalles, JPanel pago, JPanel inicioSesion) { //Este boton se utiliza para ir de la ventana de detalles a la de pago o a la de inicio de sesion al darle a continuar
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean logeado = getLogeado(); //Esta variable se utiliza para comprobar si se esta logeado o no
				boolean detalle = true; //Esta variable se utiliza para especificar si se viene de la ventana de detalles, es importante en los botones de inicio de sesion y de registro
				setPanDeseado(detalles); //Guarda la ventana en al que se esta en setPanDeseado
				setDetalles(detalle); //Guarda el valos de la variabel detalle en setDetalles
				if(logeado == true) { //Comprueba si se esta logeado para saber a que panel debe saltar
					pago.setVisible(true);
					detalles.setVisible(false);
				}
				else {
					inicioSesion.setVisible(true);
					detalles.setVisible(false);
				}
			}
		});
	}
	public void BotonIrInicioSesion(JButton boton, JPanel panSalida, JPanel panInicioSesion) { //Boton para ir a la ventana de inicio de sesion desde las demas ventanas, menos desde la ventana de registro
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panInicioSesion.setVisible(true);
				panSalida.setVisible(false);
				setPanDeseado(panSalida); //Guarda la ventana en la que se esta en setPanDeseado
			}
		});
	}
	public void CancelarInicioSesion(JButton boton, JPanel panInicio) { //Boton para cancelar el inicio de sesion
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panDeseado = getPanDeseado(); //Llama a la funcion getPanDeseado para recoger el panel en el que se estaba a la hora de ir a inicio de sesion
				panDeseado.setVisible(true);
				panInicio.setVisible(false);
			}
		});
	}
	public void IrRegistroAInicioSesion(JButton boton, JPanel panInicio, JPanel panRegistro) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panInicio.setVisible(true);
				panRegistro.setVisible(false);
			}
		});
	}
	public void IrBienveLineas(JList<?> lista,JButton boton, JPanel bienvenida, JPanel lineas) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lineas.setVisible(true);
				bienvenida.setVisible(false);
				lineas1 = modelo.consultas.getLineas();
				String nombre;
				vista.sel_linea.modeloLineas.removeAllElements();
				for(int i=0; i<lineas1.size(); i++) {
					nombre = lineas1.get(i).getCodLinea();
					//nombre = "[" + nombre + "]" + " " + lineas1.get(i).getNombre();
					vista.sel_linea.modeloLineas.addElement(nombre);
					vista.sel_linea.listLineas.setModel(vista.sel_linea.modeloLineas);
				}
				
			}
		});
	}
	public void MostrarParadas(JList<?> lineas ,JList<?> listaParadas) {
		lineas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				vista.sel_linea.modeloParadas.removeAllElements();
				String codLinea = vista.sel_linea.listLineas.getSelectedValue();
				paradas = modelo.consultas.getParadasByLinea(codLinea);
				for(int i=0; i<paradas.size(); i++) {
					vista.sel_linea.modeloParadas.addElement(paradas.get(i).getNombre());
					vista.sel_linea.listParadas.setModel(vista.sel_linea.modeloParadas);
				}
			}
		});
	}
	public void AtrasBilleteLineas(JButton boton, JPanel lineas, JPanel billete) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lineas.setVisible(true);
				billete.setVisible(false);
			}
		});
	}
	
	public void ContinuarLineaBillete (JList<?> listaOrigen, JList<?> listaDestino, JButton boton, JPanel linea, JPanel billete) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				billete.setVisible(true);
				linea.setVisible(false);
				vista.sel_billete.modeloOrigen.removeAllElements();

				vista.sel_billete.modeloDestino.removeAllElements();
	
				String codLinea = vista.sel_linea.listLineas.getSelectedValue();
				paradas = modelo.consultas.getParadasByLinea(codLinea); 				
				for(int i=0; i<paradas.size(); i++) {
					vista.sel_billete.modeloOrigen.addElement(paradas.get(i).getNombre());
					vista.sel_billete.listaOrigen.setModel(vista.sel_billete.modeloOrigen);
					vista.sel_billete.modeloDestino.addElement(paradas.get(i).getNombre());
					vista.sel_billete.listaDestino.setModel(vista.sel_billete.modeloDestino);

				}
			}
		});
	}
	
	public void ContinuarBilleteFecha (JButton boton, JPanel billete, JPanel fecha) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecha.setVisible(true);
				billete.setVisible(false);
				vista.sel_fecha.txtOrigen.removeAll();
				vista.sel_fecha.txtDestino.removeAll();
				String origen = (String) vista.sel_billete.listaOrigen.getSelectedValue();
				String destino = (String) vista.sel_billete.listaDestino.getSelectedValue();
				
				vista.sel_fecha.txtOrigen.setText(origen);
				vista.sel_fecha.txtDestino.setText(destino);
			}
		});
	}
	
	public void IniciarSesion(JButton boton, JTextField usuario, JPasswordField contrasena, JPanel panLogin, JPanel panPago) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = null;
				String contString;
				char[] cont;
				boolean logeado;
				boolean detalles;
				JPanel panDeseado = getPanDeseado();
				
				dni = usuario.getText();
				cont = contrasena.getPassword();
				contString = new String(cont);
				setLogeado(dni, contString);
				logeado = getLogeado();
				detalles = getDetalles();
				if(logeado == true) {
					if(detalles == false) {
						panDeseado.setVisible(true);
						panLogin.setVisible(false);
					}
					else {
						panPago.setVisible(true);
						panLogin.setVisible(false);
					}
				}
			}
		});
	}
	public void Registrar(JButton boton, JPanel panRegistro, JPanel panPago, JTextField nom, JTextField ape, JDateChooser fecha0, JTextField dni0,JRadioButton femenino0, JRadioButton masculino0, JPasswordField contChar, JPasswordField contChar2, JLabel errorContrasena, JLabel errorDNI, JLabel errorSexo, JLabel errorDNINoIntroducido) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = null;
				String contrasena;
				String contrasenaConfirmar;
				String nombre;
				String apellidos;
				java.sql.Date fecha;
				boolean femenino;
				boolean masculino;
				boolean detalles;
				char sexo = 'n';
				char[] cont;
				char[] contConfirmar;
				int registrado;
				Encriptacion encriptar = new Encriptacion();
				JPanel panDeseado = getPanDeseado();
				
				dni = dni0.getText();
				nombre = nom.getText();
				apellidos = ape.getText();
				cont = contChar.getPassword();
				contrasena = new String(cont);
				fecha = new java.sql.Date(fecha0.getDate().getTime());
				contrasena = encriptar.Encriptacion(contrasena);
				contConfirmar = contChar2.getPassword();
				contrasenaConfirmar = new String(contConfirmar);
				contrasenaConfirmar = encriptar.Encriptacion(contrasenaConfirmar);
				femenino = femenino0.isSelected();
				masculino = masculino0.isSelected();
				if(femenino == true)
					sexo = 'M';
				else if(masculino == true)
					sexo = 'V';
				else
					sexo = 'n';
				
				setRegistrado(nombre, apellidos, fecha, dni, sexo, contrasena, contrasenaConfirmar);
				registrado = getRegistrado();
				detalles = getDetalles();
				switch(registrado) {
					case 0: if(detalles == false) {
								panDeseado.setVisible(true);
								panRegistro.setVisible(false);
							}
							else {
								panPago.setVisible(true);
								panRegistro.setVisible(false);
							}
					break;
					case 1: errorDNI.setVisible(true);
						errorDNINoIntroducido.setVisible(false);
						errorContrasena.setVisible(false);
						errorSexo.setVisible(false);
					break;
					case 2: errorContrasena.setVisible(true);
						errorDNI.setVisible(false);
						errorDNINoIntroducido.setVisible(false);
						errorSexo.setVisible(false);
					break;
					case 3: errorSexo.setVisible(true);
						errorDNI.setVisible(false);
						errorDNINoIntroducido.setVisible(false);
						errorContrasena.setVisible(false);
					break;
					case 4: errorDNINoIntroducido.setVisible(true);
						errorDNI.setVisible(false);
						errorContrasena.setVisible(false);
						errorSexo.setVisible(false);
					break;
				}
			}
		});
	}
	private void setLogeado(String usuario, String contrasena) {
		ComprobarInicioSesion comprobar = new ComprobarInicioSesion();
		
		logeado = comprobar.comprobarInicio(usuario, contrasena);
	}
	public boolean getLogeado() {
		return this.logeado;
	}
	public void setRegistrado(String nombre, String apellidos, Date fecha, String dni, char sexo, String contrasena, String contrasena2) {
		ComprobarRegistro comprobar = new ComprobarRegistro();
		
		registrado = comprobar.comprobarRegistro(nombre, apellidos, fecha, dni, sexo, contrasena, contrasena2);
	}
	public int getRegistrado() {
		return this.registrado;
	}
	private void setPanDeseado(JPanel panDeseado) {
		this.panDeseadoInicio = panDeseado;
	}
	private JPanel getPanDeseado() {
		return this.panDeseadoInicio;
	}
	public void setDetalles(boolean detalles) {
		this.detalles = detalles;
	}
	public boolean getDetalles() {
		return this.detalles;
	}
}



