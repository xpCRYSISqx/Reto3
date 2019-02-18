package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase encargada del calculo de objeto billete. 
 * Calcula el precio del trayecto  teniendo en cuenta la relacion de consumo del autobus por kilometro
 * Tiene los datos necesario para imiprimir el ticket del billete al final de la compra
 */

public class FuncionesBillete {
	
	Modelo modelo;
	/**
	 * Constructor de la clase FuncionesBillete
	 * 
	 * @param modelo Instancia de la clase modelo para poder utilizarla
	 */
	public FuncionesBillete (Modelo modelo) {
		this.modelo = modelo;
	}
	
	
	/**
	 * Metodo para calcular el precio del billete
	 * 
	 * @param billete Objeto con la informacion del billete
	 * 
	 * @return Retorna el precio del billete
	 */
	public float calcularPrecioBillete(Billete billete) {
		
		float lat1 = modelo.paradaOrigen.getLatitud();
		float lon1 = modelo.paradaOrigen.getLongitud();
		float lat2 = modelo.paradaDestino.getLatitud();
		float lon2 = modelo.paradaDestino.getLongitud();
		Autobus autobus = modelo.autobus;
		float distancia = this.calcularDistanciaKm(lat1, lon1, lat2, lon2);
		float precio = this.calcularPrecioTrayecto(autobus, distancia);
		
		return precio;

	}
	/**
	 * Calcula el precio de un trayecto
	 * 
	 * @param autobus Objeto autobus con la informacion del autobus que se va a utilizar
	 * @param distancia Distancia que va a ser recorrida
	 * 
	 * @return Retorna el precio del trayecto
	 */
	public float calcularPrecioTrayecto(Autobus autobus, float distancia) {
		
		float precio = 0;
		float consumo = autobus.getConsumo();
		float beneficio = 1.2f;
		float iva = 1.21f;
		
		// calculamos el precio
		precio = consumo * distancia * beneficio * iva;
		
		// redondeamos el precio
		precio = Math.round(precio*100.0f)/100.0f;
		
		return precio;
	}
	/**
	 * Metodo que calcula la dsitancia en Km entre dos paradas
	 * 
	 * @param lat1 Obtiene los datos de la latitud de la primera parada
	 * @param lat2 Obtiene los datos de la latitud de la segunda parada
	 * @param lon1 Obtiene los datos de la longitud de la primera parada
	 * @param lon2 Obtiene los datos de la longitud de la segunda parada
	 * 
	 * @return Retorna la distancia en Km
	 */
	public float calcularDistanciaKm(float lat1, float lon1, float lat2, float lon2) {
		
		// https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
		
		int R = 6371; // Radio de la tierra en km
		float dLat = deg2rad(lat2-lat1);
		float dLon = deg2rad(lon2-lon1); 
		float a = (float) ( 
				Math.sin(dLat/2) * Math.sin(dLat/2) +
				Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
				Math.sin(dLon/2) * Math.sin(dLon/2)
				); 
		float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))); 
		float d = R * c; // Distancia en km
		return d;
	}
	/**
	 * Transfroma los grados decigrados en radianes
	 * 
	 * @param deg Grados en decigrados
	 * 
	 * @return Grados en radianes
	 */
	public float deg2rad(float deg) {
		return deg * (float)(Math.PI/180);
	}
	
	/**
	 * Metodo que imprime el billete
	 * 
	 * @param path Ruta de impresion del billete
	 * 
	 * @return Retorna la ruta del billete
	 */
	public String imprimirBillete(String path) {
		
		FileWriter fichero = null;	
		PrintWriter writer = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date fechaActual = new Date();
		String sexo = "Mujer";
		if (modelo.cliente.getSexo() == 'V') {
			sexo = "Varón";
		}
		
		try {
			
			fichero = new FileWriter(path);
			writer = new PrintWriter(fichero);
			
			writer.println("=== DATOS DEL CLIENTE ===");
			writer.println();
			writer.println("DNI: " + modelo.cliente.getDni());
			writer.println("Nombre: " + modelo.cliente.getNombre());
			writer.println("Apellidos: " + modelo.cliente.getApellidos());
			writer.println("Fecha nacimiento: " + modelo.cliente.getFechaNacimiento());
			writer.println("Sexo: " + sexo);
			writer.println();
			writer.println();
			
			writer.println("=== DATOS DEL BILLETE DE IDA ===");
			writer.println();
			writer.println("Código Billete: " + modelo.billeteIda.getCodBillete());
			writer.println("Número de Trayecto: " + modelo.billeteIda.getNTrayecto());
			writer.println("Línea: " + modelo.billeteIda.getCodLinea() + ": " + modelo.linea.getNombre());
			writer.println("Origen: " + modelo.paradaOrigen.getNombre());
			writer.println("Destino: " + modelo.paradaDestino.getNombre());
			writer.println("Autobus: " + modelo.billeteIda.getCodBus());
			writer.println("Fecha Ida: " + modelo.billeteIda.getFecha());
			writer.println("Hora: " + modelo.billeteIda.getHora());
			writer.println("Precio: " + modelo.billeteIda.getPrecio() + "€");
			writer.println("Fecha de compra: " + dateFormat.format(fechaActual));
			writer.println();
			writer.println();
			
			if (modelo.billeteVuelta != null) {
			
				writer.println("=== DATOS DEL BILLETE DE VUELTA ===");
				writer.println();
				writer.println("Código Billete: " + modelo.billeteVuelta.getCodBillete());
				writer.println("Número de Trayecto: " + modelo.billeteVuelta.getNTrayecto());
				writer.println("Línea: " + modelo.billeteIda.getCodLinea() + ": " + modelo.linea.getNombre());
				writer.println("Parada Origen: " +  modelo.paradaDestino.getNombre());
				writer.println("Parada Destino: " + modelo.paradaOrigen.getNombre());
				writer.println("Autobus: " + modelo.billeteVuelta.getCodBus());
				writer.println("Fecha Vuelta: " + modelo.billeteVuelta.getFecha());
				writer.println("Hora: " + modelo.billeteVuelta.getHora());
				writer.println("Precio: " + modelo.billeteVuelta.getPrecio() + "€");
				writer.println("Fecha de compra: " + dateFormat.format(fechaActual));
				writer.println();
				
			}
			
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
				if (writer != null) {
					writer.close();
				}
				} catch (Exception e) {
					e.getStackTrace();
			}
		}
		
		return path;
		
	}

}
