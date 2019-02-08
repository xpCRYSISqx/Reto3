package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanPago extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	
	JPanel pago = new JPanel();
	
	public JTable tablaDatosBillete;
	public JPanel panelTotal;
	public JButton btnContinuar, btnCancelar, btnCancelarPago, btnAtras, btnSeparador, btn200, btn100, btn50, btn20, btn10, bbtn5, btn2e, btn1e, btn050, btn020, btn010, btn005, btn002, btn001;
	public JLabel lblIcono, lblTotal, lblDineroTotal, lblIntroducido, lblDineroIntro, lblRestante, lblDineroRest;
	
	public PanPago() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblIcono = new JLabel("SISTEMA DE PAGO");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		btnAtras = new JButton("Atr\u00E1s");
<<<<<<< HEAD
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			} 
		});
		btnAtras.setBounds(10, 614, 100, 25);
=======
		FormatoDiseno.formatoBtnAtras(btnAtras);
>>>>>>> 3ad83dc2c05a89bac86314624166b71eeb1f4be5
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		
		btn200 = new JButton("200 \u20AC");
		FormatoDiseno.formatoBtn(btn200);
		btn200.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn200.setBounds(523, 295, 83, 40);
		add(btn200);
		
		btn100 = new JButton("100 \u20AC");
		FormatoDiseno.formatoBtn(btn100);
		btn100.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn100.setBounds(523, 346, 83, 40);
		add(btn100);
		
		btn50 = new JButton("50 \u20AC");
		FormatoDiseno.formatoBtn(btn50);
		btn50.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn50.setBounds(523, 397, 83, 40);
		add(btn50);
		
		btn20 = new JButton("20 \u20AC");
		btn20.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn20.setBounds(616, 295, 78, 40);
		btn20.setBorder(null);
		btn20.setForeground(new Color(255, 255, 255));
		btn20.setBackground(new Color(204, 0, 0));
		add(btn20);
		
		btn10 = new JButton("10 \u20AC");
		btn10.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn10.setBounds(616, 346, 83, 40);
		btn10.setBorder(null);
		btn10.setForeground(new Color(255, 255, 255));
		btn10.setBackground(new Color(204, 0, 0));
		add(btn10);
		
		bbtn5 = new JButton("5 \u20AC");
		bbtn5.setFont(new Font("Dialog", Font.PLAIN, 18));
		bbtn5.setBounds(616, 397, 83, 40);
		FormatoDiseno.formatoBtn(bbtn5);
		add(bbtn5);
		
		btn001 = new JButton("0,01 \u20AC");
		btn001.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn001.setBounds(925, 346, 89, 40);
		add(btn001);
		
		btn002 = new JButton("0,02 \u20AC");
		btn002.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn002.setBounds(925, 295, 89, 40);
		add(btn002);
		
		btn005 = new JButton("0,05 \u20AC");
		btn005.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn005.setBounds(826, 397, 89, 40);
		add(btn005);
		
		btn010 = new JButton("0,10 \u20AC");
		btn010.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn010.setBounds(826, 346, 89, 40);
		add(btn010);
		
		btn020 = new JButton("0,20 \u20AC");
		btn020.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn020.setBounds(826, 295, 89, 40);
		add(btn020);
		
		btn050 = new JButton("0,50 \u20AC");
		btn050.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn050.setBounds(727, 397, 89, 40);
		add(btn050);
		
		btn1e = new JButton("1 \u20AC");
		btn1e.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn1e.setBounds(727, 346, 83, 40);
		add(btn1e);
		
		btn2e = new JButton("2 \u20AC");
		btn2e.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn2e.setBounds(727, 295, 83, 40);
		add(btn2e);
		
		btnCancelarPago = new JButton("Cancelar Pago");
		btnCancelarPago.setBounds(64, 469, 120, 30);
		add(btnCancelarPago);
		
		tablaDatosBillete = new JTable();
		tablaDatosBillete.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaDatosBillete.setEnabled(false);
		tablaDatosBillete.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Autob\u00FAs", "L\u00EDnea", "Origen", "Destino", "Fecha ida", "Fecha vuelta", "C\u00F3digo billete"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, String.class, String.class, Object.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaDatosBillete.setRowHeight(50, 30);
		tablaDatosBillete.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablaDatosBillete.getColumnModel().getColumn(1).setPreferredWidth(35);
		tablaDatosBillete.getColumnModel().getColumn(2).setPreferredWidth(140);
		tablaDatosBillete.getColumnModel().getColumn(3).setPreferredWidth(140);
		tablaDatosBillete.getColumnModel().getColumn(6).setPreferredWidth(90);
		tablaDatosBillete.setBackground(new Color(220, 220, 220));
		tablaDatosBillete.setBounds(20, 121, 994, 140);
		tablaDatosBillete.setRowHeight(30);
		add(tablaDatosBillete);
		
		btnSeparador = new JButton("");
		btnSeparador.setEnabled(false);
		btnSeparador.setBounds(709, 295, 8, 163);
		add(btnSeparador);
		
		//Panel donde se muestran los datos del pago al instante: total a pagar, dinero introducido y dinero restante	
		panelTotal = new JPanel();
		panelTotal.setBackground(new Color(220, 220, 220));
		panelTotal.setBounds(64, 295, 291, 163);
		add(panelTotal);
		panelTotal.setLayout(null);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTotal.setBounds(10, 11, 101, 32);
		panelTotal.add(lblTotal);
		
		lblDineroTotal = new JLabel("0 \u20AC");
		lblDineroTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroTotal.setBounds(108, 11, 121, 32);
		panelTotal.add(lblDineroTotal);
		
		lblIntroducido = new JLabel("Introducido");
		lblIntroducido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIntroducido.setBounds(10, 66, 101, 32);
		panelTotal.add(lblIntroducido);
		
		lblDineroIntro = new JLabel("0 \u20AC");
		lblDineroIntro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroIntro.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroIntro.setBounds(108, 66, 121, 32);
		panelTotal.add(lblDineroIntro);
		
		lblRestante = new JLabel("Restante");
		lblRestante.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRestante.setBounds(10, 126, 101, 32);
		panelTotal.add(lblRestante);
		
		lblDineroRest = new JLabel("0 \u20AC");
		lblDineroRest.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroRest.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroRest.setBounds(108, 126, 121, 32);
		panelTotal.add(lblDineroRest);

	}
}
