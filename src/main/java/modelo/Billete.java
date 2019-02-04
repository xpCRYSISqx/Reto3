package modelo;

import java.sql.Date;
import java.sql.Time;

public class Billete {
	
	private Integer codBillete;
	private int nTrayecto;
	private String codLinea;
	private int codBus;
	private int codParadaInicio;
	private int codParadaFin;
	private Date fecha;
	private Time hora;
	private String dni;
	private float precio;
	

	public Billete(Integer codBillete, int nTrayecto, String codLinea, int codBus, int codParadaInicio, int codParadaFin, Date fecha, Time hora, String dni, float precio) {
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

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
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
