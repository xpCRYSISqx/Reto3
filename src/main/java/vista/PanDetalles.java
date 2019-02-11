package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.BorderLayout;
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

	/**
	 * Create the panel.
	 */
	
	JPanel detalles_compra = new JPanel();
	
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JLabel lblIcono, lblTitulo;
	private JTable table;
	private JScrollPane scrollPane;
	
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
			
		
		
		String[] columnNames = {
			"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"
        };
		
		Object[][] data = {
		    {"Kathy", "Smith", "Snowboarding", new Integer(5), new Boolean(false)},
		};
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(data,columnNames) {
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
		
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(204, 150, 150));
		table.setBounds(30, 300, 964, 100);
		table.setRowHeight(50);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
//		table.getColumnModel().getColumn(5).setPreferredWidth(120);
//		table.getColumnModel().getColumn(6).setPreferredWidth(90);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50,200,700,73);
		add(scrollPane);

	}
}
