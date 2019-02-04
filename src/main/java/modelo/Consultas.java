package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Consultas {
	
	private Conexion conexion;
	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet result;
	
	public Consultas(Conexion conexion) {
		this.conexion = conexion;
		this.connection = null;
		this.stmt = null;
		this.result = null;
	}
	
	/****************************************************************************************************************
	 * 
	 * Metodos para cargar datos de la BBDD (Consultas Select)
	 * 
	 ****************************************************************************************************************/
	
	public ArrayList<Linea> getLineas() {
		
		Linea linea = null;
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		String codLinea;
		ArrayList<Autobus> autobuses = new ArrayList<Autobus>();
		ArrayList<Integer> codAutobuses = new ArrayList<Integer>();

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT * FROM linea");
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				codLinea = result.getString("Cod_Linea");
				autobuses = getAutobusesByLinea(result.getString(codLinea));
				for(int i = 0;i<autobuses.size();i++) {
					codAutobuses.add(autobuses.get(i).getCodBus());
				}
			}
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				linea = new Linea();
				linea.setCodLinea(result.getString("Cod_Linea"));
				linea.setNombre(result.getString("Nombre"));
				autobuses = getAutobusesByLinea(result.getString(result.getString("Cod_Linea")));
				for(int i = 0;i<autobuses.size();i++) {
					codAutobuses.add(autobuses.get(i).getCodBus());
				}
				linea.setCodAutobuses(codAutobuses);
				lineas.add(linea);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// cerramos los objetos ResultSet y PreparedStatement
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    
		    // cerramos la conexion
		    conexion.desconectar();
		}       
		
		return lineas;
		
	}
	
	public ArrayList<Autobus> getAutobusesByLinea(String codLinea) {
		
		Autobus autobus = null;
		ArrayList<Autobus> autobuses = new ArrayList<Autobus>();

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT Cod_bus FROM `linea_autobus` where Cod_Linea = ?");
			stmt.setString(1, codLinea);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				autobus = new Autobus();
				autobus.setCodBus(result.getInt("Cod_bus"));
				autobus = getInfoAutobus(autobus);
				autobuses.add(autobus);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                
		
		return autobuses;
		
	}
	
	public Autobus getInfoAutobus(Autobus autobus) {

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT N_plazas, Consumo_km, Color FROM autobus where Cod_bus = ?");
			stmt.setInt(1, autobus.getCodBus());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				autobus.setNumPlazas(result.getInt("N_plazas"));
				autobus.setConsumo(result.getFloat("Consumo_km"));
				autobus.setColor(result.getString("Color"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                  
		
		return autobus;
		
	}
	
	public ArrayList<Parada> getParadasByLinea(String codLinea) {
		
		Parada parada = null;
		ArrayList<Parada> paradas = new ArrayList<Parada>();

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT Cod_Parada, SQRT(POWER(Latitud-(SELECT Latitud FROM `parada` WHERE Cod_Parada = 1),2)+POWER(Longitud-(SELECT Longitud FROM `parada` WHERE Cod_Parada = 1),2))\"Distancia\""
					+ " FROM `parada` WHERE Cod_Parada IN (SELECT Cod_Parada FROM `linea-parada` WHERE Cod_Linea = ?) ORDER BY Distancia ASC");
			//stmt = this.connection.prepareStatement("SELECT Cod_Parada FROM `linea-parada` where Cod_Linea = ?");
			stmt.setString(1, codLinea);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				parada = new Parada();
				parada.setCodParada(result.getInt("Cod_Parada"));
				parada = getInfoParada(parada);
				paradas.add(parada);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}       
		
		return paradas;
		
	}
	
	public Parada getInfoParada(Parada parada) {

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT Nombre, Calle, Latitud, Longitud FROM parada where Cod_Parada = ?");
			stmt.setInt(1, parada.getCodParada());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				parada.setNombre(result.getString("Nombre"));
				parada.setCalle(result.getString("Calle"));
				parada.setLatitud(result.getFloat("Latitud"));
				parada.setLongitud(result.getFloat("Longitud"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
		
		return parada;
		
	}
	
	public Boolean comprobarFechasBillete(Billete billete) {
		
		Boolean disponible = false;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT count(*) FROM billete WHERE Cod_bus = ?");
			stmt.setInt(1, billete.getCodBus());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			System.out.println(result);
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				//disponible = result.getInt('1');
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}              
		
		return disponible;
		
	}
	
	public Cliente getClienteByDNI(String dni) {
		
		Cliente cliente = null;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT * FROM cliente where DNI = ?");
			stmt.setString(1, dni);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				cliente = new Cliente();
				cliente.setDni(result.getString("DNI"));
				cliente.setNombre(result.getString("Nombre"));
				cliente.setApellidos(result.getString("Apellidos"));
				cliente.setFechaNacimiento(result.getDate("Fecha_nac"));
				cliente.setSexo(result.getString("Sexo").charAt(0));
				cliente.setContraseña(result.getString("Contraseña"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
		
		return cliente;
		
	}
	
	/****************************************************************************************************************
	 * 
	 * Metodos para insertar los datos de los objetos cliente y billete en la BBDD (Consultas Insert)
	 * 
	 ****************************************************************************************************************/
	
	// inserta los atributos de un objetos cliente en la BBDD
	public void insertarCliente(Cliente cliente) {

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement("INSERT INTO cliente (DNI, Nombre, Apellidos, Fecha_nac, Sexo, Contraseña) VALUES (?, ?, ?, ?, ?, ?)");
			
			// añadimos los valores a insertar
			stmt.setString(1, cliente.getDni());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellidos());
			stmt.setDate(4, cliente.getFechaNacimiento());
			stmt.setString(5, String.valueOf(cliente.getSexo()));
			stmt.setString(6, cliente.getContraseña());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			System.out.println("Gracias por registrarse!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
	}
	
	// inserta los atributos de un objetos billete en la BBDD
	public void insertarBillete(Billete billete) {

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement("INSERT INTO billete (NTrayecto, Cod_Linea, Cod_Bus, Cod_Parada_Inicio, Cod_Parada_Fin, Fecha, Hora, DNI, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			// añadimos los valores a insertar
			stmt.setInt(1, billete.getNTrayecto());
			stmt.setString(2, billete.getCodLinea());
			stmt.setInt(3, billete.getCodBus());
			stmt.setInt(4, billete.getCodParadaInicio());
			stmt.setInt(5, billete.getCodParadaFin());
			stmt.setDate(6, billete.getFecha());
			stmt.setTime(7, billete.getHora());
			stmt.setString(8, billete.getDni());
			stmt.setFloat(9, billete.getPrecio());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			System.out.println("Gracias por su compra!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
	}

}
