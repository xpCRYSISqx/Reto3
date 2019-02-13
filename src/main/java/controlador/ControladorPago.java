package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.*;
import vista.*;

public class ControladorPago implements ActionListener{
	
	private MainFrame vista;
	private Modelo modelo;
	
	
	private JLabel importe, introducido, restante;
	public float total = 0;
	public float dinero = 0;
	private float falta = 0;
	private float moneda = 0;
	public String sobra = "";
	public float[] monedas; // Almacena el valor de las monedas y billetes que se van introducioendo para liego poder retarlos.
	
	public ControladorPago(MainFrame vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		
		this.importe = this.vista.pago.lblDineroTotal;
		this.introducido = this.vista.pago.lblDineroIntro;
		this.restante = this.vista.pago.lblDineroRest;
		this.monedas = new float[0];
	}
	
	public void addListeners() {
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
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		float importe;
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		
			case "0,01 €":
				importe = 0.01f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,02 €":
				importe = 0.02f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,05 €":
				importe = 0.05f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,10 €":
				importe = 0.1f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,20 €":
				importe = 0.2f;
				FuncionBotonDinero(importe);
				break;
				
			case "0,50 €":
				importe = 0.5f;
				FuncionBotonDinero(importe);
				break;
				
			case "1 €":
				importe = 1f;
				FuncionBotonDinero(importe);
				break;
				
			case "2 €":
				importe = 2f;
				FuncionBotonDinero(importe);
				break;
				
			case "5 €":
				importe = 5f;
				FuncionBotonDinero(importe);
				break;
				
			case "10 €":
				importe = 10f;
				FuncionBotonDinero(importe);
				break;
				
			case "20 €":
				importe = 20f;
				FuncionBotonDinero(importe);
				break;
				
			case "50 €":
				importe = 50f;
				FuncionBotonDinero(importe);
				break;
				
			case "100 €":
				importe = 100f;
				FuncionBotonDinero(importe);
				break;
				
			case "200 €":
				importe = 200f;
				FuncionBotonDinero(importe);
				break;
				
			case "Atrás":
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
	
	public void FuncionBotonDinero(float importe) {
		RedimensionarArrayMayor redimensionMayor = new RedimensionarArrayMayor();
		int posicion;
		this.total = this.modelo.precioTotal;
		dinero = dinero + importe;
		dinero = Math.round(dinero*100);
		dinero = dinero/100;
		monedas = redimensionMayor.redimensionarArray(monedas);
		posicion = monedas.length - 1;
		monedas[posicion] = importe;
		introducido.setText(Float.toString(dinero) + " €");
		if(dinero < total) {
			falta = modelo.pagar.Falta(total, dinero);
			restante.setText(Float.toString(falta) + " €");
		}
		else
			TodoIntroducido();
	}
	
	public void FuncionDevolver() {
		RedimensionarArrayMenor redimensionMenor = new RedimensionarArrayMenor();
		int posicion;
		if(dinero > 0) {
			posicion = monedas.length - 1;
			moneda = monedas[posicion];
			dinero = dinero - moneda;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			introducido.setText(Float.toString(dinero) + " €");
			monedas = redimensionMenor.redimensionarArray(monedas);
			if(dinero < total) {
				falta = modelo.pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
		}
	}
	
	public void TodoIntroducido() {
		
		introducido.setText(Float.toString(dinero) + " €");
		restante.setText("0 €");
		
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
		
		vista.fin_pago.txtTotal.setText(Float.toString(total) + " €");
		vista.fin_pago.txtPagado.setText(Float.toString(dinero) + " €");
		vista.fin_pago.txtDevolver.setText(sobra + " €");
		
	}
}