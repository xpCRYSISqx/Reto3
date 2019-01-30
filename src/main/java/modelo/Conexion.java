package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase que permite conectar con la base de datos
 * @author laura
 *
 */
public class Conexion {
	
	// datos de conexion
	private String bd;
	private String username;
	private String password;
	private String localhost;
	private String url;
	private String[] datosConexion;
	private String params = "serverTimezone=UTC";
	
	private Connection connection = null;
	
	public Conexion() {
		
		// cargamos los datos de conexion del archivo datosBBDD.txt
		this.datosConexion = getConnectionInfo();
		this.bd = datosConexion[0];
		this.username = datosConexion[1];
		this.password = datosConexion[2];
		this.localhost = datosConexion[3];
		this.url = "jdbc:mysql://"+localhost+":3306/"+bd+"?"+params;
		
		// nos conectanos a la base de datos, si la conexion no es correcta lanzamos una excepcion
		try {
			this.connection = DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
	}

	public Connection getConnection(){
		return connection;
	}

	public void desconectar(){
		connection = null;
	}
	
	public String[] getConnectionInfo() {
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("./resources/datosBBDD.txt").getFile());
		BufferedReader br = null;
		String[] datos = new String[4];
		int count = 0;
		String st;
		
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		   
		try {
			while ((st = br.readLine()) != null) {
				datos[count] = st.substring(st.indexOf(":") + 1, st.indexOf(",")).replace(" ", "");
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return datos;
		
	}
}