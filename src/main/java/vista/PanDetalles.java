package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class PanDetalles extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	JPanel detalles_compra = new JPanel();
	public JButton btnContinuar;
	
	public PanDetalles() {
		setBounds(0, 0, 1024, 720);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		JButton button = new JButton("Atr\u00E1s");
		button.setBounds(10, 542, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Cancelar");
		button_1.setBounds(10, 566, 89, 23);
		add(button_1);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(683, 566, 107, 23);
		add(btnContinuar);
		
		JButton button_3 = new JButton("Inicio de Sesi\u00F3n");
		button_3.setBounds(683, 11, 107, 23);
		add(button_3);
		
		JButton button_4 = new JButton("Registrar");
		button_4.setBounds(683, 45, 107, 23);
		add(button_4);
		
		JLabel lblDetallesDe = new JLabel("DETALLES DE BILLETE");
		lblDetallesDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetallesDe.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblDetallesDe.setBounds(10, 11, 780, 69);
		add(lblDetallesDe);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
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
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		table.setBackground(SystemColor.inactiveCaption);
		table.setBounds(94, 230, 591, 140);
		add(table);

	}
}
