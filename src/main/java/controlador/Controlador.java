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
		botones.BotonContinuar(vista.sel_linea.btnContinuar, vista.sel_linea, vista.sel_billete);
		botones.BotonContinuar(vista.sel_billete.btnContinuar, vista.sel_billete, vista.sel_fecha);
		botones.BotonContinuar(vista.sel_fecha.btnContinuar, vista.sel_fecha, vista.detalles_compra);
		botones.BotonContinuar(vista.detalles_compra.btnContinuar, vista.detalles_compra, vista.login);
		botones.BotonIrInicioSesion(vista.sel_linea.btnlogin, vista.sel_linea, vista.login);
		botones.BotonIrRegistro(vista.sel_linea.btnRegistro, vista.sel_linea, vista.registro);
		botones.IrInicioSesionARegistro(vista.login.btnRegistrar, vista.login, vista.registro);
		botones.IrRegistroAInicioSesion(vista.registro.btnLogin, vista.login, vista.registro);
		botones.Registrar(vista.registro.btnRegistro, vista.registro, vista.registro.txtNombre, vista.registro.txtApellidos, vista.registro.dateChooser, vista.registro.txtDni, vista.registro.rbtnFem, vista.registro.rbtnMasc, vista.registro.passwordField, vista.registro.passwordField2);
		botones.BotonContinuar(vista.pago.btnContinuar, vista.pago, vista.fin_pago);
	}
}