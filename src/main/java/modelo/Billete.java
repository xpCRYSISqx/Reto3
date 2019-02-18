package modelo;

import java.sql.Date;

/**
 * Este objeto se encarga de almacenar toda la informacion necesaria para imprimir el billete
 * 
 * @author Ustaritz, Laura, Mikel
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
 * 
 * @return codBillete: Retorna el codigo del billete
 * @return nTrayecto: Retorna el numero del trayecto del billete
 * @return codLinea: Retorna el codigo de la linea que ocupa el billete
 * @return codBus: Retorna el codigo del autobus del cual se ha comprado el billete
 * @return codParadaInicio: Retorna el codigo de la parada de origen
 * @return codParadaFin: Retorna el codigo de la parada de destino
 * @return fecha: Retorna la fecha para la que se ha comprado el billete
 * @return hora: Retorna la hora para la cual se ha comprado el billete
 * @return dni: Retorna el DNI del usuario que ha comprado el billete
 * @return precio: Retorna el precio del billete
 *
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
	
	public Billete() {
		
	}

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

	public int getCodBillete() {
		return codBillete;
	}

	public void setCodBillete(int codBillete) {
		this.codBillete = codBillete;
	}

	public int getNTrayecto() {
		return nTrayecto;
	}

	public void setNTrayecto(int nTrayecto) {
		this.nTrayecto = nTrayecto;
	}

	public String getCodLinea() {
		return codLinea;
	}

	public void setCodLinea(String codLinea) {
		this.codLinea = codLinea;
	}

	public int getCodBus() {
		return codBus;
	}

	public void setCodBus(int codBus) {
		this.codBus = codBus;
	}

	public int getCodParadaInicio() {
		return codParadaInicio;
	}

	public void setCodParadaInicio(int codParadaInicio) {
		this.codParadaInicio = codParadaInicio;
	}

	public int getCodParadaFin() {
		return codParadaFin;
	}

	public void setCodParadaFin(int codParadaFin) {
		this.codParadaFin = codParadaFin;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
