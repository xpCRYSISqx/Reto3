package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Conexion;
import modelo.LineaDAO;

public class Principal {

	public static void main(String[] args) {
		
		Conexion connection = new Conexion();
		LineaDAO lineaDAO = new LineaDAO(connection.getConnection());
		ResultSet result;
		
		result = lineaDAO.selectLineasAll();
		
//		while (result.next()) {
//			System.out.println (result.getString("Cod_Linea") + ": " + result.getString("Nombre"));
//		} 

	}

}