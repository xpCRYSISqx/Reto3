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
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanPago() {
		setLayout(null);
		
		JButton button = new JButton("200 \u20AC");
		button.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button.setBounds(263, 295, 83, 40);
		add(button);
		
		JButton button_1 = new JButton("100 \u20AC");
		button_1.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_1.setBounds(263, 346, 83, 40);
		add(button_1);
		
		JButton button_2 = new JButton("50 \u20AC");
		button_2.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_2.setBounds(263, 397, 83, 40);
		add(button_2);
		
		JButton button_3 = new JButton("20 \u20AC");
		button_3.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_3.setBounds(356, 295, 78, 40);
		add(button_3);
		
		JButton button_4 = new JButton("10 \u20AC");
		button_4.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_4.setBounds(356, 346, 83, 40);
		add(button_4);
		
		JButton button_5 = new JButton("5 \u20AC");
		button_5.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_5.setBounds(356, 397, 83, 40);
		add(button_5);
		
		JButton button_6 = new JButton("0,01 \u20AC");
		button_6.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_6.setBounds(665, 346, 89, 40);
		add(button_6);
		
		JButton button_7 = new JButton("0,02 \u20AC");
		button_7.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_7.setBounds(665, 295, 89, 40);
		add(button_7);
		
		JButton button_8 = new JButton("0,05 \u20AC");
		button_8.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_8.setBounds(566, 397, 89, 40);
		add(button_8);
		
		JButton button_9 = new JButton("0,10 \u20AC");
		button_9.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_9.setBounds(566, 346, 89, 40);
		add(button_9);
		
		JButton button_10 = new JButton("0,20 \u20AC");
		button_10.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_10.setBounds(566, 295, 89, 40);
		add(button_10);
		
		JButton button_11 = new JButton("0,50 \u20AC");
		button_11.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_11.setBounds(467, 397, 89, 40);
		add(button_11);
		
		JButton button_12 = new JButton("1 \u20AC");
		button_12.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_12.setBounds(467, 346, 83, 40);
		add(button_12);
		
		JButton button_13 = new JButton("2 \u20AC");
		button_13.setFont(new Font("Agency FB", Font.PLAIN, 30));
		button_13.setBounds(467, 295, 83, 40);
		add(button_13);
		
		JButton button_14 = new JButton("Atr\u00E1s");
		button_14.setBounds(10, 587, 89, 23);
		add(button_14);
		
		JButton button_15 = new JButton("Cancelar");
		button_15.setBounds(10, 614, 89, 23);
		add(button_15);
		
		JButton button_16 = new JButton("Continuar");
		button_16.setBounds(669, 614, 107, 23);
		add(button_16);
		
		JButton btnCancelarPago = new JButton("Cancelar Pago");
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
		table.setRowHeight(1, 30);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.setBackground(SystemColor.menu);
		table.setBounds(20, 121, 756, 140);
		add(table);
		
		JButton button_17 = new JButton("");
		button_17.setEnabled(false);
		button_17.setBounds(449, 295, 8, 163);
		add(button_17);
		
		JLabel lblSistemaDePago = new JLabel("SISTEMA DE PAGO");
		lblSistemaDePago.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDePago.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblSistemaDePago.setBounds(10, 11, 737, 72);
		add(lblSistemaDePago);
		
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
