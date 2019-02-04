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
import modelo.Linea;
import modelo.Modelo;
import vista.MainFrame;

public class Botones {
	public MainFrame vista;
	public Modelo modelo;
	public boolean logeado;
	public int registrado;
	private JPanel panDeseadoInicio;

	
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
	public void BotonContinuarFinal(JButton boton, JPanel panSalida, JPanel panDeseado, JPanel panContador) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panDeseado.setVisible(true);
				panSalida.setVisible(false);
				TimerTask tarea=new TimerTask(){
					public void run(){
						panDeseado.setVisible(false);
						panContador.setVisible(true);
					}
				};
				//se crea un objeto de tipo timer
				Timer tiempo=new Timer();
				//se indica la tarea a ejecutar y el retardo
				tiempo.schedule(tarea, 5000);
			}
		});
	}
	public void BotonIrRegistro(JButton boton, JPanel panSalida, JPanel panRegistro) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panRegistro.setVisible(true);
				panSalida.setVisible(false);
				setPanDeseadoInicio(panSalida);
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
				setPanDeseadoInicio(panSalida);
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

	
	public void BotonMostrarLinea(JList<?> lineas,JPanel sel_linea) {
		lineas.addListSelectionListener(new ListSelectionListener() {
			public void addListSelectionListener (ListSelectionListener  x) {
				setPanDeseadoInicio(sel_linea);
				CargarLineas(lineas, sel_linea);
			}
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
				//addListSelectionListener(ListSelectionListener x)
			}
		});
		
	}
	
	private void CargarLineas(JList<?> lineas, JPanel sel_linea) {
		ArrayList<Linea> lineas1 = modelo.consultas.getLineas();
		
	}


	public void IniciarSesion(JButton boton, JTextField usuario, JPasswordField contrasena, JPanel panLogin) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = null;
				String contString;
				char[] cont;
				boolean logeado;
				JPanel panDeseado = getPanDeseadoInicio();
				
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
		JPanel panDeseado = getPanDeseadoInicio();
		
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
	private void setPanDeseadoInicio(JPanel panDeseado) {
		this.panDeseadoInicio = panDeseado;
	}
	private JPanel getPanDeseadoInicio() {
		return this.panDeseadoInicio;
	}
}

