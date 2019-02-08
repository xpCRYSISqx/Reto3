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
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanRegistro extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JPanel registro = new JPanel();
		
	public JLabel lblTitulo,lblIcono,lblNombre,lblApellidos,lblDni, lblSexo,lblPassword, lblPassword2, lblfechaNac, lblErrorDNI, lblErrorContrasenas, lblErrorSexo, lblErrorDNINoIntroducido;
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
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 0, 1024, 720);
		
		// Label del logotipo
		lblIcono = new JLabel("");
		FormatoDiseno.formatoIcono(lblIcono);
		add(lblIcono);
		
		//Label de titulo del panel
		lblTitulo = new JLabel("Registro");
		FormatoDiseno.formatoTitulo(lblTitulo);
		add(lblTitulo);
		
		btnLogin = new JButton("Inicio Sesi\u00F3n");
		FormatoDiseno.formatoBtnLogin(btnLogin);
		add(btnLogin);
		
		btnRegistro = new JButton("Registrar");
		FormatoDiseno.formatoBtn(btnRegistro);
		btnRegistro.setBounds(471, 537, 115, 40);
		add(btnRegistro);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(322, 259, 77, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		FormatoDiseno.formatoTxt(txtNombre);
		txtNombre.setBounds(409, 256, 216, 20);
		txtNombre.setColumns(10);
		add(txtNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(322, 290, 77, 14);
		add(lblApellidos);
		
		txtApellidos = new JTextField();
		FormatoDiseno.formatoTxt(txtApellidos);
		txtApellidos.setBounds(409, 287, 216, 20);
		txtApellidos.setColumns(10);
		add(txtApellidos);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(322, 411, 77, 14);
		add(lblDni);
		
		txtDni = new JTextField();
		FormatoDiseno.formatoTxt(txtDni);
		txtDni.setBounds(409, 408, 216, 20);
		txtDni.setColumns(10);
		add(txtDni);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(322, 367, 77, 14);
		add(lblSexo);
		
		rbtnMasc = new JRadioButton("Masculino");
		rbtnMasc.setBackground(Color.WHITE);
		buttonGroup.add(rbtnMasc);
		rbtnMasc.setBounds(462, 352, 112, 23);
		add(rbtnMasc);
		
		rbtnFem = new JRadioButton("Femenino");
		rbtnFem.setBackground(Color.WHITE);
		buttonGroup.add(rbtnFem);
		rbtnFem.setBounds(462, 378, 112, 23);
		add(rbtnFem);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(385, 445, 46, 14);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		FormatoDiseno.formatoTxt(passwordField);
		passwordField.setBounds(450, 442, 140, 20);
		add(passwordField);
		
//		progressBar = new JProgressBar();
//		progressBar.setBounds(252, 20, 500, 15);
//		add(progressBar);
		
		lblPassword2 = new JLabel("Confirmar password");
		lblPassword2.setBounds(334, 476, 96, 14);
		add(lblPassword2);
		
		passwordField2 = new JPasswordField();
		FormatoDiseno.formatoTxt(passwordField2);
		passwordField2.setBounds(450, 473, 140, 20);
		add(passwordField2);
		
		lblfechaNac = new JLabel("Fecha nacimiento");
		lblfechaNac.setBounds(322, 321, 123, 20);
		add(lblfechaNac);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(455, 318, 170, 20);
		add(dateChooser);
		
		lblErrorDNI = new JLabel("Ya existe un usuario con ese DNI");
		lblErrorDNI.setBounds(634, 408, 273, 20);
		lblErrorDNI.setVisible(false);
		add(lblErrorDNI);
		
		lblErrorContrasenas = new JLabel("Las contrase\u00F1as no coinciden, int\u00E9ntelo de nuevo");
		lblErrorContrasenas.setBounds(600, 442, 371, 20);
		lblErrorContrasenas.setVisible(false);
		add(lblErrorContrasenas);
		
		lblErrorSexo = new JLabel("Se deber\u00E1 indicar el sexo para completar el registro");
		lblErrorSexo.setBounds(600, 367, 336, 14);
		lblErrorSexo.setVisible(false);
		add(lblErrorSexo);
		
		lblErrorDNINoIntroducido = new JLabel("Debe introducir un DNI, no puede dejar el campo en blanco");
		lblErrorDNINoIntroducido.setBounds(635, 411, 336, 17);
		lblErrorDNINoIntroducido.setVisible(false);
		add(lblErrorDNINoIntroducido);

		btnCancelar = new JButton("Cancelar");
		FormatoDiseno.formatoBtnCancelar(btnCancelar);
		add(btnCancelar); 
	}
}
