package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;

public class PanPago extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	
	public JTable tablaDatosBillete;
	public JPanel panelTotales;
	public JButton btnContinuar, btnCancelar, btnCancelarPago, btnAtras, btnSeparador, btn200, btn100, btn50, btn20, btn10, btn5, btn2, btn1, btn050, btn020, btn010, btn005, btn002, btn001;
	public JLabel lblIcono, lblTotal, lblDineroTotal, lblIntroducido, lblDineroIntro, lblRestante, lblDineroRest;
	
	public PanPago() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
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
		
		btn200 = new JButton("200 \u20AC");
		FormatoDiseno.formatoBtn(btn200);
		btn200.setBounds(523, 320, 85, 40);
		add(btn200);
		
		btn100 = new JButton("100 \u20AC");
		FormatoDiseno.formatoBtn(btn100);
		btn100.setBounds(523, 370, 85, 40);
		add(btn100);
		
		btn50 = new JButton("50 \u20AC");
		FormatoDiseno.formatoBtn(btn50);
		btn50.setBounds(523, 420, 83, 40);
		add(btn50);
		
		btn20 = new JButton("20 \u20AC");
		FormatoDiseno.formatoBtn(btn20);
		btn20.setBounds(616, 320, 85, 40);
		add(btn20);
		
		btn10 = new JButton("10 \u20AC");
		FormatoDiseno.formatoBtn(btn10);
		btn10.setBounds(616, 370, 85, 40);
		add(btn10);
		
		btn5 = new JButton("5 \u20AC");
		FormatoDiseno.formatoBtn(btn5);
		btn5.setBounds(616, 420, 85, 40);
		add(btn5);
		
		btn2 = new JButton("2 \u20AC");
		FormatoDiseno.formatoBtn(btn2);
		btn2.setBounds(727, 320, 85, 40);
		add(btn2);
		
		btn1 = new JButton("1 \u20AC");
		FormatoDiseno.formatoBtn(btn1);
		btn1.setBounds(727, 370, 85, 40);
		add(btn1);
		
		btn050 = new JButton("0,50 \u20AC");
		FormatoDiseno.formatoBtn(btn050);
		btn050.setBounds(727, 420, 85, 40);
		add(btn050);
		
		btn020 = new JButton("0,20 \u20AC");
		FormatoDiseno.formatoBtn(btn020);
		btn020.setBounds(826, 320, 85, 40);
		add(btn020);
		
		btn010 = new JButton("0,10 \u20AC");
		FormatoDiseno.formatoBtn(btn010);
		btn010.setBounds(826, 370, 85, 40);
		add(btn010);
		
		btn005 = new JButton("0,05 \u20AC");
		FormatoDiseno.formatoBtn(btn005);
		btn005.setBounds(826, 420, 85, 40);
		add(btn005);
		
		btn002 = new JButton("0,02 \u20AC");
		FormatoDiseno.formatoBtn(btn002);
		btn002.setBounds(925, 320, 85, 40);
		add(btn002);
		
		btn001 = new JButton("0,01 \u20AC");
		FormatoDiseno.formatoBtn(btn001);
		btn001.setBounds(925, 370, 85, 40);
		add(btn001);
		
		btnCancelarPago = new JButton("Devolver");
		FormatoDiseno.formatoBtnCancelarPago(btnCancelarPago);
		add(btnCancelarPago);
		
		tablaDatosBillete = new JTable();
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
		tablaDatosBillete.setEnabled(false);
		tablaDatosBillete.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		tablaDatosBillete.setBackground(new Color(204, 150, 150));
		tablaDatosBillete.setBounds(30, 200, 984, 100);
		tablaDatosBillete.setRowHeight(50);
		tablaDatosBillete.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablaDatosBillete.getColumnModel().getColumn(1).setPreferredWidth(35);
		tablaDatosBillete.getColumnModel().getColumn(2).setPreferredWidth(140);
		tablaDatosBillete.getColumnModel().getColumn(3).setPreferredWidth(140);
		tablaDatosBillete.getColumnModel().getColumn(4).setPreferredWidth(120);
		tablaDatosBillete.getColumnModel().getColumn(5).setPreferredWidth(120);
		tablaDatosBillete.getColumnModel().getColumn(6).setPreferredWidth(90);
		add(tablaDatosBillete);
		
		btnSeparador = new JButton("");
		btnSeparador.setEnabled(false);
		btnSeparador.setBounds(709, 320, 8, 163);
		add(btnSeparador);
		
		//Panel donde se muestran los datos del pago al instante: total a pagar, dinero introducido y dinero restante	
		panelTotales = new JPanel();
		panelTotales.setBackground(Color.GRAY);
		panelTotales.setBounds(30, 320, 291, 163);
		add(panelTotales);
		panelTotales.setLayout(null);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTotal.setBounds(10, 11, 101, 32);
		panelTotales.add(lblTotal);
		
		lblDineroTotal = new JLabel("0 \u20AC");
		lblDineroTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroTotal.setBounds(108, 11, 121, 32);
		panelTotales.add(lblDineroTotal);
		
		lblIntroducido = new JLabel("Introducido");
		lblIntroducido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblIntroducido.setBounds(10, 66, 101, 32);
		panelTotales.add(lblIntroducido);
		
		lblDineroIntro = new JLabel("0 \u20AC");
		lblDineroIntro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroIntro.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroIntro.setBounds(108, 66, 121, 32);
		panelTotales.add(lblDineroIntro);
		
		lblRestante = new JLabel("Restante");
		lblRestante.setFont(new Font("Arial", Font.PLAIN, 20));
		lblRestante.setBounds(10, 126, 101, 32);
		panelTotales.add(lblRestante);
		
		lblDineroRest = new JLabel("0 \u20AC");
		lblDineroRest.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDineroRest.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDineroRest.setBounds(108, 126, 121, 32);
		panelTotales.add(lblDineroRest);

	}
}
