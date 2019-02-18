package modelo;

/**
 * Clase encargada del calculo logico del programa
 * 
 * @author Uztaritz, Mikel. Laura
 * 
 * @param conexion: instancia de la conexion a bbdd
 * @param consultas: instancia de las consultas a bbdd
 * @param funcionesBillete: instancia de la clase donde se calculan las funciones necesarias para el billete
 * @param funcionesPago: instancia de la clase donde se calculan las funciones necesarias para el pago
 * @param funcionesRegistro: instancia de la clase donde se calculan las funciones necesarias para el registro
 * @param funciones cliente: instancia de la clase donde se realizan las funciones necesarias para la gestion del cliente
 * @param billeteIda: instancia de la clase donde se calculan las funciones necesarias para el billete de ida
 * @param billeteVuelta: instancia de la clase donde se calculan las funciones necesarias para el billete de vuelta
 * @param linea: instancia de la clase donde se calculan las funciones necesarias para la linea de trayecto
 * @param paradaOrigen: instancia de la clase donde se calculan las funciones necesarias para las paradas (Origen)
 * @param paradaDestino: instancia de la clase donde se calculan las funciones necesarias para el paradas (Destino)
 * @param autobus: instancia de la clase donde se calculan las funciones necesarias para la gestion del autobus
 *  
 */

public class Modelo {
	
	public Conexion conexion;
	public Consultas consultas;
	public FuncionesBillete funcionesBillete;
	public FuncionesPago funcionesPago;
	public FuncionesRegistro funcionesRegistro;
	public Cliente cliente;
	public Billete billeteIda;
	public Billete billeteVuelta;
	public Linea linea;
	public Parada paradaOrigen;
	public Parada paradaDestino;
	public Autobus autobus;
	
	public float precioTotal;
	
	public Modelo() {
		
		// creamos un objeto BBDD que se encargara de conectarse a la BBDD
		conexion = new Conexion();
				
		// Creamos un objeto Consultas que se encargara de hacer consultas a la BBDD
		consultas = new Consultas(conexion);
		
		// Creamos objetos con las funciones generales del programa
		funcionesBillete = new FuncionesBillete(this);
		funcionesPago = new FuncionesPago(this);
		funcionesRegistro = new FuncionesRegistro(this);
		
		cliente = null;
		billeteIda = null;
		billeteVuelta = null;
		linea = null;
		paradaOrigen = null;
		paradaDestino = null;
		autobus = null;
		
		
		// guardamos el precio total de los billetes
		precioTotal = 0;
		
	}
	
}