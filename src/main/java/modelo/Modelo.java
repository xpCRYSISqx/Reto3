package modelo;

public class Modelo {
	
	public Ficheros ficheros;
	public Consultas consultas;
	public Encriptacion encriptacion;
	private String[] datosConexion;
	private Conexion conexion;
	public Pagar pagar;
	public Cliente cliente;
	public Billete billeteIda;
	public Billete billeteVuelta;
	public Linea linea;
	public Parada paradaOrigen;
	public Parada paradaDestino;
	public Autobus autobus;
	
	public float precioTotal;
	
	public Modelo() {
		
		// creamos un objeto Ficheros que se encargara de leer y escribir en archivos de texto plano
		ficheros = new Ficheros();
		
		// cargamos los datos de conexion del archivo datosBBDD.txt
		datosConexion = ficheros.getConnectionInfo();
		
		// creamos un objeto BBDD que se encargara de conectarse a la BBDD
		conexion = new Conexion(datosConexion);
		
		// Creamos un objeto Consultas que se encargara de hacer consultas a la BBDD
		consultas = new Consultas(conexion);
		
		// Creamos un objeto Encriptacion que usaremos para encriptar las contraseñas
		encriptacion = new Encriptacion();
		
		// Creamos un objeto Pagar que usaremos para el realizar el pago
		pagar = new Pagar();
		
		// iniciamos los objetos que usaremos para ir almacenando los datos introducidos por el cliente
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