package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase que permite conectar con la base de datos
 * 
 * @author Laura
 *
 *@param bd: Nombre de la base de datos
 *@param username: Numbre del ususario de la base de datos que se va a utilizar
 *@param password: Contraseña del usuario de la base de datos que se va a utilizar
 *@param host: Nombre del host que se va a utilizar
 *@param url: Direccion en la que se encuentra la base de datos
 *@param connection: Se utiliza para saber si se esta conectado a la base de datos o no
 *@param datos: Array que almacena los datos de conexion
 *@param filePath: Guarda la direccion en la que esta el archibo con los datos de conexion
 *@param fileReader: Es utilizado para leer la informacion del conexion de un fichero
 *@param buffer: Lee la informacion en el buffer
 *@param linea: Guarda el codigo de la linea
 *@param count: Se utiliza para recorrer el array de datos
 *
 *@return datos: Reotrna el array de datos con los valores adecuados
 *@return connection: Retorna si el programa se ha podido conectar a la base de datos o no
 *
 */
public class Conexion {
	
	private String bd;
	private String username;
	private String password;
	private String host;
	private String url;
	private Connection connection = null;
	
	private final String params = "serverTimezone=UTC"; // https://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue
	
	public Conexion() {
		
		String[] datos = getConnectionInfo();
		
		connection = null;
		host = datos[0];
		bd = datos[1];
		username = datos[2];
		password = datos[3];
		url = "jdbc:mysql://"+host+":3306/"+bd+"?"+params;
	}
	
	// lee los datos de conexion a la base de datos del archivo /resources/datosBBDD.txt
	public String[] getConnectionInfo() {

		String filePath = "src/main/java/resources/datosBBDD.txt";
		FileReader fileReader = null;
		BufferedReader buffer = null;
		String[] datos = new String[4];
		String linea = "";
		int count = 0;
		
		// carga el archivo de datos en un buffer
		try {
			fileReader = new FileReader(filePath);
			buffer = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		// recorre el buffer leyendo de cada linea del archivo el substring
		// necesario y lo guarda en una entrada del array
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
	
	protected Connection conectar(){
		try { connection = DriverManager.getConnection(url, username, password); } 
		catch (SQLException e) { throw new IllegalStateException("Cannot connect the database!", e); }
		return connection;
	}

	protected void desconectar(){
		if (connection != null)
			try {connection.close();} catch (SQLException e) {e.printStackTrace();}
	}

}