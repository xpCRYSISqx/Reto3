package modelo;

public class ComprobarLogin {
	
	Modelo modelo;
	Cliente cliente;
	
	public Cliente comprobarInicio(String usuario, String contrasena, Modelo modelo) {
	Cliente cliente = null;
		
		this.modelo = modelo;
		Encriptacion encriptar = new Encriptacion();
		contrasena = encriptar.Encriptacion(contrasena);
		
		cliente = modelo.consultas.getClienteByDNI(usuario);
		
		if(cliente != null) {
			if(!contrasena.equals(cliente.getContrasena())) {
				cliente = null;
			}
		}
		
		return cliente;
		
	}
}