package modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptacion {

	public String Encriptacion(String contrase�aAEncriptar){
        String contrase�aGenerada = null;
        try {
        	// Crea una instancia de MessageDigest para MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Agrega la contrase�a separada en bytes para separarla
            md.update(contrase�aAEncriptar.getBytes());
            // Saca los bytes separados
            byte[] bytes = md.digest();
            // bytes[] almacena los bytes en formato decimal
            // Los bytes en decimal pasan a hexadecimal
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // Coge los bytes separados de la contrase�a en hexadecimal y los junta en un string
            contrase�aGenerada = sb.toString();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return contrase�aGenerada;
    }
}