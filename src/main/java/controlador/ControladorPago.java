package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import modelo.*;
import vista.*;

public class ControladorPago implements ActionListener{
	
	private MainFrame vista;
	private Billete billete;
	private Pagar pagar;
	private JLabel importe, introducido, restante;
	private JButton unCent, dosCent, cincoCent, diezCent, veinteCent, cincuentaCent, unEur, dosEur, cincoEur, diezEur, veinteEur, cincuentaEur, cienEur, doscientosEur, continuar, cancelar, devolver;
	public float total = 0;
	public float dinero = 0;
	private float falta = 0;
	private float moneda = 0;
	public String sobra = "";
	public float[] monedas; // Almacena el valor de las monedas y billetes que se van introducioendo para liego poder retarlos.
	
	public ControladorPago(MainFrame vista, Billete billete, Pagar pagar) {
		this.vista = vista;
		this.billete = billete;
		this.importe = this.vista.pago.lblDineroTotal;
		this.introducido = this.vista.pago.lblDineroIntro;
		this.restante = this.vista.pago.lblDineroRest;
		this.unCent = this.vista.pago.btn001;
		this.dosCent = this.vista.pago.btn002;
		this.cincoCent = this.vista.pago.btn005;
		this.diezCent = this.vista.pago.btn010;
		this.veinteCent = this.vista.pago.btn020;
		this.cincuentaCent = this.vista.pago.btn050;
		this.unEur = this.vista.pago.btn1;
		this.dosEur = this.vista.pago.btn2;
		this.cincoEur = this.vista.pago.btn5;
		this.diezEur = this.vista.pago.btn10;
		this.veinteEur = this.vista.pago.btn20;
		this.cincuentaEur = this.vista.pago.btn50;
		this.cienEur = this.vista.pago.btn100;
		this.doscientosEur = this.vista.pago.btn200;
		this.continuar = this.vista.pago.btnContinuar;
		this.cancelar = this.vista.pago.btnCancelar;
		this.devolver = this.vista.pago.btnCancelarPago;
		this.pagar = pagar;
		//this.total = this.billete.getPrecio();
		this.total = 400;
		this.importe.setText(Float.toString(total) + " €");
		this.monedas = new float[0];
	}
	
	public void addListeners() {
		unCent.addActionListener(this);
		dosCent.addActionListener(this);
		cincoCent.addActionListener(this);
		diezCent.addActionListener(this);
		veinteCent.addActionListener(this);
		cincuentaCent.addActionListener(this);
		unEur.addActionListener(this);
		dosEur.addActionListener(this);
		cincoEur.addActionListener(this);
		diezEur.addActionListener(this);
		veinteEur.addActionListener(this);
		cincuentaEur.addActionListener(this);
		cienEur.addActionListener(this);
		doscientosEur.addActionListener(this);
		devolver.addActionListener(this);
		continuar.addActionListener(this);
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
		
		dinero = dinero + importe;
		dinero = Math.round(dinero*100);
		dinero = dinero/100;
		monedas = redimensionMayor.redimensionarArray(monedas);
		posicion = monedas.length - 1;
		monedas[posicion] = importe;
		introducido.setText(Float.toString(dinero) + " €");
		if(dinero < total) {
			falta = pagar.Falta(total, dinero);
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
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
		}
		else {}
	}
	
	public void TodoIntroducido() {
		introducido.setText(Float.toString(dinero) + " €");
		restante.setText("");
		unCent.setEnabled(false);
		dosCent.setEnabled(false);
		cincoCent.setEnabled(false);
		diezCent.setEnabled(false);
		veinteCent.setEnabled(false);
		cincuentaCent.setEnabled(false);
		unEur.setEnabled(false);
		dosEur.setEnabled(false);
		cincoEur.setEnabled(false);
		diezEur.setEnabled(false);
		veinteEur.setEnabled(false);
		cincuentaEur.setEnabled(false);
		cienEur.setEnabled(false);
		doscientosEur.setEnabled(false);
		continuar.setVisible(true);
		continuar.setEnabled(true);
	}
	
	public void FuncionContinuar() {
		sobra = pagar.Sobra(total, dinero);
		
	}
}