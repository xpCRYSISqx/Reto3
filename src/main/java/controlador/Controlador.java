package controlador;

import modelo.*;
import vista.MainFrame;

/**
 * El controlador realiza las funciones basicas del programa, tambien se utiliza para iniciar los distintos controladores, los cuales son el puente de enlace entre la vista y el modelo
 * 
 * @author Mikel, Laura, Ustaritz
 * 
 * @param modelo: Instancia del modelo para poder utilizarlo
 * @param vista: Instancia de la vista para poder utilizarla.
 * @param controladorBienvenida: Instancia del controlador del panel de bienvenida para poder utilizarlo
 * @param controladorBillete: Instancia del controlador del panel de billete para poder utilizarlo
 * @param controladorFrcha: Instancia del controlador del panel de fecha.
 * @param controladorDetalles: Instancia del controlador del panel de detalles.
 * @param controladorLogin: Instancia del controlador del panel de inicio de sesion.
 * @param controladorRegistro: Instancio del controlador del panel de registro.
 * @param controladorPago: Instancia del controlados del panel de pago.
 * @param controladorFinPago: Instancia del controlador del panel de finalizacion del pago y empresion del billete
 * 
 */

public class Controlador {
	
	public Modelo modelo;
	public MainFrame vista;
	
	private ControladorBienvenida controladorBienvenida;
	private ControladorBillete controladorBillete;
	private ControladorFecha controladorFecha;
	private ControladorDetalles controladorDetalles;
	private ControladorLogin controladorLogin;
	private ControladorRegistro controladorRegistro;
	private ControladorPago controladorPago;
	private ControladorFinPago controladorFinPago;
	
	public Controlador(Modelo modelo, MainFrame vista) {
		
		this.modelo = modelo;
		this.vista = vista;
		
	}
	
	// Esta funcion se encarga de inicializar la interfaz
	public void inicializarInterfaz() {
		vista.setVisible(true);
		vista.bienvenida.setVisible(true);
		vista.sel_billete.setVisible(false);
		vista.sel_fecha.setVisible(false);
		vista.detalles_compra.setVisible(false);
		vista.login.setVisible(false);
		vista.registro.setVisible(false);
		vista.pago.setVisible(false);
		vista.fin_pago.setVisible(false);
		vista.agur.setVisible(false);
		
	}
	
	// Esta funcion de encarga de inicializar los botones
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
		
		// añadimos listeners a los botones del panel 'sel_billete'
		this.controladorBillete = new ControladorBillete(vista, modelo);
		this.controladorBillete.addListeners();
		
		// añadimos listeners a los botones del panel 'sel_fecha'
		this.controladorFecha = new ControladorFecha(vista, modelo);
		this.controladorFecha.addListeners();
		
		// añadimos listeners a los botones del panel 'detalles_compra'
		this.controladorDetalles = new ControladorDetalles(vista, modelo);
		this.controladorDetalles.addListeners();
		
		// añadimos listeners a los botones del panel 'pago'
		this.controladorPago = new ControladorPago(vista, modelo);
		this.controladorPago.addListeners();
		
		// añadimos listeners a los botones del panel "fin_pago"
		this.controladorFinPago = new ControladorFinPago(vista, modelo);
		this.controladorFinPago.addListeners();
	}
	
}