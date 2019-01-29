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
import com.toedter.calendar.JDateChooser;

public class PanRegistro extends JPanel {
	/**
	 * 
	 */
	
	JPanel registro = new JPanel();
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public PanRegistro() {
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblRegistro.setBounds(10, 36, 790, 81);
		add(lblRegistro);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(321, 409, 46, 14);
		add(label_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(279, 157, 46, 14);
		add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(335, 154, 216, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(279, 188, 46, 14);
		add(lblApellidos);
		
		textField_3 = new JTextField();
		textField_3.setBounds(335, 185, 216, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(279, 219, 46, 14);
		add(lblDni);
		
		textField_4 = new JTextField();
		textField_4.setBounds(335, 216, 216, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sexo");
		lblNewLabel.setBounds(279, 250, 46, 14);
		add(lblNewLabel);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(361, 246, 86, 23);
		add(rdbtnMasculino);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(449, 246, 77, 23);
		add(rdbtnFemenino);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(386, 406, 140, 20);
		add(passwordField);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(129, 11, 508, 14);
		add(progressBar);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(386, 483, 103, 43);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(0, 686, 89, 23);
		add(btnNewButton_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(386, 437, 140, 20);
		add(passwordField_1);
		
		JLabel lblVuelvaAIntroducir = new JLabel("Confirmar password");
		lblVuelvaAIntroducir.setBounds(270, 440, 96, 14);
		add(lblVuelvaAIntroducir);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(701, 11, 89, 23);
		add(btnLogin);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(371, 276, 180, 20);
		add(dateChooser);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha nacimiento");
		lblFechaDeNacimiento.setBounds(279, 282, 88, 14);
		add(lblFechaDeNacimiento);

	}
}
