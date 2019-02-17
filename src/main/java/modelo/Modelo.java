package modelo;

public class Modelo {
	
	public Consultas consultas;
	public Encriptacion encriptacion;
	public Pagar pagar;
	public Cliente cliente;
	public Billete billeteIda;
	public Billete billeteVuelta;
	public Linea linea;
	public Parada paradaOrigen;
	public Parada paradaDestino;
	public Autobus autobus;
	
	public float precioTotal;
	
	public Modelo(Consultas consultas, Encriptacion encriptacion, Pagar pagar) {
		
		// iniciamos los objetos que usaremos para ir almacenando los datos introducidos por el cliente
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