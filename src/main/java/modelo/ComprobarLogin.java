package modelo;

public class ComprobarLogin {
	
	Modelo modelo = new Modelo();
	Cliente cliente = null;
	
	public Cliente comprobarInicio(String usuario, String contrasena) {
		
		Encriptacion encriptar = new Encriptacion();
		contrasena = encriptar.Encriptacion(contrasena);
		
		cliente = modelo.consultas.getClienteByDNI(usuario);
		
		if(cliente != null) {
			if(!contrasena.equals(cliente.getContraseña())) {
				cliente = null;
			}
		}
		
		return cliente;
		
	}
}