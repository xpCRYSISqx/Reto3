package controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.*;
import vista.MainFrame;

public class Controlador {
	
	//Atributos
	public Modelo modelo;
	public MainFrame vista;
	
	//Constructor con parametros
	public Controlador(Modelo modelo, MainFrame vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void inicializarEventos() {
		
		// crea un objeto billete y lo inserta en bbdd
		try {
			// creamos la fecha y hora
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			java.sql.Date fecha = new java.sql.Date(df.parse("02-04-2015").getTime());
			java.sql.Time time = java.sql.Time.valueOf( "18:05:00" );
			
			// creamos el objeto billete
			Billete billete = modelo.crearBillete(1234, 2, "L2", 1002, 3, 6, fecha, time, "15236985K", 45.5f);
			
			modelo.comprobarFechasBillete(billete);
			
			// insertamos los datos del billete en la bbdd
			//modelo.insertarBillete(billete);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
	}
	
	public void inicializarInterfaz() {
		vista.setVisible(true);
		vista.bienvenida.setVisible(true);
		vista.sel_linea.setVisible(false);
		vista.sel_billete.setVisible(false);
		vista.sel_fecha.setVisible(false);
		vista.detalles_compra.setVisible(false);
		vista.login.setVisible(false);
		vista.registro.setVisible(false);
		vista.pago.setVisible(false);
		vista.fin_pago.setVisible(false);
		vista.agur.setVisible(false);
	}
	
	public void manejoInterfaz() {
		Botones botones = new Botones();
		botones.BotonContinuar(vista.bienvenida.btnContinuar, vista.bienvenida, vista.sel_linea);
		botones.BotonContinuar(vista.sel_linea.btnContinuar, vista.sel_linea, vista.sel_billete);
		botones.BotonContinuar(vista.sel_billete.btnContinuar, vista.sel_billete, vista.sel_fecha);
		botones.BotonContinuar(vista.sel_fecha.btnContinuar, vista.sel_fecha, vista.detalles_compra);
		botones.BotonContinuar(vista.detalles_compra.btnContinuar, vista.detalles_compra, vista.login);
		botones.BotonInicioSesion(vista.login.btnLogin, vista.login, vista.pago);
		botones.BotonRegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.BotonRegistro(vista.sel_linea.btnRegistro, vista.sel_linea, vista.registro);
		botones.BotonRegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.BotonRegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.BotonRegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.BotonRegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.BotonRegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.BotonContinuar(vista.pago.btnContinuar, vista.pago, vista.fin_pago);
		botones.BotonContinuarFinal(vista.fin_pago.btnContinuar, vista.fin_pago, vista.agur, vista.bienvenida);
		
	}

}
