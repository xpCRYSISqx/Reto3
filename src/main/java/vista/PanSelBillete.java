package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class PanSelBillete extends JPanel {

	/**
	 * Create the panel.
	 */
	
	JPanel sel_billete = new JPanel();
	
	public PanSelBillete() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		JButton btnInicioDeSesin = new JButton("Inicio de Sesi\u00F3n");
		btnInicioDeSesin.setBounds(683, 15, 107, 23);
		add(btnInicioDeSesin);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(683, 42, 107, 23);
		add(btnNewButton);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(683, 566, 107, 23);
		add(btnContinuar);
		
		JLabel lblNewLabel = new JLabel("SELECCI\u00D3N DE BILLETE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblNewLabel.setBounds(10, 15, 780, 60);
		add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 566, 89, 23);
		add(btnCancelar);
		
		JCheckBox chckbxSimple = new JCheckBox("Simple");
		chckbxSimple.setBounds(306, 147, 97, 23);
		add(chckbxSimple);
		
		JCheckBox chckbxIdaVuelta = new JCheckBox("Ida / Vuelta");
		chckbxIdaVuelta.setBounds(422, 147, 97, 23);
		add(chckbxIdaVuelta);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblOrigen.setBounds(227, 201, 84, 23);
		add(lblOrigen);
		
		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(485, 201, 66, 23);
		add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(208, 235, 121, 189);
		add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(463, 235, 121, 189);
		add(list_1);
		
		JButton btnNewButton_1 = new JButton("Atr\u00E1s");
		btnNewButton_1.setBounds(10, 539, 89, 23);
		add(btnNewButton_1);

	}
}
