package modelo;

/**
 * Esta clase se encarga de redimensionar un array que se le pasa por parametro.
 * 
 * @author Mikel.
 * 
 * @param arrayRedimensionar: Es el array que se desea redimensionar, se le para como parametro a la funcion.
 * @param tamano: Es el tamaño al que se desea redimensionar el array, en este caso genera un array con una posición mas que el array que se desea redimensionar.
 * @param arrayRedimensionado: es el array una vez redimensionado, se declara con un espacio mas que el array que se desea redimensionar.
 * 
 * @return arrayRedimensionado: devuelve el array una vez ha sido redimensionado y se ha copiado el contenido del array que se queria redimensionar.
 */

public class RedimensionarArrayMayor {

	public float[] redimensionarArray(float[] arrayRedimensionar) {
		int tamano = arrayRedimensionar.length + 1;
		float[] arrayRedimensionado = new float[tamano];
		
		System.arraycopy(arrayRedimensionar, 0, arrayRedimensionado, 0, arrayRedimensionar.length); // Copia arrayRedimensionar en arrayRedimensionado, el cuel es una posicion mas largo.
		return arrayRedimensionado; // Devuelve el resultado.
	}
}