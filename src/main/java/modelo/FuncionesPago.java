package modelo;

public class FuncionesPago {
	
	Modelo modelo;
	
	public FuncionesPago (Modelo modelo) {
		this.modelo = modelo;
	}
	
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
	public float[] redimensionarArrayMayor(float[] arrayRedimensionar) {
		int tamano = arrayRedimensionar.length + 1;
		float[] arrayRedimensionado = new float[tamano];
		
		System.arraycopy(arrayRedimensionar, 0, arrayRedimensionado, 0, arrayRedimensionar.length); // Copia arrayRedimensionar en arrayRedimensionado, el cuel es una posicion mas largo.
		return arrayRedimensionado; // Devuelve el resultado.
	}
	
	/**
	 * Esta clase se encarga de redimensionar un array que se le pasa por parametro.
	 * 
	 * @author Mikel.
	 * 
	 * @param arrayRedimensionar: Es el array que se desea redimensionar, se le para como parametro a la funcion.
	 * @param tamano: Es el tamaño al que se desea redimensionar el array, en este caso genera un array con una posición menos que el array que se desea redimensionar.
	 * @param arrayRedimensionado: es el array una vez redimensionado, se declara con un espacio mas que el array que se desea redimensionar.
	 * 
	 * @return arrayRedimensionado: devuelve el array una vez ha sido redimensionado y se ha copiado el contenido del array que se queria redimensionar.
	 */
	public float[] redimensionarArrayMenor(float[] arrayRedimensionar) {
		int tamano = arrayRedimensionar.length - 1;
		float[] arrayRedimensionado = new float[tamano];
		
		System.arraycopy(arrayRedimensionar, 0, arrayRedimensionado, 0, arrayRedimensionar.length - 1); // Copia arrayRedimensionar en arrayRedimensionado, el cuel es una posicion mas largo.
		return arrayRedimensionado; // Devuelve el resultado.
	}
	
	/*
	 * Funciones pago
	 */
	
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
	 * @param cont: guarda la cantidad de monedas de cada tipo que tiene que devolver.
	 * 
	 * @return falta: devuelve el valor total de cada producto seleccionado.
	 * @return devolver: devuelve la cantidad de monedas y billetes que hay que devolver al usuario de la maquina expendedora si fuese necesario.
	 */
	
	public float falta(float total, float dinero){	
		
		float falta = 0f;//dinero que le falta por introducir.
		     
		falta = total - dinero;//obtenemos la diferencia.
		falta = Math.round(falta*100);//redondeamos el numero.
		falta = falta/100;
						 		
		return falta;						
	}

	public String sobra(float total, float dinero){
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
	            devolver=devolver+Integer.toString(cont)+" billetes de 500€" + "\n" ;
			}           
	        cont = 0;
	        if(sobra >= 200)
	        {
	             cont = (int) sobra/200;
	             sobra = sobra%200;
	             devolver = devolver+Integer.toString(cont)+" billetes de 200€" + "\n" ;
	        }           
	        cont = 0;
	        if(sobra >= 100)
	        {
	             cont = (int) sobra/100;
	             sobra = sobra%100;
	             devolver = devolver+Integer.toString(cont)+" billetes de 100€" + "\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 50)
	        {
	             cont = (int)sobra/50;
	             sobra = sobra%50;
	             devolver = devolver+Integer.toString(cont)+" billetes de 50€" + "\n" ;
	        }             
	        cont=0;
	        if(sobra >= 20)
	        {
	        	cont = (int) sobra/20;
	        	sobra = sobra%20;
	            devolver = devolver+Integer.toString(cont)+" billetes de 20€" + "\n" ;
	        }
	        cont = 0;
	        if(sobra >= 10)
	        {
	        	cont = (int) sobra/10;
	            sobra = sobra%10;
	            devolver = devolver+Integer.toString(cont)+" billetes de 10€ " + "\n" ;
	        }                    
	        cont = 0;
	        if(sobra >= 5)
	        {
	        	cont = (int) sobra/5;
	            sobra = sobra%5;
	            devolver = devolver+Integer.toString(cont)+" billetes de 5€" + "\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 2)
	        {
	        	cont = (int) sobra/2;
	            sobra = sobra%2;
	            devolver = devolver+Integer.toString(cont)+" monedas de 2€" + "\n" ;
	        }             
	        cont = 0;
	        if(sobra >= 1)
	        {
	            cont = (int)sobra/1;
	            sobra = sobra%1;
	            devolver = devolver+Integer.toString(cont)+" monedas de 1€" + "\n" ;
	        }
	        cont = 0;
	        sobra = Math.round(sobra*100);
			if(sobra >= 50)
			{
				cont = (int) (sobra/50);
				sobra = (float) (sobra%50);
				devolver = devolver+Integer.toString(cont)+" monedas de 0,50€" + "\n";
			}
			cont = 0;
			sobra = Math.round(sobra); 
			if(sobra >= 20)
			{
				cont = (int) (sobra/20);
				sobra = (float) (sobra%20);
				devolver = devolver+Integer.toString(cont)+" monedas de 0,20€" + "\n"; 		 
			}
			cont = 0;
			sobra = Math.round(sobra);   
			if(sobra >= 10)
			{
				cont = (int) (sobra/10);
				sobra = (float) (sobra%10);
				devolver = devolver+Integer.toString(cont)+" monedas de 0,10€" + "\n";	
			}			   
			cont = 0;
			sobra = Math.round(sobra);			      
			if(sobra >= 5)
			{
				cont = (int) (sobra/5);
				sobra = (float) (sobra%5);
				devolver = devolver+Integer.toString(cont)+" monedas de 0,05€" + "\n";		    	  
			}    
			cont = 0;
			sobra = Math.round(sobra);
			if(sobra >= 2)
			{
				cont = (int) (sobra/2);
				sobra = (float) (sobra%2);
				devolver = devolver+Integer.toString(cont)+" monedas de 0,02€" + "\n";	  
			}
			cont = 0;
			sobra = Math.round(sobra);
			if(sobra >= 1)
			{
				cont = (int) (sobra/1);
				//sobra = (float) (sobra%0.01);
				devolver = devolver+Integer.toString(cont)+" monedas de 0,01€" + "\n";	
			}    		
		}
		return devolver;		
	}

}
