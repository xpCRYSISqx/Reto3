package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
	
	public void imprimirBillete(Billete billete) {
		FileWriter fichero = null;	
		BufferedWriter linea = null;
		
		try {
			
			fichero = new FileWriter("c:/Billetes/billete-" + billete.getDni() + "-" + billete.getFecha() + ".txt");
			linea = new BufferedWriter(fichero);
			
			linea.write("=== BILLETE ===");
			linea.newLine();
			linea.write("------------------------------");
			linea.newLine();
			
			linea.write("=== DATOS DEL TRAYECTO ===");
			linea.newLine();
			linea.write("------------------------------");
			linea.newLine();
			linea.write("Línea: " + billete.getCodLinea());
			linea.newLine();
			linea.write("Origen: " + billete.getCodParadaInicio());
			linea.newLine();
			linea.write("Destino: " + billete.getCodParadaFin());
			linea.newLine();
			linea.write("Fecha: " + billete.getFecha());
			linea.newLine();
			linea.newLine();
			
			linea.write("=== DATOS DEL CLIENTE ===");
			linea.newLine();
			linea.write("------------------------------");
			linea.newLine();
			linea.write("DNI: " + billete.getDni());
			linea.newLine();
//			linea.write("Nombre: ");
//			linea.newLine();
//			linea.write("Apellidos: ");
//			linea.newLine();
//			linea.write("Fecha nacimiento: ");
//			linea.newLine();
//			linea.write("Sexo: ");
//			linea.newLine();
			
			linea.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
				if (linea != null) {
					linea.close();
				}
				} catch (Exception e) {
					e.getStackTrace();
			}
		}
	}

}
