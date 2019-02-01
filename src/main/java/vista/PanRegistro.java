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
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanRegistro extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JPanel registro = new JPanel();
		
	public JLabel lblTitulo, lblNombre, lblApellidos, lblDni, lblSexo,lblPassword, lblPassword2, lblfechaNac;
	public JTextField txtNombre, txtApellidos, txtDni;
	public JButton btnLogin, btnRegistro, btnCancelar;
	public JRadioButton rbtnMasc, rbtnFem;
	public JPasswordField passwordField, passwordField2;
	public JDateChooser dateChooser;
	public JProgressBar progressBar;
	
	public final ButtonGroup buttonGroup = new ButtonGroup();
	
	/**
	 * Create the panel.
	 */
	
	public PanRegistro() {
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblTitulo = new JLabel("REGISTRO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(10, 36, 790, 81);
		add(lblTitulo);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(321, 409, 46, 14);
		add(lblPassword);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(279, 157, 46, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(335, 154, 216, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(279, 188, 46, 14);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(335, 185, 216, 20);
		add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(279, 219, 46, 14);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(335, 216, 216, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(279, 250, 46, 14);
		add(lblSexo);
		
		rbtnMasc = new JRadioButton("Masculino");
		buttonGroup.add(rbtnMasc);
		rbtnMasc.setBounds(361, 246, 86, 23);
		add(rbtnMasc);
		
		rbtnFem = new JRadioButton("Femenino");
		buttonGroup.add(rbtnFem);
		rbtnFem.setBounds(449, 246, 77, 23);
		add(rbtnFem);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(386, 406, 140, 20);
		add(passwordField);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(129, 11, 508, 14);
		add(progressBar);
		
		btnRegistro = new JButton("Registrar");
		btnRegistro.setBounds(386, 483, 103, 43);
		add(btnRegistro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(0, 686, 89, 23);
		add(btnCancelar);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(386, 437, 140, 20);
		add(passwordField2);
		
		lblPassword2 = new JLabel("Confirmar password");
		lblPassword2.setBounds(270, 440, 96, 14);
		add(lblPassword2);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(701, 11, 89, 23);
		add(btnLogin);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(371, 276, 180, 20);
		add(dateChooser);
		
		lblfechaNac = new JLabel("Fecha nacimiento");
		lblfechaNac.setBounds(279, 282, 88, 14);
		add(lblfechaNac);

	}
}
