package modelo;

import java.sql.Connection;
import java.util.ArrayList;

public class Modelo {
	
	private Connection connection = new Conexion().getConnection();
	private Linea linea = new Linea();
	
	private LineaDAO lineaDAO = new LineaDAO(connection);
	private ArrayList<Linea> lineas = lineaDAO.selectLineasAll();
	
	public Modelo() {
		for (int i = 0; i < lineas.size(); i++) { 		      
	      System.out.print(lineas.get(i).getCodLinea()+": ");
	      System.out.println(lineas.get(i).getNombre()); 
		} 
	}
}
