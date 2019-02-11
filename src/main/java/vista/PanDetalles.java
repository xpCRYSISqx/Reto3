package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;

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
	public JLabel lblIcono, lblTitulo;
	
	public PanDetalles() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1024, 720);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		lblTitulo = new JLabel("DETALLES DE BILLETE");
		FormatoDiseno.formatoIcono(lblTitulo);
		add(lblTitulo);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		FormatoDiseno.formatoBtnLogin(btnLogin);
		add(btnLogin);
		
		btnRegistro = new JButton("Registro");
		FormatoDiseno.formatoBtnRegistro(btnRegistro);
		add(btnRegistro);
		
		btnAtras = new JButton("Atr\u00E1s");
		FormatoDiseno.formatoBtnAtras(btnAtras);
		add(btnAtras);
		
		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar);
		
		btnContinuar = new JButton("Pagar");
		FormatoDiseno.formatoBtnContinuar(btnContinuar);
		add(btnContinuar);
		
		tablaDatos = new JTable();
		tablaDatos.setModel(new DefaultTableModel(
			new Object[][] {
				{"Autob\u00FAs", "L\u00EDnea", "Origen", "Destino", "Fecha ida", "Fecha vuelta", "C\u00F3digo billete"},
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
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaDatos.setEnabled(true);
		tablaDatos.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		tablaDatos.setBackground(new Color(204, 150, 150));
		tablaDatos.setBounds(30, 300, 964, 100);
		tablaDatos.setRowHeight(50);
		tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(35);
		tablaDatos.getColumnModel().getColumn(2).setPreferredWidth(140);
		tablaDatos.getColumnModel().getColumn(3).setPreferredWidth(140);
		tablaDatos.getColumnModel().getColumn(4).setPreferredWidth(120);
		tablaDatos.getColumnModel().getColumn(5).setPreferredWidth(120);
		tablaDatos.getColumnModel().getColumn(6).setPreferredWidth(90);
		add(tablaDatos);
	}
}
