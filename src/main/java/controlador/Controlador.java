package controlador;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.*;
import vista.MainFrame;

public class Controlador {
	
	// Atributos
	public Modelo modelo;
	public MainFrame vista;
	public boolean logeado;
	
	// Constructor con parametros
	public Controlador(Modelo modelo, MainFrame vista) {
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void inicializarEventos() {
		
		/*
		 * Como sacar los datos de las lineas
		 */
		
		// cargamos las lineas en un array list
		ArrayList<Linea> lineas = modelo.consultas.getLineas();
		
		// estas variables las usaremos para almacenar los codigos de autobuses y municipios que pertenecen a esa linea
		ArrayList<Integer> codAutobuses;
		ArrayList<Integer> codMunicipios;
		
		
		// recorremos el array list de lineas
		for (int i = 0; i < lineas.size(); i++) { 		      
	      System.out.print(lineas.get(i).getCodLinea()+": ");
	      System.out.println(lineas.get(i).getNombre());
	     
	      // el atributo codAutobuses del objeto linea es un array list
	      // lo almacenamos en la variable que hemos creado antes y lo recorremos con un for
	      System.out.println("Autobuses:");
	      codAutobuses = lineas.get(i).getCodAutobuses();
	      for (int j = 0; j < codAutobuses.size(); j++) {
	    	  System.out.println(codAutobuses.get(j));
	      }
	      
	      // lo mismo para los codigos de los municipio
	      // los guardamos en un array list y lo recorremos con un for
	      System.out.println("Municipios:");
	      codMunicipios = lineas.get(i).getCodMunicipios();
	      for (int j = 0; j < codMunicipios.size(); j++) {
	    	  System.out.println(codMunicipios.get(j));
	      }
		}
		
		/*
		 * Como comprobar que haya plazas disponibles para el billete seleccionado
		 */
		
			// creamos la fecha y hora
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date fecha = null;
			try {
				fecha = new Date(df.parse("02-04-2015").getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Time time = Time.valueOf( "18:05:00" );
			Boolean disponible;

			// creamos el objeto billete
			Billete billete = new Billete(1234, 2, "L2", 1002, 3, 6, fecha, time, "15236985K", 45.5f);
			
			// comprobamos si hay plazas disponibles para el autobus y la fecha seleccionada
			disponible = modelo.consultas.comprobarPlazasBillete(billete);
			System.out.println(disponible);

			// insertamos los datos del billete en la bbdd
			//modelo.insertarBillete(billete);

			// imprimir billete
			modelo.ficheros.imprimirBillete(billete);
		
		
		
		
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
		Botones botones = new Botones(modelo, vista);
		botones.IrBienveLineas(vista.sel_linea.listLineas, vista.bienvenida.btnContinuar, vista.bienvenida, vista.sel_linea);
		botones.MostrarParadas(vista.sel_linea.listLineas, vista.sel_linea.listParadas);
		botones.BotonContinuar(vista.sel_linea.btnContinuar, vista.sel_linea, vista.sel_billete);
		botones.BotonContinuar(vista.sel_billete.btnContinuar, vista.sel_billete, vista.sel_fecha);
		botones.BotonContinuar(vista.sel_fecha.btnContinuar, vista.sel_fecha, vista.detalles_compra);
		botones.BotonContinuar(vista.detalles_compra.btnContinuar, vista.detalles_compra, vista.login);
		botones.BotonIrInicioSesion(vista.sel_linea.btnlogin, vista.sel_linea, vista.login);
		botones.BotonIrInicioSesion(vista.sel_billete.btnLogin, vista.sel_billete, vista.login);
		botones.BotonIrInicioSesion(vista.sel_fecha.btnLogin, vista.sel_fecha, vista.login);
		botones.BotonIrInicioSesion(vista.detalles_compra.btnLogin, vista.detalles_compra, vista.login);
		botones.CancelarInicioSesion(vista.login.btnCancelar, vista.login);
		botones.BotonIrRegistro(vista.sel_linea.btnRegistro, vista.sel_linea, vista.registro);
		botones.BotonIrRegistro(vista.sel_billete.btnregistro, vista.sel_billete, vista.registro);
		botones.BotonIrRegistro(vista.sel_fecha.btnRegistrar, vista.sel_fecha, vista.registro);
		botones.BotonIrRegistro(vista.sel_fecha.btnRegistrar, vista.sel_fecha, vista.registro);
		botones.BotonIrRegistro(vista.detalles_compra.btnRegistro, vista.detalles_compra, vista.registro);
		botones.CancelarRegistro(vista.registro.btnCancelar, vista.registro);
		botones.IrInicioSesionARegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.IrRegistroAInicioSesion(vista.registro.btnLogin, vista.login, vista.registro);
		botones.Registrar(vista.registro.btnRegistro, vista.registro, vista.registro.txtNombre, vista.registro.txtApellidos, vista.registro.dateChooser, vista.registro.txtDni, vista.registro.rbtnFem, vista.registro.rbtnMasc, vista.registro.passwordField, vista.registro.passwordField2, vista.registro.lblErrorContrasenas, vista.registro.lblErrorDNI, vista.registro.lblErrorSexo);
		botones.IniciarSesion(vista.login.btnLogin, vista.login.userField, vista.login.password, vista.login);
		botones.BotonContinuar(vista.pago.btnContinuar, vista.pago, vista.fin_pago);
	}
}