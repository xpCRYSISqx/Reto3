package modelo;

public class Modelo {
	
	public Consultas consultas;
	public Billete billete;
	public Ficheros ficheros;
	
	public Modelo() {
		
		consultas = new Consultas();
		billete = new Billete();
		ficheros = new Ficheros();
	}
	
}