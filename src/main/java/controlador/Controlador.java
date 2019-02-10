package controlador;

import modelo.*;
import vista.MainFrame;

public class Controlador {
	
	public Modelo modelo;
	public MainFrame vista;
	
	private ControladorBienvenida controladorBienvenida;
	private ControladorLineas controladorLineas;
	private ControladorBillete controladorBillete;
	private ControladorFecha controladorFecha;
	private ControladorDetalles controladorDetalles;
	private ControladorLogin controladorLogin;
	private ControladorRegistro controladorRegistro;
	
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
	
	public void inicializarBotones() {
		
		// añadimos listeners a los botones del panel 'login'
		this.controladorLogin = new ControladorLogin(vista, modelo);
		this.controladorLogin.addListeners();
		
		// añadimos listeners a los botones del panel 'registro'
		this.controladorRegistro = new ControladorRegistro(vista, modelo);
		this.controladorRegistro.addListeners();
		
		// añadimos listeners a los botones del panel 'bienvenida'
		this.controladorBienvenida = new ControladorBienvenida(vista, modelo);
		this.controladorBienvenida.addListeners();
		
		// añadimos listeners a los botones del panel 'sel_lineas'
		this.controladorLineas = new ControladorLineas(vista, modelo);
		this.controladorLineas.addListeners();
		
		// añadimos listeners a los botones del panel 'sel_billete'
		this.controladorBillete = new ControladorBillete(vista, modelo);
		this.controladorBillete.addListeners();
		
		// añadimos listeners a los botones del panel 'sel_fecha'
		this.controladorFecha = new ControladorFecha(vista, modelo);
		this.controladorFecha.addListeners();
		
		// añadimos listeners a los botones del panel 'detalles_compra'
		this.controladorDetalles = new ControladorDetalles(vista, modelo);
		this.controladorDetalles.addListeners();
		
	}
	
}