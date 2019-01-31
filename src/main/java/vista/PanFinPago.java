package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
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
	
	JPanel fin_pago = new JPanel();
	
	public JLabel lblTitulo,lblTotal,lblPagado,lblADevolver;
	public JButton btnContinuar,btnSeparador;
	public JTextField txtTotal,txtPagado,txtDevolver;
	
	public PanFinPago() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblTitulo = new JLabel("FINALIZAR PAGO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(10, 11, 780, 75);
		add(lblTitulo);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(683, 566, 107, 23);
		add(btnContinuar);
		
		lblTotal = new JLabel("IMPORTE TOTAL");
		lblTotal.setBounds(277, 179, 101, 23);
		add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(388, 179, 132, 22);
		add(txtTotal);
		txtTotal.setColumns(10);
		
		lblPagado = new JLabel("PAGADO");
		lblPagado.setBounds(277, 213, 101, 23);
		add(lblPagado);
		
		lblADevolver = new JLabel("A DEVOLVER");
		lblADevolver.setBounds(277, 267, 101, 23);
		add(lblADevolver);
		
		txtPagado = new JTextField();
		txtPagado.setColumns(10);
		txtPagado.setBounds(388, 212, 132, 22);
		add(txtPagado);
		
		txtDevolver = new JTextField();
		txtDevolver.setColumns(10);
		txtDevolver.setBounds(388, 267, 132, 22);
		add(txtDevolver);
		
		btnSeparador = new JButton("");
		btnSeparador.setEnabled(false);
		btnSeparador.setBounds(277, 247, 243, 9);
		add(btnSeparador);

	}

}
