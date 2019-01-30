package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanFinPago extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	
	JPanel fin_pago = new JPanel();
	public JButton btnContinuar;
	
	
	public PanFinPago() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		JLabel lblPagar = new JLabel("FINALIZAR PAGO");
		lblPagar.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagar.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblPagar.setBounds(10, 11, 780, 75);
		add(lblPagar);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(683, 566, 107, 23);
		add(btnContinuar);
		
		JLabel lblImporteTotal = new JLabel("IMPORTE TOTAL");
		lblImporteTotal.setBounds(277, 179, 101, 23);
		add(lblImporteTotal);
		
		textField = new JTextField();
		textField.setBounds(388, 179, 132, 22);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPagado = new JLabel("PAGADO");
		lblPagado.setBounds(277, 213, 101, 23);
		add(lblPagado);
		
		JLabel lblADevolver = new JLabel("A DEVOLVER");
		lblADevolver.setBounds(277, 267, 101, 23);
		add(lblADevolver);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(388, 212, 132, 22);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(388, 267, 132, 22);
		add(textField_2);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setBounds(277, 247, 243, 9);
		add(button_1);

	}

}
