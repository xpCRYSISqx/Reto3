package modelo;

/**
 * Esta clase se encarga de hacer todos los calculos necesarios con el dinero.
 * 
 * Ademas de hacer los calculos necesarios, tambien muestra el dinero total a pagar, asi como el dinero faltante que el ususario debe introducir.
 * Una vez introducido todo el dinero necesario, tambien se encarga de devolver el dinero sobrante al usuario si fuese necesario.
 * 
 * @author Mikel
 * 
 * @param dinero: es la variable que almacena la cantidad de dinero introducida por el usuario.
 * @param total: guarda el dinero a pagar en total por todos los productos seleccionados.
 * @param sobra: guarda el dinero sobrante despues de introducir el pago en la maquina.
 * @param falta: guarda el dinero faltante despues de introducir el pago en la maquina.
 * 
 * @return falta: devuelve el valor total de cada producto seleccionado.
 * 
 */
public class Pagar {
	
	public float Falta(float total, float dinero)
	{	
		//Declaracion e inicializacion de variabeles
		float falta = 0f;//dinero que le falta por introducir.
		
		//Inicio del programa       
		falta = total - dinero;//obtenemos la diferencia.
		falta = Math.round(falta*100);//redondeamos el numero.
		falta = falta/100;
						 		
		return falta;						
	}
	public float Sobra(float total, float dinero)
	{
		float sobra = 0f;
		
		sobra = dinero-total;
		sobra = Math.round(sobra*100);//redondeamos el numero.
		sobra = sobra/100;
		
		return sobra;	
	}
}