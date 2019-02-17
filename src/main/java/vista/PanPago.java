package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PanPago extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JTable tablaDatosBillete;
	public JPanel panelTotales;
	public JButton btnContinuar, btnCancelar, btnCancelarPago, btnAtras, btnSeparador, btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn050, btn020, btn010, btn005, btn002, btn001;
	public JLabel lblIcono, lblTotal, lblDineroTotal, lblIntroducido, lblDineroIntro, lblRestante, lblDineroRest;
	
	public PanPago() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// logo
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		/*
		 * Botones monedas y billetes
		 */
		btn200 = new JButton("200 \u20AC");
		FormatoDiseno.formatoBtn(btn200);
		btn200.setBounds(450, 250, 85, 40);
		add(btn200);
		
		btn100 = new JButton("100 \u20AC");
		FormatoDiseno.formatoBtn(btn100);
		btn100.setBounds(450, 300, 85, 40);
		add(btn100);
		
		btn50 = new JButton("50 \u20AC");
		FormatoDiseno.formatoBtn(btn50);
		btn50.setBounds(450, 350, 83, 40);
		add(btn50);
		
		btn20 = new JButton("20 \u20AC");
		FormatoDiseno.formatoBtn(btn20);
		btn20.setBounds(545, 250, 85, 40);
		add(btn20);
		
		btn10 = new JButton("10 \u20AC");
		FormatoDiseno.formatoBtn(btn10);
		btn10.setBounds(545, 300, 85, 40);
		add(btn10);
		
		btn5 = new JButton("5 \u20AC");
		FormatoDiseno.formatoBtn(btn5);
		btn5.setBounds(545, 350, 85, 40);
		add(btn5);
		
		btn2 = new JButton("2 \u20AC");
		FormatoDiseno.formatoBtn(btn2);
		btn2.setBounds(658, 250, 85, 40);
		add(btn2);
		
		btn1 = new JButton("1 \u20AC");
		FormatoDiseno.formatoBtn(btn1);
		btn1.setBounds(658, 300, 85, 40);
		add(btn1);
		
		btn050 = new JButton("0,50 \u20AC");
		FormatoDiseno.formatoBtn(btn050);
		btn050.setBounds(658, 350, 85, 40);
		add(btn050);
		
		btn020 = new JButton("0,20 \u20AC");
		FormatoDiseno.formatoBtn(btn020);
		btn020.setBounds(753, 250, 85, 40);
		add(btn020);
		
		btn010 = new JButton("0,10 \u20AC");
		FormatoDiseno.formatoBtn(btn010);
		btn010.setBounds(753, 300, 85, 40);
		add(btn010);
		
		btn005 = new JButton("0,05 \u20AC");
		FormatoDiseno.formatoBtn(btn005);
		btn005.setBounds(753, 350, 85, 40);
		add(btn005);
		
		btn002 = new JButton("0,02 \u20AC");
		FormatoDiseno.formatoBtn(btn002);
		btn002.setBounds(848, 250, 85, 40);
		add(btn002);
		
		btn001 = new JButton("0,01 \u20AC");
		FormatoDiseno.formatoBtn(btn001);
		btn001.setBounds(848, 300, 85, 40);
		add(btn001);
		
		// separador
		btnSeparador = new JButton("");
		btnSeparador.setEnabled(false);
		btnSeparador.setBounds(640, 250, 5, 140);
		add(btnSeparador);
		
		/*
		 * Botones
		 */
		
		btnCancelarPago = new JButton("Devolver");
		FormatoDiseno.formatoBtnCancelarPago(btnCancelarPago);
		add(btnCancelarPago);
		
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		btnContinuar.setEnabled(false);
		btnContinuar.setVisible(false);
		
		// Panel donde se muestran los datos del pago al instante:
		// total a pagar, dinero introducido y dinero restante	
		panelTotales = new JPanel();
		panelTotales.setBackground(Color.GRAY);
		panelTotales.setBounds(45, 250, 290, 200);
		add(panelTotales);
		panelTotales.setLayout(null);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTotal.setBounds(20, 20, 100, 32);
		panelTotales.add(lblTotal);
		
		lblDineroTotal = new JLabel("0 \u20AC");
		lblDineroTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroTotal.setBounds(130, 20, 120, 32);
		panelTotales.add(lblDineroTotal);
		
		lblIntroducido = new JLabel("Introducido");
		lblIntroducido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIntroducido.setBounds(20, 75, 100, 32);
		panelTotales.add(lblIntroducido);
		
		lblDineroIntro = new JLabel("0 \u20AC");
		lblDineroIntro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroIntro.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroIntro.setBounds(130, 75, 120, 32);
		panelTotales.add(lblDineroIntro);
		
		lblRestante = new JLabel("Restante");
		lblRestante.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRestante.setBounds(20, 135, 101, 32);
		panelTotales.add(lblRestante);
		
		lblDineroRest = new JLabel("0 \u20AC");
		lblDineroRest.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroRest.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroRest.setBounds(130, 135, 121, 32);
		panelTotales.add(lblDineroRest);

	}
}
