package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.*;
import vista.*;

/**
 * 
 * @author Mikel, Laura
 * 
 * @param vista: Guarda el objeto vista para poder utilizar los distintos elementos de la interfaz
 * @param modelo: Guarda el objeto modelo para poder acceder a los metodos del modelo
 *
 */

public class ControladorPago implements ActionListener{
	
	private MainFrame vista; // Declara el objeto vista
	private Modelo modelo; // Declara el objeto modelo
	
	
	private JLabel importe, introducido, restante;
	public float total = 0; // Total del importe que se debe pagar
	public float dinero = 0; // Total del dinero que ha sido introdcido hasta al momento
	private float falta = 0; // Total del dinero que falta por introducir
	private float moneda = 0; // Guarda el valos de la ultima moneda o billete introducido
	public float sobra = 0; // Total del 
	public float[] monedas; // Almacena el valor de las monedas y billetes que se van introducioendo para luego poder retarlos.
	
	public ControladorPago(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		this.importe = this.vista.pago.lblDineroTotal;
		this.introducido = this.vista.pago.lblDineroIntro;
		this.restante = this.vista.pago.lblDineroRest;
		this.monedas = new float[0];
	}
	
	public void addListeners() {
		// Se agregan los action listeners a los botones para poder utilizarlos
		this.vista.pago.btn001.addActionListener(this);
		this.vista.pago.btn002.addActionListener(this);
		this.vista.pago.btn005.addActionListener(this);
		this.vista.pago.btn010.addActionListener(this);
		this.vista.pago.btn020.addActionListener(this);
		this.vista.pago.btn050.addActionListener(this);
		this.vista.pago.btn1.addActionListener(this);
		this.vista.pago.btn2.addActionListener(this);
		this.vista.pago.btn5.addActionListener(this);
		this.vista.pago.btn10.addActionListener(this);
		this.vista.pago.btn20.addActionListener(this);
		this.vista.pago.btn50.addActionListener(this);
		this.vista.pago.btn100.addActionListener(this);
		this.vista.pago.btn200.addActionListener(this);
		
		this.vista.pago.btnAtras.addActionListener(this);
		this.vista.pago.btnCancelar.addActionListener(this);
		this.vista.pago.btnCancelarPago.addActionListener(this);
		this.vista.pago.btnContinuar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand(); // Almacena el texto del boton para poder identificarlo posteriormente
		float importe; // Almacena el importe que representa cada uno de los botones, para asν poder realizar las operaciones con el dinero
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "0,01 ":
				importe = 0.01f;
				FuncionBotonDinero(importe); // Llama a la funcion que realiza las operaciones con el importe de cada boton
				break;
				
			case "0,02 ":
				importe = 0.02f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,05 ":
				importe = 0.05f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,10 ":
				importe = 0.1f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,20 ":
				importe = 0.2f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,50 ":
				importe = 0.5f;
				FuncionBotonDinero(importe);
				break;
				
			case "1 ":
				importe = 1f;
				FuncionBotonDinero(importe);
				break;
				
			case "2 ":
				importe = 2f;
				FuncionBotonDinero(importe);
				break;
				
			case "5 ":
				importe = 5f;
				FuncionBotonDinero(importe);
				break;
				
			case "10 ":
				importe = 10f;
				FuncionBotonDinero(importe);
				break;
				
			case "20 ":
				importe = 20f;
				FuncionBotonDinero(importe);
				break;
				
			case "50 ":
				importe = 50f;
				FuncionBotonDinero(importe);
				break;
				
			case "100 ":
				importe = 100f;
				FuncionBotonDinero(importe);
				break;
				
			case "200 ":
				importe = 200f;
				FuncionBotonDinero(importe);
				break;
				
			case "Atrαs":
				vista.detalles_compra.setVisible(true);
				vista.pago.setVisible(false);
				break;
				
			case "Cancelar":
				vista.bienvenida.setVisible(true);
				vista.pago.setVisible(false);
				break;
				
			case "Devolver":
				FuncionDevolver();
				break;
				
			case "Continuar":
				FuncionContinuar();
				break;
				
		}
	}
	
	public void FuncionBotonDinero(float importe) { // Realiza las operaciones con el importe de cada boton, tambien almacena las cantidades que se ban introduciendo, se calcula el dinero que fala por introducir o lo que sobra.
		RedimensionarArrayMayor redimensionMayor = new RedimensionarArrayMayor(); // Instancia la clase que se utiliza para redimensionar un array a uno menor
		int posicion; // Guarda la posicion en la que se debe almacenar el importe del boton pulsado en al array de monedas
		this.total = this.modelo.precioTotal; // Guarda el importe total que se debe introducir
		dinero = dinero + importe; // Se suma el importe del boton pulsado al dinero que ya se habia introducido
		dinero = Math.round(dinero*100); // Redondea el resultado
		dinero = dinero/100;
		monedas = redimensionMayor.redimensionarArray(monedas); // Redimensiona el array monedas a un array una posicion mayos para poder guardar el importe del boton pulsado
		posicion = monedas.length - 1;
		monedas[posicion] = importe; // Guarda el importe en la ultima posicion del array
		introducido.setText(Float.toString(dinero) + " "); // Muestra en la interfaz el dinero que se ha introducido hasta el momento
		if(dinero < total) { // Comprueba si todabia falta dinero para llegar al total
			falta = modelo.pagar.Falta(total, dinero); // En caso de no llegar o sobrepasar el total necesario, se calcula el dinero faltante
			restante.setText(Float.toString(falta) + " "); // Muestra en la interfaz el dinero que falta para alcanzar el total
		}
		else
			TodoIntroducido(); // Si se ha introducedo o sobrepasado el total, llama a esta funcion
	}
	
	public void FuncionDevolver() { // Realiza las operaciones necesarias cuando el usuario pide que se le devuelva la ultima moneda introducida
		RedimensionarArrayMenor redimensionMenor = new RedimensionarArrayMenor(); // Instancia la clase que se utiliza para redimensionar un array a uno menor
		int posicion;
		if(dinero > 0) {
			posicion = monedas.length - 1;
			moneda = monedas[posicion]; // Guarda el valor de la ultima moneda introducida en el array
			dinero = dinero - moneda; // Resta al dinero total el importe de la ultima moneda introducida
			dinero = Math.round(dinero*100); 
			dinero = dinero/100;
			introducido.setText(Float.toString(dinero) + " "); // Actualiza el indicador del dinero introducido en la interfaz, con el valor que tiene despues de sacar la ultima moneda introducida
			monedas = redimensionMenor.redimensionarArray(monedas);
			if(dinero < total) { // Comprueba si despues de sacar la moneda el dinero introducido hasta el momento es menor que el total
				falta = modelo.pagar.Falta(total, dinero); // Calcula el dinero que falta para llegar al total
				restante.setText(Float.toString(falta) + " "); // Muestra en la interfaz el dinero que falta
				this.vista.pago.btn001.setEnabled(true); // Vuelve a habilitar los botones con el dinero
				this.vista.pago.btn002.setEnabled(true);
				this.vista.pago.btn005.setEnabled(true);
				this.vista.pago.btn010.setEnabled(true);
				this.vista.pago.btn020.setEnabled(true);
				this.vista.pago.btn050.setEnabled(true);
				this.vista.pago.btn1.setEnabled(true);
				this.vista.pago.btn2.setEnabled(true);
				this.vista.pago.btn5.setEnabled(true);
				this.vista.pago.btn10.setEnabled(true);
				this.vista.pago.btn20.setEnabled(true);
				this.vista.pago.btn50.setEnabled(true);
				this.vista.pago.btn100.setEnabled(true);
				this.vista.pago.btn200.setEnabled(true);
				
				this.vista.pago.btnContinuar.setVisible(false); // Desabilita el boton de continuar y lo hace invisible
				this.vista.pago.btnContinuar.setEnabled(false);
			}
			else
				TodoIntroducido(); // Si el dinero es igual o mayor que el total, llama a esta funcion
		}
	}
	
	public void TodoIntroducido() { // Funcion que se utiliza una vez que el dinero ha llegado o sobrepasado el total
		
		introducido.setText(Float.toString(dinero) + " "); // Muestra el dinero que se ha introducido
		restante.setText("0 ");
		
		this.vista.pago.btn001.setEnabled(false);
		this.vista.pago.btn002.setEnabled(false);
		this.vista.pago.btn005.setEnabled(false);
		this.vista.pago.btn010.setEnabled(false);
		this.vista.pago.btn020.setEnabled(false);
		this.vista.pago.btn050.setEnabled(false);
		this.vista.pago.btn1.setEnabled(false);
		this.vista.pago.btn2.setEnabled(false);
		this.vista.pago.btn5.setEnabled(false);
		this.vista.pago.btn10.setEnabled(false);
		this.vista.pago.btn20.setEnabled(false);
		this.vista.pago.btn50.setEnabled(false);
		this.vista.pago.btn100.setEnabled(false);
		this.vista.pago.btn200.setEnabled(false);
		
		this.vista.pago.btnContinuar.setVisible(true);
		this.vista.pago.btnContinuar.setEnabled(true);
		
	}
	
	public void FuncionContinuar() {
		sobra = modelo.pagar.Sobra(total, dinero);
		vista.fin_pago.setVisible(true);
		vista.pago.setVisible(false);
		
		vista.fin_pago.txtTotal.setText(Float.toString(total) + " ");
		vista.fin_pago.txtPagado.setText(Float.toString(dinero) + " ");
		vista.fin_pago.txtDevolver.setText(Float.toString(sobra) + " ");
		
		// rellenar datos del cliente en el billete	
		modelo.billeteIda.setDni(modelo.cliente.getDni());
		
		// insertar billete en BBDD
		int codBilleteIda = modelo.consultas.insertarBillete(modelo.billeteIda);
		modelo.billeteIda.setCodBillete(codBilleteIda);
		
		// comprobar si existe billete de vuelta
		if (modelo.billeteVuelta != null) {
			
			// rellenar datos del cliente en el billete	
			modelo.billeteVuelta.setDni(modelo.cliente.getDni());
			
			// insertar billete en BBDD
			int codBilleteVuelta = modelo.consultas.insertarBillete(modelo.billeteVuelta);
			modelo.billeteVuelta.setCodBillete(codBilleteVuelta);
			
		}
		
	}
}