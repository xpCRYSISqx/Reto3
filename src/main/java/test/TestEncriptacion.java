package test;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.*;

public class TestEncriptacion {

	@Test
	public void test() {
		Encriptacion encriptacion = new Encriptacion();
		String contrase�a = "abracadabra";
		String contrase�aEncriptada = "ec5287c45f0e70ec22d52e8bcbeeb640";
		assertEquals(encriptacion.Encriptacion(contrase�a), contrase�aEncriptada);
	}
}