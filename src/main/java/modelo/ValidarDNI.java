package modelo;

public class ValidarDNI {
	
	String dni;
	
	public ValidarDNI(String dni) {
		this.dni = dni;
	}
	
	public boolean validar() {
		String letraMayuscula = "";
		if(dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) 
			return false;
		letraMayuscula = (dni.substring(8)).toUpperCase();
		if(soloNumeros() == true && letraDNI().equals(letraMayuscula))
			return true;
		else
			return false;
	}
	
	public boolean soloNumeros() {
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
	
	public String letraDNI() {
		int dni2 = Integer.parseInt(dni.substring(0, 8));
		int posicion = 0;
		String letra = "";
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E", "T"};
		
		posicion = dni2 % 23;
		letra = letras[posicion];
		
		return letra;
	}
}