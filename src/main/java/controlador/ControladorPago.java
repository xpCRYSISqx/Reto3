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
	private float[] monedas; // Almacena el valor de las monedas y billetes que se van introducioendo para liego poder retarlos.
	
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
		this.total = this.billete.getPrecio();
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
	}
	
	public void actionPerformed(ActionEvent e) {
		
		// guardamos el nombre del boton pulsado
		String botonPulsado = ((JButton) e.getSource()).getActionCommand();
		RedimensionarArrayMayor redimensionMayor = new RedimensionarArrayMayor();
		RedimensionarArrayMenor redimensionMenor = new RedimensionarArrayMenor();
		int posicion;
		
		// comprobamos que boton se ha pulsado y ejecutamos sus acciones
		switch (botonPulsado) {
		case "0,01 €":
			dinero = dinero + 0.01f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 0.01f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "0,02 €":
			dinero = dinero + 0.02f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 0.02f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "0,05 €":
			dinero = dinero + 0.05f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 0.05f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "0,10 €":
			dinero = dinero + 0.1f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 0.1f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "0,20 €":
			dinero = dinero + 0.2f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 0.2f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "0,50 €":
			dinero = dinero + 0.5f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 0.5f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "1 €":
			dinero = dinero + 1f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 1f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "2 €":
			dinero = dinero + 2f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 2f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "5 €":
			dinero = dinero + 5f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 5f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "10 €":
			dinero = dinero + 10f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 10f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "20 €":
			dinero = dinero + 20f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 20f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "50 €":
			dinero = dinero + 50f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 50f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "100 €":
			dinero = dinero + 100f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 100f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "200 €":
			dinero = dinero + 200f;
			dinero = Math.round(dinero*100);
			dinero = dinero/100;
			monedas = redimensionMayor.redimensionarArray(monedas);
			posicion = monedas.length - 1;
			monedas[posicion] = 200f;
			introducido.setText(Float.toString(dinero) + " €");
			if(dinero < total) {
				falta = pagar.Falta(total, dinero);
				restante.setText(Float.toString(falta) + " €");
			}
			else
				TodoIntroducido();
			break;
		case "Devolver":
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
		
	}
	
	public void TodoIntroducido() {
		sobra = pagar.Sobra(total, dinero);
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
}