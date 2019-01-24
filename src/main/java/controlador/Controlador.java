package controlador;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.*;

/*
 * Esta clase hace uso del paquete vista que no estara disponible hasta que hagamos merge con la rama interfaz
 * Todas las instancias de la clase vista estan comentadas 
 */
public class Controlador {
	
	public Modelo modelo;
	//public Vista vista;
	
	public Controlador(Modelo modelo/*, Vista vista*/) {
		
		this.modelo = modelo;
		//this.vista = vista;
		
	}
	
	public void inicializarEventos() {
		
		/*
		 * El siguiente codigo es de PRUEBA, para probar los metodos del modelo antes de usarlos con las vistas
		 */
		
		// carga y muestra las lineas
		ArrayList<Linea> lineas = modelo.getLineas();
		
		for (int i = 0; i < lineas.size(); i++) { 		      
	      System.out.print(lineas.get(i).getCodLinea()+": ");
	      System.out.println(lineas.get(i).getNombre()); 
		}
		
		// carga y muestra las paradas de la linea seleccionada
		ArrayList<Parada> paradas = modelo.getParadasByLinea("L1");
		
		for (int i = 0; i < paradas.size(); i++) { 		      
		      System.out.print(paradas.get(i).getCodParada()+": ");
		      System.out.print(paradas.get(i).getNombre()+", ");
		      System.out.print(paradas.get(i).getCalle()+", ");
		      System.out.print(paradas.get(i).getLatitud()+", ");
		      System.out.println(paradas.get(i).getLongitud());
		}
		
		// carga y muestra los autobuses de la linea seleccionada
		ArrayList<Autobus> autobuses = modelo.getAutobusesByLinea("L3");
		
		for (int i = 0; i < autobuses.size(); i++) { 		      
		      System.out.print(autobuses.get(i).getCodBus()+": ");
		      System.out.print(autobuses.get(i).getNumPlazas()+", ");
		      System.out.print(autobuses.get(i).getConsumo()+", ");
		      System.out.println(autobuses.get(i).getColor());
		}
		
		// crea un objeto billete y lo inserta en bbdd
		try {
			// creamos la fecha y hora
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			java.sql.Date fecha = new java.sql.Date(df.parse("02-04-2015").getTime());
			java.sql.Time time = java.sql.Time.valueOf( "18:05:00" );
			
			// creamos el objeto billete
			Billete billete = modelo.crearBillete(1234, 2, "L2", 1002, 3, 6, fecha, time, "15236985K", 45.5f);
			
			// insertamos los datos del billete en la bbdd
			//modelo.insertarBillete(billete);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// buscar un cliente
		Cliente cliente = modelo.getClienteByDNI("15236985K");
		
		// Imprimir datos cliente
		try {
			
			System.out.println(cliente.getDni());
			System.out.println(cliente.getNombre());
			System.out.println(cliente.getApellidos());
			System.out.println(cliente.getFechaNacimiento());
			System.out.println(cliente.getSexo());
			System.out.println(cliente.getContraseña());
			
		} catch (NullPointerException e) {
			System.out.println("No estas registrado");
		}
		
	}

}
