package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ficheros {
	
	public Ficheros() {
		
	}
	
	// lee los datos de conexion a la base de datos del archivo /resources/datosBBDD.txt
	public String[] getConnectionInfo() {

		String filePath = "src/main/java/resources/datosBBDD.txt";
		FileReader fileReader;
		BufferedReader buffer = null;
		String[] datos = new String[4];
		String linea;
		int count = 0;
		
		// carga el archivo en un buffer
		try {
			fileReader = new FileReader(filePath);
			buffer = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		// crea un array con una entrada por cada linea del archivo
		// cada linea es "filtrada" para que solo quede el dato necesario
		try {
			while ((linea = buffer.readLine()) != null) {
				datos[count] = linea.substring(linea.indexOf(":") + 2);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return datos;
		
	}
	
	public String imprimirBillete(Billete billete, Cliente cliente, String path) {
		
		FileWriter fichero = null;	
		PrintWriter writer = null;
		
		try {
			
			fichero = new FileWriter(path);
			writer = new PrintWriter(fichero);
			
			writer.println("=== DATOS DEL BILLETE ===");
			writer.println();
			writer.println("Línea: " + billete.getCodLinea());
			writer.println("Origen: " + billete.getCodParadaInicio());
			writer.println("Destino: " + billete.getCodParadaFin());
			writer.println("Fecha: " + billete.getFecha());
			writer.println();
			writer.println();
			writer.println("=== DATOS DEL CLIENTE ===");
			writer.println();
			writer.println("DNI: " + cliente.getDni());
			writer.println("Nombre: " + cliente.getNombre());
			writer.println("Apellidos: " + cliente.getApellidos());
			writer.println("Fecha nacimiento: " + cliente.getFechaNacimiento());
			writer.println("Sexo: " + cliente.getSexo());
			
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
