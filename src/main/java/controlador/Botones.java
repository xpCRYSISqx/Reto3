package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;
import modelo.*;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import vista.MainFrame;
import vista.PanSelLinea;
import controlador.*;

public class Botones {
	public MainFrame vista;
	public Modelo modelo;
	public boolean logeado;
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
				TimerTask tarea=new TimerTask(){
					public void run(){
						panDeseado.setVisible(false);
						panSalida.setVisible(true);
					}
				};
				//se crea un objeto de tipo timer
				Timer tiempo=new Timer();
				//se indica la tarea a ejecutar y el retardo
				tiempo.schedule(tarea, 60000);
			}
		});
	}
	
	public void BotonContinuarInicio(JButton boton, JPanel panSalida, JPanel panDeseado) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
				TimerTask tarea=new TimerTask(){
					public void run(){
						panDeseado.setVisible(false);
						panSalida.setVisible(true);
					}
				};
				//se crea un objeto de tipo timer
				Timer tiempo=new Timer();
				//se indica la tarea a ejecutar y el retardo
				tiempo.schedule(tarea, 60000);
			}
		});
	}
	
	
	public void BotonIrRegistro(JButton boton, JPanel panSalida, JPanel panRegistro) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panRegistro.setVisible(true);
				panSalida.setVisible(false);
				setPanDeseado(panSalida);
			}
		});
	}
	public void IrInicioSesionARegistro(JButton boton, JPanel panInicio, JPanel panRegistro) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panRegistro.setVisible(true);
				panInicio.setVisible(false);
			}
		});
	}
	public void BotonIrInicioSesion(JButton boton, JPanel panSalida, JPanel panInicioSesion) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panInicioSesion.setVisible(true);
				panSalida.setVisible(false);
				setPanDeseado(panSalida);
			}
		});
	}
	public void CancelarInicioSesion(JButton boton, JPanel panInicio) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panDeseado = getPanDeseado();
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
					System.out.println(i);
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
//					vista.sel_linea.modeloParadas.addElement(paradas.get(i).getNombre());
//					vista.sel_linea.modeloParadas.addElement(paradas.get(i).getCodParada());
					vista.sel_linea.listParadas.setModel(vista.sel_linea.modeloParadas);
				}
			}
		});
	}
	public void IniciarSesion(JButton boton, JTextField usuario, JPasswordField contrasena, JPanel panLogin) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = null;
				String contString;
				char[] cont;
				boolean logeado;
				JPanel panDeseado = getPanDeseado();
				
				dni = usuario.getText();
				cont = contrasena.getPassword();
				contString = new String(cont);
				setLogeado(dni, contString);
				logeado = getLogeado();
				if(logeado == true) {
					panDeseado.setVisible(true);
					panLogin.setVisible(false);
				}
			}
		});
	}
	public void Registrar(JButton boton, JPanel panRegistro, JTextField nom, JTextField ape, JDateChooser fecha0, JTextField dni0,JRadioButton femenino0, JRadioButton masculino0, JPasswordField contChar, JPasswordField contChar2) {
		String dni = null;
		String contrasena;
		String contrasenaConfirmar;
		String nombre;
		String apellidos;
		Date fecha;
		boolean femenino;
		boolean masculino;
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
		fecha = (Date) fecha0.getDate();
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
		switch(registrado) {
			case 0: panDeseado.setVisible(true);
					panRegistro.setVisible(false);
			break;
			case 1:
			break;
			case 2:
			break;
			case 3:
			break;
		}
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
}

