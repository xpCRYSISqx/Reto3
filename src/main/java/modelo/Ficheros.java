package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Ficheros {
	
	Modelo modelo;
	
	public Ficheros(Modelo modelo) {
		this.modelo = modelo;
	}
	
//	// lee los datos de conexion a la base de datos del archivo /resources/datosBBDD.txt
//	public String[] getConnectionInfo() {
//
//		String filePath = "src/main/java/resources/datosBBDD.txt";
//		FileReader fileReader;
//		BufferedReader buffer = null;
//		String[] datos = new String[4];
//		String linea;
//		int count = 0;
//		
//		// carga el archivo en un buffer
//		try {
//			fileReader = new FileReader(filePath);
//			buffer = new BufferedReader(fileReader);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} 
//		  
//		// crea un array con una entrada por cada linea del archivo
//		// cada linea es "filtrada" para que solo quede el dato necesario
//		try {
//			while ((linea = buffer.readLine()) != null) {
//				datos[count] = linea.substring(linea.indexOf(":") + 2);
//				count++;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//		
//		return datos;
//		
//	}
	
	public String imprimirBillete(Billete billeteIda, Billete billeteVuelta, Cliente cliente, String path) {
		
		FileWriter fichero = null;	
		PrintWriter writer = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date fechaActual = new Date();
		String sexo = "Mujer";
		if (cliente.getSexo() == 'V') {
			sexo = "Varon";
		}
		
		try {
			
			fichero = new FileWriter(path);
			writer = new PrintWriter(fichero);
			
			writer.println("=== DATOS DEL CLIENTE ===");
			writer.println();
			writer.println("DNI: " + cliente.getDni());
			writer.println("Nombre: " + cliente.getNombre());
			writer.println("Apellidos: " + cliente.getApellidos());
			writer.println("Fecha nacimiento: " + cliente.getFechaNacimiento());
			writer.println("Sexo: " + sexo);
			writer.println();
			writer.println();
			
			writer.println("=== DATOS DEL BILLETE DE IDA ===");
			writer.println();
			writer.println("Código Billete: " + billeteIda.getCodLinea());
			writer.println("Número de Trayecto: " + billeteIda.getNTrayecto());
			writer.println("Línea: " + billeteIda.getCodLinea() + ": " + modelo.linea.getNombre());
			writer.println("Origen: " + modelo.paradaOrigen.getNombre());
			writer.println("Destino: " + modelo.paradaDestino.getNombre());
			writer.println("Autobus: " + billeteIda.getCodBus());
			writer.println("Fecha: " + billeteIda.getFecha());
			writer.println("Hora: " + billeteIda.getHora());
			writer.println("Precio: " + billeteIda.getPrecio() + "€");
			writer.println("Fecha de compra: " + dateFormat.format(fechaActual));
			writer.println();
			writer.println();
			
			writer.println("=== DATOS DEL BILLETE DE VUELTA ===");
			writer.println();
			writer.println("Código Billete: " + billeteVuelta.getCodLinea());
			writer.println("Número de Trayecto: " + billeteVuelta.getNTrayecto());
			writer.println("Línea: " + billeteIda.getCodLinea() + ": " + modelo.linea.getNombre());
			writer.println("Origen: " +  modelo.paradaOrigen.getNombre());
			writer.println("Destino: " + modelo.paradaDestino.getNombre());
			writer.println("Autobus: " + billeteVuelta.getCodBus());
			writer.println("Fecha: " + billeteVuelta.getFecha());
			writer.println("Hora: " + billeteVuelta.getHora());
			writer.println("Precio: " + billeteVuelta.getPrecio() + "€");
			writer.println("Fecha de compra: " + dateFormat.format(fechaActual));
			writer.println();
			
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
