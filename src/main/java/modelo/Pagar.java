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
 * @param sumaDinero: suma la cantidad de dinero introducida por el usuario.
 * @param devolver: guarda un string con la cantidad de billetes y monedas que la máquina debe devolver.
 * @param cont: guarda la cantidad de monedas de cada tipo que tiene que devolver.
 * @param totalProducto: guarda el dinero a pagar en total por un tipo de producto, es decir, el precio total de ese producto dependiendo de la cantidad seleccionada.
 * @param total: guarda el dinero a pagar en total por todos los productos seleccionados.
 * @param sobra: guarda el dinero sobrante despues de introducir el pago en la maquina.
 * @param falta: guarda el dinero faltante despues de introducir el pago en la maquina.
 * 
 * @return falta: devuelve el valor total de cada producto seleccionado.
 * @return devolver: devuelve la cantidad de monedas y billetes que hay que devolver al usuario de la maquina expendedora si fuese necesario.
 * 
 */
public class Pagar {
	
	public static  float Falta(float total, float dinero)
	{	
		//Declaracion e inicializacion de variabeles
		float sumaIntro = 0f;//va sumando lo que  introduce en caso de faltar dinero.
		String devolver = "";
		int cont = 0;
		float totalProducto = 0f;
		float sobra = 0f;//cantidad que tiene que devolver.
		float falta = 0f;//dinero que le falta por introducir.
		
		//Inicio del programa				
		sumaIntro = dinero;		       
		falta = total-sumaIntro;//obtenemos la diferencia.
		falta = Math.round(falta*100);//redondeamos el numero.
		falta = falta/100;			
		sumaIntro = dinero+sumaIntro;
						 		
		return falta;						
	}
	public static String Sobra(float total, float dinero)
	{
		float sobra = 0f;
		int cont = 0;
		String devolver = "";
		
		if(dinero > total)//Si el dinero intro es mayor que el importe se calcula la devolucion.
		{ 
			sobra = dinero-total;
			if(sobra >= 500) //si la cantidad es mayor que este num, se divide entre el para saber la cantidad de billetes de este tipo,y calcula el resto para saber el dinero que le queda por analizar.
			{
				cont = (int) sobra/500;
	            sobra = sobra%500;
	            devolver=devolver+Float.toString(cont)+" billetes de 500€\n" ;
			}           
	        cont = 0;
	        if(sobra >= 200)
	        {
	             cont = (int) sobra/200;
	             sobra = sobra%200;
	             devolver = devolver+Float.toString(cont)+" billetes de 200€\n" ;
	        }           
	        cont = 0;
	        if(sobra >= 100)
	        {
	             cont = (int) sobra/100;
	             sobra = sobra%100;
	             devolver = devolver+Float.toString(cont)+" billetes de 100€\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 50)
	        {
	             cont = (int)sobra/50;
	             sobra = sobra%50;
	             devolver = devolver+Float.toString(cont)+" billetes de 50€\n" ;
	        }             
	        cont=0;
	        if(sobra >= 20)
	        {
	        	cont = (int) sobra/20;
	        	sobra = sobra%20;
	            devolver = devolver+Float.toString(cont)+" billetes de 20€\n" ;
	        }
	        cont = 0;
	        if(sobra >= 10)
	        {
	        	cont = (int) sobra/10;
	            sobra = sobra%10;
	            devolver = devolver+Float.toString(cont)+" billetes de 10€\n" ;
	        }                    
	        cont = 0;
	        if(sobra >= 5)
	        {
	        	cont = (int) sobra/5;
	            sobra = sobra%5;
	            devolver = devolver+Float.toString(cont)+" billetes de 5€\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 2)
	        {
	        	cont = (int) sobra/2;
	            sobra = sobra%2;
	            devolver = devolver+Float.toString(cont)+" monedas de 2€\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 1)
	        {
	            cont = (int)sobra/1;
	            sobra = sobra%1;
	            devolver = devolver+Float.toString(cont)+" monedas de 1€\n" ;
	        }
	        cont = 0;
	        sobra = Math.round(sobra*100);
			if(sobra >= 50)
			{
				cont = (int) (sobra/50);
				sobra = (float) (sobra%50);
				devolver = devolver+Float.toString(cont)+" monedas de 50cent\n";
			}
			cont = 0;
			sobra = Math.round(sobra); 
			if(sobra >= 20)
			{
				cont = (int) (sobra/20);
				sobra = (float) (sobra%20);
				devolver = devolver+Float.toString(cont)+" monedas de 20cent\n"; 		 
			}
			cont = 0;
			sobra = Math.round(sobra);   
			if(sobra >= 10)
			{
				cont = (int) (sobra/10);
				sobra = (float) (sobra%10);
				devolver = devolver+Float.toString(cont)+" monedas de 10cent\n";	
			}			   
			cont = 0;
			sobra = Math.round(sobra);			      
			if(sobra >= 5)
			{
				cont = (int) (sobra/5);
				sobra = (float) (sobra%5);
				devolver = devolver+Float.toString(cont)+" monedas de 5cent\n";		    	  
			}    
			cont = 0;
			sobra = Math.round(sobra);
			if(sobra >= 2)
			{
				cont = (int) (sobra/2);
				sobra = (float) (sobra%2);
				devolver = devolver+Float.toString(cont)+" monedas de 2cent\n";	  
			}
			cont = 0;
			sobra = Math.round(sobra);
			if(sobra >= 1)
			{
				cont = (int) (sobra/1);
				//sobra = (float) (sobra%0.01);
				devolver = devolver+Float.toString(cont)+" monedas de 1cent\n";	
			}    		
		}
		return devolver;		
	}
}