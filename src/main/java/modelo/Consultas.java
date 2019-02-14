package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Consultas {
	
	private Conexion conexion;
	private Connection connection;
	
	public Consultas(Conexion conexion) {
		this.conexion = conexion;
		this.connection = null;
	}
	
	/****************************************************************************************************************
	 * 
	 * Metodos para cargar datos de la BBDD (Consultas Select)
	 * 
	 ****************************************************************************************************************/
	
	
	public ArrayList<Linea> getLineas() {
		
		Linea linea = null;
		ArrayList<Linea> lineas = new ArrayList<Linea>();
		ArrayList<Autobus> autobuses;
		ArrayList<Municipio> municipios;
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT * FROM linea");
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Linea con los resultados y los añade a un arrayList
			while (result.next()) {
				linea = new Linea();
				linea.setCodLinea(result.getString("Cod_Linea"));
				linea.setNombre(result.getString("Nombre"));				
				lineas.add(linea);
			}
			
			// cargamos los codigos de los autobuses
			for(int i = 0;i<lineas.size();i++) {
				autobuses = getAutobusesByLinea(lineas.get(i).getCodLinea());
				lineas.get(i).setAutobuses(autobuses);
			}
			
			// cargamos los codigos de los municipios
			for(int i = 0;i<lineas.size();i++) {
				municipios = getMunicipiosByLinea(lineas.get(i).getCodLinea());
				lineas.get(i).setMunicipios(municipios);
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
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT l.Cod_bus, N_plazas, Consumo_km, Color FROM `linea_autobus` l, `autobus` a where l.Cod_bus=a.Cod_bus and Cod_Linea = ?");
			stmt.setString(1, codLinea);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Autobus con los resultados y los añade a un arrayList
			while (result.next()) {
				autobus = new Autobus();
				autobus.setCodBus(result.getInt("Cod_bus"));
				autobus.setNumPlazas(result.getInt("N_plazas"));
				autobus.setConsumo(result.getFloat("Consumo_km"));
				autobus.setColor(result.getString("Color"));
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
	
	private ArrayList<Municipio> getMunicipiosByLinea(String codLinea) {
		
		Municipio municipio = null;
		ArrayList<Municipio> municipios = new ArrayList<Municipio>();
		ArrayList<Parada> paradas = new ArrayList<Parada>();
		ArrayList<Integer> codParadas;
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT * FROM `poblacion_parada`");
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			paradas = getParadasByLinea(codLinea);
			
			// crea objetos Municipio con los resultados y los añade a un arrayList
			while (result.next()) {
				for(int i = 0;i<paradas.size();i++) {
					if (result.getInt("Cod_Parada") == paradas.get(i).getCodParada()) {
						municipio = new Municipio();
						municipio.setCodPostal(result.getInt("Cod_Postal"));
	//					municipio = getInfoAutobus(municipio);
						municipios.add(municipio);
					}
				}
			}
			
			// cargamos los codigos de las paradas
			for(int i = 0;i<municipios.size();i++) {
				codParadas = new ArrayList<Integer>();
				paradas = getParadasByMunicipio(municipios.get(i).getCodPostal());
				for(int j = 0;j<paradas.size();j++) {
					codParadas.add(paradas.get(j).getCodParada());
				}
				municipios.get(i).setCodParadas(codParadas);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                
		
		return municipios;
		
	}
	
	public ArrayList<Parada> getParadasByMunicipio(int codMunicipio) {
		
		Parada parada = null;
		ArrayList<Parada> paradas = new ArrayList<Parada>();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("Select po.Cod_Parada, Nombre, Calle, Latitud, Longitud from `poblacion_parada` po, `parada` pa where po.Cod_Parada=pa.Cod_Parada and Cod_Postal = ?");
			stmt.setInt(1, codMunicipio);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Parada con los resultados y los añade a un arrayList
			while (result.next()) {
				parada = new Parada();
				parada.setCodParada(result.getInt("Cod_Parada"));
				parada.setNombre(result.getString("Nombre"));
				parada.setCalle(result.getString("Calle"));
				parada.setLatitud(result.getFloat("Latitud"));
				parada.setLongitud(result.getFloat("Longitud"));
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
	
	public ArrayList<Parada> getParadasByLinea(String codLinea) {
		
		Parada parada = null;
		ArrayList<Parada> paradas = new ArrayList<Parada>();
		PreparedStatement stmt = null;
		ResultSet result = null;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT l.Cod_Parada, Nombre, Calle, Latitud, Longitud, SQRT(POWER(Latitud-(SELECT Latitud FROM `parada` WHERE Cod_Parada = 1),2)+POWER(Longitud-(SELECT Longitud FROM `parada` WHERE Cod_Parada = 1),2)) \"Distancia\" FROM `linea-parada` l, `parada` p WHERE l.Cod_Parada=p.Cod_Parada and Cod_Linea = ? ORDER BY Distancia ASC");
			//stmt = this.connection.prepareStatement("SELECT * `linea-parada` l, `parada` p WHERE l.Cod_Parada=p.Cod_Parada and Cod_Linea = ?");
			stmt.setString(1, codLinea);
			
			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();
			
			// crea objetos Parada con los resultados y los añade a un arrayList
			while (result.next()) {
				parada = new Parada();
				parada.setCodParada(result.getInt("Cod_Parada"));
				parada.setNombre(result.getString("Nombre"));
				parada.setCalle(result.getString("Calle"));
				parada.setLatitud(result.getFloat("Latitud"));
				parada.setLongitud(result.getFloat("Longitud"));
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
	
	public Cliente getClienteByDNI(String dni) {
		
		Cliente cliente = null;
		PreparedStatement stmt = null;
		ResultSet result = null;

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
	
	public Boolean comprobarPlazasBillete(int codBus, Date fecha) {

		PreparedStatement stmt = null;
		ResultSet result = null;
		Boolean disponible = false;
		int plazasOcupadas = 0;
		int plazasTotales = 0;

		// comprobar las plazas ocupadas en un autobus
		try {
			
			// abrimos una conexion
			connection = conexion.conectar();

			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT count(*) FROM billete WHERE Cod_bus = ? and Fecha = ?");
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
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}   
		
		// comprobar las plazas totales de un autobus
		try {
			
			// abrimos una conexion
			connection = conexion.conectar();

			// preparamos la consulta SQL a la base de datos
			stmt = connection.prepareStatement("SELECT N_plazas FROM autobus WHERE Cod_bus = ?");
			stmt.setInt(1, codBus);

			// Ejecuta la consulta y guarda los resultados en un objeto ResultSet   
			result = stmt.executeQuery();

			// crea objetos con los resultados y los añade a un arrayList
			while (result.next()) {
				plazasTotales = result.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { result.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}           

		if (plazasOcupadas < plazasTotales)  {
			disponible = true;
		} else {
			disponible = false;
		}

		return disponible;
	}
	
	
	public float calcularPrecioBillete(float lat1, float lon1, float lat2, float lon2, Autobus autobus) {
		
		float precio = 0;
		float distancia;
		float consumo;
		float beneficio;
		
		// calculamos la distancia en kilometros
		distancia = calcularDistanciaKm(lat1, lon1, lat2, lon2);
		
		// calculamos el consumo del autobus
		consumo = calcularConsumo(distancia, autobus);
		
		// calculamos el beneficio
		beneficio = consumo * 0.2f;
		
		// calculamos el precio
		precio = consumo + beneficio;
		
		// redondeamos el precio
		precio = Math.round(precio*100.0f)/100.0f;
		
		return precio;
	}
	
	// https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
	public float calcularDistanciaKm(float lat1, float lon1, float lat2, float lon2) {
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

	public float deg2rad(float deg) {
	  return deg * (float)(Math.PI/180);
	}
	
	public float calcularConsumo(float distancia, Autobus autobus) {
		float consumoTotal;
		float consumo = autobus.getConsumo();
		consumoTotal = consumo * distancia * 0.8f;
		return consumoTotal;
	}

	
	/****************************************************************************************************************
	 * 
	 * Metodos para insertar los datos de los objetos cliente y billete en la BBDD (Consultas Insert)
	 * 
	 ****************************************************************************************************************/
	
	// inserta los atributos de un objetos cliente en la BBDD
	public void insertarCliente(Cliente cliente) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;

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
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}                 
	}
	
	// inserta los atributos de un objetos billete en la BBDD
	public int insertarBillete(Billete billete) {
		
		PreparedStatement stmt = null;
		ResultSet result = null;
		int codBillete = 0;

		try {
			
			// abrimos una conexion
			connection = conexion.conectar();
			
			// preparamos la consulta INSERT
			stmt = connection.prepareStatement("INSERT INTO billete (NTrayecto, Cod_Linea, Cod_Bus, Cod_Parada_Inicio, Cod_Parada_Fin, Fecha, Hora, DNI, Precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			// añadimos los valores a insertar
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
		    try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
		    try { connection.close(); } catch (Exception e) { e.printStackTrace(); }
		}
		
		return codBillete;
		
	}

}
