package test;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.*;

public class TestEncriptacion {

	@Test
	public void test() {
		Encriptacion encriptacion = new Encriptacion();
		String contraseña = "abracadabra";
		String contraseñaEncriptada = "ec5287c45f0e70ec22d52e8bcbeeb640";
		assertEquals(encriptacion.Encriptacion(contraseña), contraseñaEncriptada);
	}
}