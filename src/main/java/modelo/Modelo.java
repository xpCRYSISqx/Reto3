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
	
	public Modelo(Ficheros ficheros, String[] datosConexion, Conexion conexion, Consultas consultas, Encriptacion encriptacion, Pagar pagar) {
		
		// iniciamos los objetos que usaremos para ir almacenando los datos introducidos por el cliente
		this.ficheros = ficheros;
		this.datosConexion = datosConexion;
		this.conexion = conexion;
		this.consultas = consultas;
		this.encriptacion = encriptacion;
		this.pagar = pagar;
		
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