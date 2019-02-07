package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class PanDetalles extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTable tablaDatos;

	/**
	 * Create the panel.
	 */
	
	JPanel detalles_compra = new JPanel();
	
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JLabel lblTitulo;
	
	public PanDetalles() {
		setBackground(new Color(255, 192, 203));
		setBounds(0, 0, 1024, 720);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		btnLogin = new JButton("Inicio de Sesi\u00F3n");
		btnLogin.setBounds(880, 35, 125, 25);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(880, 71, 125, 25);
		add(btnRegistro);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 614, 100, 25);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 650, 100, 25);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(915, 650, 90, 25);
		add(btnContinuar);
		
		lblTitulo = new JLabel("DETALLES DE BILLETE");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(30, 35, 1004, 81);
		add(lblTitulo);
		
		tablaDatos = new JTable();
		tablaDatos.setEnabled(false);
		tablaDatos.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		tablaDatos.setModel(new DefaultTableModel(
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
		tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(35);
		tablaDatos.getColumnModel().getColumn(2).setPreferredWidth(140);
		tablaDatos.getColumnModel().getColumn(3).setPreferredWidth(140);
		tablaDatos.getColumnModel().getColumn(6).setPreferredWidth(90);
		tablaDatos.setBackground(new Color(220, 220, 220));
		tablaDatos.setBounds(30, 230, 964, 140);
		tablaDatos.setRowHeight(30);
		add(tablaDatos);

	}
}
