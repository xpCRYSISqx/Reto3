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
		setBounds(0, 0, 1024, 720);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		btnAtras = new JButton("Atr\u00E1s");
		btnAtras.setBounds(10, 673, 89, 23);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 697, 89, 23);
		add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(907, 686, 107, 23);
		add(btnContinuar);
		
		btnLogin = new JButton("Inicio de Sesi\u00F3n");
		btnLogin.setBounds(907, 11, 107, 23);
		add(btnLogin);
		
		btnRegistro = new JButton("Registrar");
		btnRegistro.setBounds(907, 45, 107, 23);
		add(btnRegistro);
		
		lblTitulo = new JLabel("DETALLES DE BILLETE");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(10, 11, 780, 69);
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
		tablaDatos.setBackground(SystemColor.inactiveCaption);
		tablaDatos.setBounds(94, 230, 591, 140);
		add(tablaDatos);

	}
}
