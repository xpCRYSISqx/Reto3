package controlador;

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
		//Boton para ir de bienvenida a lineas
		botones.IrBienveLineas(vista.sel_linea.listLineas, vista.bienvenida.btnContinuar, vista.bienvenida, vista.sel_linea);
		//Muestra la lista de paradas en la ventana de lineas
		botones.MostrarParadas(vista.sel_linea.listLineas, vista.sel_linea.listParadas);
		//Boton para ir de lineas a la seleccion del billete
		botones.BotonContinuar(vista.sel_linea.btnContinuar, vista.sel_linea, vista.sel_billete);
		//Boton para ir de la seleccion del billete a la seleccion de la fecha
		botones.BotonContinuar(vista.sel_billete.btnContinuar, vista.sel_billete, vista.sel_fecha);
		//Boton para ir de la seleccion de la fecha a los detalles de la compra
		botones.BotonContinuar(vista.sel_fecha.btnContinuar, vista.sel_fecha, vista.detalles_compra);
		//Boton para ir de los detalles de la compra a la ventana de Log in
		botones.BotonContinuar(vista.detalles_compra.btnContinuar, vista.detalles_compra, vista.login);
		//Boton para ir de lineas a la ventana de Log in
		botones.BotonIrInicioSesion(vista.sel_linea.btnlogin, vista.sel_linea, vista.login);
		//Boton para ir de billete a la ventana de Log in
		botones.BotonIrInicioSesion(vista.sel_billete.btnLogin, vista.sel_billete, vista.login);
		//Boton para ir de fecha a Log in
		botones.BotonIrInicioSesion(vista.sel_fecha.btnLogin, vista.sel_fecha, vista.login);
		//Boton para ir de los detalles de la compra a Log in
		botones.BotonIrInicioSesion(vista.detalles_compra.btnLogin, vista.detalles_compra, vista.login);
		//Boton para cancelar en la ventana de Log in y ir a la ventana en la que se estaba
		botones.CancelarInicioSesion(vista.login.btnCancelar, vista.login);
		//Boton para ir de lineas a registro
		botones.BotonIrRegistro(vista.sel_linea.btnRegistro, vista.sel_linea, vista.registro);
		//Boton para ir de billete a registro
		botones.BotonIrRegistro(vista.sel_billete.btnregistro, vista.sel_billete, vista.registro);
		//boton para ir de fecha a registro
		botones.BotonIrRegistro(vista.sel_fecha.btnRegistrar, vista.sel_fecha, vista.registro);
		//Boton para ir de detalles a registro
		botones.BotonIrRegistro(vista.detalles_compra.btnRegistro, vista.detalles_compra, vista.registro);
		//Boton para cancelar el registro y ir a la ventana en la que se estaba
		botones.CancelarRegistro(vista.registro.btnCancelar, vista.registro);
		//Boton para ir a registro cuando se esta en Log in
		botones.IrInicioSesionARegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		//Boton para ir a Log in cuendo se esta en registro
		botones.IrRegistroAInicioSesion(vista.registro.btnLogin, vista.login, vista.registro);
		//boton para registrar un usuario
		botones.Registrar(vista.registro.btnRegistro, vista.registro, vista.registro.txtNombre, vista.registro.txtApellidos, vista.registro.dateChooser, vista.registro.txtDni, vista.registro.rbtnFem, vista.registro.rbtnMasc, vista.registro.passwordField, vista.registro.passwordField2, vista.registro.lblErrorContrasenas, vista.registro.lblErrorDNI, vista.registro.lblErrorSexo, vista.registro.lblErrorDNINoIntroducido);
		//Boton para iniciar sesion
		botones.IniciarSesion(vista.login.btnLogin, vista.login.userField, vista.login.password, vista.login);
		//Boton para ir de la ventana de pago a la de finalizar el pago
		botones.BotonContinuar(vista.pago.btnContinuar, vista.pago, vista.fin_pago);
		//Boton para ir atras en la ventana de billete
		botones.AtrasBilleteLineas(vista.sel_billete.btnAtras, vista.sel_linea, vista.sel_billete);
	}
}