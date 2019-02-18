package app;

import controlador.Controlador;
import modelo.Modelo;
import vista.MainFrame;

/**
 * Clase main de la aplicacion, desde aqui se instancian los componentes basicos para que el programa funcione y se inicializa el controlador
 * 
 * @author Laura, Ustaritz, Mikel
 * 
 * @param ficheros: Instancia de la clase ficheros para utilizarla mas adelante
 * @param datosConexion: Guarda los detos de conexion a la base de datos
 * @param conexion: instancia de la clase que establece la conexion con la base de datos
 * @param consultas: Instancia de la calse que se utiliza para hacer consultas a la base de datos
 * @param encriptacion: Instancia de la clase que se utiliza para encriptar la base de datos
 * @param pagar: Instancia de la clase que se utiliza para calcular los importe cuando se dispone a pagar el billete
 * @param vista: Instancia del main frame, se utiliza para iniciar la interfaz
 * @param modelo: Instancia del modelo, se utiliza para accedes a las distintas clases del modelo
 * @param controlador: Instancia del controlador, se utiliza para iniciar el programa en general y realizar sus funciones basicas, asi como para controlar su funcionamiento
 *
 */

public class App {

	public static void main(String[] args) {
		
		MainFrame vista = new MainFrame();
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador(modelo, vista);
		
		controlador.inicializarInterfaz();
		controlador.inicializarBotones();
	}
}