package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conexion;
import modelo.Linea;
import modelo.LineaDAO;

public class Principal {

	public static void main(String[] args) {
		
		Connection connection = new Conexion().getConnection();
		LineaDAO lineaDAO = new LineaDAO(connection);
		ArrayList<Linea> lineas = lineaDAO.selectLineasAll();
		
		for (int i = 0; i < lineas.size(); i++) { 		      
          System.out.print(lineas.get(i).getCodLinea()+": ");
          System.out.println(lineas.get(i).getNombre()); 
		} 
		
	}

}