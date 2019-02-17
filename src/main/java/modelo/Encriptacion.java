package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

public class Encriptacion {

	public String Encriptacion(String contraseñaAEncriptar){
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
}