package modelo;

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