package modelo;

import java.util.Date;

public class Billete {
	
	private int codBillete;
	private String Ntrayecto;
	private String codLinea;
	private int codBus;
	private String nombre;
	private int codParadaInicio;
	private int codParadaFin;
	private Date fecha;
	private Date hora;
	private String dni;
	private float precio;
	
	public Billete() {
		
	}

	public int getCodBillete() {
		return codBillete;
	}

	public void setCodBillete(int codBillete) {
		this.codBillete = codBillete;
	}

	public String getNtrayecto() {
		return Ntrayecto;
	}

	public void setNtrayecto(String ntrayecto) {
		Ntrayecto = ntrayecto;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
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
