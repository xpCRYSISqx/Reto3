package modelo;

import java.sql.Date;

/**
 * Este objeto se encarga de almacenar toda la informacion necesaria para imprimir el billete
 */
public class Billete {
	
	private int codBillete;
	private int nTrayecto;
	private String codLinea;
	private int codBus;
	private int codParadaInicio;
	private int codParadaFin;
	private Date fecha;
	private String hora;
	private String dni;
	private float precio;
	/**
	 * Constructor vacio del objeto billete
	 */
	public Billete() {
		
	}
	/**
	 * Constructor con parametros del objeto billete
	 * 
	 * @param codBillete: Almacena el codigo del billete
	 * @param nTrayecto: Guarda el numero del trayecto del billete
	 * @param codLinea: Almacena el codigo de la linea que ocupa el billete
	 * @param codBus: Almacena el codigo del autobus del cual se ha comprado el billete
	 * @param codParadaInicio: Guarda el codigo de la parada de origen
	 * @param codParadaFin: Guarda el codigo de la parada de destino
	 * @param fecha: Guarda la fecha para la que se ha comprado el billete
	 * @param hora: Guarda la hora para la cual se ha comprado el billete
	 * @param dni: Guarda el DNI del usuario que ha comprado el billete
	 * @param precio: Guarda el precio del billete
	 */
	public Billete(int codBillete, int nTrayecto, String codLinea, int codBus, 
			int codParadaInicio, int codParadaFin, Date fecha, String hora, String dni, float precio) {
		this.codBillete = codBillete;
		this.nTrayecto = nTrayecto;
		this.codLinea = codLinea;
		this.codBus = codBus;
		this.codParadaInicio = codParadaInicio;
		this.codParadaFin = codParadaFin;
		this.fecha = fecha;
		this.hora = hora;
		this.dni = dni;
		this.precio = precio;
	}
	/**
	 * Geter del codigo del billete
	 * 
	 * @return Retorna el codigo del billete
	 */
	public int getCodBillete() {
		return codBillete;
	}
	/**
	 * Seter del codigo del billete
	 * 
	 * @param codBillete Almacena el codigo del billete
	 */
	public void setCodBillete(int codBillete) {
		this.codBillete = codBillete;
	}
	/**
	 * Geter del numero del trayecto
	 * 
	 * @return Retorna el numero del trayecto del billete
	 */
	public int getNTrayecto() {
		return nTrayecto;
	}
	/**
	 * Seter del numero del trayecto
	 * 
	 * @param nTrayecto Guarda el numero del trayecto del billete
	 */
	public void setNTrayecto(int nTrayecto) {
		this.nTrayecto = nTrayecto;
	}
	/**
	 * Geter del codigo de la linea
	 * 
	 * @return Retorna el codigo de la linea que ocupa el billete
	 */
	public String getCodLinea() {
		return codLinea;
	}
	/**
	 * Seter del codigo de la linea
	 * 
	 * @param codLinea Almacena el codigo de la linea que ocupa el billete
	 */
	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}
	/**
	 * Geter del codigo del autobus
	 * 
	 * @return Retorna el codigo del autobus del cual se ha comprado el billete
	 */
	public int getCodBus() {
		return codBus;
	}
	/**
	 * Seter del codigo del autobus
	 * 
	 * @param codBus Almacena el codigo del autobus del cual se ha comprado el billete
	 */
	public void setCodBus(int codBus) {
		this.codBus = codBus;
	}
	/**
	 * Geter del codigo de la parada de origen
	 * 
	 * @return Retorna el codigo de la parada de origen
	 */
	public int getCodParadaInicio() {
		return codParadaInicio;
	}
	/**
	 * Seter de la parada de origen
	 * 
	 * @param codParadaInicio Guarda el codigo de la parada de origen
	 */
	public void setCodParadaInicio(int codParadaInicio) {
		this.codParadaInicio = codParadaInicio;
	}
	/**
	 * Geter de la parada de destino
	 * 
	 * @return Retorna el codigo de la parada de destino
	 */
	public int getCodParadaFin() {
		return codParadaFin;
	}
	/**
	 * Seter del codigo de la parada de destino
	 * 
	 * @param codParadaFin Guarda el codigo de la parada de destino
	 */
	public void setCodParadaFin(int codParadaFin) {
		this.codParadaFin = codParadaFin;
	}
	/**
	 * Geter de la fecha
	 * 
	 * @return Retorna la fecha para la que se ha comprado el billete
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * Seter de la fecha
	 * 
	 * @param fecha Guarda la fecha para la que se ha comprado el billete
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * Geter de la hora
	 * 
	 * @return Retorna la hora para la cual se ha comprado el billete
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * Seter de la hora
	 * 
	 * @param hora Guarda la hora para la cual se ha comprado el billete
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	/**
	 * Geter del DNI del cliente
	 * 
	 * @return Retorna el DNI del usuario que ha comprado el billete
	 */
	public String getDni() {
		return dni;
	}
	/**
	 * Seter del DNI del cliente
	 * 
	 * @param dni Guarda el DNI del usuario que ha comprado el billete
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * Geter del precio del billete
	 * 
	 * @return Retorna el precio del billete
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Seter del precio del billete
	 * 
	 * @param precio Guarda el precio del billete
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
