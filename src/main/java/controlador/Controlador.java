package controlador;

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
	
	public void inicializarEventos() {}
			
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
		
		//Botones direccionales inter-paneles
		botones.IrBienveLineas(vista.sel_linea.listLineas, vista.bienvenida.btnContinuar, vista.bienvenida, vista.sel_linea);//Boton para ir de bienvenida a lineas
		botones.MostrarParadas(vista.sel_linea.listLineas, vista.sel_linea.listParadas);//Muestra la lista de paradas en la ventana de lineas
		botones.ContinuarLineaBillete(vista.sel_billete.listaOrigen, vista.sel_billete.listaDestino, vista.sel_linea.btnContinuar, vista.sel_linea, vista.sel_billete);//Boton para ir de lineas a la seleccion del billete
		botones.ContinuarBilleteFecha(vista.sel_billete.btnContinuar, vista.sel_billete, vista.sel_fecha);//Boton para ir de la seleccion del billete a la seleccion de la fecha
		botones.BotonContinuar(vista.sel_fecha.btnContinuar, vista.sel_fecha, vista.detalles_compra);//Boton para ir de la seleccion de la fecha a los detalles de la compra
		botones.IrDetallesBilleteAPago(vista.detalles_compra.btnContinuar, vista.detalles_compra, vista.pago, vista.login);//Boton para ir de los detalles del billeta a la ventana de pago o a la de Log in
		
		botones.IrRegistroAInicioSesion(vista.registro.btnLogin, vista.login, vista.registro);//Boton para ir a Log in cuendo se esta en registro
		botones.BotonIrInicioSesion(vista.sel_linea.btnLogin, vista.sel_linea, vista.login);//Boton para ir de lineas a la ventana de Log in
		botones.BotonIrInicioSesion(vista.sel_billete.btnLogin, vista.sel_billete, vista.login);//Boton para ir de billete a la ventana de Log in
		botones.BotonIrInicioSesion(vista.sel_fecha.btnLogin, vista.sel_fecha, vista.login);//Boton para ir de fecha a Log in
		botones.BotonIrInicioSesion(vista.detalles_compra.btnLogin, vista.detalles_compra, vista.login);//Boton para ir de los detalles de la compra a Log in
		
		botones.IrInicioSesionARegistro(vista.login.btnRegistro, vista.login, vista.registro);//Boton para ir a registro cuando se esta en Log in
		botones.BotonIrRegistro(vista.sel_linea.btnRegistro, vista.sel_linea, vista.registro);//Boton para ir de lineas a registro
		botones.BotonIrRegistro(vista.sel_billete.btnRegistro, vista.sel_billete, vista.registro);//Boton para ir de billete a registro
		botones.BotonIrRegistro(vista.sel_fecha.btnRegistro, vista.sel_fecha, vista.registro);//boton para ir de fecha a registro
		botones.BotonIrRegistro(vista.detalles_compra.btnRegistro, vista.detalles_compra, vista.registro);//Boton para ir de detalles a registro
		
		//boton para registrar un usuario
		botones.Registrar(vista.registro.btnRegistro, vista.registro, vista.pago, vista.registro.txtNombre, vista.registro.txtApellidos, vista.registro.dateChooser, vista.registro.txtDni, vista.registro.rbtnFem, vista.registro.rbtnMasc, vista.registro.passwordField, vista.registro.passwordField2, vista.registro.lblErrorContrasenas, vista.registro.lblErrorDNI, vista.registro.lblErrorSexo, vista.registro.lblErrorDNINoIntroducido);
		
		//Boton para iniciar sesion
		botones.IniciarSesion(vista.login.btnLogin, vista.login.userField, vista.login.password, vista.login, vista.pago);
		
		//Botones genericos
		botones.BotonContinuar(vista.pago.btnContinuar, vista.pago, vista.fin_pago);//Boton para ir de la ventana de pago a la de finalizar el pago
		
		botones.BotonAtras(vista.sel_billete.btnAtras, vista.sel_linea, vista.sel_billete);	//Boton para ir atras en la ventana de billete	
		botones.BotonAtras(vista.sel_fecha.btnAtras, vista.sel_billete, vista.sel_fecha);//Boton para ir atras en la ventana de seleccion de fecha
		botones.BotonAtras(vista.detalles_compra.btnAtras, vista.sel_fecha, vista.detalles_compra);//Boton para ir atras en la ventana de detalles
		
		botones.BotonAtrasRegistro(vista.registro.btnAtras, vista.registro);
		botones.BotonAtrasRegistro(vista.login.btnAtras, vista.login);
		
		botones.BotonCancelar(vista.sel_linea.btnCancelar, vista.sel_linea, vista.bienvenida);
		botones.BotonCancelar(vista.sel_billete.btnCancelar, vista.sel_billete, vista.bienvenida);
		botones.BotonCancelar(vista.sel_fecha.btnCancelar, vista.sel_fecha, vista.bienvenida);
		botones.BotonCancelar(vista.detalles_compra.btnCancelar, vista.detalles_compra, vista.bienvenida);
		botones.BotonCancelar(vista.registro.btnCancelar, vista.registro, vista.bienvenida);
		botones.BotonCancelar(vista.login.btnCancelar, vista.login, vista.bienvenida);
		
		//Boton para cancelar el registro y ir a la ventana en la que se estaba
//		botones.CancelarRegistro(vista.registro.btnCancelar, vista.registro);
		//Boton para cancelar en la ventana de Log in y ir a la ventana en la que se estaba
//		botones.CancelarInicioSesion(vista.login.btnCancelar, vista.login);
	}
}