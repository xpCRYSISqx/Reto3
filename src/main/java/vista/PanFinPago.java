package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanFinPago extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the panel.
	 */
	
	public JLabel lblIcono,lblTitulo,lblTotal,lblPagado,lblADevolver,lblImprimir;
	public JButton btnImprimir,btnSeparador;
	public JTextField txtTotal,txtPagado,txtDevolver;
	
	public PanFinPago() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		lblTitulo = new JLabel("¡Gracias por su compra!");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Agency FB", Font.BOLD, 44));
		lblTitulo.setBounds(10, 210, 1004, 80);
		add(lblTitulo);
		
		lblTotal = new JLabel("IMPORTE TOTAL");
		FormatoDiseno.formatoLbl(lblTotal);
		lblTotal.setBounds(387, 300, 120, 25);
		add(lblTotal);
		
		txtTotal = new JTextField();
		FormatoDiseno.formatoTxt(txtTotal);
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setBounds(506, 300, 180, 25);
		txtTotal.setFocusable(false);
		add(txtTotal);
		
		lblPagado = new JLabel("PAGADO");
		FormatoDiseno.formatoLbl(lblPagado);
		lblPagado.setBounds(387, 350, 120, 25);
		add(lblPagado);
		
		txtPagado = new JTextField();
		FormatoDiseno.formatoTxt(txtPagado);
		txtPagado.setHorizontalAlignment(SwingConstants.CENTER);
		txtPagado.setBounds(506, 350, 180, 25);
		txtPagado.setFocusable(false);
		add(txtPagado);
		
		lblADevolver = new JLabel("A DEVOLVER");
		FormatoDiseno.formatoLbl(lblADevolver);
		lblADevolver.setBounds(387, 400, 120, 25);
		add(lblADevolver);
		
		txtDevolver = new JTextField();
		FormatoDiseno.formatoTxt(txtDevolver);
		txtDevolver.setHorizontalAlignment(SwingConstants.CENTER);
		txtDevolver.setBounds(506, 400,180, 150);
		txtDevolver.setFocusable(false);
		add(txtDevolver);
		
		btnSeparador = new JButton("");
		FormatoDiseno.formatoBtn(btnSeparador);
		btnSeparador.setEnabled(false);
		btnSeparador.setBounds(397, 570, 230, 9);
		add(btnSeparador);
		
		lblImprimir = new JLabel("Pulse 'Imprimir' para adquirir su billete");
		FormatoDiseno.formatoLbl(lblImprimir);
		lblImprimir.setBounds(387, 590, 250, 25);
		add(lblImprimir);

		btnImprimir = new JButton("Imprimir");
		FormatoDiseno.formatoBtn(btnImprimir);
		btnImprimir.setBounds(452, 620, 120, 40);
		add(btnImprimir);
		
	}
}
