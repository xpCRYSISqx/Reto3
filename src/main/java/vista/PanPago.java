package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanPago extends JPanel {
	
	/**
	 * Create the panel.
	 */
	
	JPanel pago = new JPanel();
	
	
	public JButton btnContinuar, btnCancelar, btnCancelarPago, btnSeparador, btn200, btn100, btn50, btn20, btn10, bbtn5, btn2, btn1, btn050, btn020, btn010, btn005, btn002, btn001;
	public JTable table;
	public JLabel lblTitulo;
	
	
	public PanPago() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		btn200 = new JButton("200 \u20AC");
		btn200.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn200.setBounds(263, 295, 83, 40);
		add(btn200);
		
		btn100 = new JButton("100 \u20AC");
		btn100.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn100.setBounds(263, 346, 83, 40);
		add(btn100);
		
		btn50 = new JButton("50 \u20AC");
		btn50.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn50.setBounds(263, 397, 83, 40);
		add(btn50);
		
		btn20 = new JButton("20 \u20AC");
		btn20.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn20.setBounds(356, 295, 78, 40);
		add(btn20);
		
		btn10 = new JButton("10 \u20AC");
		btn10.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn10.setBounds(356, 346, 83, 40);
		add(btn10);
		
		bbtn5 = new JButton("5 \u20AC");
		bbtn5.setFont(new Font("Agency FB", Font.PLAIN, 30));
		bbtn5.setBounds(356, 397, 83, 40);
		add(bbtn5);
		
		btn001 = new JButton("0,01 \u20AC");
		btn001.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn001.setBounds(665, 346, 89, 40);
		add(btn001);
		
		btn002 = new JButton("0,02 \u20AC");
		btn002.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn002.setBounds(665, 295, 89, 40);
		add(btn002);
		
		btn005 = new JButton("0,05 \u20AC");
		btn005.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn005.setBounds(566, 397, 89, 40);
		add(btn005);
		
		btn010 = new JButton("0,10 \u20AC");
		btn010.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn010.setBounds(566, 346, 89, 40);
		add(btn010);
		
		btn020 = new JButton("0,20 \u20AC");
		btn020.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn020.setBounds(566, 295, 89, 40);
		add(btn020);
		
		btn050 = new JButton("0,50 \u20AC");
		btn050.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn050.setBounds(467, 397, 89, 40);
		add(btn050);
		
		btn1 = new JButton("1 \u20AC");
		btn1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn1.setBounds(467, 346, 83, 40);
		add(btn1);
		
		btn2 = new JButton("2 \u20AC");
		btn2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		btn2.setBounds(467, 295, 83, 40);
		add(btn2);
		
		JButton button_14 = new JButton("Atr\u00E1s");
		button_14.setBounds(10, 652, 89, 23);
		add(button_14);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 686, 89, 23);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(907, 686, 107, 23);
		add(btnContinuar);
		
		btnCancelarPago = new JButton("Cancelar Pago");
		btnCancelarPago.setBounds(10, 469, 101, 23);
		add(btnCancelarPago);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Autob\u00FAs", "L\u00EDnea", "Origen", "Destino", "Fecha ida", "Fecha vuelta", "C\u00F3digo billete"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setRowHeight(50, 30);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.setBackground(SystemColor.menu);
		table.setBounds(20, 121, 994, 140);
		add(table);
		
		btnSeparador = new JButton("");
		button_17.setEnabled(false);
		button_17.setBounds(449, 295, 8, 163);
		add(button_17);
		
		lblTitulo = new JLabel("SISTEMA DE PAGO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(10, 11, 1004, 72);
		add(lblTitulo);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 295, 243, 163);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Total");
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(10, 11, 101, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Introducido");
		label_1.setFont(new Font("Arial", Font.PLAIN, 20));
		label_1.setBounds(10, 66, 101, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Restante");
		label_2.setFont(new Font("Arial", Font.PLAIN, 20));
		label_2.setBounds(10, 126, 101, 32);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("0 \u20AC");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Arial", Font.PLAIN, 20));
		label_3.setBounds(108, 11, 121, 32);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("0 \u20AC");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Arial", Font.PLAIN, 20));
		label_4.setBounds(108, 66, 121, 32);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("0 \u20AC");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Arial", Font.PLAIN, 20));
		label_5.setBounds(108, 126, 121, 32);
		panel.add(label_5);

	}
}
