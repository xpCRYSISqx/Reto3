package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FuncionesRegistro {
	
	Modelo modelo;
	
	public FuncionesRegistro (Modelo modelo) {
		this.modelo = modelo;
	}
	
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
	
	/**
	 * Esta clase se utiliza para encriptar la contraseña que el usuario introduce en la interfaz
	 * 
	 * @author Mikel
	 * 
	 * @param ContraseñaEncriptar: Es la contraseña que se va a encriptar
	 * @param contraseñaGenerada: Es la contraseña una vez encriptada
	 * @param md: Instancia de MessageDigest, se utiliza para separar la contraseña en fragmentos para poder encriptarla
	 * @param bytes: Array que almacena los distintros trozos separados de la contraseña con MessageDigest transformados en bytes
	 * @param sb: Instancia de StringBuilder, se utiliza para volver a unir las diferentes partes de la contrasela vez encriptada
	 *
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
	
	/*
	 * Comprobar inicio de sesion
	 */
	public Cliente comprobarInicio(String usuario, String contrasena) {
		
		Cliente cliente = null;
		contrasena = modelo.funcionesRegistro.encriptacion(contrasena);
		
		cliente = modelo.consultas.getClienteByDNI(usuario);
		
		if(cliente != null) {
			if(!contrasena.equals(cliente.getContrasena())) {
				cliente = null;
			}
		}
		
		return cliente;
		
	}

}
