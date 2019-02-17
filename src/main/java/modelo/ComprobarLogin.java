package modelo;

public class ComprobarLogin {
	
	Modelo modelo;
	Cliente cliente;
	
	public ComprobarLogin(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public Cliente comprobarInicio(String usuario, String contrasena) {
	
		Cliente cliente = null;
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