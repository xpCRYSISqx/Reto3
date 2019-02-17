package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funciones {
	
	/*
	 * Funciones validar dni
	 */
	public boolean validarDNI(String dni) {
		String letraMayuscula = "";
		if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) 
			return false;
		letraMayuscula = (dni.substring(8)).toUpperCase();
		if(soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula))
			return true;
		else
			return false;
	}
	
	public boolean soloNumeros(String dni) {
		String numero = "";
		String dni2 = "";
		String[] numerosUnoNueve = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(int i = 0; i < dni.length() - 1; i++) {
			numero = dni.substring(i, i+1);
			for(int j = 0; j < numerosUnoNueve.length; j++) {
				if(numero.equals(numerosUnoNueve[j]))
					dni2 = dni2 + numerosUnoNueve[j];
			}
		}
		if(dni2.length() != 8)
			return false;
		else
			return true;
	}
	
	public String letraDNI(String dni) {
		int dni2 = Integer.parseInt(dni.substring(0, 8));
		int posicion = 0;
		String letra = "";
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
		
		posicion = dni2 % 23;
		letra = letras[posicion];
		
		return letra;
	}
	
	/*
	 * Encriptar contraseña
	 */
	public String encriptacion(String contraseñaAEncriptar){
        String contraseñaGenerada = null;
        try {
        	// Crea una instancia de MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Agrega la contraseña separada en bytes para separarla
            md.update(contraseñaAEncriptar.getBytes());
            // Saca los bytes separados
            byte[] bytes = md.digest();
            // bytes[] almacena los bytes en formato decimal
            // Los bytes en decimal pasan a hexadecimal
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Coge los bytes separados de la contraseña en hexadecimal y los junta en un string
            contraseñaGenerada = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return contraseñaGenerada;
    }
	
	/**
	 * Esta clase se encarga de redimensionar un array que se le pasa por parametro.
	 * 
	 * @author Mikel.
	 * 
	 * @param arrayRedimensionar: Es el array que se desea redimensionar, se le para como parametro a la funcion.
	 * @param tamano: Es el tamaño al que se desea redimensionar el array, en este caso genera un array con una posición mas que el array que se desea redimensionar.
	 * @param arrayRedimensionado: es el array una vez redimensionado, se declara con un espacio mas que el array que se desea redimensionar.
	 * 
	 * @return arrayRedimensionado: devuelve el array una vez ha sido redimensionado y se ha copiado el contenido del array que se queria redimensionar.
	 */
	public float[] redimensionarArrayMayor(float[] arrayRedimensionar) {
		int tamano = arrayRedimensionar.length + 1;
		float[] arrayRedimensionado = new float[tamano];
		
		System.arraycopy(arrayRedimensionar, 0, arrayRedimensionado, 0, arrayRedimensionar.length); // Copia arrayRedimensionar en arrayRedimensionado, el cuel es una posicion mas largo.
		return arrayRedimensionado; // Devuelve el resultado.
	}
	
	/**
	 * Esta clase se encarga de redimensionar un array que se le pasa por parametro.
	 * 
	 * @author Mikel.
	 * 
	 * @param arrayRedimensionar: Es el array que se desea redimensionar, se le para como parametro a la funcion.
	 * @param tamano: Es el tamaño al que se desea redimensionar el array, en este caso genera un array con una posición menos que el array que se desea redimensionar.
	 * @param arrayRedimensionado: es el array una vez redimensionado, se declara con un espacio mas que el array que se desea redimensionar.
	 * 
	 * @return arrayRedimensionado: devuelve el array una vez ha sido redimensionado y se ha copiado el contenido del array que se queria redimensionar.
	 */
	public float[] redimensionarArrayMenor(float[] arrayRedimensionar) {
		int tamano = arrayRedimensionar.length - 1;
		float[] arrayRedimensionado = new float[tamano];
		
		System.arraycopy(arrayRedimensionar, 0, arrayRedimensionado, 0, arrayRedimensionar.length - 1); // Copia arrayRedimensionar en arrayRedimensionado, el cuel es una posicion mas largo.
		return arrayRedimensionado; // Devuelve el resultado.
	}
	
	
	/*
	 * Metodos para calcular el precio
	 */
	public float calcularPrecioBillete(Autobus autobus, float distancia) {
		
		float precio = 0;
		float consumo = autobus.getConsumo();
		float beneficio = 1.2f;
		float iva = 1.21f;
		
		// calculamos el precio
		precio = consumo * distancia * beneficio * iva;
		
		// redondeamos el precio
		precio = Math.round(precio*100.0f)/100.0f;
		
		return precio;
	}
	
	public float calcularDistanciaKm(float lat1, float lon1, float lat2, float lon2) {
		
		// https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
		
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
	
	/*
	 * Funciones pago
	 */
	
	/**
	 * Esta clase se encarga de hacer todos los calculos necesarios con el dinero.
	 * 
	 * Ademas de hacer los calculos necesarios, tambien muestra el dinero total a pagar, asi como el dinero faltante que el ususario debe introducir.
	 * Una vez introducido todo el dinero necesario, tambien se encarga de devolver el dinero sobrante al usuario si fuese necesario.
	 * 
	 * @author Mikel
	 * 
	 * @param dinero: es la variable que almacena la cantidad de dinero introducida por el usuario.
	 * @param total: guarda el dinero a pagar en total por todos los productos seleccionados.
	 * @param sobra: guarda el dinero sobrante despues de introducir el pago en la maquina.
	 * @param falta: guarda el dinero faltante despues de introducir el pago en la maquina.
	 * @param cont: guarda la cantidad de monedas de cada tipo que tiene que devolver.
	 * 
	 * @return falta: devuelve el valor total de cada producto seleccionado.
	 * @return devolver: devuelve la cantidad de monedas y billetes que hay que devolver al usuario de la maquina expendedora si fuese necesario.
	 */
	
	public float falta(float total, float dinero){	
		
		float falta = 0f;//dinero que le falta por introducir.
		     
		falta = total - dinero;//obtenemos la diferencia.
		falta = Math.round(falta*100);//redondeamos el numero.
		falta = falta/100;
						 		
		return falta;						
	}

	public String sobra(float total, float dinero){
		float sobra = 0f;
		int cont = 0;
		String devolver = "";
		
		if(dinero > total)//Si el dinero intro es mayor que el importe se calcula la devolucion.
		{ 
			sobra = dinero-total;
			if(sobra >= 500) //si la cantidad es mayor que este num, se divide entre el para saber la cantidad de billetes de este tipo,y calcula el resto para saber el dinero que le queda por analizar.
			{
				cont = (int) sobra/500;
	            sobra = sobra%500;
	            devolver=devolver+Float.toString(cont)+" billetes de 500€\n" ;
			}           
	        cont = 0;
	        if(sobra >= 200)
	        {
	             cont = (int) sobra/200;
	             sobra = sobra%200;
	             devolver = devolver+Float.toString(cont)+" billetes de 200€\n" ;
	        }           
	        cont = 0;
	        if(sobra >= 100)
	        {
	             cont = (int) sobra/100;
	             sobra = sobra%100;
	             devolver = devolver+Float.toString(cont)+" billetes de 100€\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 50)
	        {
	             cont = (int)sobra/50;
	             sobra = sobra%50;
	             devolver = devolver+Float.toString(cont)+" billetes de 50€\n" ;
	        }             
	        cont=0;
	        if(sobra >= 20)
	        {
	        	cont = (int) sobra/20;
	        	sobra = sobra%20;
	            devolver = devolver+Float.toString(cont)+" billetes de 20€\n" ;
	        }
	        cont = 0;
	        if(sobra >= 10)
	        {
	        	cont = (int) sobra/10;
	            sobra = sobra%10;
	            devolver = devolver+Float.toString(cont)+" billetes de 10€\n" ;
	        }                    
	        cont = 0;
	        if(sobra >= 5)
	        {
	        	cont = (int) sobra/5;
	            sobra = sobra%5;
	            devolver = devolver+Float.toString(cont)+" billetes de 5€\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 2)
	        {
	        	cont = (int) sobra/2;
	            sobra = sobra%2;
	            devolver = devolver+Float.toString(cont)+" monedas de 2€\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 1)
	        {
	            cont = (int)sobra/1;
	            sobra = sobra%1;
	            devolver = devolver+Float.toString(cont)+" monedas de 1€\n" ;
	        }
	        cont = 0;
	        sobra = Math.round(sobra*100);
			if(sobra >= 50)
			{
				cont = (int) (sobra/50);
				sobra = (float) (sobra%50);
				devolver = devolver+Float.toString(cont)+" monedas de 50cent\n";
			}
			cont = 0;
			sobra = Math.round(sobra); 
			if(sobra >= 20)
			{
				cont = (int) (sobra/20);
				sobra = (float) (sobra%20);
				devolver = devolver+Float.toString(cont)+" monedas de 20cent\n"; 		 
			}
			cont = 0;
			sobra = Math.round(sobra);   
			if(sobra >= 10)
			{
				cont = (int) (sobra/10);
				sobra = (float) (sobra%10);
				devolver = devolver+Float.toString(cont)+" monedas de 10cent\n";	
			}			   
			cont = 0;
			sobra = Math.round(sobra);			      
			if(sobra >= 5)
			{
				cont = (int) (sobra/5);
				sobra = (float) (sobra%5);
				devolver = devolver+Float.toString(cont)+" monedas de 5cent\n";		    	  
			}    
			cont = 0;
			sobra = Math.round(sobra);
			if(sobra >= 2)
			{
				cont = (int) (sobra/2);
				sobra = (float) (sobra%2);
				devolver = devolver+Float.toString(cont)+" monedas de 2cent\n";	  
			}
			cont = 0;
			sobra = Math.round(sobra);
			if(sobra >= 1)
			{
				cont = (int) (sobra/1);
				//sobra = (float) (sobra%0.01);
				devolver = devolver+Float.toString(cont)+" monedas de 1cent\n";	
			}    		
		}
		return devolver;		
	}
	
	/*
	 * Imprimir billete
	 */
	public String imprimirBillete(Billete billeteIda, Billete billeteVuelta, Cliente cliente, String path, Modelo modelo) {
		
		FileWriter fichero = null;	
		PrintWriter writer = null;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date fechaActual = new Date();
		String sexo = "Mujer";
		if (cliente.getSexo() == 'V') {
			sexo = "Varon";
		}
		
		try {
			
			fichero = new FileWriter(path);
			writer = new PrintWriter(fichero);
			
			writer.println("=== DATOS DEL CLIENTE ===");
			writer.println();
			writer.println("DNI: " + cliente.getDni());
			writer.println("Nombre: " + cliente.getNombre());
			writer.println("Apellidos: " + cliente.getApellidos());
			writer.println("Fecha nacimiento: " + cliente.getFechaNacimiento());
			writer.println("Sexo: " + sexo);
			writer.println();
			writer.println();
			
			writer.println("=== DATOS DEL BILLETE DE IDA ===");
			writer.println();
			writer.println("Código Billete: " + billeteIda.getCodLinea());
			writer.println("Número de Trayecto: " + billeteIda.getNTrayecto());
			writer.println("Línea: " + billeteIda.getCodLinea() + ": " + modelo.linea.getNombre());
			writer.println("Origen: " + modelo.paradaOrigen.getNombre());
			writer.println("Destino: " + modelo.paradaDestino.getNombre());
			writer.println("Autobus: " + billeteIda.getCodBus());
			writer.println("Fecha: " + billeteIda.getFecha());
			writer.println("Hora: " + billeteIda.getHora());
			writer.println("Precio: " + billeteIda.getPrecio() + "€");
			writer.println("Fecha de compra: " + dateFormat.format(fechaActual));
			writer.println();
			writer.println();
			
			writer.println("=== DATOS DEL BILLETE DE VUELTA ===");
			writer.println();
			writer.println("Código Billete: " + billeteVuelta.getCodLinea());
			writer.println("Número de Trayecto: " + billeteVuelta.getNTrayecto());
			writer.println("Línea: " + billeteIda.getCodLinea() + ": " + modelo.linea.getNombre());
			writer.println("Origen: " +  modelo.paradaOrigen.getNombre());
			writer.println("Destino: " + modelo.paradaDestino.getNombre());
			writer.println("Autobus: " + billeteVuelta.getCodBus());
			writer.println("Fecha: " + billeteVuelta.getFecha());
			writer.println("Hora: " + billeteVuelta.getHora());
			writer.println("Precio: " + billeteVuelta.getPrecio() + "€");
			writer.println("Fecha de compra: " + dateFormat.format(fechaActual));
			writer.println();
			
			writer.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
				if (writer != null) {
					writer.close();
				}
				} catch (Exception e) {
					e.getStackTrace();
			}
		}
		
		return path;
		
	}

}
