package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class PanDetalles extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public JButton btnLogin,btnRegistro,btnContinuar,btnAtras,btnCancelar;
	public JLabel lblIcono, lblTitulo, lblBilleteIda, lblBilleteVuelta;
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
		
		// label billete ida
		lblBilleteIda = new JLabel("Datos billete ida:");
		lblBilleteIda.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblBilleteIda.setHorizontalAlignment(SwingConstants.LEFT);
		lblBilleteIda.setBounds(45, 210, 300, 40);
		add(lblBilleteIda);
		
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
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		detallesIda.setDefaultRenderer(String.class, centerRenderer);
		detallesIda.setDefaultRenderer(int.class, centerRenderer);
		detallesIda.setDefaultRenderer(float.class, centerRenderer);
		detallesIda.setFillsViewportHeight(true);
		detallesIda.setBackground(new Color(204, 150, 150));
		detallesIda.setBounds(45, 300, 934, 100);
		detallesIda.setRowHeight(50);
		detallesIda.setFocusable(false);
		detallesIda.setRowSelectionAllowed(false);
		detallesIda.getColumnModel().getColumn(0).setPreferredWidth(180);
		detallesIda.getColumnModel().getColumn(1).setPreferredWidth(180);
		detallesIda.getColumnModel().getColumn(2).setPreferredWidth(180);
		detallesIda.getColumnModel().getColumn(3).setPreferredWidth(120);
		detallesIda.getColumnModel().getColumn(4).setPreferredWidth(150);
		detallesIda.getColumnModel().getColumn(5).setPreferredWidth(120);
		detallesIda.getColumnModel().getColumn(6).setPreferredWidth(120);
		
		scrollPaneIda = new JScrollPane(detallesIda);
		scrollPaneIda.setBounds(45,250,934,73);
		add(scrollPaneIda);
		
		// label billete ida
		lblBilleteVuelta = new JLabel("Datos billete vuelta:");
		lblBilleteVuelta.setFont(new Font("Agency FB", Font.BOLD, 22));
		lblBilleteVuelta.setHorizontalAlignment(SwingConstants.LEFT);
		lblBilleteVuelta.setBounds(45, 360, 300, 40);
		add(lblBilleteVuelta);
				
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
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		});
		

		detallesVuelta.setDefaultRenderer(String.class, centerRenderer);
		detallesVuelta.setDefaultRenderer(int.class, centerRenderer);
		detallesVuelta.setDefaultRenderer(float.class, centerRenderer);
		detallesVuelta.setFillsViewportHeight(true);
		detallesVuelta.setBackground(new Color(204, 150, 150));
		detallesVuelta.setBounds(45, 600, 934, 100);
		detallesVuelta.setRowHeight(50);
		detallesVuelta.setFocusable(false);
		detallesVuelta.setRowSelectionAllowed(false);
		detallesVuelta.setCellSelectionEnabled(false);
		detallesVuelta.getColumnModel().getColumn(0).setPreferredWidth(180);
		detallesVuelta.getColumnModel().getColumn(1).setPreferredWidth(180);
		detallesVuelta.getColumnModel().getColumn(2).setPreferredWidth(180);
		detallesVuelta.getColumnModel().getColumn(3).setPreferredWidth(120);
		detallesVuelta.getColumnModel().getColumn(4).setPreferredWidth(150);
		detallesVuelta.getColumnModel().getColumn(5).setPreferredWidth(120);
		detallesVuelta.getColumnModel().getColumn(6).setPreferredWidth(120);
		
		scrollPaneVuelta = new JScrollPane(detallesVuelta);
		scrollPaneVuelta.setBounds(45,400,934,73);
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
