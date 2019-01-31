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

public class PanPago extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	
	JPanel pago = new JPanel();
	
	public JTable tablaDatosBillete;
	public JPanel panelTotal;
	public JButton btnContinuar, btnCancelar, btnCancelarPago, btnAtras, btnSeparador, btn200, btn100, btn50, btn20, btn10, bbtn5, btn2e, btn1e, btn050, btn020, btn010, btn005, btn002, btn001;
	public JLabel lblTitulo, lblTotal, lblDineroTotal, lblIntroducido, lblDineroIntro, lblRestante, lblDineroRest;
	
	public PanPago() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btn200 = new JButton("200 \u20AC");
		btn200.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn200.setBounds(263, 295, 83, 40);
		add(btn200);
		
		btn100 = new JButton("100 \u20AC");
		btn100.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn100.setBounds(263, 346, 83, 40);
		add(btn100);
		
		btn50 = new JButton("50 \u20AC");
		btn50.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn50.setBounds(263, 397, 83, 40);
		add(btn50);
		
		btn20 = new JButton("20 \u20AC");
		btn20.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn20.setBounds(356, 295, 78, 40);
		add(btn20);
		
		btn10 = new JButton("10 \u20AC");
		btn10.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn10.setBounds(356, 346, 83, 40);
		add(btn10);
		
		bbtn5 = new JButton("5 \u20AC");
		bbtn5.setFont(new Font("Dialog", Font.PLAIN, 18));
		bbtn5.setBounds(356, 397, 83, 40);
		add(bbtn5);
		
		btn001 = new JButton("0,01 \u20AC");
		btn001.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn001.setBounds(665, 346, 89, 40);
		add(btn001);
		
		btn002 = new JButton("0,02 \u20AC");
		btn002.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn002.setBounds(665, 295, 89, 40);
		add(btn002);
		
		btn005 = new JButton("0,05 \u20AC");
		btn005.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn005.setBounds(566, 397, 89, 40);
		add(btn005);
		
		btn010 = new JButton("0,10 \u20AC");
		btn010.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn010.setBounds(566, 346, 89, 40);
		add(btn010);
		
		btn020 = new JButton("0,20 \u20AC");
		btn020.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn020.setBounds(566, 295, 89, 40);
		add(btn020);
		
		btn050 = new JButton("0,50 \u20AC");
		btn050.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn050.setBounds(467, 397, 89, 40);
		add(btn050);
		
		btn1e = new JButton("1 \u20AC");
		btn1e.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn1e.setBounds(467, 346, 83, 40);
		add(btn1e);
		
		btn2e = new JButton("2 \u20AC");
		btn2e.setFont(new Font("Dialog", Font.PLAIN, 18));
		btn2e.setBounds(467, 295, 83, 40);
		add(btn2e);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 652, 89, 23);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 686, 89, 23);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(907, 686, 107, 23);
		add(btnContinuar);
		
		btnCancelarPago = new JButton("Cancelar Pago");
		btnCancelarPago.setBounds(10, 469, 101, 23);
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
		tablaDatosBillete.setBackground(SystemColor.menu);
		tablaDatosBillete.setBounds(20, 121, 994, 140);
		add(tablaDatosBillete);
		
		btnSeparador = new JButton("");
		btnSeparador.setEnabled(false);
		btnSeparador.setBounds(449, 295, 8, 163);
		add(btnSeparador);
		
		lblTitulo = new JLabel("SISTEMA DE PAGO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(10, 11, 1004, 72);
		add(lblTitulo);
		
		//Panel donde se muestran los datos del pago al instante: total a pagar, dinero introducido y dinero restante	
		panelTotal = new JPanel();
		panelTotal.setBackground(SystemColor.inactiveCaption);
		panelTotal.setBounds(10, 295, 243, 163);
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
