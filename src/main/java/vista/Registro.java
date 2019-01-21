package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JButton;

public class Registro extends JPanel {
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public Registro() {
		setLayout(null);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblRegistro.setBounds(0, 39, 528, 81);
		add(lblRegistro);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(150, 317, 46, 14);
		add(label_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(123, 156, 46, 14);
		add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(179, 153, 216, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(123, 187, 46, 14);
		add(lblApellidos);
		
		textField_3 = new JTextField();
		textField_3.setBounds(179, 184, 216, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(123, 218, 46, 14);
		add(lblDni);
		
		textField_4 = new JTextField();
		textField_4.setBounds(179, 215, 216, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sexo");
		lblNewLabel.setBounds(123, 249, 46, 14);
		add(lblNewLabel);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(205, 245, 86, 23);
		add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(293, 245, 77, 23);
		add(rdbtnFemenino);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 314, 140, 20);
		add(passwordField);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 11, 508, 14);
		add(progressBar);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(215, 389, 103, 43);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(10, 463, 89, 23);
		add(btnNewButton_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(215, 345, 140, 20);
		add(passwordField_1);
		
		JLabel lblVuelvaAIntroducir = new JLabel("Confirmar password");
		lblVuelvaAIntroducir.setBounds(99, 348, 96, 14);
		add(lblVuelvaAIntroducir);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(429, 39, 89, 23);
		add(btnLogin);

	}
}
