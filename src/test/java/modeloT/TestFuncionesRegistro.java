package modeloT;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.*;

public class TestFuncionesRegistro {
	
	Modelo modelo = new Modelo();
	FuncionesRegistro funcionesRegistro = new FuncionesRegistro(modelo);
	
	@Test
	public void testValidarDNI() {
		String dni = "72317852X";
		assertEquals(true, funcionesRegistro.validarDNI(dni));
	}
	
	@Test
	public void testValidarDNIError() {
		String dni = "12317852X";
		assertNotEquals(true, funcionesRegistro.validarDNI(dni));
	}
	
	@Test
	public void testSoloNumeros() {
		String dni = "72317852X";
		assertEquals(true, funcionesRegistro.soloNumeros(dni));
	}
	
	@Test
	public void testSoloNumerosError() {
		String dni = "123178ffX";
		assertNotEquals(true, funcionesRegistro.soloNumeros(dni));
	}
	
	@Test
	public void testLetraDNI() {
		String dni = "72317852X";
		String letraMayuscula = (dni.substring(8)).toUpperCase();
		assertEquals(letraMayuscula, funcionesRegistro.letraDNI(dni));
	}
	
	@Test
	public void testLetraDNIError() {
		String dni = "12317852B";
		String letraMayuscula = (dni.substring(8)).toUpperCase();
		assertNotEquals(letraMayuscula, funcionesRegistro.letraDNI(dni));
	}

	@Test
	public void testEncriptacion() {
		
		String contraseña = "abracadabra";
		String contraseñaEncriptada = "ec5287c45f0e70ec22d52e8bcbeeb640";
		
		assertEquals(contraseñaEncriptada, funcionesRegistro.encriptacion(contraseña));
	}
		
	
}