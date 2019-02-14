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

	private static final long serialVersionUID = 1L;
	
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JLabel lblIcono, lblTitulo;
	public JTable detallesIda, detallesVuelta;
	public JScrollPane scrollPaneIda, scrollPaneVuelta;
	
	public PanDetalles() {
		
		// configuracion del panel
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1024, 720);
		setBorder(UIManager.getBorder("Button.border"));
		setLayout(null);
		
		// logo
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		lblTitulo = new JLabel("DETALLES DE BILLETE");
		FormatoDiseno.formatoIcono(lblTitulo);
		add(lblTitulo);		
		
		// Tabla detalles billete ida
		detallesIda = new JTable();
		Object[][] datosIda = {};
		String[] columnNames = {"L\u00EDnea", "Origen", "Destino", "Autobus",  "Fecha", "Hora", "Precio"};
		detallesIda.setModel(new DefaultTableModel(datosIda,columnNames) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, int.class, String.class, String.class, float.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		detallesIda.setFillsViewportHeight(true);
		detallesIda.setBackground(new Color(204, 150, 150));
		detallesIda.setBounds(45, 300, 964, 100);
		detallesIda.setRowHeight(50);
		detallesIda.getColumnModel().getColumn(0).setPreferredWidth(60);
		detallesIda.getColumnModel().getColumn(1).setPreferredWidth(35);
		detallesIda.getColumnModel().getColumn(2).setPreferredWidth(140);
		detallesIda.getColumnModel().getColumn(3).setPreferredWidth(140);
		detallesIda.getColumnModel().getColumn(4).setPreferredWidth(120);
		
		scrollPaneIda = new JScrollPane(detallesIda);
		scrollPaneIda.setBounds(50,250,700,73);
		add(scrollPaneIda);
		
		
		// Tabla detalles billete vuelta
		detallesVuelta = new JTable();
		Object[][] datosVuelta = {};
		detallesVuelta.setModel(new DefaultTableModel(datosVuelta,columnNames) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, int.class, String.class, String.class, float.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		detallesVuelta.setFillsViewportHeight(true);
		detallesVuelta.setBackground(new Color(204, 150, 150));
		detallesVuelta.setBounds(45, 600, 964, 100);
		detallesVuelta.setRowHeight(50);
		detallesVuelta.getColumnModel().getColumn(0).setPreferredWidth(60);
		detallesVuelta.getColumnModel().getColumn(1).setPreferredWidth(35);
		detallesVuelta.getColumnModel().getColumn(2).setPreferredWidth(140);
		detallesVuelta.getColumnModel().getColumn(3).setPreferredWidth(140);
		detallesVuelta.getColumnModel().getColumn(4).setPreferredWidth(120);
		
		scrollPaneVuelta = new JScrollPane(detallesVuelta);
		scrollPaneVuelta.setBounds(50,400,700,73);
		add(scrollPaneVuelta);
		
		/*
		 * Botones
		 */
		
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

	}
}
