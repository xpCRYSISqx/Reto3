package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clase encargada, junto con la clase conexion, de atender peticiones a bbdd. Gestiona y ordena la informacion que adquiere de la bbdd
 */

public class Consultas {
	
	private Conexion conexion;
	private Connection connection;
	/**
	 * Contructor de la clase consultas
	 * 
	 * @param conexion Clase encargada de la conexion a la base de datos
	 */
	public Consultas(Conexion conexion) {
		this.conexion = conexion;
		this.connection = null;
	}
	
	/****************************************************************************************************************
	 * 
	 * Metodos para cargar datos de la BBDD (Consultas Select)
	 * 
	 ****************************************************************************************************************/
	
	/**
	 * Metodo encargado de conseguir la informacion de las diferentes lineas de la base de datos
	 * 
	 * @return Retorna un array list con una lista de objetos linea, cada uno de ellos tiene la informacion de una linea diferente
	 */
	public ArrayList<Linea> getLineas() {
		
		Linea linea = null;
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM linea";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Linea con los resultados y los a�ade a un arrayList
			while (result.next()) {
				linea = new Linea();
				linea.setCodLinea(result.getString("Cod_Linea"));
				linea.setNombre(result.getString("Nombre"));				
				lineas.add(linea);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    
		    // cerramos la conexion
		    conexion.desconectar();
		}       
		
		return lineas;
		
	}
	/**
	 * Metodo encargado de buscar la informacion de los autobuses de una linea concreta
	 * 
	 * @param codLinea Codigo de la linea de la cual se quieren saber los autobuses
	 * 
	 * @return Retorna un array list con una lista de objetos ded tipo autobus, cada uno de ellos tiene la informacion de un autobus concreto
	 */
	public ArrayList<Autobus> getAutobusesByLinea(String codLinea) {
		
		Autobus autobus = null;
		ArrayList<Autobus> autobuses = new ArrayList<Autobus>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT l.Cod_bus, N_plazas, Consumo_km, Color FROM `linea_autobus` l, `autobus` a where l.Cod_bus=a.Cod_bus and Cod_Linea = ?";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			stmt.setString(1, codLinea);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Autobus con los resultados y los a�ade a un arrayList
			while (result.next()) {
				autobus = new Autobus(
					result.getInt("Cod_bus"),
					result.getInt("N_plazas"),
					result.getFloat("Consumo_km"),
					result.getString("Color")
				);
				autobuses.add(autobus);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                
		
		return autobuses;
		
	}
	/**
	 * Metodo encargado de conseguir la informacion de los municipios por los cuales pasa una linea
	 * 
	 * @param codLinea Codigo de la linea de la cual se quieren saber los municipios
	 * 
	 * @return Retorna un array list de objetos municipio
	 */
	public ArrayList<Municipio> getMunicipiosByLinea(String codLinea) {
		
		Municipio municipio = null;
		ArrayList<Municipio> municipios = new ArrayList<Municipio>();
		ArrayList<Parada> paradas = new ArrayList<Parada>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM `poblacion_parada`";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// carga las paradas de la linea
			paradas = getParadasByLinea(codLinea);
			
			// crea objetos Municipio con los resultados y los a�ade a un arrayList
			while (result.next()) {
				for(int i = 0;i<paradas.size();i++) {
					if (result.getInt("Cod_Parada") == paradas.get(i).getCodParada()) {
						municipio = new Municipio();
						municipio.setCodPostal(result.getInt("Cod_Postal"));
						municipios.add(municipio);
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                
		
		return municipios;
		
	}
	/**
	 * Metodo encargado de conseguir la informacion de las paradas de un municipio
	 * 
	 * @param codMunicipio Codigo del municipio del cual se quieren saber las paradas
	 * 
	 * @return Retorna un array list de objetos parada
	 */
	public ArrayList<Parada> getParadasByMunicipio(int codMunicipio) {
		
		Parada parada = null;
		ArrayList<Parada> paradas = new ArrayList<Parada>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "Select po.Cod_Parada, Nombre, Calle, Latitud, Longitud from `poblacion_parada` po, `parada` pa where po.Cod_Parada=pa.Cod_Parada and Cod_Postal = ?";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, codMunicipio);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Parada con los resultados y los a�ade a un arrayList
			while (result.next()) {
				parada = new Parada(
					result.getInt("Cod_Parada"),
					result.getString("Nombre"),
					result.getString("Calle"),
					result.getFloat("Latitud"),
					result.getFloat("Longitud")
				);
				paradas.add(parada);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}       
		
		return paradas;
		
	}
	/**
	 * Metodo que se encarga de buscar las paradas de una linea
	 * 
	 * @param codLinea Codigo de la linea, se utiliza para saber que paradas hay en esa linea
	 * 
	 * @return Retorna un array list de objetos parada
	 */
	public ArrayList<Parada> getParadasByLinea(String codLinea) {
		
		Parada parada = null;
		ArrayList<Parada> paradas = new ArrayList<Parada>();
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT l.Cod_Parada, Nombre, Calle, Latitud, Longitud, SQRT(POWER(Latitud-(SELECT Latitud FROM `parada` WHERE Cod_Parada = 1),2)+POWER(Longitud-(SELECT Longitud FROM `parada` WHERE Cod_Parada = 1),2)) \"Distancia\" FROM `linea-parada` l, `parada` p WHERE l.Cod_Parada=p.Cod_Parada and Cod_Linea = ? ORDER BY Distancia ASC";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			stmt.setString(1, codLinea);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Parada con los resultados y los a�ade a un arrayList
			while (result.next()) {
				parada = new Parada(
					result.getInt("Cod_Parada"),
					result.getString("Nombre"),
					result.getString("Calle"),
					result.getFloat("Latitud"),
					result.getFloat("Longitud")
				);
				paradas.add(parada);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}       
		
		return paradas;
		
	}
	/**
	 * Metodo encargado de buscar el cliente con un DNI especifico
	 * 
	 * @param dni DNI del cliente que se quiere buscar
	 * @return Retorna un objeto con la informacion del cliente
	 */
	public Cliente getClienteByDNI(String dni) {
		
		Cliente cliente = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		String query = "SELECT * FROM cliente where DNI = ?";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(query);
			stmt.setString(1, dni);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				cliente = new Cliente(
					result.getString("DNI"),
					result.getString("Nombre"),
					result.getString("Apellidos"), 
					result.getDate("Fecha_nac"),
					result.getString("Sexo").charAt(0),
					result.getString("Contrase�a")
				);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
		
		return cliente;
		
	}
	/**
	 * Metodo encargado de comprobar si el autobus tiene plazas libres
	 * 
	 * @param codBus Codigo del autobus que se quiere comprobar
	 * @param fecha Fecha para la cual se quiere mirar si hay plazas
	 * 
	 * @return Retorna true o false en funcion de si hay plazas o no respectibamente
	 */
	public Boolean comprobarPlazasBillete(int codBus, Date fecha) {

		PreparedStatement stmt = null;
		ResultSet result = null;
		Boolean disponible = false;
		int plazasOcupadas = 0;
		int plazasTotales = 0;
		
		String queryBillete = "SELECT count(*) FROM billete WHERE Cod_bus = ? and Fecha = ?";
		String queryAutobus = "SELECT N_plazas FROM autobus WHERE Cod_bus = ?";

		// comprobar las plazas ocupadas en un autobus
		try {
			
			// abrimos una conexion
			connection = conexion.conectar();

			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(queryBillete);
			stmt.setInt(1, codBus);
			stmt.setDate(2, fecha);
  
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet
			result = stmt.executeQuery();

			while (result.next()) {
				plazasOcupadas = result.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}   
		
		// comprobar las plazas totales de un autobus
		try {
			
			// abrimos una conexion
			connection = conexion.conectar();

			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement(queryAutobus);
			stmt.setInt(1, codBus);

			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();

			// crea objetos con los resultados y los a�ade a un arrayList
			while (result.next()) {
				plazasTotales = result.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}           

		if (plazasOcupadas < plazasTotales)  {
			disponible = true;
		} else {
			disponible = false;
		}

		return disponible;
	}

	
	/****************************************************************************************************************
	 * 
	 * Metodos para insertar los datos de los objetos cliente y billete en la BBDD (Consultas Insert)
	 * 
	 ****************************************************************************************************************/
	
	/**
	 * Inserta los atributos de un objetos cliente en la base de datos
	 * 
	 * @param cliente objeto cliente que se quiere insertar en la base de datos
	 */
	public void insertarCliente(Cliente cliente) {
		
		PreparedStatement stmt = null;
		String query = "INSERT INTO cliente (DNI, Nombre, Apellidos, Fecha_nac, Sexo, Contrase�a) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement(query);
			
			// a�adimos los valores a insertar
			stmt.setString(1, cliente.getDni());
			stmt.setString(2, cliente.getNombre());
			stmt.setString(3, cliente.getApellidos());
			stmt.setDate(4, cliente.getFechaNacimiento());
			stmt.setString(5, String.valueOf(cliente.getSexo()));
			stmt.setString(6, cliente.getContrasena());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
	}
	
	/**
	 * Inserta los atributos de un objetos billete en la base de datos
	 * 
	 * @param billete Objeto billete que se quiere introducir en la base de datos
	 * 
	 * @return Retorna el codigo del billete, generado de manera aleatoria
	 */
	public int insertarBillete(Billete billete) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codBillete = 0;
		
		String query = "INSERT INTO billete (NTrayecto, Cod_Linea, Cod_Bus, Cod_Parada_Inicio, Cod_Parada_Fin, Fecha, Hora, DNI, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			// a�adimos los valores a insertar
			stmt.setInt(1, billete.getNTrayecto());
			stmt.setString(2, billete.getCodLinea());
			stmt.setInt(3, billete.getCodBus());
			stmt.setInt(4, billete.getCodParadaInicio());
			stmt.setInt(5, billete.getCodParadaFin());
			stmt.setDate(6, billete.getFecha());
			stmt.setString(7, billete.getHora());
			stmt.setString(8, billete.getDni());
			stmt.setFloat(9, billete.getPrecio());
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			stmt.executeUpdate();
			
			result = stmt.getGeneratedKeys();
			result.next();
		    codBillete = result.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
		return codBillete;
		
	}

}
