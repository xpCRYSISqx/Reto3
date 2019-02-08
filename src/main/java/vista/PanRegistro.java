package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
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
		
	public JLabel lblTitulo, lblNombre, lblApellidos, lblDni, lblSexo,lblPassword, lblPassword2, lblfechaNac, lblErrorDNI, lblErrorContrasenas, lblErrorSexo, lblErrorDNINoIntroducido;
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
		setBackground(new Color(255, 192, 203));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		lblTitulo = new JLabel("REGISTRO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Mistral", Font.PLAIN, 44));
		lblTitulo.setBounds(30, 35, 1004, 81);
		add(lblTitulo);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		btnLogin.setBounds(880, 35, 125, 25);
		add(btnLogin);
		
		btnRegistro = new JButton("Registrar");
		btnRegistro.setBounds(470, 435, 103, 43);
		add(btnRegistro);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 650, 100, 25);
		add(btnCancelar);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(384, 343, 46, 14);
		add(lblPassword);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(321, 157, 77, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(408, 154, 216, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(321, 188, 77, 14);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(408, 185, 216, 20);
		add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(321, 309, 77, 14);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(408, 306, 216, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(321, 265, 77, 14);
		add(lblSexo);
		
		rbtnMasc = new JRadioButton("Masculino");
		rbtnMasc.setBackground(new Color(255, 192, 203));
		buttonGroup.add(rbtnMasc);
		rbtnMasc.setBounds(461, 250, 112, 23);
		add(rbtnMasc);
		
		rbtnFem = new JRadioButton("Femenino");
		rbtnFem.setBackground(new Color(255, 192, 203));
		buttonGroup.add(rbtnFem);
		rbtnFem.setBounds(461, 276, 112, 23);
		add(rbtnFem);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(449, 340, 140, 20);
		add(passwordField);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(252, 20, 500, 15);
		add(progressBar);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(449, 371, 140, 20);
		add(passwordField2);
		
		lblPassword2 = new JLabel("Confirmar password");
		lblPassword2.setBounds(333, 374, 96, 14);
		add(lblPassword2);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(454, 216, 170, 20);
		add(dateChooser);
		
		lblfechaNac = new JLabel("Fecha nacimiento");
		lblfechaNac.setBounds(321, 219, 123, 20);
		add(lblfechaNac);
		
		lblErrorDNI = new JLabel("Ya existe un usuario con ese DNI");
		lblErrorDNI.setBounds(633, 306, 273, 20);
		lblErrorDNI.setVisible(false);
		add(lblErrorDNI);
		
		lblErrorContrasenas = new JLabel("Las contrase\u00F1as no coinciden, int\u00E9ntelo de nuevo");
		lblErrorContrasenas.setBounds(599, 340, 371, 20);
		lblErrorContrasenas.setVisible(false);
		add(lblErrorContrasenas);
		
		lblErrorSexo = new JLabel("Se deber\u00E1 indicar el sexo para completar el registro");
		lblErrorSexo.setBounds(599, 265, 336, 14);
		lblErrorSexo.setVisible(false);
		add(lblErrorSexo);
		
		lblErrorDNINoIntroducido = new JLabel("Debe introducir un DNI, no puede dejar el campo en blanco");
		lblErrorDNINoIntroducido.setBounds(634, 309, 336, 17);
		lblErrorDNINoIntroducido.setVisible(false);
		add(lblErrorDNINoIntroducido);

	}
}
