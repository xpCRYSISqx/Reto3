package app;

import controlador.Controlador;
import modelo.Conexion;
import modelo.Consultas;
import modelo.Encriptacion;
import modelo.Ficheros;
import modelo.Modelo;
import modelo.Pagar;
import vista.MainFrame;

public class App {

	public static void main(String[] args) {
		
		// Instancia de las clases necesarias para el programa
		
		// creamos un objeto Ficheros que se encargara de leer y escribir en archivos de texto plano
		Ficheros ficheros = new Ficheros();
				
		// cargamos los datos de conexion del archivo datosBBDD.txt
		String[] datosConexion = ficheros.getConnectionInfo();
				
		// creamos un objeto BBDD que se encargara de conectarse a la BBDD
		Conexion conexion = new Conexion(datosConexion);
				
		// Creamos un objeto Consultas que se encargara de hacer consultas a la BBDD
		Consultas consultas = new Consultas(conexion);
				
		// Creamos un objeto Encriptacion que usaremos para encriptar las contrase�as
		Encriptacion encriptacion = new Encriptacion();
				
		// Creamos un objeto Pagar que usaremos para el realizar el pago
		Pagar pagar = new Pagar();
		
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo(ficheros, datosConexion, conexion, consultas, encriptacion, pagar);
		Controlador controlador = new Controlador(modelo, vista);
		
		controlador.inicializarInterfaz();
		controlador.inicializarBotones();
	}
}