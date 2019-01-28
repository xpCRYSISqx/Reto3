package modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class PrepararTicket {
	
	private int codBillete;
	private int nTrayecto;
	private String codLinea;
	private String nombreLinea;
	private int codBus;
	private int codParadaInicio;
	private String paradaInicio;
	private int codParadaFin;
	private String paradaFin;
	private Date fecha;
	private Time hora;
	private String dni;
	private float precio;
	private Modelo modelo;
	
	public PrepararTicket(int codBillete, int nTrayecto, String codLinea, int codBus, int codParadaInicio, int codParadaFin, Date fecha, Time hora, String dni, float precio) {
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
		ArrayList<Linea> lineas = modelo.getLineas();
		for(int i = 0; i < lineas.size(); i++) {
			if(lineas.get(i).getCodLinea() == codLinea)
				this.nombreLinea = lineas.get(i).getNombre();
		}
		
	}
}