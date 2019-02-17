package controlador;

import modelo.Linea;
import modelo.Modelo;
import modelo.Parada;
import vista.MainFrame;

public class ControladorCancelar {
	public MainFrame vista;
	public Modelo modelo;
	public Linea linea;
	public Parada paradaOrigen, paradaDestino;
	
	/*public ControladorCancelar(MainFrame vista, Modelo modelo, Linea linea, Parada paradaOrigen, Parada paradaDestino) {
		this.vista = vista;
		this.modelo = modelo;
		this.linea = linea;
		this.paradaOrigen = paradaOrigen;
		this.paradaDestino = paradaDestino;
	}*/
	public ControladorCancelar(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
	}
	public void reset() {
		Controlador con = new Controlador(modelo, vista);
		con.inicializarInterfaz();
		con.inicializarBotones();
		vista.sel_billete.btnLogin.setVisible(true);
		vista.sel_billete.btnLogin.setEnabled(true);
		vista.sel_billete.btnRegistro.setVisible(true);
		vista.sel_billete.btnRegistro.setEnabled(true);
		vista.sel_fecha.btnLogin.setVisible(true);
		vista.sel_fecha.btnLogin.setEnabled(true);
		vista.sel_fecha.btnRegistro.setVisible(true);
		vista.sel_fecha.btnRegistro.setEnabled(true);
		vista.detalles_compra.btnLogin.setVisible(true);
		vista.detalles_compra.btnLogin.setEnabled(true);
		vista.detalles_compra.btnRegistro.setVisible(true);
		vista.detalles_compra.btnRegistro.setEnabled(true);
		vista.login.userField.setText("");
		vista.login.password.setText("");
		vista.registro.passwordField.setText("");
		vista.registro.passwordField2.setText("");
		vista.registro.txtApellidos.setText("");
		vista.registro.txtDni.setText("");
		vista.registro.txtNombre.setText("");
	}
}
